package com.hsj.entity;
import org.springframework.stereotype.Component;

/**
 * @author waja
 */
@Component
public class GetSession {
    private static String  sessionId;

    public static String getSessionId() {
        return sessionId;
    }

    public static void setSessionId(String sessionId) {
        GetSession.sessionId = sessionId;
    }
}
