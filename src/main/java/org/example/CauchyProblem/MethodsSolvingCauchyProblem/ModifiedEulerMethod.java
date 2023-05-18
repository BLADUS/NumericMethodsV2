package org.example.CauchyProblem.MethodsSolvingCauchyProblem;

import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.CauchyProblem.FunctionTwoVariables.evaluateFunctionTwoVariables;
import static org.example.CauchyProblem.FunctionTwoVariables.writeY;

/**
 * @author Vladislav Osada
 * @date 18.05.2023 23:41
 */
public class ModifiedEulerMethod {
    // Модифицированный метод Эйлера
    public static List<Double> modifiedEuler(String functionString, double[] limits, double h) throws ScriptException {
        List<Double> yValues = new ArrayList<>();
        double x0 = limits[0];
        double xLast = limits[1];

        double y0 = writeY(x0);

        yValues.add(y0);

        int n = (int) Math.round((xLast - x0) / h);

        for (int i = 0; i < n; i++) {
            double f1 = evaluateFunctionTwoVariables(functionString, x0, y0);
            double xHalf = x0 + h / 2.0;
            double yHalf = y0 + h / 2.0 * f1;
            double f2 = evaluateFunctionTwoVariables(functionString, xHalf, yHalf);

            double yNext = y0 + h * f2;
            x0 = x0 + h;
            y0 = yNext;

            System.out.println("Step " + (i + 1) + ": x = " + x0 + ", y = " + y0);

            yValues.add(y0);
        }

        return yValues;
    }
}
