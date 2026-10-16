package com.cerro.verde.config;
import com.cerro.verde.entities.*;
import com.cerro.verde.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDateTime;
@Configuration
public class DatosIniciales {
 @Bean
 CommandLineRunner cargarDatos(AreaRepository areas, RegionRepository regiones, ZonaRepository zonas,
   PuntoMonitoreoRepository puntos, ParametroRepository parametros, MonitoreoRepository monitoreos,
   LecturaParametroRepository lecturas, AlertaRepository alertas) {
  return args -> {
   if (areas.count()==0 && regiones.count()==0 && parametros.count()==0) {
    Area area=areas.save(Area.builder().nombre("Gestión Ambiental").descripcion("Área responsable del monitoreo hídrico").build());
    Region region=regiones.save(Region.builder().nombre("Arequipa").descripcion("Región del proyecto").build());
    Zona zona=zonas.save(Zona.builder().nombre("PTAR La Enlozada").descripcion("Zona de tratamiento y reutilización de agua").region(region).build());
    PuntoMonitoreo punto=puntos.save(PuntoMonitoreo.builder().nombre("Punto de control principal").descripcion("Punto demostrativo para pruebas del laboratorio").latitud(-16.45).longitud(-71.60).zona(zona).area(area).build());
    Parametro ph=parametros.save(Parametro.builder().nombre("pH").descripcion("Potencial de hidrógeno").unidadMedida("pH").rangoMin(6.0).rangoMax(9.0).build());
    parametros.save(Parametro.builder().nombre("Turbidez").descripcion("Turbidez del agua tratada").unidadMedida("NTU").rangoMin(0.0).rangoMax(5.0).build());
    parametros.save(Parametro.builder().nombre("Caudal").descripcion("Caudal de agua tratada").unidadMedida("m3/s").rangoMin(0.0).rangoMax(1.5).build());
    Monitoreo monitoreo=monitoreos.save(Monitoreo.builder().tipoMuestreo("MANUAL").horaMuestreo(LocalDateTime.now()).observacion("Registro de prueba inicial").punto(punto).build());
    double valorPh=7.2;
    lecturas.save(LecturaParametro.builder().valor(valorPh).fechaHora(LocalDateTime.now()).monitoreo(monitoreo).parametro(ph).build());
    if (valorPh<ph.getRangoMin() || valorPh>ph.getRangoMax()) {
     alertas.save(Alerta.builder().tipoAlerta("FUERA_DE_RANGO").valorDetectado(valorPh).fechaDeteccion(LocalDateTime.now()).estado("ACTIVA").monitoreo(monitoreo).parametro(ph).build());
    }
   }
  };
 }
}
