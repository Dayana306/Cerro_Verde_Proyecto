package com.cerro.verde.services;
import com.cerro.verde.entities.Alerta;
import com.cerro.verde.repositories.AlertaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class AlertaService {
 private final AlertaRepository repository;
 public AlertaService(AlertaRepository repository) { this.repository=repository; }
 public List<Alerta> listar() { return repository.findAll(); }
 public Optional<Alerta> buscar(Long id) { return repository.findById(id); }
 public Alerta guardar(Alerta item) { return repository.save(item); }
 public void eliminar(Long id) { repository.deleteById(id); }
}
