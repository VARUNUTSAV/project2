package com.Varun.project2.model;

import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "Author")
public class Address {
    private String hno;
    private String city;
    private String state;

    public Address(){
    }

    public String getHno(){ return hno; }
    public void setHno(String hno){ this.hno = hno; }
    public String getCity(){ return city; }
    public void setCity(String city){ this.city = city; }
    public String getState(){ return state; }
    public void setState(String state){ this.state = state; }

    @Override
    public String toString() {
        return "Address{" +
                "hno='" + hno + '\'' +
                ", city='" + city + '\'' +
                ", state=" + state +
                '}';
    }
}
