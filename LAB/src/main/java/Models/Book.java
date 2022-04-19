package Models;
import javax.persistence.*;

import Enumerations.Category;
import lombok.Data;

@Data
@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Category category;
    private int availableCopies;
    @ManyToOne
    private Author author;

    public Book() {
    }

    public Book(Long id, String name, Category category, int availableCopies, Author author) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.availableCopies = availableCopies;
        this.author = author;
    }
}
