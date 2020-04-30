package manager;

import constants.Regex;
import context.FunctionContext;
import exception.JavaScriptExecutorException;
import lombok.extern.slf4j.Slf4j;
import exception.ErrorCode;
import util.Pieces;
import util.Validate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class ScriptEngineManager
{
    private StringBuilder stringBuilder;
    private Scanner scanner;
    private FunctionContext functionContext;

    public ScriptEngineManager()
    {
        functionContext = new FunctionContext();
    }

    private void initialize() throws FileNotFoundException
    {

        Validate.requireNonNull(functionContext.getTie(), "Object must not be empty.");

        stringBuilder = new StringBuilder();

        functionContext.setScriptPath
                (
                        disassemble().get(Pieces.SCRIPT_PATH.getValue())
                );

        scanner = new Scanner(new File(functionContext.getScriptPath()));

        functionContext.setFunctionName
                (
                        disassemble().get(Pieces.FUNCTION_NAME.getValue())
                );

    }

    public String eval(String var) throws FileNotFoundException
    {

        functionContext.setTie(var);

        initialize();

        String func = scannerFunction(functionContext.getFunctionName());

        if (func.isEmpty())
        {

            throw new JavaScriptExecutorException(ErrorCode.FUNCTION_NOT_FOUND, "Function not found : " + var);
        }

        return func;
    }

    private String scannerFunction(String functionName)
    {
        while (scanner.hasNextLine())
        {
            String firstLane = scanner.nextLine();

            //TODO : shl add func
            if (firstLane.startsWith("var " + functionName))
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

                        return stringBuilder.append(endLane).toString() + functionName + "();";
                    }

                }

            }
        }

        return "";
    }

    private Map<String, String> disassemble()
    {
        Map<String, String> pieceMap = new HashMap<>();

        EnumSet.allOf(Pieces.class)
                .forEach(e -> {

                    if (e.equals(Pieces.FUNCTION_NAME))
                    {
                        pieceMap.put(Pieces.FUNCTION_NAME.getValue(), resolveParam(Regex.FUNCTON_NAME));
                    }
                    else if (e.equals(Pieces.SCRIPT_PATH))
                    {

                        pieceMap.put(Pieces.SCRIPT_PATH.getValue(), resolveParam(Regex.SCRIPT_PATH));

                    }
                });

        return pieceMap;
    }

    private String resolveParam(String regex)
    {

        String param = null;

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(functionContext.getTie());

        while (matcher.find())
        {

            param = matcher.group();
        }

        return param;

    }
}
