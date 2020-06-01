package business;

import data.dto.ReporteDTO;
import data.entities.Reporte;
import data.entities.Usuario;
import data.repositories.AnimalRepository;
import data.repositories.ReporteRepository;
import data.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReporteService {

    @Autowired
    private ReporteRepository repository;
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Reporte> findAll(){
        List<Reporte> items = new ArrayList<>();
        for (Reporte item : repository.findAll()){
            items.add(item);
        }
        return items;
    }

    public List<Reporte> findReportsByUserID(Long user_id) {
        List<Reporte> reportes = new ArrayList<>();
        for (Reporte reporte : repository.findAll())
            if (reporte.getUsuario().getId().equals(user_id))
                reportes.add(reporte);
        return reportes;
    }

    public Reporte findOne(Long id){
        return repository.findById(id).orElseThrow(()->new ReporteNotFoundException(id));
    }

    public Reporte create(ReporteDTO dto){
        Reporte reporte = new Reporte();

        reporte.setDate(dto.getDate());
        reporte.setRespuestas(dto.getRespuestas());
        reporte.setAnimal(animalRepository.findById(dto.getAnimalid()).get());
        reporte.setUsuario(usuarioRepository.findById(dto.getUsuarioid()).get());
        reporte.setComment(dto.getComment());
        reporte.setLatitude(dto.getLatitude());
        reporte.setLongitude(dto.getLongitude());
        reporte.setLongitudAnimal(dto.getLongitudAnimal());
        reporte.setPicturesURLs(dto.getPicturesURLs());

        return repository.save(reporte);
    }

    public Reporte update(Reporte item, Long id){
        return repository.findById(id).map(reporte -> {
            reporte.setComment(item.getComment());
            reporte.setDate(item.getDate());
            reporte.setLatitude(item.getLatitude());
            reporte.setLongitude(item.getLongitude());
            reporte.setPicturesURLs(item.getPicturesURLs());
            reporte.setAnimal(item.getAnimal());
            reporte.setUsuario(item.getUsuario());
            reporte.setRespuestas(item.getRespuestas());
            reporte.setLongitudAnimal(item.getLongitudAnimal());
            return repository.save(reporte);
        }).orElseGet(()->{
            item.setId(id);
            return repository.save(item);
        });
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
    
    
}
