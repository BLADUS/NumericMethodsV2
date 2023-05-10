package org.example.systemsLinearEquations;
import org.example.systemsLinearEquations.MethodsSolvingSystem.GaussMethod;

import javax.script.ScriptException;
import java.util.Scanner;
import static org.example.systemsLinearEquations.AuxiliaryFunctions.readSystemFromFile;

/**
 * @author Vladislav Osada
 * @date 10.05.2023 3:05
 */
public class Main {
    private static  LinearSystem system = readSystemFromFile("D:\\ProgrammingProjects\\Java\\NumericMethodsV2\\src\\main\\java\\org\\example\\systemsLinearEquations\\system");
    public static void mainMenu() throws ScriptException {
        int point = pointList();

        double EPS;
        switch (point) {
            case 0: {
                return;
            }
            case 1:{
                // Решение с помощью метода Гаусса
                double[] gaussSolution = GaussMethod.solve(system);

                // Вывод результатов
                System.out.println("Решение с помощью метода Гаусса:");
                for (int i = 0; i < gaussSolution.length; i++) {
                    System.out.printf("x%d = %.2f%n", i + 1, gaussSolution[i]);
                }
            }
        }
        mainMenu();
    }

    public static int pointList() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите пункт меню: ");
        System.out.println("0.Выйти");
        System.out.println("1.Решить систему методом Гаусса");


        return scanner.nextInt();
    }

    public static void main(String[] args) throws ScriptException {
        mainMenu();
    }
}
