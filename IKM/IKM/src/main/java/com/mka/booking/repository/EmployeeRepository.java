package com.mka.booking.repository;

import com.mka.booking.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для работы с сущностью {@link Employee}.
 * Предоставляет стандартные CRUD‑операции через Spring Data JPA.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
