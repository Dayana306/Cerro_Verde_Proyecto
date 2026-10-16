package com.cerro.verde.services;
import com.cerro.verde.entities.Parametro;
import com.cerro.verde.repositories.ParametroRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ParametroService {
 private final ParametroRepository repository;
 public ParametroService(ParametroRepository repository) { this.repository=repository; }
 public List<Parametro> listar() { return repository.findAll(); }
 public Optional<Parametro> buscar(Long id) { return repository.findById(id); }
 public Parametro guardar(Parametro item) { return repository.save(item); }
 public void eliminar(Long id) { repository.deleteById(id); }
}
