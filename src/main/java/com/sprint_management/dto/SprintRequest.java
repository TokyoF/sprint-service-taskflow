
package com.sprint_management.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SprintRequest {

  private String name; // Nombre del Sprint
  private LocalDate startDate; // Fecha de inicio
  private LocalDate endDate; // Fecha de finalización
  private String goal; // Objetivo del Sprint
  private String status; // Estado del Sprint (como texto, luego se mapeará al enum)
}
