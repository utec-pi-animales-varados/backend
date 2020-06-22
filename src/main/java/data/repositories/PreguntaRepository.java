package data.repositories;

import data.entities.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
    public List<Pregunta> findAllByOrderByPrioridadAsc();
}
