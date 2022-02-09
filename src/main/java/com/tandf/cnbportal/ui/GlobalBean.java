package com.tandf.cnbportal.ui;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;


@ApplicationScoped
@Named
public class GlobalBean implements Serializable {
private String test= "initial value";
    @PostConstruct
    public void init() {


    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
