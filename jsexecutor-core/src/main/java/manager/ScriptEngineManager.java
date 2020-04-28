package manager;

import exception.JavaScriptExecutorException;
import lombok.extern.slf4j.Slf4j;
import util.ErrorCode;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Slf4j
public class ScriptEngineManager
{
    private StringBuilder stringBuilder;
    private Scanner scanner;

    public ScriptEngineManager(@NotNull String filePath) throws FileNotFoundException
    {
        stringBuilder = new StringBuilder();
        File file = new File(filePath);
        scanner = new Scanner(file);
    }

    public String eval(String var){

        String func = scannerFunc(var);;

        if (func.isEmpty()){

            throw new JavaScriptExecutorException(ErrorCode.FUNCTION_NOT_FOUND, "Function not found : " + var);
        }

        return func;
    }

    /*public String eval(String func){

        return scannerFunc(func);
    }*/


    private String scannerFunc(String var)
    {
        while (scanner.hasNextLine())
        {
            String firstLane = scanner.nextLine();

            //TODO : shl add func
            if (firstLane.startsWith("var " + var))
            {
                stringBuilder
                        .append(firstLane);
                while (scanner.hasNextLine())
                {

                    String endLane = scanner.nextLine();

                    if (!endLane.startsWith("};"))
                    {

                        stringBuilder.append(endLane);

                    }
                    else if (endLane.startsWith("};"))
                    {

                        return stringBuilder.append(endLane).toString() + var + "();";
                    }

                }

            }
        }

        return "";

    }
}
