package com.github.pavelhe.dao;

import java.io.*;
import java.util.*;

import au.com.bytecode.opencsv.*;
import com.github.pavelhe.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class QuestionDaoImpl implements QuestionDao {
    private final static int QUESTION_TEXT = 1;
    private final static int RIGHT_ANSWER = 0;

    private String filePath;

    public QuestionDaoImpl(@Value("${filePathEn}") String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Question> getQuestionsFromCSV() {
        validateFilePath();
        List<Question> questions = new ArrayList<>();
        String[] line;
        try (CSVReader reader = new CSVReader(new FileReader(this.filePath), ',', '"', 1)) {
            while ((line = reader.readNext()) != null) {
                Question question = new Question(line[QUESTION_TEXT], Integer.valueOf(line[RIGHT_ANSWER]));
                String[] answerText = new String[line.length - 2];
                System.arraycopy(line, 2, answerText, 0, answerText.length);
                question.setAnswers(createAnswers(answerText));
                questions.add(question);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return questions;
    }

    private List<Answer> createAnswers(String[] answerText) {
        List<Answer> answers = new ArrayList<>();
        for (String text : answerText) {
            answers.add(new Answer(text));
        }
        return answers;
    }

    private void validateFilePath() {
        try {
            Properties properties = new Properties();
            properties.load(getClass().getResourceAsStream("/application.yml"));
            String defaultLocale = properties.getProperty("defaultLocale");
            if (Objects.equals(defaultLocale, "ru"))
                filePath = properties.getProperty("filePathRu");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
