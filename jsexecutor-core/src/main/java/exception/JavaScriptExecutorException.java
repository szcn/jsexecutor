package exception;

import java.util.Objects;

public class JavaScriptExecutorException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    private int errorCode;
    private String errorDescription;

    public JavaScriptExecutorException()
    {
    }

    public JavaScriptExecutorException(Throwable cause) {
        super(cause);
    }

    public JavaScriptExecutorException(String message)
    {
        super(message);
    }

    public JavaScriptExecutorException(int code, String message)
    {
        super(buildMessage(code, null, message));
        this.errorCode = code;
    }

    public JavaScriptExecutorException(int code, String message, Throwable cause)
    {
        super(buildMessage(code, null, message), cause);
        this.errorCode = code;
    }

    public JavaScriptExecutorException(int code, String errorDescription, String message)
    {
        super(buildMessage(code, errorDescription, message));
        this.errorCode = code;
        this.errorDescription = errorDescription;
    }

    public JavaScriptExecutorException(int code, String errorDescription, String message, Throwable cause)
    {
        super(buildMessage(code, errorDescription, message), cause);
        this.errorCode = code;
        this.errorDescription = errorDescription;
    }

    private static String buildMessage(int code, String errorDescription, String message)
    {
        return message + " (errorCode: " + code + (Objects.nonNull(errorDescription) ? "-" + errorDescription : "" ) + ")";
    }

    public int getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(int errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getErrorDescription()
    {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription)
    {
        this.errorDescription = errorDescription;
    }
}
