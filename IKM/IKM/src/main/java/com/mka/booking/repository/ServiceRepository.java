package com.mka.booking.repository;

import com.mka.booking.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для работы с сущностью {@link Service}.
 * Предоставляет стандартные CRUD‑операции через Spring Data JPA.
 */
public interface ServiceRepository extends JpaRepository<Service, Long> {
}
