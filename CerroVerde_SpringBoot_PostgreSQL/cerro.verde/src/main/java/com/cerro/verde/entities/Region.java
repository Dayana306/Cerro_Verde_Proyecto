package com.cerro.verde.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
@Entity @Table(name="region")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Region {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id_region") private Long id;
 @NotBlank @Column(name="nombre_region", nullable=false, unique=true, length=100) private String nombre;
 @Column(length=300) private String descripcion;
 @Column(nullable=false) @Builder.Default private Boolean estado=true;
}
