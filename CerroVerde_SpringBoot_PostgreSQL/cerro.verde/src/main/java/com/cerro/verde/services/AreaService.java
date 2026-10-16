package com.cerro.verde.services;
import com.cerro.verde.entities.Area;
import com.cerro.verde.repositories.AreaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class AreaService {
 private final AreaRepository repository;
 public AreaService(AreaRepository repository) { this.repository=repository; }
 public List<Area> listar() { return repository.findAll(); }
 public Optional<Area> buscar(Long id) { return repository.findById(id); }
 public Area guardar(Area item) { return repository.save(item); }
 public void eliminar(Long id) { repository.deleteById(id); }
}
