package com.example.demo.model.jpa;

import javax.persistence.*;
import java.util.List;

@Entity
public class Services {

    @Id
    @GeneratedValue
    @Column(name = "service_id")
    private int serviceId;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "location")
    private String location;

    @ManyToMany
    @JoinTable(name = "ServicesOrders", catalog = "postgres", schema = "public", joinColumns = @JoinColumn(name = "service_id", referencedColumnName = "service_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false))
    private List<Orders> orders;

    public Services(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Services() {
    }

    public int getServiceId() {
        return serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Services services = (Services) o;

        if (serviceId != services.serviceId) return false;
        if (name != null ? !name.equals(services.name) : services.name != null) return false;
        if (location != null ? !location.equals(services.location) : services.location != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = serviceId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Services{" +
                "serviceId=" + serviceId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", orders=" + orders +
                '}';
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
