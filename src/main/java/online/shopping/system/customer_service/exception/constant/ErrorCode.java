package online.shopping.system.customer_service.exception.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import online.shopping.system.customer_service.exception.ExceptionCode;
import org.apache.logging.log4j.message.ParameterizedMessage;

@Getter
@AllArgsConstructor
public enum ErrorCode implements ExceptionCode {
    CUSTOMER_ALREADY_EXIST("C0001","customer with username: {} is already existed"),

    SYSTEM_BUSY("C0002","System busy"),
    JWT_ID_NOT_MATCH("C003", "Jwt id is not matched with corresponding customer");


    private final String errorCode;
    private final String message;

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage(Object... arguments) {
        if(arguments == null){
            return message;
        }
        return new ParameterizedMessage(message, arguments).getFormattedMessage();
    }
}
