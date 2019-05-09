package com.services;

import com.dto.PaymentDTO;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.datastructures.payment.Payer;

public class PaymentService {


 public static PaymentService getPaymentsService() {

     return new PaymentService();
 }
 /**
  * save paymentDTO on payment
  * @param paymentDTO
  * @return Payment
  * @throws Exception
  */
 public Payment paymentSave(PaymentDTO paymentDTO) throws MPException {
   Payment payment = new Payment();

   payment.setTransactionAmount(paymentDTO.getAmount())
          .setToken(paymentDTO.getToken())
          .setDescription("Prueba de pago ")
          .setInstallments(paymentDTO.getInstallments())
          .setPaymentMethodId( paymentDTO.getPaymentMethodId())
          .setIssuerId(paymentDTO.getIssuerId());

   payment.setPayer(new Payer().setEmail(paymentDTO.getEmail()));

    payment.save();
  // Print the status of payment

   System.out.println(payment.getStatus());
   return  payment;
 }


}
