
package com.sprint_management.controller;

import com.sprint_management.dto.SprintRequest;
import com.sprint_management.dto.SprintResponse;
import com.sprint_management.service.SprintService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sprints")
@RequiredArgsConstructor
public class SprintController {

  private final SprintService sprintService;

  /**
   * Crear un nuevo sprint.
   *
   * @param sprintRequest Datos del sprint a crear.
   * @return Respuesta con los datos del sprint creado.
   */
  @PostMapping
  public ResponseEntity<SprintResponse> createSprint(@RequestBody SprintRequest sprintRequest) {
    SprintResponse sprintResponse = sprintService.createSprint(sprintRequest);
    return new ResponseEntity<>(sprintResponse, HttpStatus.CREATED);
  }

  /**
   * Obtener un sprint por su ID.
   *
   * @param id Identificador del sprint.
   * @return Respuesta con los datos del sprint solicitado.
   */
  @GetMapping("/{id}")
  public ResponseEntity<SprintResponse> getSprintById(@PathVariable Long id) {
    SprintResponse sprintResponse = sprintService.getSprintById(id);
    return ResponseEntity.ok(sprintResponse);
  }

  /**
   * Actualizar un sprint existente.
   *
   * @param id            Identificador del sprint.
   * @param sprintRequest Datos actualizados del sprint.
   * @return Respuesta con los datos del sprint actualizado.
   */
  @PutMapping("/{id}")
  public ResponseEntity<SprintResponse> updateSprint(@PathVariable Long id, @RequestBody SprintRequest sprintRequest) {
    SprintResponse sprintResponse = sprintService.updateSprint(id, sprintRequest);
    return ResponseEntity.ok(sprintResponse);
  }

  /**
   * Eliminar un sprint por su ID.
   *
   * @param id Identificador del sprint.
   * @return Respuesta con un código de estado 204 (sin contenido).
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteSprint(@PathVariable Long id) {
    sprintService.deleteSprint(id);
    return ResponseEntity.noContent().build();
  }
}
