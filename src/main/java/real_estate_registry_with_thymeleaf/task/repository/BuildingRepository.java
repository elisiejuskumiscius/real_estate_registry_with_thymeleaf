package real_estate_registry_with_thymeleaf.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import real_estate_registry_with_thymeleaf.task.model.Address;
import real_estate_registry_with_thymeleaf.task.model.Building;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {

    List<Building> findByAddress (Address address);

}
