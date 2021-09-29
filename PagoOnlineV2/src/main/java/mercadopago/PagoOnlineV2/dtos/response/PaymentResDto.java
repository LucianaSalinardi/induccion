package mercadopago.PagoOnlineV2.dtos.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mercadopago.resources.datastructures.payment.Payer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.servlet.http.HttpServletResponse;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public abstract class PaymentResDto implements HttpServletResponse {


    private String token;
    private Float transactionAmount;
    private Payer payer;
    private String description;
    private String paymentMethodId;
    private String issuerId;
    private Integer installments;
}
