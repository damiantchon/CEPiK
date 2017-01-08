package pl.cepik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/dodajKierowce")
    public String dodajKierowce(Model theModel){
        Kierowcy kierowca = new Kierowcy();
        theModel.addAttribute("kierowca", kierowca);
        return "form-kierowcy";
    }

    @PostMapping("/zapiszKierowce")
    public String zapiszKierowce(@ModelAttribute("kierowca") Kierowcy kierowca){

        kierowcyService.zapiszKierowce(kierowca);

        return "redirect:/kierowcy/lista";
    }
}
