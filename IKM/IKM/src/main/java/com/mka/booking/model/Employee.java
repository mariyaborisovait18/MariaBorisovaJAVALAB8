package com.mka.booking.model;

import jakarta.persistence.*;
import java.util.List;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Имя сотрудника обязательно")
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;

    @NotBlank(message = "Специализация обязательна")
    private String specialization;
}
