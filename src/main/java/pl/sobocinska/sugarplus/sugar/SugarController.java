package pl.sobocinska.sugarplus.sugar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sobocinska.sugarplus.users.JpaUserService;

import javax.validation.Valid;

@Controller
@Transactional
@RequestMapping("/sugarplus")
public class SugarController {

    private final JpaSugarService jpaSugarService;
    private final JpaUserService jpaUserService;

    @Autowired
    public SugarController(JpaSugarService jpaSugarService, JpaUserService jpaUserService) {
        this.jpaSugarService = jpaSugarService;
        this.jpaUserService = jpaUserService;
    }

    // home page and recent sugars
    @GetMapping({"/home", "/"})
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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        sugar.setUser(jpaUserService.findUserByUserName(name));
        jpaSugarService.createSugar(sugar);
        return "redirect:/sugarplus/home";
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
        return "redirect:/sugarplus/home";
    }


    // próbuję przekazać do jsp dane do średnich....
    @GetMapping({"/getAverageSugars"})
    @ResponseBody
    public String getAverageSugars(Model model) {

        model.addAttribute("averageSugars", jpaSugarService.findSugarsByDate());
        return "";
    }

}
