package org.example.CauchyProblem;

import java.util.List;

/**
 * @author Vladislav Osada
 * @date 18.05.2023 23:58
 */
public class ErrorMethods {

    public static double estimateErrorRungeRomberg(List<Double> solution, double h) {
        int n = solution.size();

        double error = 0.0;
        for (int i = 0; i < n - 1; i++) {
            double y1 = solution.get(i);
            double y2 = solution.get(i + 1);
            double exactValue = (y2 - y1) / (h);

            error += Math.pow(exactValue - y2, 2);
        }

        return Math.sqrt(error);
    }
}
