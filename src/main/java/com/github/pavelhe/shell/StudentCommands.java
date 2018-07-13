package com.github.pavelhe.shell;


import com.github.pavelhe.model.*;
import com.github.pavelhe.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.shell.standard.*;

@ShellComponent
public class StudentCommands {

    @Autowired
    private StudentService service;
    private String name;
    private String surname;

    @ShellMethod("Ask name")
    public String askName(@ShellOption String name) {
        this.name = name;
        tryCreateStudent();
        return name;
    }

    @ShellMethod("Ask surname")
    public String askSurname(@ShellOption String surname) {
        this.surname = surname;
        tryCreateStudent();
        return surname;
    }

    private void tryCreateStudent() {
        if (name != null && surname != null)
            service.setStudent(new Student(name, surname));
    }
}
