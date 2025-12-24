package com.mka.booking.model;

import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Сущность, представляющая клиента.
 * Содержит основную контактную информацию и список его записей.
 */
@Entity
@Table(name = "client")
@Getter
@Setter
public class Client {

    /**
     * Уникальный идентификатор клиента.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Имя клиента.
     * Поле обязательно для заполнения.
     */
    @NotBlank(message = "Имя клиента обязательно")
    @Column(nullable = false)
    private String name;

    /**
     * Телефон клиента.
     * Должен содержать от 7 до 15 цифр, допускается ведущий знак '+'.
     */
    @NotBlank(message = "Телефон обязателен")
    @Pattern(regexp = "\\+?[0-9]{7,15}", message = "Телефон должен содержать от 7 до 15 цифр")
    @Column(nullable = false)
    private String phone;

    /**
     * Список записей, связанных с клиентом.
     * Связь один-ко-многим.
     */
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    /**
     * Email клиента.
     * Не является обязательным, но должен быть корректным при заполнении.
     */
    @Email(message = "Введите корректный email")
    private String email;
}
