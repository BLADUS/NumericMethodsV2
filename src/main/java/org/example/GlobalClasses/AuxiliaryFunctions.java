package org.example.GlobalClasses;

import java.util.List;
import java.util.Scanner;


/**
 * @author Vladislav Osada
 * @date 05.05.2023 20:45
 */
public class AuxiliaryFunctions {
    public static double inputDouble(String text) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(text);
        while (!scanner.hasNextDouble()) {
            System.out.println("Ошибка: введите корректное значение");
            scanner.next(); // Очищаем некорректный ввод
        }
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

    // Вспомогательный метод для преобразования List<Double> в double[]
    public static double[] toArray(List<Double> list) {
        if (list == null) {
            return new double[0]; // Возвращаем пустой массив, если список равен null
        }

        double[] array = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
