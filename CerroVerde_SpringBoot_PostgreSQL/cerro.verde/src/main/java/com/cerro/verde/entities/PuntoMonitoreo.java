package com.cerro.verde.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
@Entity @Table(name="punto_monitoreo")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class PuntoMonitoreo {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id_punto") private Long id;
 @NotBlank @Column(name="nombre_punto", nullable=false, length=120) private String nombre;
 @Column(length=300) private String descripcion;
 @DecimalMin("-90.0") @DecimalMax("90.0") private Double latitud;
 @DecimalMin("-180.0") @DecimalMax("180.0") private Double longitud;
 @Column(nullable=false) @Builder.Default private Boolean estado=true;
 @ManyToOne(fetch=FetchType.EAGER, optional=false) @JoinColumn(name="id_zona", nullable=false) private Zona zona;
 @ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name="id_area") private Area area;
}
