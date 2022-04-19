package Models;

import Enumerations.Category;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String continent;
}
