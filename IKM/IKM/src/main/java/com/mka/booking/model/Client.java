package com.mka.booking.model;
import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "client")
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Имя клиента обязательно")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Телефон обязателен")
    @Pattern(regexp = "\\+?[0-9]{7,15}", message = "Телефон должен содержать от 7 до 15 цифр")
    @Column(nullable = false)
    private String phone;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @Email(message = "Введите корректный email")
    private String email;
}
