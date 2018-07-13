package com.github.pavelvil.config;

import com.github.pavelhe.controller.*;
import com.github.pavelhe.dao.*;
import com.github.pavelhe.service.*;
import com.github.pavelhe.utils.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;
import org.springframework.context.support.*;

@Configuration
@PropertySource(value = {"file:src/test/resources/application.yml"}, name = "testProps")
public class TestConfiguration {

    private @Value("#{environment['filePathEn']}") String filePath;
    private @Value("#{environment['defaultLocale']}") String defaultLocale;

    @Bean
    public StudentController testStudentController() {
        return new StudentControllerImpl(testQuestionService(), defaultLocale, testStudentService());
    }

    @Bean
    public QuestionService testQuestionService() {
        return new QuestionServiceImpl(testQuestionDao());
    }

    @Bean
    public QuestionDao testQuestionDao() {
        return new QuestionDaoImpl(filePath);
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("locales/messages");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    @Bean
    public MessageSourceWrapper messageSourceWrapper() {
        return new MessageSourceWrapperImpl(messageSource());
    }

    @Bean
    public StudentService testStudentService() {
        return new StudentServiceImpl();
    }
}
