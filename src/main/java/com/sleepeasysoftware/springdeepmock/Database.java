package com.sleepeasysoftware.springdeepmock;

import org.springframework.stereotype.Service;

@Service
public class Database {

    public void save() {
        System.out.println("production code");  //pretend this saves to a database.  I do not want this to occur in my test!
    }

}