package pl.cepik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cepik.entity.Kierowcy;
import pl.cepik.entity.Pojazdy;
import pl.cepik.entity.Zdarzenia;
import pl.cepik.service.KierowcyService;

import java.util.List;


@Controller
@RequestMapping("/kierowcy")
public class KierowcyController {

    private final KierowcyService kierowcyService;

    @Autowired
    public KierowcyController(KierowcyService kierowcyService) {
        this.kierowcyService = kierowcyService;
    }

    @GetMapping("/lista")
    public String listaKierowcy(Model theModel){
        List<Kierowcy> kierowcy = kierowcyService.getKierowcy();
        Kierowcy kierowca = new Kierowcy();
        theModel.addAttribute("Kierowcy", kierowcy);
        theModel.addAttribute("kierowca", kierowca);
        return "starosta/kierowcy-lista-starosta";
    }

    @GetMapping("/sprawdzKierowce")
    public String sprawdzKierowce(@ModelAttribute("kierowca") Kierowcy kiero, Model theModel){
        int idSzukanegoKierowcy = kiero.getIdKierowcy();
        Kierowcy kierowca = kierowcyService.getKierowcy(idSzukanegoKierowcy);

        if(kierowca!=null){
            List<Pojazdy> pojazdy = kierowcyService.getPojazdy(idSzukanegoKierowcy);
            List<Zdarzenia> zdarzenia = kierowcyService.getZdarzenia(idSzukanegoKierowcy);
            theModel.addAttribute("kierowca", kierowca);
            theModel.addAttribute("pojazdy", pojazdy);
            theModel.addAttribute("zdarzenia", zdarzenia);
            return "policja/kierowcy-wynik-policja";
        }else {
            return "policja/kierowcy-form-policja";
        }
    }

    @GetMapping("/sprawdzanieKierowcyForm")
    public String sprawdzanieKierowcyForm(Model theModel){
        Kierowcy kierowca = new Kierowcy();
        theModel.addAttribute("kierowca",kierowca);
        return "policja/kierowcy-form-policja";
    }

    @PostMapping("/listaFiltrowana")
    public String listaFiltrowanaKierowcy(@ModelAttribute("kierowca") Kierowcy kierowca, Model theModel){
        List<Kierowcy> kierowcy = kierowcyService.getKierowcyFiltrowana(kierowca);
        theModel.addAttribute("Kierowcy", kierowcy);
        return "starosta/kierowcy-lista-starosta";
    }

    @GetMapping("/dodajKierowce")
    public String dodajKierowce(Model theModel){
        Kierowcy kierowca = new Kierowcy();
        theModel.addAttribute("kierowca", kierowca);
        return "starosta/kierowcy-form-starosta";
    }

    @PostMapping("/zapiszKierowce")
    public String zapiszKierowce(@ModelAttribute("kierowca") Kierowcy kierowca){

        kierowcyService.zapiszKierowce(kierowca);
        return "redirect:/kierowcy/lista";
    }

    @PostMapping("zapiszEdytowanegoKierowce")
    public String zapiszEdytowanegoKierowce(@ModelAttribute("kierowca") Kierowcy kierowca) {

        kierowcyService.zapiszEdytowanegoKierowce(kierowca);
        return "redirect:/kierowcy/lista";
    }

    @GetMapping("/edytujKierowce")
    public String edytujKierowce(@RequestParam("IdKierowcy") int idKierowcy, Model theModel){
        Kierowcy kierowca = kierowcyService.getKierowcy(idKierowcy);
        theModel.addAttribute("kierowca", kierowca);
        return "starosta/kierowcy-edit-form-starosta";
    }

    @GetMapping("/usunKierowce")
    public String usunKierowce(@RequestParam("IdKierowcy") int idKierowcy){
        kierowcyService.usunKierowce(idKierowcy);
        return "redirect:/kierowcy/lista";
    }

}
