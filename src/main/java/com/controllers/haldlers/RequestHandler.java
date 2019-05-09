package com.controllers.haldlers;

import com.dto.PaymentDTO;
import com.errors.ErrorCause;

import java.util.List;

public interface RequestHandler {

    /**
     * Inform the status of validation.
     */

    /**
     * Method that must inform the status of the validation
     * @return whether the request is valid or not.
     */
    boolean validate(PaymentDTO paymentDTO);

    /**
     * List validation failures in the request parameters.
     * @return a list of @see ErrorCause.java
     */

    List<ErrorCause> getInvalidCause();
}
