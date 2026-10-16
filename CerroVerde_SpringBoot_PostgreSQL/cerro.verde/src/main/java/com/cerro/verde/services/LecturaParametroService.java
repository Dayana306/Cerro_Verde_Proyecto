package com.cerro.verde.services;
import com.cerro.verde.entities.LecturaParametro;
import com.cerro.verde.repositories.LecturaParametroRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class LecturaParametroService {
 private final LecturaParametroRepository repository;
 public LecturaParametroService(LecturaParametroRepository repository) { this.repository=repository; }
 public List<LecturaParametro> listar() { return repository.findAll(); }
 public Optional<LecturaParametro> buscar(Long id) { return repository.findById(id); }
 public LecturaParametro guardar(LecturaParametro item) { return repository.save(item); }
 public void eliminar(Long id) { repository.deleteById(id); }
}
