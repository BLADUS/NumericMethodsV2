package org.example.equations;

import static org.example.equations.AuxiliaryFunctions.inputDouble;
import static org.example.equations.AuxiliaryFunctions.writeFunction;

/**
 * @author Vladislav Osada
 * @date 05.05.2023 20:29
 */
public class DividingSegmentInHalf {
    private final double EPS = writeEPS();
    private final static String functionString = AuxiliaryFunctions.writeFunction();
    public static void bisection() {
        double a = inputDouble("Введите первую границу: ");
        double b = inputDouble("Введите первую границу: ");
    }

    private double writeEPS() {
        return inputDouble("Введите точность: ");
    }

}
