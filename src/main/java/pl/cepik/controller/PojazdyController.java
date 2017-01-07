package pl.cepik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.cepik.entity.Pojazdy;
import pl.cepik.service.PojazdyService;

import java.util.List;


@Controller
@RequestMapping("/pojazdy")
public class PojazdyController {

    @Autowired
    private PojazdyService pojazdyService;

    @GetMapping("/lista")
    public String listaPojazdy(Model theModel){

        List<Pojazdy> pojazdy = pojazdyService.getPojazdy();
        theModel.addAttribute("Pojazdy", pojazdy);

        return "lista-pojazdy";
    }
}
