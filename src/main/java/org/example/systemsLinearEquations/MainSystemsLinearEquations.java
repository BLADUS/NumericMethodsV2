package org.example.systemsLinearEquations;
import org.example.systemsLinearEquations.MethodsSolvingSystem.GaussMethod;
import java.util.Scanner;

import static org.example.AuxiliaryFunctions.*;
import static org.example.systemsLinearEquations.MethodsSolvingSystem.SeidelMethod.seidel;

/**
 * @author Vladislav Osada
 * @date 10.05.2023 3:05
 */
public class MainSystemsLinearEquations {
    private static LinearSystem system = readSystemFromManualInput();

    public static void mainMenu() {
        int point = pointList();

        double EPS;
        switch (point) {
            case 0: {
                return;
            }
            case 1: {
                system = readSystemFromManualInput();
                break;
            }
            case 2: {
                printSystemEquations(system);
                break;
            }
            case 3: {
                if (system != null) {
                    double[] gaussSolution = GaussMethod.solve(system);

                    // Вывод результатов
                    System.out.println("Решение с помощью метода Гаусса:");
                    for (int i = 0; i < gaussSolution.length; i++) {
                        System.out.printf("x%d = %.2f%n", i + 1, gaussSolution[i]);
                    }
                }
            }
            case 4:{
                EPS = writeEPS();

                double[] solution = seidel(system, EPS);

                // Вывод результатов
                System.out.println("Решение с помощью метода Зейделя:");
                for (int i = 0; i < solution.length; i++) {
                    System.out.printf("x%d = %.2f%n", i + 1, solution[i]);
                }
            }
        }
        mainMenu();
    }

    public static int pointList() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите пункт меню: ");
        System.out.println("0.Выйти");
        System.out.println("1.Записать новую систему");
        System.out.println("2.Вывести систему");
        System.out.println("3.Решить систему методом Гаусса");
        System.out.println("4.Решить систему методом Зейделя");

        return scanner.nextInt();
    }

    public static void main(String[] args) {
        mainMenu();
    }
}
