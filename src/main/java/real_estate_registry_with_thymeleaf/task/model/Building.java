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
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @ManyToOne //(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Column(name = "size", nullable = false)
    private int size;

    @Column(name = "market_value", nullable = false)
    private BigDecimal marketValue;

    @ManyToOne
    @JoinColumn(name = "type_name_id", nullable = false)
    private PropertyType propertyType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person getPerson() { return person; }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public BigDecimal getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(BigDecimal marketValue) {
        this.marketValue = marketValue;
    }

    public PropertyType getPropertyType() { return propertyType; }

    public void setPropertyType(PropertyType propertyType) { this.propertyType = propertyType; }
}
