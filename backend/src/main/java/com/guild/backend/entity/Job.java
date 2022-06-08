package com.guild.backend.entity;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@NamedQuery(name = "Job.findByAdventurerAndDate",
        query = "SELECT id From Job Where EXTRACT(YEAR FROM date_closed) = 2022 and adventurer_id = ?1 and EXTRACT(MONTH FROM date_closed) = ?2")
public class Job {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @NotEmpty(message = "Title cannot be empty or null")
    private String title;

    @Column(name = "descriptions")
    @NotEmpty(message = "Description cannot be empty or null")
    private String description;

    @Column(name = "rank")
    private String rank;

    @Column(name = "reward")
    @DecimalMin(value = "0", message = "Reward cannot be below zero")
    private float reward;

    @Column(name = "location")
    @NotEmpty(message = "Location cannot be empty or null")
    private String location;

    @Lob
    @Column(name = "photo_url")
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] image;

    @Column(name = "status")
    private String status;

    @Column(name = "date_added")
    private LocalDateTime date_added;

    @Column(name = "date_accepted")
    private LocalDateTime date_accepted;

    @Column(name = "date_closed")
    private LocalDateTime date_closed;

    @Column(name = "adventurer_id")
    private Long adventurer_id;

    @Column(name = "customer_id")
    private Long customer_id;

    @Column(name = "date_accepted")
    private LocalDateTime date_accepted;
}
