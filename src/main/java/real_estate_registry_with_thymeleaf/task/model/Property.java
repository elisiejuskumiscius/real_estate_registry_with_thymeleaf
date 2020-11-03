//package real_estate_registry_with_thymeleaf.task.model;
//
//import javax.persistence.*;
//import java.util.Set;
//
//
//@Entity
//@Table(name = "property_type")
//public class Property {
//
//    @Id
//    @Column(name = "id", unique = true, nullable = false, updatable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String propertyName;
//
//    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "property_type")
//    @Column(name = "property_type", unique = true, nullable = false)
//
//    private String propertyName;
//
//}
//
//enum PropertyType {
//
//    APARTMENT("APARTMENT"),
//
//    HOUSE("HOUSE"),
//
//    INDUSTRIAL("INDUSTRIAL"),
//
//    COMMERCIAL("COMMERCIAL");
//
//    private String value;
//
//    PropertyType(String value) { this.value = value; }
//}