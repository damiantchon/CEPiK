package pl.cepik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.cepik.entity.Oc;
import pl.cepik.service.OcService;

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

        return "oc-lista";
    }
}
