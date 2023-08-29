package com.Varun.project2.model;

import com.mongodb.lang.NonNull;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "Author")
public class author {
    @NonNull
    private int id;
    private String name;
    private Address address;

    public author(){
    }
    public int getId(){ return id; }
    public void setId(int id){ this.id = id; }
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public Address getAddress(){ return address; }
    public void setAddress(Address address){
        this.address.setHno(address.getHno());
        this.address.setCity(address.getCity());
        this.address.setCity(address.getCity());
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address=" + address.toString() +
                '}';
    }
}
