package com.octo.controller.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

import org.junit.Test;
import org.springframework.http.HttpStatus;

public class ClientErrorHandlerTest {

    @Test
    public void toResponseTest() {
        final ClientErrorHandler handler = new ClientErrorHandler();

        NotFoundException exception = new NotFoundException();

        Response response = handler.toResponse(exception);
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
        assertEquals("{\"message\":\"HTTP 404 Not Found\"}", response.getEntity().toString());

        final String message = null;
        exception = new NotFoundException(message);

        response = handler.toResponse(exception);
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
        assertEquals("{\"message\":\"Client error.\"}", response.getEntity().toString());
    }
}
