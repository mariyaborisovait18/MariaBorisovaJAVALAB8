package com.mka.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Главный класс приложения Booking.
 * Запускает Spring Boot и инициализирует все компоненты системы.
 */
@SpringBootApplication
public class BookingApplication {

    /**
     * Точка входа в приложение.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        SpringApplication.run(BookingApplication.class, args);
    }
}
