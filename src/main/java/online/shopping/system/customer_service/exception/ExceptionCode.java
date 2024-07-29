package online.shopping.system.customer_service.exception;

public interface ExceptionCode {

    String getErrorCode();

    //the getMessage method : new ParameterizedMessage(message, arguments).getFormattedMessage();
    //will automatically help you to replace {} with the arguments
    String getMessage(Object...arguments);

}
