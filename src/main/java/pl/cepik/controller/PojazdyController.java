package pl.cepik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cepik.entity.Pojazdy;
import pl.cepik.service.PojazdyService;

import java.util.List;


@Controller
@RequestMapping("/pojazdy")
public class PojazdyController {

    private final PojazdyService pojazdyService;

    @Autowired
    public PojazdyController(PojazdyService pojazdyService) {
        this.pojazdyService = pojazdyService;
    }

    @GetMapping("/lista")
    public String listaPojazdy(Model theModel){

        List<Pojazdy> pojazdy = pojazdyService.getPojazdy();
        Pojazdy pojazd = new Pojazdy();
        theModel.addAttribute("Pojazdy", pojazdy);
        theModel.addAttribute("pojazd", pojazd);

        return "pojazdy-lista";
    }

    @PostMapping("/listaFiltrowana")
    public String litaFiltrowanaPojazdy(@ModelAttribute("pojazd") Pojazdy pojazd, Model theModel){

        List<Pojazdy> pojazdy = pojazdyService.getPojazdyFiltrowana(pojazd);
        theModel.addAttribute("Pojazdy", pojazdy);
        return "pojazdy-lista";
    }

    @GetMapping("/dodajPojazd")
    public String dodajPojazd(Model theModel){
        Pojazdy pojazd = new Pojazdy();
        theModel.addAttribute("pojazd",pojazd);
        return "pojazdy-form";
    }
    @PostMapping("/zapiszPojazd")
    public String zapiszNowyPojazd(@ModelAttribute("pojazd") Pojazdy pojazd){

        pojazdyService.zapiszNowyPojazd(pojazd);
        return "redirect:/pojazdy/lista";
    }

    @PostMapping("/zapiszEdytowanyPojazd")
    public String zapiszEdytowanyPojazd(@ModelAttribute("pojazd") Pojazdy pojazd){
        pojazdyService.zapiszEdytowanyPojazd(pojazd);
        return "redirect:/pojazdy/lista";
    }

    @GetMapping("/edytujPojazd")
    public String edytujPojazd(@RequestParam("numerRejestracyjny") String nrRejestracyjny, Model theModel){
        Pojazdy pojazd = pojazdyService.getPojazdy(nrRejestracyjny);
        theModel.addAttribute("pojazd", pojazd);
        return "pojazdy-edit-form";
    }

    @GetMapping("/usunPojazd")
    public String usunPojazd(@RequestParam("numerRejestracyjny") String nrRejestracyjny){
        pojazdyService.usunPojazd(nrRejestracyjny);
        return "redirect:/pojazdy/lista";
    }

}
