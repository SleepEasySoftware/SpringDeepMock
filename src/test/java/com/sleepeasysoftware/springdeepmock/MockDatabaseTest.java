package com.sleepeasysoftware.springdeepmock;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MockDatabaseTest {

    @Test
    public void testReplaceRepositoryWithMock() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Database mockRepo = context.getBean(Database.class);
        Middle middle = context.getBean(Middle.class);
        middle.useEnd();
        verify(mockRepo).save();
    }

    @Configuration
    @ImportResource("classpath:/beans.xml") //import the beans.xml configuration, I definitely don't want:
    //1) A separate config file for each test
    //2) To define all these beans by hand
    public static class Config {

        @Bean
        @Primary    //given two beans of the same type, let this one win
        //that means this config will give you back a mock database
        //not the real one
        //
        //because this config is only used for tests, this @Primary won't interfere with
        //production code
        public Database getDatabase() {
            return mock(Database.class);
        }

    }

}