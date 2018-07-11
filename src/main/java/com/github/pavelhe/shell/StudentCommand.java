package com.github.pavelhe.shell;


import com.github.pavelhe.model.*;
import org.springframework.shell.standard.*;

@ShellComponent
public class StudentCommand {

    private String name;
    private String surname;

    @ShellMethod("Ask name")
    public String askName(@ShellOption String name) {
        this.name = name;
        return name;
    }

    @ShellMethod("Ask surname")
    public String askSurname(@ShellOption String surname) {
        this.surname = surname;
        return surname;
    }

    public Student getStudentFromShellCommand() {
        boolean dataNotNull = name != null && surname != null;
        if (dataNotNull)
            return new Student(name, surname);
        return null;
    }
}
