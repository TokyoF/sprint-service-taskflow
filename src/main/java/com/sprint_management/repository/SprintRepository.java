
package com.sprint_management.repository;

import com.sprint_management.model.SprintEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepository extends JpaRepository<SprintEntity, Long> {
  // Podemos agregar métodos personalizados si es necesario, por ejemplo:
  // List<SprintEntity> findByStatus(SprintStatus status);
}
