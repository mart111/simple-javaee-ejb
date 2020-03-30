package org.example.beans;

import javax.ejb.Local;


@Local
public interface SimpleBeanService {

    void increment();

    int getNumber();
}
