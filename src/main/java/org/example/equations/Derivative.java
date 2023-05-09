package org.example.equations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vladislav Osada
 * @date 09.05.2023 16:38
 */
public class Derivative {
    //Получаем список наших коэфицентов
    public static List<Double> getCoefficients(String polynomial) {
        List<Double> coefficients = new ArrayList<>();

        String[] terms = polynomial.split("\\s*([+-])\\s*"); // Разделяем многочлен на термы с использованием "+" и "-"
        for (String term : terms) {
            double coefficient;
            if (term.contains("x^")) {
                coefficient = extractCoefficient(term);
                coefficients.add(coefficient);
            }
        }

        return coefficients;
    }

    private static double extractCoefficient(String term) {
        if (term.contains("x")) {
            if (term.contains("*")) {
                String[] parts = term.split("\\*\\s*x");
                String coefficientString = parts[0].trim();
                if (coefficientString.isEmpty()) {
                    return 1.0;
                } else {
                    return Double.parseDouble(coefficientString);
                }
            } else {
                return 1.0;
            }
        } else {
            return 0.0;
        }
    }

    private static double extractConstant(String term) {
        if (term.contains("x")) {
            return 0.0;
        } else {
            return Double.parseDouble(term.trim());
        }
    }

    private static List<Integer> getDegrees(String polynomial) {
        List<Integer> degrees = new ArrayList<>();

        String[] terms = polynomial.split("\\s*([+-])\\s*");
        for (String term : terms) {
            if (term.contains("x^")) {
                int startIndex = term.indexOf("^") + 1;
                int endIndex = term.length();
                String degreeString = term.substring(startIndex, endIndex);
                int degree = Integer.parseInt(degreeString.trim());
                degrees.add(degree);
            } else if (term.contains("x")) {
                degrees.add(1);
            }
        }

        return degrees;
    }

    public static List<Character> getOperationSigns(String inputString) {
        List<Character> operationSigns = new ArrayList<>();

        int length = inputString.length();
        for (int i = 0; i < length; i++) {
            char currentChar = inputString.charAt(i);
            if (isOperationSign(currentChar)) {
                if (i < length - 1) {
                    operationSigns.add(currentChar);
                }
            } else if (currentChar == 'x' && i > 0) {
                char previousChar = inputString.charAt(i - 1);
                if (previousChar == '+' || previousChar == '-') {
                    operationSigns.add(previousChar);
                }
            } else if (currentChar == '^' || currentChar == '*') {
                operationSigns.add(currentChar);
            }
        }
        operationSigns.remove(operationSigns.size() - 1);
        return operationSigns;
    }

    private static boolean isOperationSign(char c) {
        return c == '+' || c == '-' || c == '*' || c == '^';
    }

    public static String takeDerivative(String functionString) {
        List<Double> coefficients = getCoefficients(functionString);
        List<Integer> degrees = getDegrees(functionString);
        List<Character> operationSigns = getOperationSigns(functionString);

        StringBuilder derivativeString = new StringBuilder();

        for (int i = 0; i < coefficients.size(); i++) {
            double coefficient = coefficients.get(i);
            int degree = degrees.get(i);

            if (coefficient != 0) {
                if (derivativeString.length() > 0) {
                    derivativeString.append(operationSigns.get(i));
                }

                double derivativeCoefficient = coefficient * degree;
                int derivativeDegree = degree - 1;

                derivativeString.append(derivativeCoefficient);

                if (derivativeDegree != 0) {
                    derivativeString.append("*x");

                    if (derivativeDegree != 1) {
                        derivativeString.append("^").append(derivativeDegree);
                    }
                }
            }
        }

        return derivativeString.toString();
    }
}
