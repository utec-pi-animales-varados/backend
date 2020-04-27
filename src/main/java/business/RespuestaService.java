package business;

import data.entities.Respuesta;
import data.repositories.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RespuestaService {

    @Autowired
    private RespuestaRepository repository;

    public List<Respuesta> findAll() {
        return repository.findAll();
    }

    public Respuesta save(Respuesta respuesta) {
        return repository.save(respuesta);
    }

    public Respuesta findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RespuestaNotFoundException(id));
    }

    public Respuesta update(Respuesta newRespuesta, Long id) {
        return repository.findById(id).map(Respuesta -> {
            Respuesta.setTextoRespuesta(newRespuesta.getTextoRespuesta());
            Respuesta.setReporte(newRespuesta.getReporte());
            Respuesta.setPregunta(newRespuesta.getPregunta());
            return repository.save(Respuesta);
        }).orElseGet(()->{
            newRespuesta.setId(id);
            return repository.save(newRespuesta);
        });
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
