package pl.cepik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.cepik.entity.Zdarzenia;
import pl.cepik.service.ZdarzeniaService;

import java.util.List;

/**
 * Created by Damian on 05.01.2017.
 */
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
}
