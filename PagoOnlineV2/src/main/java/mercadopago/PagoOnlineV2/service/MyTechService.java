package mercadopago.PagoOnlineV2.service;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.payment.Payer;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.Item;
import com.mercadopago.resources.datastructures.payment.Identification;
import mercadopago.PagoOnlineV2.dtos.request.*;
import org.springframework.stereotype.Service;


@Service
public class MyTechService {


    private static Payment payment;

    //Metodo para crear preferencia (ejercicio 1) seteando valores.

    public Preference getPreference() throws MPException {
        MercadoPago.SDK.setAccessToken("TEST-2406243809774848-092102-25dc1ac7252364a6d0d4712b6dfb96de-818388241");
        Preference preference = new Preference();
        Item item1 = new Item();
        item1.setQuantity(1);
        item1.setCategoryId("cat123");
        item1.setUnitPrice(75000F);
        item1.setDescription("Smart Samsung 55 pulgadas 4K UHD QN55Q60TA");
        Float total = item1.getUnitPrice() * item1.getQuantity();
        BackUrls backUrl = new BackUrls();
        backUrl.setSuccess("https://www.google.com");
        preference.setBackUrls(backUrl);
        preference.appendItem(item1);
        preference.save();
        return preference;
    }
    //Metodo crear pago seteando los valores.

    public Payment createPayment(PaymentReqDto paymentReqDto) throws MPException{
        MercadoPago.SDK.setAccessToken("TEST-2406243809774848-092102-25dc1ac7252364a6d0d4712b6dfb96de-818388241");

         payment = new Payment()
                .setTransactionAmount(75000f)
                .setToken(paymentReqDto.getToken())
                .setDescription("Smart Samsung 55 pulgadas 4K UHD QN55Q60TA")
                .setInstallments(paymentReqDto.getInstallments())
                .setStatus(Payment.Status.approved);
        Payer payer= new Payer();
        payer.getEmail();
        payer.setIdentification(paymentReqDto.getPayer().getIdentification());
        payment.save();
        return payment;
    }

    //Metodo crear pago a modo de prueba para que traiga los valores sin setearlos.

    public Payment create_payment(PaymentReqDto paymentReqDto) throws MPException {
        MercadoPago.SDK.setAccessToken("TEST-2406243809774848-092102-25dc1ac7252364a6d0d4712b6dfb96de-818388241");
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


