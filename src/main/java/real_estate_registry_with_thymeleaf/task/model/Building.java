package real_estate_registry_with_thymeleaf.task.model;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "building")
public class Building {

    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Column(name = "size", nullable = false)
    private int size;

    @Column(name = "market_value", nullable = false)
    private BigDecimal marketValue;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "property_type_id", nullable = false)
    @Enumerated(EnumType.STRING)
    private PropertyTypeEntity propertyType;

}
