package manager;

import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Slf4j
public class ScannerManager
{
    private StringBuilder stringBuilder;
    private Scanner scanner;
    private File file;

    public ScannerManager(@NotNull String filePath) throws FileNotFoundException
    {
        file = new File(filePath);
        stringBuilder = new StringBuilder();
        scanner = new Scanner(file);

    }

    public String scannerFunc(String var)
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
