package com.cerro.verde.controllers;
import com.cerro.verde.entities.Parametro;
import com.cerro.verde.services.ParametroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/parametros")
@CrossOrigin(origins = "*")
public class ParametroController {
 private final ParametroService service;
 public ParametroController(ParametroService service) { this.service=service; }
 @GetMapping public List<Parametro> listar() { return service.listar(); }
 @GetMapping("/<built-in function id>") public ResponseEntity<Parametro> buscar(@PathVariable Long id) {
  return service.buscar(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
 }
 @PostMapping public ResponseEntity<Parametro> crear(@Valid @RequestBody Parametro item) {
  return ResponseEntity.status(201).body(service.guardar(item));
 }
 @PutMapping("/<built-in function id>") public ResponseEntity<Parametro> actualizar(@PathVariable Long id, @Valid @RequestBody Parametro item) {
  if (service.buscar(id).isEmpty()) return ResponseEntity.notFound().build();
  item.setId(id); return ResponseEntity.ok(service.guardar(item));
 }
 @DeleteMapping("/<built-in function id>") public ResponseEntity<Void> eliminar(@PathVariable Long id) {
  if (service.buscar(id).isEmpty()) return ResponseEntity.notFound().build();
  service.eliminar(id); return ResponseEntity.noContent().build();
 }
}
