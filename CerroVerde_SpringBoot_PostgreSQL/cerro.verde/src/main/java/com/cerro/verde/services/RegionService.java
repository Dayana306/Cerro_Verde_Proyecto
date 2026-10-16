package com.cerro.verde.services;
import com.cerro.verde.entities.Region;
import com.cerro.verde.repositories.RegionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class RegionService {
 private final RegionRepository repository;
 public RegionService(RegionRepository repository) { this.repository=repository; }
 public List<Region> listar() { return repository.findAll(); }
 public Optional<Region> buscar(Long id) { return repository.findById(id); }
 public Region guardar(Region item) { return repository.save(item); }
 public void eliminar(Long id) { repository.deleteById(id); }
}
