package com.ripple.infrasvc.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sumit.nagariya on 18/09/19.
 */
public class BaseController {
    protected static final int HTTP_OK = 200;
    protected static final int HTTP_CREATED = 201;
    protected static final int HTTP_INTERNAL_SERVER_ERROR = 500;
    protected static final int HTTP_BAD_REQUEST = 400;
    protected static final int HTTP_CONFLICT = 409;
    protected static final int HTTP_NOT_FOUND = 404;
    protected static final int HTTP_UNPROCESSABLE_ENTITY = 422;
    protected static final int HTTP_FORBIDDEN = 403;
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
    private static final int EXCEPTION_CACHE_SIZE = 256;


}
