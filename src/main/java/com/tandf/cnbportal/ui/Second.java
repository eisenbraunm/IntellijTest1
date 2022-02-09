package com.tandf.cnbportal.ui;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class Second implements Serializable {

  private  String hithere;
    @Inject
    TestCDI testCDI;

    @PostConstruct
    public void init() {

       hithere="hello from another bean";
        System.out.print("value printed from proxy (set in test bean) is correct but can't view in debugger "+  testCDI.getTest());

        testCDI.setTest("testCDI. test value set in second bean but can't view in debugger");
        System.out.print("value changed in seconbeand) is correct but can't view in debugger "+  testCDI.getTest());
    }


    public String getHithere() {

        return hithere;
    }

    public void setHithere(String hithere) {

        this.hithere = hithere;
    }

    public TestCDI getTestCDI() {
        return testCDI;
    }

    public void setTestCDI(TestCDI testCDI) {
        this.testCDI = testCDI;
    }
}
