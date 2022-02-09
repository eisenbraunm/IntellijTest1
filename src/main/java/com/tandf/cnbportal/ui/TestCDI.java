package com.tandf.cnbportal.ui;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import java.io.Serializable;

@SessionScoped
@Named
public class TestCDI implements Serializable {
    private String test;
    public TestCDI() {

    }


    @PostConstruct
    public void init() {

        System.out.println("CALLING CONSTRUCTOR TESTCDI Session Object"
        );
    }


    public String getTest() {

        return test;
    }

    public void setTest(String test) {

        this.test = test;
    }


}
