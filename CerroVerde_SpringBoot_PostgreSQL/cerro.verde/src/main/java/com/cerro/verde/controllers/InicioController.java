package com.cerro.verde.controllers;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController
@CrossOrigin(origins = "*")
public class InicioController {
 @GetMapping("/")
 public Map<String,Object> inicio() {
  return Map.of("proyecto","Sistema Web de Monitoreo Hídrico - Cerro Verde",
   "estado","API REST activa","baseDatos","PostgreSQL",
   "recursos",new String[]{"/api/areas","/api/regiones","/api/zonas","/api/puntos-monitoreo","/api/parametros","/api/monitoreos","/api/lecturas","/api/alertas"});
 }
}
