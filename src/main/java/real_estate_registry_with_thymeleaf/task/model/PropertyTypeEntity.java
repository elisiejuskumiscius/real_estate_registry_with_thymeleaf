package real_estate_registry_with_thymeleaf.task.model;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "property_type")
public class PropertyTypeEntity {

    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "property_type")
    @Column(name = "property_type", unique = true, nullable = false)
    private Set<Building> propertyType;

}
