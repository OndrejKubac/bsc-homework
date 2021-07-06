package com.kubac.homework.processor;

public interface ConsoleOutputMessage {

    static void appendPackageProcessing(StringBuilder line) {
        line.append("Package processing...\n");
    }

    static void appendPackageSaved(StringBuilder line) {
        line.append("Package was successfully saved.\n");
    }

    static void appendPackageNotSaved(StringBuilder line) {
        line.append("Package was not saved.\n");
    }

    static void appendIncorrectWeightFormat(StringBuilder line) {
        line.append("Incorrect weight format. (Must be positive number with maximum 3 decimal places)\n");
    }

    static void appendIncorrectPostalFormat(StringBuilder line) {
        line.append("Incorrect postal code format. (Must be with fixed 5 digits)\n");
    }
}
