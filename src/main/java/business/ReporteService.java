package business;

import data.entities.Reporte;
import data.repositories.ReporteRepository;
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
    
    public List<Reporte> findAll(){
        List<Reporte> items = new ArrayList<>();
        for (Reporte item : repository.findAll()){
            items.add(item);
        }
        return items;
    }

    public Reporte findOne(Long id){
        return repository.findById(id).get();
    }

    public Reporte create(Reporte item){
        return repository.save(item);
    }

    public Reporte update(Reporte item){
        return repository.save(item);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
    
    
}
