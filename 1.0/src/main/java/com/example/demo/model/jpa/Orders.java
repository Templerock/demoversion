package com.example.demo.model.jpa;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
public class Orders {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private int orderId;

    @Basic
    @Column(name = "order_date ")
    private Date orderDate;

    @Basic
    @Column(name = "execution_date ")
    private Date executionDate;

    @Basic
    @Column(name = "order_status")
    private String orderStatus;


    @ManyToMany(mappedBy = "orders")
    private List<Services> services;

    @ManyToOne
    @JoinTable(name = "UsersOrders", catalog = "postgres", schema = "public", joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false))
    private Users user;

    public Orders() {
        this.orderDate = new Date();
    }

    public int getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Date getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate() {
        this.executionDate = new Date();
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

        Orders orders = (Orders) o;

        if (orderId != orders.orderId) return false;
        if (orderDate != null ? !orderDate.equals(orders.orderDate) : orders.orderDate != null) return false;
        if (executionDate != null ? !executionDate.equals(orders.executionDate) : orders.executionDate != null)
            return false;
        if (orderStatus != null ? !orderStatus.equals(orders.orderStatus) : orders.orderStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (executionDate != null ? executionDate.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", executionDate=" + executionDate +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }

    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
