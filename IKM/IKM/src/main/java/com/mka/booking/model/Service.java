package com.mka.booking.model;

import jakarta.persistence.*;
import java.util.List;
import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * Сущность, представляющая услугу.
 * Содержит информацию о названии, длительности, цене и связанных записях.
 */
@Entity
@Table(name = "service")
@Data
public class Service {

    /**
     * Уникальный идентификатор услуги.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Название услуги.
     * Поле обязательно для заполнения.
     */
    @NotBlank(message = "Название услуги обязательно")
    @Column(nullable = false)
    private String name;

    /**
     * Длительность услуги в минутах.
     * Значение должно быть положительным.
     */
    @NotNull(message = "Длительность обязательна")
    @Min(1)
    @Column(nullable = false)
    private Integer duration;

    /**
     * Список записей, связанных с данной услугой.
     * Связь один-ко-многим.
     */
    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;

    /**
     * Стоимость услуги.
     * Значение должно быть неотрицательным.
     */
    @NotNull(message = "Цена обязательна")
    @DecimalMin("0.0")
    @Column(nullable = false)
    private Double price;
}
