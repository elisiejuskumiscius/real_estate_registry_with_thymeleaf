package real_estate_registry_with_thymeleaf.task.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "last_name", nullable = false, length = 50)
    private String last_name;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "person")
    private final Set<Building> building = new HashSet<>();
}
