package business;

import data.entities.Pregunta;
import data.repositories.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PreguntaService {

    @Autowired
    private PreguntaRepository repository;

    public List<Pregunta> findAll() {
        return repository.findAll();
    }

    public Pregunta save(Pregunta pregunta) {
        return repository.save(pregunta);
    }

    public Pregunta findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new PreguntaNotFoundException(id));
    }

    public Pregunta update(Pregunta newPregunta, Long id) {
        return repository.findById(id).map(pregunta -> {
            pregunta.setQuestionText(newPregunta.getQuestionText());
            return repository.save(pregunta);
        }).orElseGet(() -> {
            newPregunta.setId(id);
            return repository.save(newPregunta);
        });
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
