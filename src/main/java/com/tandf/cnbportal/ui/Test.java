package com.tandf.cnbportal.ui;

import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.spi.BeanManager;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;



@Named("test")
@ViewAccessScoped
public class Test implements Serializable {
    private String testResult= "initial simple value";

    @Inject
    BeanManager beanManager;

    @Inject
    GlobalBean global;  //(application scoped)

    @Inject
    TestCDI testCDI;

    @PostConstruct
    public void init() {
        testResult="simple value set in init";
        testCDI.setTest("value set in ViewAccessScoped Test Bean");

        System.out.println("value printed from proxy  is correct but can't view in debugger: "+ testCDI.getTest());

    }

    public Integer getTotalSessions(){

        return SessionCounter.getCount();
    }

    public String getTestResult() {

        System.out.println ("testCDI.getTest(): " +testCDI.getTest());
        return testResult;
    }

    public void setTestResult(String testResult) {

        this.testResult = testResult;
    }

    public BeanManager getBeanManager() {
        return beanManager;
    }

    public void setBeanManager(BeanManager beanManager) {
        this.beanManager = beanManager;
    }

    public GlobalBean getGlobal() {
        return global;
    }

    public void setGlobal(GlobalBean global) {
        this.global = global;
    }

    public TestCDI getTestCDI() {
        return testCDI;
    }

    public void setTestCDI(TestCDI testCDI) {
        this.testCDI = testCDI;
    }

    public void gotoAnother() {
        FacesContext context = FacesContext.getCurrentInstance();
        NavigationHandler nh = context.getApplication().getNavigationHandler();
        nh.handleNavigation(context, null, "/second.xhtml");
    }
}
