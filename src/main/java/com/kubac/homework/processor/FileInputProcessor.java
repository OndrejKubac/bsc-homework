package com.kubac.homework.processor;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;

@RequiredArgsConstructor
public class FileInputProcessor extends Thread {

    private final String filePath;

    @SneakyThrows
    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            ConsoleInputProcessor.processInputLine(line);
        }
    }
}
