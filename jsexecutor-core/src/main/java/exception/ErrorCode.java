package exception;

public abstract class ErrorCode extends RuntimeException
{

    public static final int GENERIC_ERROR = 0;

    public static final int FUNCTION_NOT_FOUND = 101;

    public static final int FILE_NOT_FOUND = 201;

    public static final int OBJECT_IS_NULL = 301;

}
