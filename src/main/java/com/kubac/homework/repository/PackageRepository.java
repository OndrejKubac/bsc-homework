package com.kubac.homework.repository;

import java.math.BigDecimal;
import java.util.*;

import static java.util.Collections.synchronizedMap;

public class PackageRepository {

    public static final Map<Integer, List<BigDecimal>> packageRepository = synchronizedMap(new HashMap<>());

    public static void savePackage(Integer postalCode, BigDecimal weight) {
        packageRepository.computeIfAbsent(postalCode, item -> new ArrayList<>()).add(weight);
    }

    public static Set<Integer> getAllPostalCodes() {
        return packageRepository.keySet();
    }

    public static BigDecimal getWeightForPostalCode(Integer postalCode) {

        return packageRepository.get(postalCode).stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
