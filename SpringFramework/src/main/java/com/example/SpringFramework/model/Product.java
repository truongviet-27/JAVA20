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

    @Column(nullable = false, length = 6)
    @NotEmpty(message = "Không được để trống")
    @NotNull(message = "Không được để trống")
    @NotBlank(message = "Không được để trống")
    String code;

    @NotNull(message = "Không được để trống")
    @NotEmpty(message = "Không được để trống")
    @NotBlank(message = "Không được để trống")
    @Min(value = 6, message = "Không được ngắn hơn 6 ký tự")
    @Max(value = 255, message = "Không được dài hơn 255 ký tự")
    String name;

    @NotNull(message = "Không được để trống")
    @NotEmpty(message = "Không được để trống")
    @NotBlank(message = "Không được để trống")
    double price;
}
