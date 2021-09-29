package com.mercadolibre.pagoOnline.controller;

import com.mercadolibre.pagoOnline.service.MyTechService;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PreferenceController {

    private final MyTechService myTechService;

    public PreferenceController(MyTechService myTechService) {
        this.myTechService = myTechService;
    }


    @GetMapping(value = "/preference", produces = "text/html")
    public String createPreference(Model model) throws MPException {
        Preference preference = myTechService.getPreference();
        model.addAttribute("preferenceId", preference.getId());
        model.addAttribute("description", preference.getItems().get(0).getDescription());
        model.addAttribute("category", preference.getItems().get(0).getCategoryId());
        model.addAttribute("unitPrice", preference.getItems().get(0).getUnitPrice());

        return "preference";
    }
}
