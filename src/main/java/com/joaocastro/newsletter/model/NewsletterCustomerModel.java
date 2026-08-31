package com.joaocastro.newsletter.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "newsletter_customer")
@Getter
@Setter
public class NewsletterCustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 150)
    private String mail;

    @Column(name = "REGISTER_DATE", insertable = false, updatable = false)
    private LocalDateTime registerDate;

}
