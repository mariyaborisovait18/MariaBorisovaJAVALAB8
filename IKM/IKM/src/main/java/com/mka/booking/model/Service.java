package com.mka.booking.model;

import jakarta.persistence.*;
import java.util.List;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "service")
@Data
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Название услуги обязательно")
    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Длительность обязательна")
    @Min(1)
    @Column(nullable = false)
    private Integer duration; // в минутах

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;

    @NotNull(message = "Цена обязательна")
    @DecimalMin("0.0")
    @Column(nullable = false)
    private Double price;
}
