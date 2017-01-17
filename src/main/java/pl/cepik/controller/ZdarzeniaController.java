package pl.cepik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cepik.entity.Kierowcy;
import pl.cepik.entity.Pojazdy;
import pl.cepik.entity.Zdarzenia;
import pl.cepik.service.ZdarzeniaService;

import java.util.List;

@Controller
@RequestMapping("/zdarzenia")
public class ZdarzeniaController {

    @Autowired
    private ZdarzeniaService zdarzeniaService;

    @GetMapping("/lista")
    public String listaZdarzenia(Model theModel){
        List<Zdarzenia> zdarzenia = zdarzeniaService.getZdarzenia();
        theModel.addAttribute("Zdarzenia",zdarzenia);

        return "zdarzenia-lista";
    }

    @GetMapping("/dodajZdarzenieForm")
    public String dodajZdarzenieForm(Model theModel){
        Zdarzenia zdarzenie = new Zdarzenia();
        theModel.addAttribute("zdarzenie",zdarzenie);

        return "policja/dodawanieZdarzenia/zdarzenia-form-policja";
    }

    @PostMapping("/zapiszZdarzenie")
    public String zapiszZdarzenie(@ModelAttribute("zdarzenie")Zdarzenia zdarzenie, Model theModel){
        theModel.addAttribute("zdarzenie",zdarzenie);
        int idKierowcy = zdarzenie.getIdKierowcy();
        String numerRejestracyjny = zdarzenie.getNumerRejestracyjny();
        if(zdarzenie.getIdKierowcy()<=0&&zdarzenie.getNumerRejestracyjny().equals("")){
            return "policja/dodawanieZdarzenia/zdarzenia-form-brak-policja";
        }
        Kierowcy kierowca = zdarzeniaService.getKierowca(idKierowcy);
        Pojazdy pojazd = zdarzeniaService.getPojazd(numerRejestracyjny);
        if(kierowca==null && zdarzenie.getNumerRejestracyjny().equals("")){
            return "policja/dodawanieZdarzenia/zdarzenia-form-1-policja";
        }else if(pojazd==null && zdarzenie.getIdKierowcy()<=0){
            return "policja/dodawanieZdarzenia/zdarzenia-form-2-policja";
        }else if(pojazd==null && kierowca==null){
            return "policja/dodawanieZdarzenia/zdarzenia-form-1and2-policja";
        }
        if(kierowca!=null&&(zdarzenie.getTypZdarzenia().equals("Odebranie uprawnień")
                                        ||zdarzenie.getTypZdarzenia().equals("Nadanie uprawnień"))) {
            zdarzeniaService.dodajZdarzenie(zdarzenie);
            theModel.addAttribute("kierowca",kierowca);
            return "policja/dodawanieZdarzenia/zdarzenia-kierowca-edit-policja";

        }else if(pojazd!=null&&(zdarzenie.getTypZdarzenia().equals("Zgłoszenie kradzieży pojazdu")
                ||zdarzenie.getTypZdarzenia().equals("Odzyskanie pojazdu"))){//TODO
            zdarzeniaService.dodajZdarzenie(zdarzenie);
            theModel.addAttribute("pojazd",pojazd);
            return "policja/dodawanieZdarzenia/zdarzenia-pojazd-edit-policja";

        }else{
            zdarzeniaService.dodajZdarzenie(zdarzenie);
            return "policja/menu-policja";
        }
    }

    @PostMapping("/zapiszKierowceIZdarzenie")
    public String zapiszKierowceIZdarzenie(@ModelAttribute("kierowca")Kierowcy kierowca, Model theModel){
        zdarzeniaService.edytujKierowce(kierowca);
        return "policja/menu-policja";
    }
    @PostMapping("/zapiszPojazdIZdarzenie")
    public String zapiszPojazdIZdarzenie(@ModelAttribute("pojazd")Pojazdy pojazd, Model theModel){
        zdarzeniaService.edytujPojazd(pojazd);
        return "policja/menu-policja";
    }
}
