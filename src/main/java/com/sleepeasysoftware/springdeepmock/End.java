package com.sleepeasysoftware.springdeepmock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class End {

    @Autowired
    private Database database;  //in my test, I want this to be a mock

    public void useDatabase() {
        database.save();
    }

}