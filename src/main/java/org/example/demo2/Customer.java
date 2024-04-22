package org.example.demo2;

public class Customer {
    String name;
    String streetAddress;
    String city;
    String state;
    String zip;
    String beerLicense;
    String payment;
    String loadingDockCapabilities;
    String deliveryConstraints;
    public Customer(
            String name,
            String streetAddress,
            String city,
            String state,
            String zip,
            String beerLicense,
            String payment,
            String loadingDockCapabilities,
            String deliveryConstraints
    ){

        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.beerLicense = beerLicense;
        this.payment = payment;
        this.loadingDockCapabilities = loadingDockCapabilities;
        this.deliveryConstraints = deliveryConstraints;
    }
}
