package com.kubac.homework.processor;

import static com.kubac.homework.BscHomeworkApplication.APP_RUNNING;
import static com.kubac.homework.repository.PackageRepository.getAllPostalCodes;
import static com.kubac.homework.repository.PackageRepository.getWeightForPostalCode;

public class ConsoleOutputProcessor extends Thread {

    private static final int OUTPUT_PERIOD = 60000;

    @Override
    public void run() {
        while (APP_RUNNING) {
            showOutput();

            try {
                Thread.sleep(OUTPUT_PERIOD);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void showOutput() {
        StringBuilder output = new StringBuilder();
        output.append("Current weights per postal code:\n");

        getAllPostalCodes().forEach(
                pos -> output.append(pos.toString()).append(" ").append(getWeightForPostalCode(pos).toString()).append("\n")
        );

        System.out.println(output);
    }
}
