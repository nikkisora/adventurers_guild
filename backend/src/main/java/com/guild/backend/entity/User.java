package com.guild.backend.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    private String patronymic;

    @Column(name = "login")
    @NotEmpty(message = "Login cannot be empty or null")
    private String login;

    @Column(name = "password")
    @NotEmpty(message = "Password cannot be empty or null")
    private String password;

    @Column(name = "rank")
    private String rank;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birth_date")
    @Past(message = "Birth date cannot be in the future")
    private LocalDate birthDate;

    @Column(name = "sex")
    @NotEmpty(message = "Sex cannot be empty or null")
    private String sex;

    @Column(name = "adventurer")
    @NotNull(message = "Adventurer cannot be empty or null")
    private boolean adventurer;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "email")
    @Email(message = "Email should be valid")
    private String email;

    @Column(name = "role")
    @Email(message = "Role should be valid")
    private String role;

    public String getPasswordConfirm() {
        return password;
    }
}
