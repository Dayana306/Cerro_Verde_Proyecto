package com.cerro.verde.controllers;
import com.cerro.verde.entities.LecturaParametro;
import com.cerro.verde.services.LecturaParametroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/lecturas")
@CrossOrigin(origins = "*")
public class LecturaParametroController {
 private final LecturaParametroService service;
 public LecturaParametroController(LecturaParametroService service) { this.service=service; }
 @GetMapping public List<LecturaParametro> listar() { return service.listar(); }
 @GetMapping("/<built-in function id>") public ResponseEntity<LecturaParametro> buscar(@PathVariable Long id) {
  return service.buscar(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
 }
 @PostMapping public ResponseEntity<LecturaParametro> crear(@Valid @RequestBody LecturaParametro item) {
  return ResponseEntity.status(201).body(service.guardar(item));
 }
 @PutMapping("/<built-in function id>") public ResponseEntity<LecturaParametro> actualizar(@PathVariable Long id, @Valid @RequestBody LecturaParametro item) {
  if (service.buscar(id).isEmpty()) return ResponseEntity.notFound().build();
  item.setId(id); return ResponseEntity.ok(service.guardar(item));
 }
 @DeleteMapping("/<built-in function id>") public ResponseEntity<Void> eliminar(@PathVariable Long id) {
  if (service.buscar(id).isEmpty()) return ResponseEntity.notFound().build();
  service.eliminar(id); return ResponseEntity.noContent().build();
 }
}
