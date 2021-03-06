package com.github.pavelvil.controller;

import java.io.*;

import com.github.pavelhe.controller.*;
import com.github.pavelhe.model.*;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = com.github.pavelvil.config.TestConfiguration.class)
public class TestStudentController {

    private final static String NAME = "Name";
    private final static String SURNAME = "Surname";
    private final static String ANSWER_ONE = "1";
    private final static String ANSWER_TWO = "2";
    private final static String ANSWER_FREE = "3";
    private final static int RIGHT_ANSWERS = 3;

    @Autowired
    private StudentController studentController;

    @Test
    public void testStartAnswer() throws Exception {
        BufferedReader mockReader = mock(BufferedReader.class);
        when(mockReader.readLine()).thenReturn(NAME, SURNAME, ANSWER_ONE, ANSWER_TWO, ANSWER_FREE, ANSWER_ONE, ANSWER_TWO, ANSWER_FREE);
        Student student = studentController.startAnswers(mockReader, null);

        assertNotNull(student);
        assertEquals(NAME, student.getName());
        assertEquals(SURNAME, student.getSurname());
        assertEquals(student.getRightAnswers(), RIGHT_ANSWERS);
    }

}
