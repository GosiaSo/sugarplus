package pl.sobocinska.sugarplus.sugar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sobocinska.sugarplus.users.JpaUserService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
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
    @GetMapping({"/home", "/", "/sugars"})
    public List<Sugar> showRecentSugars() {
        return jpaSugarService.findSugarsByDate();
    }

    @PostMapping("/sugars")
    public Sugar addSugar(@Valid @RequestBody Sugar sugar) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        sugar.setUser(jpaUserService.findUserByUserName(name));
        return jpaSugarService.createSugar(sugar);
    }

    @PutMapping("/sugars/{id}")
    public Sugar editSugar(@PathVariable Long id, @Valid @RequestBody Sugar sugar) {
        return jpaSugarService.findSugarById(id);
    }

}
