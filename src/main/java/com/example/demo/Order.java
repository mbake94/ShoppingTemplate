package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "order_db")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "subtotal")
    private double subtotal;

    private double total;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "customer_id")
//
}
