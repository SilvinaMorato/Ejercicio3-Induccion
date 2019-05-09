package com.controllers.haldlers;

public class HelperTest {


    public static String getMockParamsInvalid1() {

        String payment ="{\n" +
                "\t\t\"email\": \"aaaaa@aaaa.com\",\n" +
                "\t\t\"amount\":123.4,\n" +
                "\t\t\"payment_method_id\":\"visa\",\n" +
                "\t\t\"installments\":\"3\",\n" +
                "\t\t\"issuerId\":123,\n" +
                "\t\t\"token\": \"\"\n" +
                "}\n";

        return payment;
    }
}
