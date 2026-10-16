package com.cerro.verde.services;
import com.cerro.verde.entities.PuntoMonitoreo;
import com.cerro.verde.repositories.PuntoMonitoreoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class PuntoMonitoreoService {
 private final PuntoMonitoreoRepository repository;
 public PuntoMonitoreoService(PuntoMonitoreoRepository repository) { this.repository=repository; }
 public List<PuntoMonitoreo> listar() { return repository.findAll(); }
 public Optional<PuntoMonitoreo> buscar(Long id) { return repository.findById(id); }
 public PuntoMonitoreo guardar(PuntoMonitoreo item) { return repository.save(item); }
 public void eliminar(Long id) { repository.deleteById(id); }
}
