package org.example.Interpolation.initializingXandY;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Vladislav Osada
 * @date 12.05.2023 0:14
 */
public class InitArrayY {
    public static void fillArrayY(double[] y) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значения для массива y:");

        for (int i = 0; i < y.length; i++) {
            System.out.print("y[" + i + "]: ");
            y[i] = scanner.nextDouble();
        }
    }

    public static double[] fillArrayYFromFile(String filePath) {
        double[] y = new double[5];

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            System.out.println("Чтение данных из файла " + filePath + " для заполнения массива y:");

            int i = 0;
            while (scanner.hasNextLine() && i < y.length) {
                y[i] = Double.parseDouble(scanner.nextLine());
                System.out.println("y[" + i + "]: " + y[i]);
                i++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + filePath + " не найден.");
        }

        return y;
    }
}
