package com.mercadolibre.pagoOnline.service;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.Item;
import org.springframework.stereotype.Service;


@Service
public class MyTechService {


    public Preference getPreference() throws MPException {
        MercadoPago.SDK.setAccessToken("APP_USR-8446184297487974-090916-d77d717e5efd5c9466eb0b68025013fb-818388241");
        Preference preference = new Preference();
        Item item1 = new Item();
        item1.setQuantity(1);
        item1.setCategoryId("cat123");
        item1.setUnitPrice(75000F);
        item1.setDescription("SMART SAMSUNG 55 PULGADAS 4K UHD QN55Q60TA");
        BackUrls backUrl = new BackUrls();
        backUrl.setSuccess("https://www.mercadolibre.com.ar");
        preference.setBackUrls(backUrl);
        preference.appendItem(item1);
        preference.save();
        return preference;

    }

}
