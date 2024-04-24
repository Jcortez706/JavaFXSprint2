/**
 * This class represents a customer in the application.
 */
package org.example.demo2;

public class Customer {

    /** Name of the customer. */
    String name;

    /** Street address of the customer. */
    String streetAddress;

    /** City of the customer. */
    String city;

    /** State of the customer. */
    String state;

    /** ZIP code of the customer. */
    String zip;

    /** Beer license information of the customer. */
    String beerLicense;

    /** Payment information of the customer. */
    String payment;

    /** Loading dock capabilities of the customer. */
    String loadingDockCapabilities;

    /** Delivery constraints of the customer. */
    String deliveryConstraints;

    /**
     * Constructs a Customer object with the provided details.
     *
     * @param name                    Name of the customer.
     * @param streetAddress           Street address of the customer.
     * @param city                    City of the customer.
     * @param state                   State of the customer.
     * @param zip                     ZIP code of the customer.
     * @param beerLicense             Beer license information of the customer.
     * @param payment                 Payment information of the customer.
     * @param loadingDockCapabilities Loading dock capabilities of the customer.
     * @param deliveryConstraints     Delivery constraints of the customer.
     */
    public Customer(String name,
                    String streetAddress,
                    String city,
                    String state,
                    String zip,
                    String beerLicense,
                    String payment,
                    String loadingDockCapabilities,
                    String deliveryConstraints) {

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