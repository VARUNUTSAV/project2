package com.Varun.project2.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Document(collection = "Authordb")
public class author {
    private int id;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private Address address;

    public author(int id, String name, Address address){
        this.id = id;
        this.name = name;
        this.address = address;
    }
    public int getId(){ return id; }
    public void setId(int id){ this.id = id; }
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public Address getAddress(){ return address; }
    public void setAddress(Address address){

        this.address = address;
//        this.address.setHno(address.getHno());
//        this.address.setCity(address.getCity());
//        this.address.setCity(address.getCity());
    }

//    @Override
//    public String toString() {
//        return "Author{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", address=" + address.toString() +
//                '}';
//    }
}
