package com.example.SpringFramework.model;

import com.example.SpringFramework.Enum.Gender;
//import com.example.SpringFramework.annotation.ValidDate;
import com.example.SpringFramework.annotation.ValidBirthDate;
import com.example.SpringFramework.annotation.ValidGender;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "\"customers\"")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    @NotNull(message = "Không được để trống")
    @NotEmpty(message = "Không được để trống")
    @NotBlank(message = "Không được để trống")
    @Size(min = 6, message = "Không được ngắn hơn 6 ký tự")
    @Pattern(regexp = "^[\\p{L}\\s]+$", message = "Không được chứa ký tự đặc biệt")
    String name;

    @Column
    @NotNull(message = "Không được để trống")
    @ValidGender
    Gender gender;

    @Column
    @NotNull(message = "Không được để trống")
    @NotEmpty(message = "Không được để trống")
    @NotBlank(message = "Không được để trống")
    String address;

    @Column
    @NotNull(message = "Không được để trống")
    @ValidBirthDate
    LocalDate birthdate;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @NotNull(message = "Không được để trống")
    Role role;

    public Customer(String name, Gender gender, String address, LocalDate birthdate) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.birthdate = birthdate;
    }

    public Customer(String name, Gender gender, String address, LocalDate birthdate, Role role) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.birthdate = birthdate;
        this.role = role;
    }


}
