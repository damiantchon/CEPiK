package pl.cepik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cepik.entity.Kierowcy;
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
        return "kierowcy-lista";
    }

    @PostMapping("/listaFiltrowana")
    public String listaFiltrowanaKierowcy(@ModelAttribute("kierowca") Kierowcy kierowca, Model theModel){
        List<Kierowcy> kierowcy = kierowcyService.getKierowcyFiltrowana(kierowca);
        theModel.addAttribute("Kierowcy", kierowcy);
        return "kierowcy-lista";
    }

    @GetMapping("/dodajKierowce")
    public String dodajKierowce(Model theModel){
        Kierowcy kierowca = new Kierowcy();
        theModel.addAttribute("kierowca", kierowca);
        return "kierowcy-form";
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
        return "kierowcy-edit-form";
    }
    @GetMapping("usunKierowce")
    public String usunKierowce(@RequestParam("IdKierowcy") int idKierowcy){
        kierowcyService.usunKierowce(idKierowcy);
        return "redirect:/kierowcy/lista";
    }
}
