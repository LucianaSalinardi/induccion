package mercadopago.PagoOnlineV2.dtos.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mercadopago.resources.datastructures.customer.card.Cardholder;
import com.mercadopago.resources.datastructures.customer.card.Issuer;
import com.mercadopago.resources.datastructures.customer.card.PaymentMethod;
import com.mercadopago.resources.datastructures.customer.card.SecurityCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;


@Validated
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CardFormReqDto {

    private Integer expirationMonth;
    private Integer expirationYear;
    private String firstSixDigits;
    private String lastFourDigits;
    private PaymentMethod paymentMethod;
    private SecurityCode securityCode;
    private Issuer issuer;
    private Cardholder cardholder;
    private String email;
    private String paymentMethodId;


}
