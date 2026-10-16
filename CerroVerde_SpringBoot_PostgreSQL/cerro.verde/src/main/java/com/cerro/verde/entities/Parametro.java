package com.cerro.verde.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
@Entity @Table(name="parametro")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Parametro {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id_parametro") private Long id;
 @NotBlank @Column(name="nombre_parametro", nullable=false, unique=true, length=100) private String nombre;
 @Column(length=300) private String descripcion;
 @NotBlank @Column(name="unidad_medida", nullable=false, length=30) private String unidadMedida;
 @Column(name="rango_min") private Double rangoMin;
 @Column(name="rango_max") private Double rangoMax;
 @Column(nullable=false) @Builder.Default private Boolean estado=true;
}
