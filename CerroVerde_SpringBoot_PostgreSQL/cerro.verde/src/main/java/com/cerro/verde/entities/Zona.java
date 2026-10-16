package com.cerro.verde.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
@Entity @Table(name="zona")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Zona {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id_zona") private Long id;
 @NotBlank @Column(name="nombre_zona", nullable=false, length=100) private String nombre;
 @Column(length=300) private String descripcion;
 @Column(nullable=false) @Builder.Default private Boolean estado=true;
 @ManyToOne(fetch=FetchType.EAGER, optional=false) @JoinColumn(name="id_region", nullable=false) private Region region;
}
