package com.kubac.homework.processor;

import com.kubac.homework.repository.PackageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConsoleInputProcessorTest {
    private static final String VALID_DELIMITER = " ";
    private static final BigDecimal VALID_WEIGHT1 = new BigDecimal("1.4");
    private static final BigDecimal VALID_WEIGHT2 = new BigDecimal("2.5");
    private static final int VALID_POSTAL_CODE1 = 12345;
    private static final int VALID_POSTAL_CODE2 = 77777;
    private static final BigDecimal INVALID_WEIGHT = new BigDecimal("1.1234");
    private static final int INVALID_POSTAL_CODE = 123456;

    @BeforeEach
    void init() {
        PackageRepository.packageRepository.clear();
    }

    @Test
    void should_save_package() {

        ConsoleInputProcessor.processInputLine(VALID_WEIGHT1 + VALID_DELIMITER + VALID_POSTAL_CODE1);

        assertEquals(1, PackageRepository.packageRepository.keySet().size());
        assertTrue(PackageRepository.packageRepository.containsKey(VALID_POSTAL_CODE1));
    }

    @Test
    void should_save_two_packages_for_same_postal_code() {
        ConsoleInputProcessor.processInputLine(VALID_WEIGHT1 + VALID_DELIMITER + VALID_POSTAL_CODE1);
        ConsoleInputProcessor.processInputLine(VALID_WEIGHT2 + VALID_DELIMITER + VALID_POSTAL_CODE1);

        assertEquals(1, PackageRepository.packageRepository.keySet().size());
        assertTrue(PackageRepository.packageRepository.containsKey(VALID_POSTAL_CODE1));
        assertEquals(2, PackageRepository.packageRepository.get(VALID_POSTAL_CODE1).size());
        assertTrue(PackageRepository.packageRepository.get(VALID_POSTAL_CODE1).contains(VALID_WEIGHT1));
        assertTrue(PackageRepository.packageRepository.get(VALID_POSTAL_CODE1).contains(VALID_WEIGHT2));
    }

    @Test
    void should_save_two_packages_with_different_postal_code() {
        ConsoleInputProcessor.processInputLine(VALID_WEIGHT1 + VALID_DELIMITER + VALID_POSTAL_CODE1);
        ConsoleInputProcessor.processInputLine(VALID_WEIGHT2 + VALID_DELIMITER + VALID_POSTAL_CODE2);

        assertEquals(2, PackageRepository.packageRepository.keySet().size());
        assertTrue(PackageRepository.packageRepository.containsKey(VALID_POSTAL_CODE1));
        assertEquals(1, PackageRepository.packageRepository.get(VALID_POSTAL_CODE1).size());
        assertTrue(PackageRepository.packageRepository.get(VALID_POSTAL_CODE1).contains(VALID_WEIGHT1));
        assertTrue(PackageRepository.packageRepository.get(VALID_POSTAL_CODE2).contains(VALID_WEIGHT2));
    }

    @Test
    void should_not_save_incorrect_weight_input() {
        ConsoleInputProcessor.processInputLine(INVALID_WEIGHT + VALID_DELIMITER + VALID_POSTAL_CODE1);

        assertEquals(0, PackageRepository.packageRepository.keySet().size());
    }

    @Test
    void should_not_save_incorrect_postal_code_input() {
        ConsoleInputProcessor.processInputLine(VALID_WEIGHT1 + VALID_DELIMITER + INVALID_POSTAL_CODE);

        assertEquals(0, PackageRepository.packageRepository.keySet().size());
    }
}