package com.Varun.project2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Document(collection = "Author")
public class Author {
    @Id
    @NotNull
    private int id;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private Address address;

    public Author(){
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
