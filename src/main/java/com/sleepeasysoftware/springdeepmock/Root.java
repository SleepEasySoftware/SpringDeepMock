package com.sleepeasysoftware.springdeepmock;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Root {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/beans.xml");  //no particular reason for using xml based configuration here
        //I just wanted to show that you can
        useMiddle(context.getBean(Middle.class));
    }

    private static void useMiddle(Middle middle) {
        middle.useEnd();
    }

}