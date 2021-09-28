package mercadopago.PagoOnlineV2.dtos.request;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.datastructures.payment.Payer;
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
public class PaymentReqDto  {


    private String payment_method_id;
    private String issuer_id;
    private Float transaction_amount;
    private String token;
    private Integer installments;
    private Payer payer;
    private String description;
    private Payment.Status status;




}
