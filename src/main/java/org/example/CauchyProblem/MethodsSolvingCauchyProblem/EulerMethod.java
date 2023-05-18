package org.example.CauchyProblem.MethodsSolvingCauchyProblem;

import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.DoubleBinaryOperator;

import static org.example.CauchyProblem.FunctionTwoVariables.*;

/**
 * @author Vladislav Osada
 * @date 18.05.2023 22:20
 */
public class EulerMethod {

    // Метод Эйлера
    public static List<Double> euler(String functionString, double[] limits, double h) throws ScriptException {
        List<Double> yValues = new ArrayList<>();
        double x0 = limits[0];
        double xLast = limits[1];

        double y0 = writeY(x0);

        yValues.add(y0);

        DoubleBinaryOperator function = createFunction(functionString);

        int n = (int) Math.round((xLast - x0) / h);

        for (int i = 0; i < n; i++) {
            double f = evaluateFunctionTwoVariables(functionString, x0, y0);
            y0 = y0 + h * f;
            x0 = x0 + h;

            System.out.println("Step " + (i + 1) + ": x = " + x0 + ", y = " + y0);

            yValues.add(y0);
        }

        return yValues;
    }

}
