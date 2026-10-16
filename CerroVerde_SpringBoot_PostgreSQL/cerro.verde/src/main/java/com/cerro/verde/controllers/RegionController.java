package com.cerro.verde.controllers;
import com.cerro.verde.entities.Region;
import com.cerro.verde.services.RegionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/regiones")
@CrossOrigin(origins = "*")
public class RegionController {
 private final RegionService service;
 public RegionController(RegionService service) { this.service=service; }
 @GetMapping public List<Region> listar() { return service.listar(); }
 @GetMapping("/<built-in function id>") public ResponseEntity<Region> buscar(@PathVariable Long id) {
  return service.buscar(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
 }
 @PostMapping public ResponseEntity<Region> crear(@Valid @RequestBody Region item) {
  return ResponseEntity.status(201).body(service.guardar(item));
 }
 @PutMapping("/<built-in function id>") public ResponseEntity<Region> actualizar(@PathVariable Long id, @Valid @RequestBody Region item) {
  if (service.buscar(id).isEmpty()) return ResponseEntity.notFound().build();
  item.setId(id); return ResponseEntity.ok(service.guardar(item));
 }
 @DeleteMapping("/<built-in function id>") public ResponseEntity<Void> eliminar(@PathVariable Long id) {
  if (service.buscar(id).isEmpty()) return ResponseEntity.notFound().build();
  service.eliminar(id); return ResponseEntity.noContent().build();
 }
}
