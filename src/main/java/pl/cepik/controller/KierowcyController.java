package pl.cepik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.cepik.entity.Kierowcy;
import pl.cepik.service.KierowcyService;

import java.util.List;


@Controller
@RequestMapping("/kierowcy")
public class KierowcyController {

    @Autowired
    private KierowcyService kierowcyService;

    @GetMapping("/lista")
    public String listaKierowcy(Model theModel){
        List<Kierowcy> kierowcy = kierowcyService.getKierowcy();
        theModel.addAttribute("Kierowcy", kierowcy);

        return "lista-kierowcy";
    }
}
