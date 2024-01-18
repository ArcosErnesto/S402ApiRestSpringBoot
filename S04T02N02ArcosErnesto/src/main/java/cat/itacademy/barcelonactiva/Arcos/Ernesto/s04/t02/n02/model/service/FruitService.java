package cat.itacademy.barcelonactiva.Arcos.Ernesto.s04.t02.n02.model.service;

import cat.itacademy.barcelonactiva.Arcos.Ernesto.s04.t02.n02.model.domain.Fruit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FruitService {
    Fruit addFruit(Fruit fruit);
    Optional<Fruit> update(int id, Fruit fruit);
    String delete(int id);
    Optional<Fruit> getOneFruit(int id);
    List<Fruit> findAll();
}
