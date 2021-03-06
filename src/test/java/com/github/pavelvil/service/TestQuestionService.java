package com.github.pavelvil.service;

import java.util.*;

import com.github.pavelhe.model.*;
import com.github.pavelhe.service.*;
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
public class TestQuestionService {

    private final static int ANSWERS_COUNT_IN_CSV = 6;

    @Autowired
    private QuestionService service;

    @Test
    public void testGetQuestionsFromCSV() throws Exception {
        List<Question> questions = service.getQuestionsFromCSV();

        assertEquals(ANSWERS_COUNT_IN_CSV, questions.size());
    }

}
