package manager;

import constants.Regex;
import context.FunctionContext;
import exception.JavaScriptExecutorException;
import lombok.extern.slf4j.Slf4j;
import exception.ErrorCode;
import util.Validate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

        Validate.requireNonNull(functionContext.getTie(), "Object must not be empty : ");

        stringBuilder = new StringBuilder();

        functionContext.setScriptPath
                (
                        disassemble().entrySet().stream()
                                .filter(e -> e.getKey().equals(Pieces.SCRIPT_PATH))
                                .map(Map.Entry::getValue)
                                .collect(Collectors.joining())
                );

        scanner = new Scanner(new File(functionContext.getScriptPath()));

        functionContext.setFuncName
                (
                        disassemble().entrySet().stream()
                                .filter(e -> e.getKey().equals(Pieces.SCRIPT_PATH))
                                .map(Map.Entry::getValue)
                                .collect(Collectors.joining())
                );

    }

    public String eval(String var) throws FileNotFoundException
    {

        functionContext.setTie(var);

        initialize();

        String func = scannerFunc(functionContext.getFuncName());

        if (func.isEmpty())
        {

            throw new JavaScriptExecutorException(ErrorCode.FUNCTION_NOT_FOUND, "Function not found : " + var);
        }

        return func;
    }

    private String scannerFunc(String funcName)
    {
        while (scanner.hasNextLine())
        {
            String firstLane = scanner.nextLine();

            //TODO : shl add func
            if (firstLane.startsWith("var " + funcName))
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

                        return stringBuilder.append(endLane).toString() + funcName + "();";
                    }

                }

            }
        }

        return "";
    }

    private Map<String, String> disassemble()
    {

        Map<String, String> pieceMap = new HashMap<>();

        pieceMap.put(Pieces.FUNCTION_NAME.getValue(), Pattern.compile(Regex.FUNC_NAME).matcher(functionContext.getTie()).toString());
        pieceMap.put(Pieces.SCRIPT_PATH.getValue(), Pattern.compile(Regex.SCRIPT_PATH).matcher(functionContext.getTie()).toString());

        return pieceMap;
    }

    public enum Pieces
    {
        FUNCTION_NAME("function_name"),
        SCRIPT_PATH("script_path");

        private final String piece;

        Pieces(final String piece)
        {
            this.piece = piece;
        }

        public String getValue()
        {
            return piece;
        }

    }
}
