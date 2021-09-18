package mercadopago.PagoOnlineV2.controller;

import com.mercadopago.exceptions.MPException;
import mercadopago.PagoOnlineV2.dtos.request.PreferenceReqDto;
import mercadopago.PagoOnlineV2.service.MyTechService;
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
