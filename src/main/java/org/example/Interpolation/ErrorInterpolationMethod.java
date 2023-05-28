package org.example.Interpolation;

import static org.example.Interpolation.InterpolationMethod.interpolate;

/**
 * @author Vladislav Osada
 * @date 23.05.2023 17:28
 */
public class ErrorInterpolationMethod {
    public static void computeErrors(double x0, double[] x, double[] y) {
        for (int degree = 1; degree <= 4; degree++) {
            double interpolatedValue = interpolate(x0, x, y, degree);
            double trueValue = computeTrueValue(x0, x, y); // Вычисляем истинное значение

            double error = Math.abs(interpolatedValue - trueValue);
            System.out.println("Степень " + degree + ": Погрешность = " + error);
        }
    }
    public static double computeTrueValue(double x0, double[] x, double[] y) {
        int index = findNearestIndex(x0, x); // Находим индекс ближайшего значения аргумента в массиве x
        return y[index]; // Возвращаем истинное значение функции для найденного индекса
    }


    /*    нахождение индекса ближайшего значения в массиве x к заданному значению x0.*/
    public static int findNearestIndex(double x0, double[] x) {
        int index = 0;
        double minDiff = Math.abs(x0 - x[0]);

        for (int i = 1; i < x.length; i++) {
            double diff = Math.abs(x0 - x[i]);
            if (diff < minDiff) {
                minDiff = diff;
                index = i;
            }
        }

        return index;
    }
}
