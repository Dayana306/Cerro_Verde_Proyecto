package com.cerro.verde.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.time.LocalDateTime;
@Entity @Table(name="monitoreo")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Monitoreo {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id_monitoreo") private Long id;
 @NotBlank @Column(name="tipo_muestreo", nullable=false, length=60) private String tipoMuestreo;
 @Column(name="hora_muestreo", nullable=false) private LocalDateTime horaMuestreo;
 @Column(length=1000) private String observacion;
 @ManyToOne(fetch=FetchType.EAGER, optional=false) @JoinColumn(name="id_punto", nullable=false) private PuntoMonitoreo punto;
}
