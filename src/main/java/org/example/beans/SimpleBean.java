package org.example.beans;

import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;


@Stateful
@SessionScoped
public class SimpleBean implements SimpleBeanService, Serializable {

    private int number = 0;

    @Override
    public void increment() {
        number++;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying session bean: " + this);
    }
}
