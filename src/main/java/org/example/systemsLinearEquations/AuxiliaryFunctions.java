package org.example.systemsLinearEquations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Vladislav Osada
 * @date 10.05.2023 3:14
 */
public class AuxiliaryFunctions {
    public static LinearSystem readSystemFromFile(String filePath) {
        File file = new File(filePath);
        try {
            Scanner scanner = new Scanner(file);

            // Чтение размера системы
            int size = scanner.nextInt();
            scanner.nextLine(); // Чтение символа новой строки после ввода числа

            // Инициализация массивов коэффициентов и правой части
            double[][] coefficients = new double[size][size];
            double[] rightHandSide = new double[size];

            // Чтение коэффициентов матрицы A и значений правой части
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    coefficients[i][j] = scanner.nextDouble();
                }
                rightHandSide[i] = scanner.nextDouble();
                scanner.nextLine(); // Чтение символа новой строки после ввода числа
            }

            // Создание объекта LinearSystem
            return new LinearSystem(coefficients, rightHandSide);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
