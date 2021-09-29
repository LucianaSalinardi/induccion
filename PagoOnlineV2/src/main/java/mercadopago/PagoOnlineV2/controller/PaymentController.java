package mercadopago.PagoOnlineV2.controller;

import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.Preference;
import mercadopago.PagoOnlineV2.dtos.request.PaymentReqDto;
import mercadopago.PagoOnlineV2.service.MyTechService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PaymentController {

    private final MyTechService myTechService;

    public PaymentController(MyTechService myTechService) {
        this.myTechService = myTechService;
    }


    @GetMapping(value = "/product", produces = "text/html")
    public String getProduct(Model model) throws MPException {
        Preference preference = myTechService.getPreference();
        model.addAttribute("preferenceId", preference.getId());
        model.addAttribute("description", preference.getItems().get(0).getDescription());
        model.addAttribute("category", preference.getItems().get(0).getCategoryId());
        model.addAttribute("unitPrice", preference.getItems().get(0).getUnitPrice());

        return "preference";
    }

    @GetMapping(value = "/cardForm", produces = "text/html")
    public String getCardForm() throws MPException {

        return "cardform";
    }

    @PostMapping(path = "/process_payment")
    public ResponseEntity<Payment> createPayment(@RequestBody PaymentReqDto paymentReqDto) throws MPException {

        return new ResponseEntity<>(myTechService.createPayment(paymentReqDto), HttpStatus.CREATED);
    }


    @GetMapping(value = "/success", produces = "text/html")
    public String congrats(Model model) throws MPException {
        Payment payment = myTechService.getPayment();
        model.addAttribute("price", payment.getTransactionAmount());
        model.addAttribute("description", payment.getDescription());
        model.addAttribute("status", payment.getStatus());
        return "congrats";

    }

}
