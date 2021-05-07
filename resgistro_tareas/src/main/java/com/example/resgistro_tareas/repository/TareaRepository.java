package com.example.resgistro_tareas.repository;

import com.example.resgistro_tareas.entity.TareaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<TareaEntity,Long> {
}
