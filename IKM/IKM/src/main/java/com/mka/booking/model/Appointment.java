package com.mka.booking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
@Getter
@Setter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull(message = "Клиент обязателен")
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @NotNull(message = "Сотрудник обязателен")
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @NotNull(message = "Услуга обязательна")
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @NotNull(message = "Дата и время обязательны")
    @Column(nullable = false)
    private LocalDateTime dateTime;
}