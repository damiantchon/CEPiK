package pl.cepik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cepik.entity.Kierowcy;
import pl.cepik.entity.Oc;
import pl.cepik.entity.Pojazdy;
import pl.cepik.service.OcService;
import pl.cepik.Main;
import java.util.List;


@Controller
@RequestMapping("/oc")
public class OcController {

    @Autowired
    private OcService ocService;



    @GetMapping("/lista")
    public String listaOc(Model theModel){
        List<Oc> oc = ocService.getOc();
        theModel.addAttribute("Oc", oc);

        return "ubezpieczyciel/oc-lista-ubezpieczyciel";
    }
    @GetMapping("/sprawdzOc")
    public String sprawdzOc(@RequestParam(value = "IdOc", required = false) Integer idOc, Model theModel){
       if(idOc == null){
           return "policja/oc-brak-policja";
       }else {
           List<Oc> oc = ocService.getOc(idOc);
           theModel.addAttribute("Oc", oc);
           return "policja/oc-wynik-policja";
       }
    }
    @GetMapping("/wybierzUbezpieczyciela")
    public String wybierzUbezpieczyciela(Model theModel){
        Main.setUbezpieczycielSaved("");
        Oc oc = new Oc();
        theModel.addAttribute("oc",oc);
        return "ubezpieczyciel/oc-wybierz-panel-ubezpieczyciel";
    }
    @RequestMapping("/wejdzUbezpieczyciel")
    public String wejdzUbezpieczyciel(@ModelAttribute("oc")Oc oc, Model theModel){
        if(Main.getUbezpieczycielSaved().equals("")){
            Main.setUbezpieczycielSaved(oc.getUbezpieczyciel());
        }

        theModel.addAttribute("ubezpieczyciel",Main.getUbezpieczycielSaved());
        return "ubezpieczyciel/oc-panel-ubezpieczyciel";
    }
    @PostMapping("/przegladajOc")
    public String przegladajOc(Model theModel){
        List<Pojazdy> ocModel = ocService.getPojazdy(Main.getUbezpieczycielSaved());
        Pojazdy pojazd = new Pojazdy();
        theModel.addAttribute("ubezpieczyciel",Main.getUbezpieczycielSaved());
        theModel.addAttribute("pojazd", pojazd);
        theModel.addAttribute("pojazdy", ocModel);
        return "ubezpieczyciel/oc-lista-ubezpieczyciel";
    }
    @GetMapping("/pokazOc")
    public String pokazOc(@RequestParam("ocId")int ocID, Model theModel){
        List<Oc> ocList= ocService.getOc(ocID);
        Oc oc = ocList.get(0);
        theModel.addAttribute("oc", oc);
        return "ubezpieczyciel/oc-pokazoc-ubezpieczyciel";
    }
    @GetMapping("/pokazKierowce")
    public String pokazKierowce(@RequestParam("idKierowcy") int idKierowcy, Model theModel){
        Kierowcy kierowca = ocService.getKierowca(idKierowcy);
        theModel.addAttribute("kierowca", kierowca);
        return "/ubezpieczyciel/oc-pokazkierowce-ubezpieczyciel";
    }
    @GetMapping("/ubezpieczenieForm")
    public String ubezpieczenieForm(Model theModel){
        Oc oc = new Oc();
        Pojazdy pojazd = new Pojazdy();
        theModel.addAttribute("ubezpieczyciel",Main.getUbezpieczycielSaved());
        theModel.addAttribute("oc",oc);
        theModel.addAttribute("pojazd",pojazd);
        return "/ubezpieczyciel/oc-dodaj-ubezpieczyciel";
    }
    @PostMapping("/zapiszOC")
    public String zapiszOc(@ModelAttribute("oc")Oc oc,Model theModel){
        oc.setUbezpieczyciel(Main.getUbezpieczycielSaved());
        ocService.zapiszOC(oc);

        List<Pojazdy> ocModel = ocService.getPojazdy(Main.getUbezpieczycielSaved());
        Pojazdy pojazd = new Pojazdy();
        theModel.addAttribute("pojazd", pojazd);
        theModel.addAttribute("pojazdy", ocModel);
        return "ubezpieczyciel/oc-lista-ubezpieczyciel";
    }
    @RequestMapping("/znajdzPojazd")
    public String znajdzPojazd(@ModelAttribute("pojazd")Pojazdy pojazd, Model theModel){
        Pojazdy pojazdModel = ocService.znajdzPojazd(pojazd);
        if(pojazdModel!=null){
            Main.setNrRejestracyjnySaved(pojazdModel.getNumerRejestracyjny());
        }
        Oc oc = new Oc();
        theModel.addAttribute("ubezpieczyciel",Main.getUbezpieczycielSaved());
        theModel.addAttribute("pojazd",pojazdModel);
        theModel.addAttribute("oc",oc);
        if(pojazdModel==null){
            pojazdModel = new Pojazdy();
            pojazdModel.setNumerRejestracyjny("");
            theModel.addAttribute("pojazd",pojazdModel);
            return "/ubezpieczyciel/oc-dodaj-ubezpieczyciel";
        }else{
            return "/ubezpieczyciel/oc-dodaj2-ubezpieczyciel";
        }
    }

}
