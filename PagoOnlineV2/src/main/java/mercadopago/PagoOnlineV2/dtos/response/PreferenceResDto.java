package mercadopago.PagoOnlineV2.dtos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.Item;
import com.mercadopago.resources.datastructures.preference.Payer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PreferenceResDto {

    private String collectorId;
    private ArrayList<Item> itemsResDto;
    private Payer payerResDto;
    private BackUrls backUrls;
}
