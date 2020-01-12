package ru.progwards.java1.lessons.datetime;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SessionManager {

    private Map<Integer, UserSession> sessions = new HashMap<>();
    private int sessionValid;    
    
    public SessionManager(int sessionValid) {
        this.sessionValid = sessionValid;
    }
    
    public void add(UserSession userSession){
        sessions.put(userSession.getSessionHandle(), userSession);
    }
    
    public UserSession get(int sessionHandle){
        UserSession us = validSession(sessions.get(sessionHandle));
        if (us != null) us.updateLastAccess();
        return us;
    }
    
    public UserSession find(String userName){
        for (UserSession us : sessions.values()){
            if (us.getUserName().equals(userName)){
                UserSession us1 = validSession(sessions.get(us.getSessionHandle()));
                if (us != null) us1.updateLastAccess();
                return us1;
            }
        }
        return null;
    }
    
    public void delete(int sessionHandle){
        sessions.remove(sessionHandle);
    }
    
    public void deleteExpired(){
        Iterator<UserSession> it = sessions.values().iterator();
        while (it.hasNext()){
            UserSession us = it.next();
            if (validSession(us) == null){
                sessions.remove(us.getSessionHandle());
                it = sessions.values().iterator();
            }
        }
    }
    
    private UserSession validSession(UserSession us){
        if (us != null && ZonedDateTime.now().isBefore(us.getLastAccess().plusSeconds(sessionValid))){
            return us;
        }
        return null;
    }

}
