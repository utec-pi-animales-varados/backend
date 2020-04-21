package business;

import data.entities.PreguntaYRespuesta;
import data.repositories.PreguntaYRespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PreguntaYRespuestaService {

    @Autowired
    private PreguntaYRespuestaRepository repository;

    public List<PreguntaYRespuesta> findAll() {
        return repository.findAll();
    }

    public PreguntaYRespuesta save(PreguntaYRespuesta preguntaYRespuesta) {
        return repository.save(preguntaYRespuesta);
    }

    public PreguntaYRespuesta findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new PreguntaYRespuestaNotFoundException(id));
    }

    public PreguntaYRespuesta update(PreguntaYRespuesta newPreguntaYRespuesta, Long id) {
        return repository.findById(id).map(preguntaYRespuesta -> {
            preguntaYRespuesta.setAnswer(newPreguntaYRespuesta.getAnswer());
            preguntaYRespuesta.setReport(newPreguntaYRespuesta.getReport());
            return repository.save(preguntaYRespuesta);
        }).orElseGet(()->{
            newPreguntaYRespuesta.setId(id);
            return repository.save(newPreguntaYRespuesta);
        });
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
