package org.example.equations;

import javax.script.*;
import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;

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
}
