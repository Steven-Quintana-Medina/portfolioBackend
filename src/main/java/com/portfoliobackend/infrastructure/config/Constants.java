package com.portfoliobackend.infrastructure.config;

public class Constants {
    //response key
    public static final String RESPONSE_MESSAGE_KEY = "message";
    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error";
    public static final String DESCRIPTION_MESSAGE_KEY = "http 200 type messages";
    public static final String DESCRIPTION_ERROR_KEY = "http 400 type messages";
    public static final String DESCRIPTION_MESSAGE_BOOLEAN_KEY = "true for http 200 message types and false for http 400 message types";


    // responses for 200 code
    public static final String PROJECT_CREATED_MESSAGE = "A project created successfully";
    public static final String PROJECT_UPDATE_MESSAGE = "A project update successfully";
    public static final String PROJECT_DELETE_MESSAGE = "A project delete successfully";

    // responses for 400n code
    public static final String SWAGGER_PROJECT_ERROR = "Problems creating a project";

    public static final String PROJECT_NOT_FOUND = "Project not found";
    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    //swagger
    public static final String SWAGGER_TITLE_MESSAGE = "Profolio backend";
    public static final String SWAGGER_DESCRIPTION_MESSAGE = "backend to upload development project descriptions";
    public static final String SWAGGER_VERSION_MESSAGE = "2.0.4";
    public static final String SWAGGER_LICENSE_NAME_MESSAGE = "Apache 2.0";
    public static final String SWAGGER_LICENSE_URL_MESSAGE = "https://springdoc.org/v2/";
    public static final String SWAGGER_TERMS_OF_SERVICE_MESSAGE = "http://swagger.io/terms/";
}
