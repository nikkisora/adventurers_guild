package com.guild.backend.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
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
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "surname")
    @NotEmpty(message = "Surname cannot be empty or null")
    private String surname;

    @Column(name = "firstname")
    @NotEmpty(message = "Firstname cannot be empty or null")
    private String firstname;

    @Column(name = "patronymic")
    @NotEmpty(message = "Patronymic cannot be empty or null")
    private String patronymic;

    @Column(name = "login")
    @NotEmpty(message = "Login cannot be empty or null")
    private String login;

    @Column(name = "password")
    @NotEmpty(message = "Password cannot be empty or null")
    private String password;

    @Column(name = "rank")
    private String rank;

    @Column(name = "age")
    @NotEmpty(message = "Age cannot be empty or null")
    private int age;

    @Column(name = "sex")
    @NotEmpty(message = "Sex cannot be empty or null")
    private String sex;

    @Column(name = "adventurer")
    @NotEmpty(message = "Adventurer cannot be empty or null")
    private boolean adventurer;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "email")
    private String email;
}
