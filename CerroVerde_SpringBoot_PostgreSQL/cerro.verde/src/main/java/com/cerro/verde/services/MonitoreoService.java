package com.cerro.verde.services;
import com.cerro.verde.entities.Monitoreo;
import com.cerro.verde.repositories.MonitoreoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class MonitoreoService {
 private final MonitoreoRepository repository;
 public MonitoreoService(MonitoreoRepository repository) { this.repository=repository; }
 public List<Monitoreo> listar() { return repository.findAll(); }
 public Optional<Monitoreo> buscar(Long id) { return repository.findById(id); }
 public Monitoreo guardar(Monitoreo item) { return repository.save(item); }
 public void eliminar(Long id) { repository.deleteById(id); }
}
