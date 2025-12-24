package com.mka.booking.repository;

import com.mka.booking.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для работы с сущностью {@link Appointment}.
 * Предоставляет стандартные CRUD‑операции через Spring Data JPA.
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
