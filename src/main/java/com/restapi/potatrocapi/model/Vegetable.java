package com.restapi.potatrocapi.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "vegetable", schema = "potatroc")
public class Vegetable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vegetable_id")
    private long vegetable_id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unit_vegetable_id")
    private Unit unit;

    @Type(type="org.hibernate.type.BinaryType")
    @Column(name="picture")
    private byte[] picture;

    public Vegetable() {
    }

    public Vegetable( String name, double price, Unit unit, byte[] picture){
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.picture = picture;
    }
    public void setId( long vegetable_id ) {
        this.vegetable_id =  vegetable_id;
    }
    public long getId() {
        return vegetable_id;
    }

    public void setName( String name ) {
        this.name =  name;
    }
    public String getName() {
        return name;
    }

    public void setPrice( double price ) {
        this.price =  price;
    }
    public double getPrice() {
        return price;
    }

    public void setUnit( Unit unit ) {
        this.unit =  unit;
    }
    public Unit getUnit() {
        return unit;
    }

    public void setPicture( byte[] picture ) {
        this.picture =  picture;
    }
    public byte[] getPicture() {
        return picture;
    }

}
