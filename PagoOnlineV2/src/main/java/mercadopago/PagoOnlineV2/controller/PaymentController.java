package mercadopago.PagoOnlineV2.controller;

import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import mercadopago.PagoOnlineV2.service.MyTechService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PaymentController {

    private final MyTechService myTechService;

    public PaymentController(MyTechService myTechService) {
        this.myTechService = myTechService;
    }


//    @GetMapping(value = "/pago", produces = "text/html")
//    public String pago(Model model) throws MPException {
//        System.out.println("prueba");
//
//        String preferenceId = "818388241-854c8292-67b0-406f-9466-055cf68daf39";
//        PreferenceReqDto preferenceReqDto = new PreferenceReqDto();
//        ArrayList<Item> list = new ArrayList<>();
//        Item item1 = new Item();
//        item1.setTitle("Televisor Samsung");
//        item1.setCategoryId("cat123");
//        item1.setUnitPrice(75000F);
//        item1.setQuantity(1);
//        list.add(item1);
//        preferenceReqDto.setItems(list);
//        myTechService.getPreference();
//        model.addAttribute("preferenceId", preferenceId);
//        return "preference";
//    }

    /**
     * TODO: completar el dto con un item, tomar de la preferencia el id y pasarselo al add atribute
     */


//
//        @GetMapping(value = "/pago", produces = "application/json")
//        public String pago(Model model) {
//        System.out.println("prueba");
//        model.addAttribute("form", new PaymentForm());
//        return "pago";
//    }
//
//    @PostMapping(value = "/pago", produces = "application/json")
//    public String pagoPost(Model model, @ModelAttribute PreferenceReqDto preferenceReqDto) throws MPException {
//        System.out.println("prueba Post");
//        model.addAttribute("form", myTechService.createPreference(preferenceReqDto));
//        return "pago";
//    }
    @GetMapping(value = "/product", produces = "text/html")
    public String getProduct(Model model) throws MPException {
        Preference preference = myTechService.getPreference();
        model.addAttribute("preferenceId", preference.getId());
        model.addAttribute("description", preference.getItems().get(0).getDescription());
        model.addAttribute("category", preference.getItems().get(0).getCategoryId());
        model.addAttribute("unitPrice", preference.getItems().get(0).getUnitPrice());
//        model.addAttribute("total",myTechService.getTotalPrice());

        return "pref";
    }

    @GetMapping(value = "/cardForm", produces = "text/html")
    public String getCardForm(Model model) throws MPException {

        return "cardform";
    }

    @GetMapping(value = "/success", produces = "text/html")
    public String congrats(Model model) throws MPException {
        Preference preference = myTechService.getPreference();
        model.addAttribute("description", preference.getItems().get(0).getDescription());
        model.addAttribute("totalPrice", (preference.getItems().get(0).getUnitPrice()) * (preference.getItems().get(0).getQuantity()));

        return "congrats";
    }

//    @GetMapping(value = "/pago", produces = "text/html")
//    public String pago(Model model) throws MPException {
//        PreferenceReqDto preferenceReqDto= new PreferenceReqDto();
//        ArrayList<Item> list= new ArrayList<>();
//        Item item1 = new Item();
//        item1.setTitle("Televisor Samsung");
//        item1.setDescription("SMART SAMSUNG 55 PULGADAS 4K UHD QN55Q60TA");
//        item1.setCategoryId("cat123");
//        item1.setUnitPrice(75000F);
//        item1.setQuantity(1);
//        list.add(item1);
//        preferenceReqDto.setItems(list);
//        Preference preferenceId= myTechService.createPreference(preferenceReqDto);
//        model.addAttribute("preferenceId",preferenceId);
//        model.addAttribute("title", item1.getTitle());
//        model.addAttribute("description",item1.getDescription());
//        model.addAttribute("category", item1.getCategoryId());
//        model.addAttribute("unitPrice",item1.getUnitPrice());
//
//        return "pref";
//    }


}
