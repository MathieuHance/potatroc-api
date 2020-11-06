package com.restapi.potatrocapi.model;
import com.fasterxml.jackson.annotation.*;


import javax.persistence.*;

@Entity
@Table(name = "location" , schema = "potatroc")

public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "location_id")
    private int location_id;

    @Column(name = "lat")
    private double lat;

    @Column(name = "lon")
    private double lon;

    @Column(name = "lat_tr")
    private double lat_tr;

    @Column(name = "lon_tr")
    private double lon_tr;

    @Column(name = "address")
    private String address;


    @OneToOne(fetch = FetchType.EAGER , mappedBy = "location", cascade = CascadeType.ALL )
    private User user;


    public Location() {
    }

    public Location(int location_id, double lat, double lon, double lat_tr, double lon_tr, String address,  User user) {
        this.location_id = location_id;
        this.lat = lat;
        this.lon = lon;
        this.lat_tr = lat_tr;
        this.lon_tr = lon_tr;
        this.address = address;
        this.user = user;
    }


    public void setId( int location_id ) {
        this.location_id =  location_id;
    }
    public long getId() {
        return location_id;
    }



    public void setLat(double lat) {
        this.lat = lat;
    }
    public double getLat() {
        return this.lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
    public double getLon() {
        return this.lon;
    }

    public void setLat_tr(double lat_tr) {
        this.lat_tr = lat_tr;
    }
    public double getLat_tr() {
        return this.lat_tr;
    }

    public void setLon_tr(double lon_tr) {
        this.lon_tr = lon_tr;
    }
    public double getLon_tr() {
        return this.lon_tr;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return this.address;
    }

    public void setUser(User user){
        this.user = user;
    }
    public User getUser(){
        return this.user;
    }

}


