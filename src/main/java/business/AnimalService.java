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
        return repository.findById(id).orElseThrow(() -> new AnimalNotFoundException(id));
    }

    public Animal create(Animal item){
        return repository.save(item);
    }

    public Animal update(Animal newAnimal, Long id){
        return repository.findById(id).map(animal -> {
            animal.setName(newAnimal.getName());
            animal.setColor(newAnimal.getColor());
            animal.setPeso(newAnimal.getPeso());
            animal.setReportes(newAnimal.getReportes());
            return repository.save(animal);
        }).orElseGet(()->{
            newAnimal.setId(id);
            return repository.save(newAnimal);
        });
    }

    public void delete(Long id){
        repository.deleteById(id);
    }


}
