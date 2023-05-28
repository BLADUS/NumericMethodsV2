package org.example.CauchyProblem.MethodsSolvingCauchyProblem;

import javax.script.ScriptException;
import java.util.*;

import static org.example.CauchyProblem.FunctionTwoVariables.evaluateFunctionTwoVariables;
import static org.example.CauchyProblem.FunctionTwoVariables.writeY;

/**
 * @author Vladislav Osada
 * @date 18.05.2023 23:47
 */
public class RungeKutta4Method {
    // Метод Рунге-Кутты 4-го порядка
    public static Map<String, List<Double>> rungeKutta4(String functionString, double[] limits, double h, double y0) throws ScriptException {
        List<Double> x1 = new ArrayList<>();
        List<Double> y1 = new ArrayList<>();

        double x0 = limits[0];
        double xLast = limits[1];

        x1.add(x0);
        y1.add(y0);

        int n = (int) Math.round((xLast - x0) / h);

        for (int i = 0; i < n; i++) {
            double k1 = evaluateFunctionTwoVariables(functionString, x0, y0);
            double k2 = evaluateFunctionTwoVariables(functionString, x0 + h / 2.0, y0 + h / 2.0 * k1);
            double k3 = evaluateFunctionTwoVariables(functionString, x0 + h / 2.0, y0 + h / 2.0 * k2);
            double k4 = evaluateFunctionTwoVariables(functionString, x0 + h, y0 + h * k3);

            double yNext = y0 + h / 6.0 * (k1 + 2 * k2 + 2 * k3 + k4);
            x0 = x0 + h;
            y0 = yNext;

            x1.add(x0);
            y1.add(y0);
        }

        Map<String, List<Double>> result = new HashMap<>();
        result.put("x1", x1);
        result.put("y1", y1);

        return result;
    }
}
