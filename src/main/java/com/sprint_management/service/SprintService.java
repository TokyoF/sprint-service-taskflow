
package com.sprint_management.service;

import com.sprint_management.dto.SprintRequest;
import com.sprint_management.dto.SprintResponse;
import com.sprint_management.exception.SprintNotFoundException;
import com.sprint_management.model.SprintEntity;
import com.sprint_management.model.SprintStatus;
import com.sprint_management.repository.SprintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SprintService {

  private final SprintRepository sprintRepository;

  /**
   * Crear un nuevo sprint.
   *
   * @param sprintRequest Información del sprint a crear.
   * @return SprintResponse con los datos del sprint creado.
   */
  public SprintResponse createSprint(SprintRequest sprintRequest) {
    SprintEntity sprintEntity = SprintEntity.builder()
        .name(sprintRequest.getName())
        .startDate(sprintRequest.getStartDate())
        .endDate(sprintRequest.getEndDate())
        .goal(sprintRequest.getGoal())
        .status(SprintStatus.valueOf(sprintRequest.getStatus().toUpperCase()))
        .build();

    SprintEntity savedSprint = sprintRepository.save(sprintEntity);
    return mapToResponse(savedSprint);
  }

  /**
   * Obtener un sprint por su ID.
   *
   * @param id Identificador del sprint.
   * @return SprintResponse con los datos del sprint.
   */
  public SprintResponse getSprintById(Long id) {
    SprintEntity sprint = sprintRepository.findById(id)
        .orElseThrow(() -> new SprintNotFoundException("Sprint no encontrado con ID: " + id));
    return mapToResponse(sprint);
  }

  /**
   * Actualizar un sprint existente.
   *
   * @param id            Identificador del sprint.
   * @param sprintRequest Información para actualizar el sprint.
   * @return SprintResponse con los datos actualizados del sprint.
   */
  public SprintResponse updateSprint(Long id, SprintRequest sprintRequest) {
    SprintEntity sprint = sprintRepository.findById(id)
        .orElseThrow(() -> new SprintNotFoundException("Sprint no encontrado con ID: " + id));

    sprint.setName(sprintRequest.getName());
    sprint.setStartDate(sprintRequest.getStartDate());
    sprint.setEndDate(sprintRequest.getEndDate());
    sprint.setGoal(sprintRequest.getGoal());
    sprint.setStatus(SprintStatus.valueOf(sprintRequest.getStatus().toUpperCase()));

    SprintEntity updatedSprint = sprintRepository.save(sprint);
    return mapToResponse(updatedSprint);
  }

  /**
   * Eliminar un sprint por su ID.
   *
   * @param id Identificador del sprint.
   */
  public void deleteSprint(Long id) {
    SprintEntity sprint = sprintRepository.findById(id)
        .orElseThrow(() -> new SprintNotFoundException("Sprint no encontrado con ID: " + id));
    sprintRepository.delete(sprint);
  }

  /**
   * Mapear una entidad Sprint a un DTO SprintResponse.
   *
   * @param sprint Entidad Sprint.
   * @return SprintResponse correspondiente.
   */
  private SprintResponse mapToResponse(SprintEntity sprint) {
    return SprintResponse.builder()
        .id(sprint.getId())
        .name(sprint.getName())
        .startDate(sprint.getStartDate())
        .endDate(sprint.getEndDate())
        .goal(sprint.getGoal())
        .status(sprint.getStatus().name())
        .build();
  }
}
