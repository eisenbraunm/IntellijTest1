package com.tandf.cnbportal.ui;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounter implements HttpSessionListener {

    private static int count;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("session created: " + event.getSession().getId());
        count++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("session destroyed: " + event.getSession().getId());
        count--;
    }

    public static int getCount() {
        return count;
    }
}