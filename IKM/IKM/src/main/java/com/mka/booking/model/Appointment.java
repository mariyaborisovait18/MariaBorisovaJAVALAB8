package com.mka.booking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Сущность, представляющая запись клиента на услугу.
 * Содержит информацию о клиенте, сотруднике, услуге и времени записи.
 */
@Entity
@Table(name = "appointment")
@Getter
@Setter
public class Appointment {

    /**
     * Уникальный идентификатор записи.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Клиент, на которого оформлена запись.
     * Поле обязательно для заполнения.
     */
    @NotNull(message = "Клиент обязателен")
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    /**
     * Сотрудник, который будет выполнять услугу.
     * Поле обязательно для заполнения.
     */
    @NotNull(message = "Сотрудник обязателен")
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    /**
     * Услуга, выбранная клиентом.
     * Поле обязательно для заполнения.
     */
    @NotNull(message = "Услуга обязательна")
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    /**
     * Дата и время проведения записи.
     * Поле обязательно для заполнения.
     */
    @NotNull(message = "Дата и время обязательны")
    @Column(nullable = false)
    private LocalDateTime dateTime;
}
