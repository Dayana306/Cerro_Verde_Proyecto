package com.cerro.verde.controllers;
import com.cerro.verde.entities.Area;
import com.cerro.verde.services.AreaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/areas")
@CrossOrigin(origins = "*")
public class AreaController {
 private final AreaService service;
 public AreaController(AreaService service) { this.service=service; }
 @GetMapping public List<Area> listar() { return service.listar(); }
 @GetMapping("/<built-in function id>") public ResponseEntity<Area> buscar(@PathVariable Long id) {
  return service.buscar(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
 }
 @PostMapping public ResponseEntity<Area> crear(@Valid @RequestBody Area item) {
  return ResponseEntity.status(201).body(service.guardar(item));
 }
 @PutMapping("/<built-in function id>") public ResponseEntity<Area> actualizar(@PathVariable Long id, @Valid @RequestBody Area item) {
  if (service.buscar(id).isEmpty()) return ResponseEntity.notFound().build();
  item.setId(id); return ResponseEntity.ok(service.guardar(item));
 }
 @DeleteMapping("/<built-in function id>") public ResponseEntity<Void> eliminar(@PathVariable Long id) {
  if (service.buscar(id).isEmpty()) return ResponseEntity.notFound().build();
  service.eliminar(id); return ResponseEntity.noContent().build();
 }
}
