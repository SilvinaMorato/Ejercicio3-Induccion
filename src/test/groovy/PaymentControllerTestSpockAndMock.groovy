import com.config.ConfigAccess
import com.controllers.PaymentController
import com.mercadopago.resources.Payment
import com.services.PaymentService
import com.validation.PaymentValidationHandler
import org.apache.http.HttpStatus
import spark.Response
import spock.lang.Specification
import spock.lang.Unroll

class PaymentControllerTestSpockAndMock  extends  Specification{

 /*   //Se debe mockear Payment and Response

    Payment payment
    Response response
    PaymentController paymentController

    def setup() {

        paymentController=  new PaymentController(new PaymentService(), new PaymentValidationHandler())
    }

    @Unroll
        def " test ProccessPayment" (){
        given:
            ConfigAccess.accessConfig()
            payment = Mock(Payment)
            response =Mock(Response)
        when:
            payment.setStatus(estado)
            response.status(resp)
            object = paymentController.proccessPayment(payment,response)
        then:
            object instanceof Map

         where:

            estado  | resp

            "approved" | HttpStatus.SC_OK
             null      |  "fruta"
    }*/


}
