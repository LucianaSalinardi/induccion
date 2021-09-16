package com.mercadolibre.pagoOnline.controller;

import com.mercadolibre.pagoOnline.dtos.request.PreferenceReqDto;
import com.mercadolibre.pagoOnline.service.MyTechService;
import com.mercadopago.exceptions.MPException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/myTech")
public class MyTechController {

    private final MyTechService myTechService;

    public MyTechController(MyTechService myTechService) {
        this.myTechService = myTechService;
    }

    @PostMapping("/preferences/create")
    public ResponseEntity<?> createPreference(@RequestBody @Valid PreferenceReqDto preferenceReqDto) throws MPException {
        return new ResponseEntity<>(myTechService.createPreference(preferenceReqDto), HttpStatus.OK);
    }


    @GetMapping("/preferences/get")
    public ResponseEntity<?> getPreference() throws MPException {
        return new ResponseEntity<>(myTechService.getPreference(),HttpStatus.OK);
    }

}
