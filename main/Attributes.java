package com.fitness.controller.main;

import com.fitness.model.Statics;
import com.fitness.model.enums.Role;
import org.springframework.ui.Model;

import java.util.List;

public class Attributes extends Main {

    protected void AddAttributes(Model model) {
        model.addAttribute("role", getRole());
        model.addAttribute("user", getUser());
    }

    protected void AddAttributesUsers(Model model) {
        AddAttributes(model);
        model.addAttribute("users", usersRepo.findAll());
        model.addAttribute("roles", Role.values());
    }

    protected void AddAttributesIndex(Model model) {
        AddAttributes(model);
        model.addAttribute("trainers", trainersRepo.findAll());
    }

    protected void AddAttributesTrainerEdit(Model model, Long id) {
        AddAttributes(model);
        model.addAttribute("trainer", trainersRepo.getReferenceById(id));
    }

    protected void AddAttributesSubs(Model model) {
        AddAttributes(model);
        model.addAttribute("subs", subsRepo.findAll());
    }

    protected void AddAttributesSubsMy(Model model) {
        AddAttributes(model);
        model.addAttribute("subs", getUser().getSubs());
    }

    protected void AddAttributesSubEdit(Model model, Long id) {
        AddAttributes(model);
        model.addAttribute("sub", subsRepo.getReferenceById(id));
    }

    protected void AddAttributesStatics(Model model) {
        AddAttributes(model);
        List<Statics> staticsList = staticsRepo.findAll();
        int income = staticsList.stream().reduce(0, (integer, stat) -> integer + (stat.getCount() * stat.getSubs().getPrice()), Integer::sum);
        model.addAttribute("income", income);
        model.addAttribute("statics", staticsList);
    }
}
