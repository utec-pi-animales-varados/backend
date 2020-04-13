package business;

import data.entities.Animal;
import data.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AnimalService {

    @Autowired
    private AnimalRepository repository;

    public List<Animal> findAll(){
        List<Animal> items = new ArrayList<>();
        for(Animal item : repository.findAll()){
            items.add(item);
        }
        return items;
    }

    public Animal findOne(Long id){
        return repository.findById(id).get();
    }

    public Animal create(Animal item){
        return repository.save(item);
    }

    public Animal update(Animal item){
        return repository.save(item);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }


}
