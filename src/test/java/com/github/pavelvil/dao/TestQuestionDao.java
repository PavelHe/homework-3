package com.github.pavelvil.dao;

import java.util.*;

import com.github.pavelhe.dao.*;
import com.github.pavelhe.model.*;
import com.github.pavelvil.config.TestConfiguration;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = TestConfiguration.class)
public class TestQuestionDao {

    private final static int ANSWERS_COUNT_IN_CSV = 6;

    @Autowired
    private QuestionDao dao;

    @Test
    public void testGetQuestionsFromCSV() throws Exception {
        List<Question> questions = dao.getQuestionsFromCSV();

        assertEquals(ANSWERS_COUNT_IN_CSV, questions.size());
    }

}
