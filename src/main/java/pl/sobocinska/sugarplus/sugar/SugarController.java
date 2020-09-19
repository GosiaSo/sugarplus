package pl.sobocinska.sugarplus.sugar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@Transactional
@RequestMapping("/sugarplus")
public class SugarController {

    private final JpaSugarService jpaSugarService;

    @Autowired
    public SugarController(JpaSugarService jpaSugarService) {
        this.jpaSugarService = jpaSugarService;
    }

    // home page and recent sugars
    @GetMapping("/home")
    public String showRecentSugars(Model model) {
        model.addAttribute("sugars", jpaSugarService.findSugarsByDate());
        return "recentSugars";
    }

    @GetMapping("/sugars/add")
    public String addSugarForm(Model model) {
        model.addAttribute("sugar", new Sugar());
        return "sugar/form";
    }

    @PostMapping("/sugars/add")
    public String addSugar(@Valid Sugar sugar, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("sugars", jpaSugarService.findSugars());
            return "sugar/form";
        }
        jpaSugarService.createSugar(sugar);
        return "redirect:/recentSugars";
    }

    @GetMapping("/sugars/edit/{id}")
    public String editSugar(@PathVariable Long id, Model model) {
        model.addAttribute("sugar", jpaSugarService.findSugarById(id));
        return "sugar/form";
    }

    @PostMapping("/sugars/edit/{id}")
    public String editSugar(@Valid Sugar sugar, BindingResult result) {
        if (result.hasErrors()) {
            return "sugar/form";
        }
        jpaSugarService.editSugar(sugar);
        return "redirect:/recentSugars";
    }

}
