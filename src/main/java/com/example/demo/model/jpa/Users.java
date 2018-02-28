package com.example.demo.model.jpa;

import javax.persistence.*;
import java.util.List;


@Entity
public class Users {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int userId;

    @Basic
    @Column(name = "location")
    private String location;

    @Basic
    @Column(name = "car_brand")
    private String carBrand;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "order_status")
    private String orderStatus;

    @OneToMany(mappedBy = "user")
    private List<Orders> orders;

    public Users(String location, String carBrand, String name) {
        this.location = location;
        this.carBrand = carBrand;
        this.name = name;
    }

    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", location='" + location + '\'' +
                ", carBrand='" + carBrand + '\'' +
                ", name='" + name + '\'' +
                ", orderStatus='" + orderStatus +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (userId != users.userId) return false;
        if (location != null ? !location.equals(users.location) : users.location != null) return false;
        if (carBrand != null ? !carBrand.equals(users.carBrand) : users.carBrand != null) return false;
        if (name != null ? !name.equals(users.name) : users.name != null) return false;
        if (orderStatus != null ? !orderStatus.equals(users.orderStatus) : users.orderStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (carBrand != null ? carBrand.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        return result;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
