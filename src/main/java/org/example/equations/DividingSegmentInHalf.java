package org.example.equations;

import javax.script.ScriptException;

import static org.example.equations.AuxiliaryFunctions.*;

/**
 * @author Vladislav Osada
 * @date 05.05.2023 20:29
 */
public class DividingSegmentInHalf {
    private static final double EPS = writeEPS();
    private final static String functionString = AuxiliaryFunctions.writeFunction();

    public static double bisection(String functionString) throws ScriptException {
        double leftBoundary = inputDouble("Введите первую границу: ");
        double rightBoundary = inputDouble("Введите первую границу: ");

        double valueLeftBoundFunction = evaluate(functionString, leftBoundary);
        double valueRightBoundFunction = evaluate(functionString, rightBoundary);

        if (valueLeftBoundFunction * valueRightBoundFunction > 0) {
            System.out.println("На заданном интервале нет корней!");
            bisection(functionString);
        }

        double x0 = (leftBoundary + rightBoundary) / 2;
        while (Math.abs(rightBoundary - leftBoundary) >= EPS) {
            double valueX0Function = evaluate(functionString, leftBoundary);
            if (valueRightBoundFunction * valueX0Function >= EPS) {
                rightBoundary = x0;
            } else {
                leftBoundary = x0;
            }
            x0 = (leftBoundary + rightBoundary) / 2;
        }
        return x0;
    }

    private static double writeEPS() {
        return inputDouble("Введите точность: ");
    }

}
