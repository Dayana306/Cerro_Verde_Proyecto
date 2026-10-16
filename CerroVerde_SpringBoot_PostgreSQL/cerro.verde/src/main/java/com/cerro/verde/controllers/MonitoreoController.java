package com.cerro.verde.controllers;
import com.cerro.verde.entities.Monitoreo;
import com.cerro.verde.services.MonitoreoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/monitoreos")
@CrossOrigin(origins = "*")
public class MonitoreoController {
 private final MonitoreoService service;
 public MonitoreoController(MonitoreoService service) { this.service=service; }
 @GetMapping public List<Monitoreo> listar() { return service.listar(); }
 @GetMapping("/<built-in function id>") public ResponseEntity<Monitoreo> buscar(@PathVariable Long id) {
  return service.buscar(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
 }
 @PostMapping public ResponseEntity<Monitoreo> crear(@Valid @RequestBody Monitoreo item) {
  return ResponseEntity.status(201).body(service.guardar(item));
 }
 @PutMapping("/<built-in function id>") public ResponseEntity<Monitoreo> actualizar(@PathVariable Long id, @Valid @RequestBody Monitoreo item) {
  if (service.buscar(id).isEmpty()) return ResponseEntity.notFound().build();
  item.setId(id); return ResponseEntity.ok(service.guardar(item));
 }
 @DeleteMapping("/<built-in function id>") public ResponseEntity<Void> eliminar(@PathVariable Long id) {
  if (service.buscar(id).isEmpty()) return ResponseEntity.notFound().build();
  service.eliminar(id); return ResponseEntity.noContent().build();
 }
}
