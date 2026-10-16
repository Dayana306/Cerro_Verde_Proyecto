package com.cerro.verde.controllers;
import com.cerro.verde.entities.PuntoMonitoreo;
import com.cerro.verde.services.PuntoMonitoreoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/puntos-monitoreo")
@CrossOrigin(origins = "*")
public class PuntoMonitoreoController {
 private final PuntoMonitoreoService service;
 public PuntoMonitoreoController(PuntoMonitoreoService service) { this.service=service; }
 @GetMapping public List<PuntoMonitoreo> listar() { return service.listar(); }
 @GetMapping("/<built-in function id>") public ResponseEntity<PuntoMonitoreo> buscar(@PathVariable Long id) {
  return service.buscar(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
 }
 @PostMapping public ResponseEntity<PuntoMonitoreo> crear(@Valid @RequestBody PuntoMonitoreo item) {
  return ResponseEntity.status(201).body(service.guardar(item));
 }
 @PutMapping("/<built-in function id>") public ResponseEntity<PuntoMonitoreo> actualizar(@PathVariable Long id, @Valid @RequestBody PuntoMonitoreo item) {
  if (service.buscar(id).isEmpty()) return ResponseEntity.notFound().build();
  item.setId(id); return ResponseEntity.ok(service.guardar(item));
 }
 @DeleteMapping("/<built-in function id>") public ResponseEntity<Void> eliminar(@PathVariable Long id) {
  if (service.buscar(id).isEmpty()) return ResponseEntity.notFound().build();
  service.eliminar(id); return ResponseEntity.noContent().build();
 }
}
