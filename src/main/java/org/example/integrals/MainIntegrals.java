package org.example.integrals;
import java.util.Scanner;
import static org.example.AuxiliaryFunctions.setLimits;
import static org.example.equations.Function.writeFunction;


/**
 * @author Vladislav Osada
 * @date 10.05.2023 3:05
 */
public class MainIntegrals {
    static String functionString = writeFunction();
    static double x;
    final double NumberOfPartitions = 20;
    private static final double[] limits = setLimits();

    public static void mainMenu() {
        int point = pointList();

        double EPS;
        switch (point) {
            case 0: {
                return;
            }
            case 1: {

                break;
            }
        }
        mainMenu();
    }

    public static int pointList() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите пункт меню: ");
        System.out.println("0.Выйти");
        System.out.println("1.Вычислить интеграл методом трапеций");
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        mainMenu();
    }
}
