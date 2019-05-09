
import com.dto.PaymentDTO
import com.validation.PaymentValidationHandler
import spock.lang.Specification
import spock.lang.Unroll

class PaymentMehtodControllerTestSpocke extends Specification {

    @Unroll
    def "test create PaymentDTO invalid"() {
        given:
        PaymentValidationHandler paymentValidationHandler = new PaymentValidationHandler()
         boolean resp
        when:
        PaymentDTO paymentDTO= new PaymentDTO()
        paymentDTO.setEmail("aaa@aaaaa.com")
        paymentDTO.setAmount(24234)
        paymentDTO.setInstallments(3)
        paymentDTO.setPaymentMethodId("visa")
        paymentDTO.setToken("")
        paymentDTO.setIssuerId("123")
        resp = paymentValidationHandler.validate(paymentDTO)

        then:

        resp == false
    }


    @Unroll
    def "test create Payment valid"() {
        given:
        PaymentValidationHandler paymentValidationHandler = new PaymentValidationHandler()
        boolean resp
        when:
        PaymentDTO paymentDTO= new PaymentDTO()
        paymentDTO.setEmail("aaa@aaaaa.com")
        paymentDTO.setAmount(24234)
        paymentDTO.setInstallments(3)
        paymentDTO.setPaymentMethodId("visa")
        paymentDTO.setToken("ed1fa2bf1929a41747ff9fe3e211c494")
        paymentDTO.setIssuerId("00011")
        resp = paymentValidationHandler.validate(paymentDTO)

        then:

        resp == true
    }
    @Unroll
    def "test Validate One Param"(){
        given:
            Boolean resp
            PaymentValidationHandler paymentValidationHandler = new PaymentValidationHandler()

        when:
        PaymentDTO paymentDTO= new PaymentDTO()
        paymentDTO.setEmail(email)
        paymentDTO.setAmount(monto)
        paymentDTO.setInstallments(cuotas)
        paymentDTO.setPaymentMethodId(tarjeta)
        paymentDTO.setToken(token)
        resp = paymentValidationHandler.validate(paymentDTO)

        then:
        resp == result
        where:
            email       | monto  |cuotas     |tarjeta|token                                  |result

        "test@test.com"  |   234  |   2      | "visa" | " "                                  | false
        "test@test.com"  |   234  |   2      | "visa" | "ea6d62138607b27f4ce22fd9986f6136"   | true
        "test@test.com"  |   234  | null     | "visa" | "ea6d62138607b27f4ce22fd9986f6136"   | false
        "test@test.com"  |   234  |   2      | ""     | "ea6d62138607b27f4ce22fd9986f6136"   | false
   }
}


