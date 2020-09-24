package pl.sobocinska.sugarplus.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.validation.Valid;

@Controller
@Transactional
@RequestMapping("/sugarplus/users")
public class UserController {
    private final JpaUserService jpaUserService;

    @Autowired
    public UserController(JpaUserService jpaUserService) {
        this.jpaUserService = jpaUserService;
    }

    @GetMapping("/register")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "user/registration";
    }

    @PostMapping("/register")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("users", jpaUserService.findAllByVisibleTrue());
            return "user/registration";
        }
        if(!user.getPassword().equals(user.getPasswordTest())){
            model.addAttribute("users", jpaUserService.findAllByVisibleTrue());
            return "user/registration";
        }
        jpaUserService.createUser(user);
        return "redirect:/sugarplus/home";
    }

}
