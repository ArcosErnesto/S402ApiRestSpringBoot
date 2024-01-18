package cat.itacademy.barcelonactiva.Arcos.Ernesto.s04.t02.n01.model.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 45)
    private String name;
    @Column(nullable = false)
    private int quantityKilos;
}
