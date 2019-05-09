package com.routers;


import com.controllers.PaymentController;
import com.services.PaymentService;
import com.utils.JsonTransformer;
import com.utils.Render;
import com.validation.PaymentValidationHandler;
import spark.Spark;
import spark.servlet.SparkApplication;
import spark.template.thymeleaf.ThymeleafTemplateEngine;



public class RestEndInit implements SparkApplication {

    /**
     *Method that starts the server manually
     */

    @Override
    public void init() {

        Spark.get("/form-3", Render::RenderView, new ThymeleafTemplateEngine());

        PaymentValidationHandler paymentValidationHandler = new PaymentValidationHandler();

        PaymentController paymentController = new PaymentController(PaymentService.getPaymentsService(),paymentValidationHandler );

        Spark.post("/form-3",paymentController::paymentV1, new JsonTransformer());

    }


}
