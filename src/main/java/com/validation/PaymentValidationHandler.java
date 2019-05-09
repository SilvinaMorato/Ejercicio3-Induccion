package com.validation;

import com.controllers.haldlers.RequestHandler;
import com.dto.PaymentDTO;
import com.errors.ErrorCause;
import com.errors.ErrorResponse;
import com.mercadopago.core.MPApiResponse;
import com.mercadopago.resources.Payment;
import org.apache.commons.validator.routines.EmailValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import  org.apache.commons.lang3.StringUtils;


public class PaymentValidationHandler implements RequestHandler{

    List<ErrorCause> causeList= new ArrayList<>();

    @Override
    public List<ErrorCause> getInvalidCause() {
        return causeList;
    }

    /**
     * Validation Automatic
     * @param paymentDTO
     * @return
     */
    public  Set<ConstraintViolation<PaymentDTO>> validateParamDinamic(PaymentDTO paymentDTO) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<PaymentDTO>> validations = validator.validate(paymentDTO);
        return validations;
    }

    /**
     * Method that validates the annotations and generates a list of cause of error.
     * @param paymentDTO
     * @return
     */
    @Override
    public boolean validate(PaymentDTO paymentDTO){
        if(!StringUtils.isNotBlank(paymentDTO.getEmail())) {
            causeList.add( new ErrorCause( "202", "Payer is null"));
        } else if (!EmailValidator.getInstance().isValid( paymentDTO.getEmail())){
            causeList.add(new ErrorCause( "202", "Format Email is incorrect" ));}

        if (paymentDTO.getAmount() == null){
            causeList.add(new ErrorCause( "204", "Amount is null or empty"));
        }else if(paymentDTO.getAmount()< 0)
            causeList.add(new ErrorCause( "204", "Amount is not positive"));

        if(!StringUtils.isNotBlank(paymentDTO.getPaymentMethodId())){
            causeList.add( new ErrorCause( "206","Payment Method is null or empty"));}
        else if (!StringUtils.isAlpha(paymentDTO.getPaymentMethodId()))
            causeList.add( new ErrorCause( "206", "Payment Method not contain letters" ));

        if(paymentDTO.getInstallments()== null)
            causeList.add( new ErrorCause( "204", "Installments is null or empty"));

        if(!StringUtils.isNotBlank(paymentDTO.getToken()))
            causeList.add(new ErrorCause("20", "Token is null or empty"));

        return causeList.isEmpty();
    }
}
