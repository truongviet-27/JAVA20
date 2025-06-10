package com.example.SpringFramework.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Scope;

@Entity
@Table(name = "\"users\"")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "fullName", nullable = false)
    String fullName;
    @Column(nullable = false)
    int age;
    @Column(nullable = false)
    String address;
    @Column(nullable = false)
    double mark;

    @ManyToOne
    @JoinColumn(name = "role_id")
    Role role;

    public User(String fullName, int age, String address, double mark) {
        this.fullName = fullName;
        this.age = age;
        this.address = address;
        this.mark = mark;
    }

    public User(String fullName, int age, String address, double mark, Role role) {
        this.fullName = fullName;
        this.age = age;
        this.address = address;
        this.mark = mark;
        this.role = role;
    }
}
