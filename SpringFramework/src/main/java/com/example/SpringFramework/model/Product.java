package com.example.SpringFramework.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "\"products\"")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    @NotEmpty(message = "Không được để trống")
    @NotNull(message = "Không được để trống")
    @NotBlank(message = "Không được để trống")
    @Size(min = 4, max = 255, message = "Code phải từ 4 đến 255 ký tự")
    String code;

    @NotNull(message = "Không được để trống")
    @NotEmpty(message = "Không được để trống")
    @NotBlank(message = "Không được để trống")
    @Size(min = 6, max = 255, message = "Name phải từ 6 đến 255 ký tự")
    String name;

    @NotNull(message = "Không được để trống")
    @Min(value = 1, message = "Price không được bé hơn 1")
    double price;
}
