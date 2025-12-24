package com.mka.booking.model;

import jakarta.persistence.*;
import java.util.List;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Сущность, представляющая сотрудника.
 * Содержит информацию о его имени, специализации и связанных записях.
 */
@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {

    /**
     * Уникальный идентификатор сотрудника.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Имя сотрудника.
     * Поле обязательно для заполнения.
     */
    @NotBlank(message = "Имя сотрудника обязательно")
    @Column(nullable = false)
    private String name;

    /**
     * Список записей, связанных с сотрудником.
     * Связь один-ко-многим.
     */
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;

    /**
     * Специализация сотрудника.
     * Поле обязательно для заполнения.
     */
    @NotBlank(message = "Специализация обязательна")
    private String specialization;
}
