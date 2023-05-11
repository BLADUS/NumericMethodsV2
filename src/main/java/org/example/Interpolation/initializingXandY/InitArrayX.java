package org.example.Interpolation.initializingXandY;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Vladislav Osada
 * @date 12.05.2023 0:14
 */
public class InitArrayX {
    public static void fillArrayX(double[] x) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значения для массива x:");

        for (int i = 0; i < x.length; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = scanner.nextDouble();
        }
    }

    public static double[] fillArrayXFromFile(String filePath) {
        double[] x = new double[5];

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            System.out.println("Чтение данных из файла " + filePath.toString() + " для заполнения массива x:");

            int i = 0;
            while (scanner.hasNextLine() && i < x.length) {
                x[i] = Double.parseDouble(scanner.nextLine());
                System.out.println("x[" + i + "]: " + x[i]);
                i++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + filePath + " не найден.");
        }

        return x;
    }
}
