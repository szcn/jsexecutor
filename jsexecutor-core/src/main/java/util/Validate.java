package util;

import exception.ErrorCode;
import exception.JavaScriptExecutorException;

public final class Validate
{

    public static <T> T requireNonNull(T obj, String message)
    {
        if (obj == null)
        {
            throw new JavaScriptExecutorException(ErrorCode.OBJECT_IS_NULL, message);
        }
        else
        {
            return obj;
        }
    }

}
