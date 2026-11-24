package com.example.grupoJovenU4P3.repository;

import com.example.grupoJovenU4P3.model.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;

// Permite realizar operaciones con las actividades en la base de datos.
public interface ActividadRepository extends JpaRepository<Actividad, Long> {
    // Spring Data JPA proporciona automáticamente las operaciones básicas.
}