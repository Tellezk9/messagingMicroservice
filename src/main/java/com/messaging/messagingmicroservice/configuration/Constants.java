package com.messaging.messagingmicroservice.configuration;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }
    public static final String ROLE_EMPLOYEE = "ROLE_EMPLOYEE";
    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error";
    public static final String RESPONSE_MESSAGE_KEY = "message";
    public static final String SENT_SUCCESSFULLY_MESSAGE = "Message sent successfully";
    public static final String EMPTY_FIELD_FOUND_MESSAGE = "All fields must be completed";
    public static final String INVALID_FORMAT_EMAIL_MESSAGE = "Wrong mail format";
    public static final String INVALID_PHONE_MESSAGE = "Wrong phone format";
    public static final String INVALID_PHONE_LENGTH_MESSAGE = "Wrong phone length format";
    public static final String SMS_NOTIFICATION_COULD_NOT_SEND_MESSAGE = "The sms notification could not be sent.";

    public static final String SWAGGER_TITLE_MESSAGE = "User API Pragma Power Up";
    public static final String SWAGGER_DESCRIPTION_MESSAGE = "User microservice";
    public static final String SWAGGER_VERSION_MESSAGE = "1.0.0";
    public static final String SWAGGER_LICENSE_NAME_MESSAGE = "Apache 2.0";
    public static final String SWAGGER_LICENSE_URL_MESSAGE = "http://springdoc.org";
    public static final String SWAGGER_TERMS_OF_SERVICE_MESSAGE = "http://swagger.io/terms/";
}