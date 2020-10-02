package pl.sobocinska.sugarplus.chart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sobocinska.sugarplus.sugar.JpaSugarService;
import pl.sobocinska.sugarplus.sugar.Sugar;

import java.util.List;

@Controller
public class ChartController {

    private final JpaSugarService jpaSugarService;

    @Autowired
    public ChartController(JpaSugarService jpaSugarService) {
        this.jpaSugarService = jpaSugarService;
    }

    @GetMapping("/sugarplus/sugars/graphs")
    public String showCharts(ModelMap modelMap){
        List<Sugar> sugarList = jpaSugarService.findSugarsByDate();
        modelMap.addAttribute("sugarDataChart", sugarList);
        return "test";
    }

    @GetMapping("/sugarplus/sugars/testy")
    public String test(){
        return "chart";
    }
}
