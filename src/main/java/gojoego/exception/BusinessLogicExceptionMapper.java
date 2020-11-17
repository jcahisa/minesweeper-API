package gojoego.exception;

import io.dropwizard.jersey.errors.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class BusinessLogicExceptionMapper implements ExceptionMapper<BusinessLogicException> {

    @Override
    public Response toResponse(BusinessLogicException exception) {
        return Response.serverError().entity(new ErrorMessage(exception.getMessage())).build();
    }
}
