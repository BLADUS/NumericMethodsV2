package org.example;

import org.example.systemsLinearEquations.LinearSystem;

import javax.script.ScriptException;
import java.util.Scanner;

import static org.example.integrals.Function.evaluate;
import static org.example.integrals.MethodsCalculatingIntegrals.SimpsonMethod.integrateBySimpsonRule;
import static org.example.integrals.MethodsCalculatingIntegrals.TrapezoidMethod.integrateByTrapezoidRule;

/**
 * @author Vladislav Osada
 * @date 05.05.2023 20:45
 */
public class AuxiliaryFunctions {
    public static double inputDouble(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        return scanner.nextDouble();
    }

    public static double writeEPS() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите точность (EPS): ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Ошибка: введите корректное значение точности (EPS)!");
            scanner.next(); // Очищаем некорректный ввод
        }
        return scanner.nextDouble();
    }

    public static double[] setLimits() {
        double[] limits = new double[2];

        limits[0] = inputDouble("Введите левую границу");
        limits[1] = inputDouble("Введите правую границу");

        return limits;
    }

    public static double estimateErrorByRungeRuleTrapezoid(String functionString, double[] limits, int n) throws ScriptException {
        double a = limits[0];
        double b = limits[1];

        // Вычисляем интеграл с более грубым разбиением
        int nCoarse = n / 2;
        double integralCoarse = integrateByTrapezoidRule(functionString, limits, nCoarse);

        // Вычисляем интеграл с более точным разбиением
        double integralFine = integrateByTrapezoidRule(functionString, limits, n);

        // Оцениваем погрешность решения по правилу Рунге
        return Math.abs(integralFine - integralCoarse) / (Math.pow(2, 2) - 1);
    }

    public static double estimateErrorByRungeRuleSimpson(String functionString, double[] limits, int n) throws ScriptException {
        double a = limits[0];
        double b = limits[1];

        double h = (b - a) / n;
        double sum1 = 0;
        double sum2 = 0;

        for (int i = 1; i <= n / 2; i++) {
            double x = a + (2 * i - 1) * h;
            sum1 += evaluate(functionString, x);
        }

        for (int i = 1; i <= n / 2 - 1; i++) {
            double x = a + 2 * i * h;
            sum2 += evaluate(functionString, x);
        }

        double integral = (h / 3) * (evaluate(functionString, a) + evaluate(functionString, b) + 4 * sum1 + 2 * sum2);

        double h2 = h / 2;
        double sum1_2 = 0;
        double sum2_2 = 0;

        for (int i = 1; i <= n; i++) {
            double x = a + (i - 0.5) * h2;
            sum1_2 += evaluate(functionString, x);
        }

        for (int i = 1; i <= n - 1; i++) {
            double x = a + i * h2;
            sum2_2 += evaluate(functionString, x);
        }

        double integral2 = (h2 / 3) * (evaluate(functionString, a) + evaluate(functionString, b) + 4 * sum1_2 + 2 * sum2_2);

        double error = Math.abs((1 / 15.0) * (integral - integral2));

        return error;
    }
}
