package com.kubac.homework;

import com.kubac.homework.processor.ConsoleOutputProcessor;
import com.kubac.homework.processor.FileInputProcessor;

import java.util.Scanner;

import static com.kubac.homework.processor.ConsoleInputProcessor.processInputLine;

public class BscHomeworkApplication {

    public static boolean APP_RUNNING = true;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        new ConsoleOutputProcessor().start();

        while (APP_RUNNING) {
            String line = input.nextLine();

            if (line.equals("quit")) {
                System.exit(0);
            }

            if (line.startsWith("run - ")) {
                new FileInputProcessor(line.substring(6)).start();
            } else {
                processInputLine(line);
            }
        }
    }
}