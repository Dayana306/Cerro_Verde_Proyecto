package com.cerro.verde.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
@Entity @Table(name="area")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Area {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id_area") private Long id;
 @NotBlank @Column(name="nombre_area", nullable=false, unique=true, length=100) private String nombre;
 @Column(length=300) private String descripcion;
 @Column(nullable=false) @Builder.Default private Boolean estado=true;
}
