package com.cerro.verde.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDateTime;
@Entity @Table(name="lectura_parametro", indexes={@Index(name="idx_lectura_fecha", columnList="fecha_hora")})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class LecturaParametro {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id_lectura") private Long id;
 @NotNull @Column(nullable=false) private Double valor;
 @Column(name="fecha_hora", nullable=false) private LocalDateTime fechaHora;
 @ManyToOne(fetch=FetchType.EAGER, optional=false) @JoinColumn(name="id_monitoreo", nullable=false) private Monitoreo monitoreo;
 @ManyToOne(fetch=FetchType.EAGER, optional=false) @JoinColumn(name="id_parametro", nullable=false) private Parametro parametro;
}
