package com.controllers;

import com.dto.PaymentDTO;
import com.errors.ErrorResponse;
import com.mercadopago.core.MPApiResponse;
import com.mercadopago.resources.Payment;
import com.services.PaymentService;
import com.utils.RequesUtil;
import com.validation.PaymentValidationHandler;
import org.apache.http.HttpStatus;
import spark.Response;
import spark.Request;
import java.util.HashMap;
import java.util.Map;

public class PaymentController {

    PaymentService paymentService = new PaymentService();
    PaymentValidationHandler paymentValidation = new PaymentValidationHandler();

    public PaymentController(PaymentService paymentService, PaymentValidationHandler paymentValidation) {
        this.paymentService = paymentService;
        this.paymentValidation = paymentValidation;
    }
     /**
     *
     * @param req
     * @param res
     * @return the save Payment-  ok!
     * @throws Exception
     */

    public Object paymentV1(Request req, Response res)throws Exception {

        PaymentDTO paymentDTO = RequesUtil.getBodyParameter(req, PaymentDTO.class);

        if(!paymentValidation.validate(paymentDTO)){
            return new ErrorResponse(400, "bad_request", "Invalid Payment Processing",  paymentValidation.getInvalidCause());
        }

       Payment payment = paymentService.paymentSave(paymentDTO);
       return proccessPayment(payment, res);
   }

    /**
     *
     *check the payment information and return the map with positive results or not.
     * @param payment
     * @param res
     * @return
     */
    public Object proccessPayment(Payment payment, Response res){

        if (payment.getStatus()==  null) {
            MPApiResponse mpa = payment.getLastApiResponse();
            res.status(mpa.getStatusCode());
            return mpa.getJsonElementResponse();
        }
        res.status(HttpStatus.SC_OK);
        Map<String, Object> map=  new HashMap<>();
        map.put("status", payment.getStatus());
        map.put("Id", payment.getId());
        return map;
    }

}
