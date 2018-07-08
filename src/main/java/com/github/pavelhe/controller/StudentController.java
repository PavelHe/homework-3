package com.github.pavelhe.controller;

import java.io.*;
import java.util.*;

import com.github.pavelhe.model.*;


public interface StudentController {

    default Student startAnswers() {
        return startAnswers(null, null);
    }

    Student startAnswers(BufferedReader reader, Locale locale);

}
