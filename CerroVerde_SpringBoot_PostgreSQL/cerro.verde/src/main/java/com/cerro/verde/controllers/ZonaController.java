package com.cerro.verde.controllers;
import com.cerro.verde.entities.Zona;
import com.cerro.verde.services.ZonaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/zonas")
@CrossOrigin(origins = "*")
public class ZonaController {
 private final ZonaService service;
 public ZonaController(ZonaService service) { this.service=service; }
 @GetMapping public List<Zona> listar() { return service.listar(); }
 @GetMapping("/<built-in function id>") public ResponseEntity<Zona> buscar(@PathVariable Long id) {
  return service.buscar(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
 }
 @PostMapping public ResponseEntity<Zona> crear(@Valid @RequestBody Zona item) {
  return ResponseEntity.status(201).body(service.guardar(item));
 }
 @PutMapping("/<built-in function id>") public ResponseEntity<Zona> actualizar(@PathVariable Long id, @Valid @RequestBody Zona item) {
  if (service.buscar(id).isEmpty()) return ResponseEntity.notFound().build();
  item.setId(id); return ResponseEntity.ok(service.guardar(item));
 }
 @DeleteMapping("/<built-in function id>") public ResponseEntity<Void> eliminar(@PathVariable Long id) {
  if (service.buscar(id).isEmpty()) return ResponseEntity.notFound().build();
  service.eliminar(id); return ResponseEntity.noContent().build();
 }
}
