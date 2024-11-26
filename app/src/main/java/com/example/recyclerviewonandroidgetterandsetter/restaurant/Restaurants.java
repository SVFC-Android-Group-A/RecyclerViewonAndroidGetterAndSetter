package com.example.recyclerviewonandroidgetterandsetter.restaurant;

public class Restaurants {
    private String name;
    private String type;
    private String location;

    // Fixed the errors
    public Restaurants(String name, String type, String location) {
        this.name = name;
        this.type = type;
        this.location = location;
    }

    public Restaurants() {}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
