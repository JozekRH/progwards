package ru.progwards.java1.lessons.datetime;

import java.time.ZonedDateTime;
import java.util.concurrent.ThreadLocalRandom;

public class UserSession {

    private int sessionHandle;
    private String userName;
    private ZonedDateTime lastAccess;

    public UserSession(String userName) {
        sessionHandle = ThreadLocalRandom.current().nextInt(1, 100000);
        this.userName = userName;
        updateLastAccess();
    }
    
    public int getSessionHandle(){
        return sessionHandle;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public ZonedDateTime getLastAccess(){
        return lastAccess;
    }
    
    public void updateLastAccess(){
        lastAccess = ZonedDateTime.now();
    }

}
