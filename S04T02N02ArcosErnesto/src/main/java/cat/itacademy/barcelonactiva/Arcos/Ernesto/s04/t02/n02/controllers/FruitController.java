package cat.itacademy.barcelonactiva.Arcos.Ernesto.s04.t02.n02.controllers;

import cat.itacademy.barcelonactiva.Arcos.Ernesto.s04.t02.n02.model.domain.Fruit;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s04.t02.n02.model.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Api/v2/fruita")
public class FruitController {
    @Autowired
    private FruitService fruitService;

    @PostMapping("/add")
    public ResponseEntity<Fruit> addFruits(@RequestBody Fruit fruit) {
        Fruit newFruit = fruitService.addFruit(fruit);

        return ResponseEntity.status(HttpStatus.CREATED).body(newFruit);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<Fruit>> updateFruit(@PathVariable int id, @RequestBody Fruit fruit) {
        Optional<Fruit> updatedFruit = fruitService.update(id, fruit);

        return ResponseEntity.status(HttpStatus.CREATED).body(updatedFruit);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFruit(@PathVariable int id) {
        String msg = fruitService.delete(id);
        return ResponseEntity.ok(msg);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Optional<Fruit>> getOneFruit(@PathVariable int id) {
        Optional<Fruit> fruit = fruitService.getOneFruit(id);
        return ResponseEntity.ok(fruit);
    }

    @GetMapping("/getAll")
    public List<Fruit> list(){
        return fruitService.findAll();
    }

}