package com.cerro.verde.services;
import com.cerro.verde.entities.Zona;
import com.cerro.verde.repositories.ZonaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ZonaService {
 private final ZonaRepository repository;
 public ZonaService(ZonaRepository repository) { this.repository=repository; }
 public List<Zona> listar() { return repository.findAll(); }
 public Optional<Zona> buscar(Long id) { return repository.findById(id); }
 public Zona guardar(Zona item) { return repository.save(item); }
 public void eliminar(Long id) { repository.deleteById(id); }
}
