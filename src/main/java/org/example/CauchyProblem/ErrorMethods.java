package org.example.CauchyProblem;


import javax.script.ScriptException;
import java.util.List;
import java.util.Map;

import static org.example.CauchyProblem.MethodsSolvingCauchyProblem.EulerMethod.euler;
import static org.example.CauchyProblem.MethodsSolvingCauchyProblem.ModifiedEulerMethod.modifiedEuler;
import static org.example.CauchyProblem.MethodsSolvingCauchyProblem.RungeKutta4Method.rungeKutta4;

/**
 * @author Vladislav Osada
 * @date 18.05.2023 23:58
 */
public class ErrorMethods {
    public static double calculateEulerError(String functionString, double[] limits, double h, double y0) throws ScriptException {
        double h2 = h / 2.0;

        Map<String, List<Double>> eulerResult1 = euler(functionString, limits, h, y0);
        Map<String, List<Double>> eulerResult2 = euler(functionString, limits, h2, y0);

        List<Double> y1_1 = eulerResult1.get("y1");
        List<Double> y1_2 = eulerResult2.get("y1");

        double exactSolution = y1_1.get(y1_1.size() - 1);
        double approximatedSolution1 = y1_1.get(y1_1.size() - 2);
        double approximatedSolution2 = y1_2.get(y1_2.size() - 2);

        return Math.abs(approximatedSolution1 - approximatedSolution2) / (Math.pow(2, 1) - 1);
    }

    public static double calculateModifiedEulerError(String functionString, double[] limits, double h, double y0) throws ScriptException {
        double h2 = h / 2.0;

        Map<String, List<Double>> modifiedEulerResult1 = modifiedEuler(functionString, limits, h, y0);
        Map<String, List<Double>> modifiedEulerResult2 = modifiedEuler(functionString, limits, h2, y0);

        List<Double> y1_1 = modifiedEulerResult1.get("y1");
        List<Double> y1_2 = modifiedEulerResult2.get("y1");

        double exactSolution = y1_1.get(y1_1.size() - 1);
        double approximatedSolution1 = y1_1.get(y1_1.size() - 2);
        double approximatedSolution2 = y1_2.get(y1_2.size() - 2);

        return Math.abs(approximatedSolution1 - approximatedSolution2) / (Math.pow(2, 1) - 1);
    }

    public static double calculateRungeKutta4Error(String functionString, double[] limits, double h, double y0) throws ScriptException {
        double h2 = h / 2.0;

        Map<String, List<Double>> rungeKutta4Result1 = rungeKutta4(functionString, limits, h, y0);
        Map<String, List<Double>> rungeKutta4Result2 = rungeKutta4(functionString, limits, h2, y0);

        List<Double> y1_1 = rungeKutta4Result1.get("y1");
        List<Double> y1_2 = rungeKutta4Result2.get("y1");

        double exactSolution = y1_1.get(y1_1.size() - 1);
        double approximatedSolution1 = y1_1.get(y1_1.size() - 2);
        double approximatedSolution2 = y1_2.get(y1_2.size() - 2);

        return Math.abs(approximatedSolution1 - approximatedSolution2) / (Math.pow(2, 1) - 1);
    }
}
