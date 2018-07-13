package com.github.pavelhe.service;


import com.github.pavelhe.model.*;
import org.springframework.stereotype.*;

@Service
public class StudentServiceImpl implements StudentService {

    private Student student;

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public Student getStudent() {
        return student;
    }
}
