import com.config.ConfigAccess;
import com.controllers.PaymentController;
import com.dto.PaymentDTO;
import com.google.common.base.Verify;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.services.PaymentService;
import com.validation.PaymentValidationHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import spark.Response;

import java.util.Map;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class PaymentMethodTestMockito {

    PaymentController paymentController;
    PaymentService paymentService;
    PaymentValidationHandler paymentValidationHandler;
    @Before
    public void setUp()throws MPException{
        ConfigAccess.accessConfig();
         paymentController = new PaymentController(new PaymentService(), new PaymentValidationHandler());
         paymentService = new PaymentService();
         paymentValidationHandler = new PaymentValidationHandler();

    }
    @Test
    public void testProcessPaymentMock() {

        Payment payment = Mockito.mock(Payment.class);
        Response response = Mockito.mock(Response.class);

        Mockito.when(payment.getStatus()).thenReturn(Payment.Status.approved);
        Mockito.when (payment.getId()).thenReturn("12");
        Mockito.when(response.status()).thenReturn(200);

       Map<String,Object> map = (Map<String, Object>) paymentController.proccessPayment(payment,response);
       if (map.size() ==2 ){
           Assert.assertEquals(map.containsValue("12"), true) ;
           Assert.assertEquals(map.containsValue(Payment.Status.approved), true);
       }
    }

    /*
    *
     */

    @Test
    public void testSavePayment() throws MPException {
        PaymentDTO paymentDTO = Mockito.mock(PaymentDTO.class);
        Payment payment = Mockito.mock(Payment.class);

        Mockito.when(paymentDTO.getPaymentMethodId()).thenReturn("visa");
        Mockito.when(paymentDTO.getAmount()).thenReturn((float) 234.2);
        Mockito.when(paymentDTO.getInstallments()).thenReturn(3);
        Mockito.when(paymentDTO.getEmail()).thenReturn("test@test.com");
        Mockito.when(paymentDTO.getToken()).thenReturn("ed1fa2bf1929a41747ff9fe3e211c494");
        Mockito.when(paymentDTO.getDescription()).thenReturn("Prueba");
        System.out.println(paymentDTO);
        Object resp= paymentValidationHandler.validate(paymentDTO);
        Assert.assertEquals(resp, true);

    }

}
