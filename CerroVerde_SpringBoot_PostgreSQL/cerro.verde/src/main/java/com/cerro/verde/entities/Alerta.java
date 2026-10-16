package com.cerro.verde.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.time.LocalDateTime;
@Entity @Table(name="alerta", indexes={@Index(name="idx_alerta_estado_tipo", columnList="estado,tipo_alerta")})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Alerta {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id_alerta") private Long id;
 @NotBlank @Column(name="tipo_alerta", nullable=false, length=40) private String tipoAlerta;
 @Column(name="valor_detectado", nullable=false) private Double valorDetectado;
 @Column(name="fecha_deteccion", nullable=false) private LocalDateTime fechaDeteccion;
 @Column(nullable=false, length=30) @Builder.Default private String estado="ACTIVA";
 @ManyToOne(fetch=FetchType.EAGER, optional=false) @JoinColumn(name="id_monitoreo", nullable=false) private Monitoreo monitoreo;
 @ManyToOne(fetch=FetchType.EAGER, optional=false) @JoinColumn(name="id_parametro", nullable=false) private Parametro parametro;
}
