package com.github.pavelhe.service;

import java.util.*;

import com.github.pavelhe.dao.*;
import com.github.pavelhe.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    public QuestionServiceImpl(@Qualifier("questionDaoImpl") QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public List<Question> getQuestionsFromCSV() {
        return questionDao.getQuestionsFromCSV();
    }
}
