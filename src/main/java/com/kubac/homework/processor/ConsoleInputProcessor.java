package com.kubac.homework.processor;

import com.kubac.homework.repository.PackageRepository;

import java.math.BigDecimal;

import static com.kubac.homework.processor.ConsoleOutputMessage.*;

public class ConsoleInputProcessor {

    public static void processInputLine(String line) {
        StringBuilder consoleOutput = new StringBuilder("Inserted input: ").append(line).append("\n");

        String[] values = line.split(" ");

        appendPackageProcessing(consoleOutput);

        if (values.length == 2) {
            BigDecimal weight = null;
            Integer pos = null;
            boolean validInput = true;

            try {
                weight = new BigDecimal(values[0]);

                if (getBigDecimalDigits(weight) > 3 || weight.compareTo(BigDecimal.ZERO) < 0) {
                    appendIncorrectWeightFormat(consoleOutput);
                    validInput = false;
                }
            } catch (NumberFormatException e) {
                appendIncorrectWeightFormat(consoleOutput);
                validInput = false;
            }

            try {
                pos = Integer.valueOf(values[1]);

                if (values[1].length() != 5) {
                    appendIncorrectPostalFormat(consoleOutput);
                    validInput = false;
                }
            } catch (NumberFormatException e) {
                appendIncorrectPostalFormat(consoleOutput);
                validInput = false;
            }

            if (validInput) {
                PackageRepository.savePackage(pos, weight);

                appendPackageSaved(consoleOutput);
            } else {

                appendPackageNotSaved(consoleOutput);
            }

        } else {
            appendIncorrectWeightFormat(consoleOutput);
            appendIncorrectPostalFormat(consoleOutput);
            appendPackageNotSaved(consoleOutput);
        }

        printOutput(consoleOutput);
    }

    private static int getBigDecimalDigits(BigDecimal bigDecimal) {
        String string = bigDecimal.stripTrailingZeros().toPlainString();
        int index = string.indexOf(".");
        return index < 0 ? 0 : string.length() - index - 1;
    }

    private static void printOutput(StringBuilder output) {
        System.out.println(output);
    }
}
