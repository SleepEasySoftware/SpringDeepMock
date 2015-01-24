package com.sleepeasysoftware.springdeepmock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Middle {

    @Autowired
    private End end;

    public void useEnd() {
        end.useDatabase();
    }

}