package real_estate_registry_with_thymeleaf.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import real_estate_registry_with_thymeleaf.task.model.Building;
import real_estate_registry_with_thymeleaf.task.repository.BuildingRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/buildings/")
public class BuildingController {

    private final BuildingRepository buildingRepository;

    @Autowired
    public BuildingController(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Building building) {
        return "add-building";
    }


    @GetMapping("list")
    public String showUpdate(Model model) {
        model.addAttribute("buildings", buildingRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addBuilding(@Valid Building building, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-building";
        }
        buildingRepository.save(building);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Building building = buildingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid building Id:" + id));
        model.addAttribute("building", building);
        return "update-building";
    }

    @PostMapping("update/{id}")
    public String updateBuilding(@PathVariable("id") Long id, @Valid Building building, BindingResult result,
                                 Model model) {
        if (result.hasErrors()) {
            building.setId(id);
            return "update-building";
        }

        buildingRepository.save(building);
        model.addAttribute("buildings", buildingRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteBuilding(@PathVariable("id") Long id, Model model) {
        Building building = buildingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid building Id:" + id));
        buildingRepository.delete(building);
        model.addAttribute("buildings", buildingRepository.findAll());
        return "index";
    }
}
