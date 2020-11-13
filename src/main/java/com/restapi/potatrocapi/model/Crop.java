package com.restapi.potatrocapi.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "crop", schema = "potatroc")
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt" , "user"}
)


public class Crop extends InfoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "crop_id")
    private long crop_id;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL )
    @JoinColumn(name = "user_crop_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL )
    @JoinColumn(name = "vegetable_crop_id")
    private Vegetable vegetable;

    @Column(name = "quantity")
    private double quantity;

    public Crop() {
    }

    public Crop ( User user, Vegetable vegetable, double quantity ){
        this.user = user;
        this.vegetable = vegetable;
        this.quantity = quantity;
    }

    public void setId( long crop_id ) {
        this.crop_id =  crop_id;
    }
    public long getId() {
        return crop_id;
    }

    public void setUser( User user ) {
        this.user =  user;
    }
    public User getUser() {
        return user;
    }
    public void setvegetable( Vegetable vegetable ) {
        this.vegetable =  vegetable;
    }
    public Vegetable getVegetable() {
        return vegetable;
    }
    public void setQuantity( double quantity ) {
        this.quantity =  quantity;
    }
    public double getQuantity() {
        return quantity;
    }
}
