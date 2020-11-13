package com.restapi.potatrocapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "unit", schema = "potatroc")
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt"}
)

public class Unit extends InfoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "unit_id")
    private long unit_id;

    @Column(name = "name")
    private String name;

    @Column(name = "symbol")
    private String symbol;

    public Unit() {
    }
    public Unit( String name, String symbol){
        this.name = name;
        this.symbol = symbol;
    }
    public void setId( long unit_id ) {
        this.unit_id =  unit_id;
    }
    public long getId() {
        return unit_id;
    }

    public void setName( String name ) {
        this.name =  name;
    }
    public String getName() {
        return name;
    }

    public void setSymbol( String symbol ) {
        this.symbol =  symbol;
    }
    public String getSymbol() {
        return symbol;
    }

}
