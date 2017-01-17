package pl.cepik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cepik.entity.Kierowcy;
import pl.cepik.entity.Oc;
import pl.cepik.entity.Pojazdy;
import pl.cepik.entity.Zdarzenia;
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

        return "starosta/pojazdy-lista";
    }

    @PostMapping("/listaFiltrowana")
    public String litaFiltrowanaPojazdy(@ModelAttribute("pojazd") Pojazdy pojazd, Model theModel){

        List<Pojazdy> pojazdy = pojazdyService.getPojazdyFiltrowana(pojazd);
        theModel.addAttribute("Pojazdy", pojazdy);
        return "starosta/pojazdy-lista";
    }

    @GetMapping("/dodajPojazd")
    public String dodajPojazd(Model theModel){
        Pojazdy pojazd = new Pojazdy();
        theModel.addAttribute("pojazd",pojazd);
        return "starosta/pojazdy-form";
    }

    @PostMapping("/zapiszPojazd")
    public String zapiszNowyPojazd(@ModelAttribute("pojazd") Pojazdy pojazd){

        pojazdyService.zapiszNowyPojazd(pojazd);
        return "redirect:/pojazdy/lista";
    }

    @GetMapping("/sprawdzaniePojazduForm")
    public String sprawdzanieKierowcyForm(Model theModel){
        Pojazdy pojazd = new Pojazdy();
        theModel.addAttribute("pojazd",pojazd);
        return "policja/pojazdy-form-policja";
    }

    @GetMapping("/sprawdzPojazd")
    public String sprawdzPojazd(@ModelAttribute("pojazd")Pojazdy poja, Model theModel){
        String nrSzukanegoPojazdu = poja.getNumerRejestracyjny();
        Pojazdy pojazd = pojazdyService.getPojazdy(nrSzukanegoPojazdu);

        if(pojazd!=null){
            Kierowcy kierowca = pojazdyService.getKierowca(pojazd.getIdKierowcy());
            Oc oc = pojazdyService.getOc(pojazd.getIdOc());
            List<Zdarzenia> zdarzenia = pojazdyService.getZdarzenia(nrSzukanegoPojazdu);
            theModel.addAttribute("pojazd", pojazd);
            theModel.addAttribute("kierowca", kierowca);
            theModel.addAttribute("zdarzenia",zdarzenia);
            theModel.addAttribute("oc",oc);
            return "policja/pojazdy-wynik-policja";
        }
        return "policja/pojazdy-form-policja";
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
        return "starosta/pojazdy-edit-form";
    }

    @GetMapping("/usunPojazd")
    public String usunPojazd(@RequestParam("numerRejestracyjny") String nrRejestracyjny){
        pojazdyService.usunPojazd(nrRejestracyjny);
        return "redirect:/pojazdy/lista";
    }

}
