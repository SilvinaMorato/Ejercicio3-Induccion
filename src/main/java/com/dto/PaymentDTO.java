package com.dto;

import com.mercadopago.core.annotations.validation.Size;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class PaymentDTO {

    @Pattern(regexp = "(\\p{Alnum}|\\s|'|-)*", message = "is not a valid alphanumeric characters")
    String description;

    @NotEmpty
    @Email(message = "Format Incorrect")
    String email;

    @NotNull
    @Min(value = 1, message = "Is not positive")
    Float amount;

    @NotNull(message = "Is not null")
    Integer installments;

    @NotBlank
    String issuerId;

    @NotBlank
    @Pattern(regexp = "(\\p{Alnum}|\\s|'|-)*", message = "is not a valid alphanumeric characters")
    String paymentMethodId;

    @NotEmpty
    @Length(min = 32, max = 32, message= "In not have 32 caracters")
    String token;

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public Float getAmount() {
        return amount;
    }

    public Integer getInstallments() {
        return installments;
    }

    public String getIssuerId() {
        return issuerId;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public String getToken() {
        return token;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
