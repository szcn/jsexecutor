package manager;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Slf4j
public class ScriptEngineManager
{
    private StringBuilder stringBuilder;
    private Scanner scanner;
    private String filePath;

    public ScriptEngineManager(@NotNull String filePath)
    {
        this.filePath = filePath;
    }

    @PostConstruct
    public void init() throws FileNotFoundException
    {
        stringBuilder = new StringBuilder();
        File file = new File(filePath);
        scanner = new Scanner(file);

    }

    public String eval(String var){

        return scannerFunc(var);
    }


    private String scannerFunc(String var)
    {
        while (scanner.hasNextLine())
        {

            String y = scanner.nextLine();

            if (y.startsWith("var " + var))
            {

                //TODO : func ismi yoksa hata fırlatmalı.
                stringBuilder
                        .append(y);
                while (scanner.hasNextLine())
                {

                    String x = scanner.nextLine();

                    if (!x.startsWith("};"))
                    {

                        stringBuilder.append(x);

                    }
                    if (x.startsWith("};"))
                    {

                        return stringBuilder.append(x).toString() + var + "();";
                    }

                }

            }

            System.out.println("Gelme saysııs : ");
            System.out.println(stringBuilder.toString());
        }

        return "";

    }
}
