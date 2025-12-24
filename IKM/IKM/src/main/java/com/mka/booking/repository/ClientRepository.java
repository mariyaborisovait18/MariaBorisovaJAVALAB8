package com.mka.booking.repository;

import com.mka.booking.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для работы с сущностью {@link Client}.
 * Предоставляет стандартные CRUD‑операции через Spring Data JPA.
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
}
