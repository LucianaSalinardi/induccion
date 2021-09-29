package mercadopago.PagoOnlineV2.service;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.payment.Payer;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.Item;
import mercadopago.PagoOnlineV2.dtos.request.*;
import org.springframework.stereotype.Service;


@Service
public class MyTechService {


    private static Payment payment;

    //Metodo para crear preferencia (ejercicio 1) seteando valores.

    private static final String ACCESS_TOKEN = "TEST-2406243809774848-092102-25dc1ac7252364a6d0d4712b6dfb96de-818388241";

    public Preference getPreference() throws MPException {
        MercadoPago.SDK.setAccessToken(ACCESS_TOKEN);
        Preference preference = new Preference();
        Item item = createItem();
        BackUrls backUrl = new BackUrls();
        backUrl.setSuccess("https://www.mercadolibre.com.ar");
        preference.setBackUrls(backUrl);
        preference.appendItem(item);
        preference.save();
        return preference;
    }

    public Item createItem() {
        Item item1 = new Item();
        item1.setQuantity(1);
        item1.setCategoryId("cat123");
        item1.setUnitPrice(75000F);
        item1.setDescription("Smart Samsung 55 pulgadas 4K UHD QN55Q60TA");

        return item1;
    }
    //Metodo para crear pago seteando los valores.

    public Payment createPayment(PaymentReqDto paymentReqDto) throws MPException {
        MercadoPago.SDK.setAccessToken(ACCESS_TOKEN);

        payment = new Payment()
                .setTransactionAmount(paymentReqDto.getTransaction_amount())
                .setToken(paymentReqDto.getToken())
                .setDescription("Smart Samsung 55 pulgadas 4K UHD QN55Q60TA")
                .setInstallments(paymentReqDto.getInstallments())
                .setStatus(Payment.Status.approved);
        Payer payer = new Payer();
        payer.getEmail();
        payer.setIdentification(paymentReqDto.getPayer().getIdentification());
        payment.save();
        return payment;
    }

    /*Metodo para crear pago (a modo de prueba) para que traiga los valores sin setearlos.
    Deberia funcionar pero hay un problema que el save no trae el id del payment, ni el status.
    Se estuvo revisando y no encontramos la manera de solucionarlo aun. */

    public Payment create_payment(PaymentReqDto paymentReqDto) throws MPException {
        MercadoPago.SDK.setAccessToken(ACCESS_TOKEN);
        Payment payment = new Payment();
        payment.setTransactionAmount(paymentReqDto.getTransaction_amount())
                .setToken(paymentReqDto.getToken())
                .setDescription(payment.getDescription())
                .setInstallments(paymentReqDto.getInstallments())
                .setPaymentMethodId(paymentReqDto.getPayment_method_id());

        Payer payer = new Payer();
        payer.setEmail(paymentReqDto.getPayer().getEmail())
                .setIdentification(paymentReqDto.getPayer().getIdentification());
        payment.setPayer(payer);
        payment.save();

        System.out.println(payment.getId());
        System.out.println(payment.getStatus());
        return payment;
    }

    public Payment getPayment() {
        return payment;
    }

}


