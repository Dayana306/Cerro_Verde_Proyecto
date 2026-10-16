package com.cerro.verde.controllers;
import com.cerro.verde.entities.Alerta;
import com.cerro.verde.services.AlertaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/alertas")
@CrossOrigin(origins = "*")
public class AlertaController {
 private final AlertaService service;
 public AlertaController(AlertaService service) { this.service=service; }
 @GetMapping public List<Alerta> listar() { return service.listar(); }
 @GetMapping("/<built-in function id>") public ResponseEntity<Alerta> buscar(@PathVariable Long id) {
  return service.buscar(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
 }
 @PostMapping public ResponseEntity<Alerta> crear(@Valid @RequestBody Alerta item) {
  return ResponseEntity.status(201).body(service.guardar(item));
 }
 @PutMapping("/<built-in function id>") public ResponseEntity<Alerta> actualizar(@PathVariable Long id, @Valid @RequestBody Alerta item) {
  if (service.buscar(id).isEmpty()) return ResponseEntity.notFound().build();
  item.setId(id); return ResponseEntity.ok(service.guardar(item));
 }
 @DeleteMapping("/<built-in function id>") public ResponseEntity<Void> eliminar(@PathVariable Long id) {
  if (service.buscar(id).isEmpty()) return ResponseEntity.notFound().build();
  service.eliminar(id); return ResponseEntity.noContent().build();
 }
}
