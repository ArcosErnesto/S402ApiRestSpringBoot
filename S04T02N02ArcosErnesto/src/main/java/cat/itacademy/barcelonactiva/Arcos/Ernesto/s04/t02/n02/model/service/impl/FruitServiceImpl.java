package cat.itacademy.barcelonactiva.Arcos.Ernesto.s04.t02.n02.model.service.impl;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s04.t02.n02.model.domain.Fruit;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s04.t02.n02.model.exceptions.FruitNotFoundException;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s04.t02.n02.model.repository.FruitRepository;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s04.t02.n02.model.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService {
    @Autowired
    private FruitRepository fruitRepository;
    @Transactional
    @Override
    public Fruit addFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Transactional
    @Override
    public Optional<Fruit> update(int id, Fruit fruit) {
        Optional<Fruit> fruitOptional = fruitRepository.findById(id);
        if(fruitOptional.isPresent()){
            Fruit fruitDb = fruitOptional.orElseThrow();

            fruitDb.setName(fruit.getName());
            fruitDb.setQuantityKilos(fruit.getQuantityKilos());

            return Optional.of(fruitRepository.save(fruitDb));

        }
        return fruitOptional;
    }

    @Override
    public String delete(int id) {
        Fruit fruit = fruitRepository.findById(id)
                .orElseThrow(()-> new FruitNotFoundException("Producto no encontrado con el id "+id));
        fruitRepository.delete(fruit);
        return "Producto eliminado con exito con el id: "+id;
    }

    @Override
    public Optional<Fruit> getOneFruit(int id) {
        return Optional.ofNullable(fruitRepository.findById(id).orElseThrow(() -> new FruitNotFoundException("Producto no encontrado")));
    }

    @Override
    public List<Fruit> findAll() {
        return fruitRepository.findAll();
    }
}
