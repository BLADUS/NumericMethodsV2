package org.example.Interpolation;

/**
 * @author Vladislav Osada
 * @date 23.05.2023 17:18
 */
public class InterpolationMethod {
    public static void interpolateAndPrint(double x0, double[] x, double[] y) {
        for (int degree = 1; degree <= 4; degree++) {
            double result = interpolate(x0, x, y, degree);
            System.out.println("Степень " + degree + ": " + result);
        }
    }

    public static double interpolate(double x0, double[] x, double[] y, int degree) {
        int n = degree + 1;
        int[] indices = getIndices(x, x0, n);
        double[] xSubset = getSubset(x, indices);
        double[] ySubset = getSubset(y, indices);
        return computeInterpolation(x0, xSubset, ySubset, degree);
    }

    private static int[] getIndices(double[] x, double x0, int n) {
        int[] indices = new int[n];
        int closestIndex = findClosestIndex(x, x0);
        int startIndex = Math.max(0, closestIndex - n / 2);
        for (int i = 0; i < n; i++) {
            indices[i] = startIndex + i;
        }
        return indices;
    }

    private static int findClosestIndex(double[] x, double x0) {
        int closestIndex = 0;
        double closestDistance = Math.abs(x[0] - x0);
        for (int i = 1; i < x.length; i++) {
            double distance = Math.abs(x[i] - x0);
            if (distance < closestDistance) {
                closestIndex = i;
                closestDistance = distance;
            }
        }
        return closestIndex;
    }

    private static double[] getSubset(double[] arr, int[] indices) {
        double[] subset = new double[indices.length];
        for (int i = 0; i < indices.length; i++) {
            subset[i] = arr[indices[i]];
        }
        return subset;
    }

    private static double computeInterpolation(double x0, double[] x, double[] y, int degree) {
        double result = 0.0;
        for (int i = 0; i <= degree; i++) {
            double term = y[i];
            for (int j = 0; j <= degree; j++) {
                if (j != i) {
                    term *= (x0 - x[j]) / (x[i] - x[j]);
                }
            }
            result += term;
        }
        return result;
    }
}
