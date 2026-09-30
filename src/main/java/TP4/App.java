package TP4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        try {
            String expression = args.length > 0
                    ? String.join(" ", Arrays.asList(args))
                    : new BufferedReader(new InputStreamReader(System.in)).readLine();
            System.out.println(new Calculette().calculer(expression));
        } catch (IOException | IllegalArgumentException | IllegalStateException | ArithmeticException exception) {
            System.out.println("Erreur : " + exception.getMessage());
        }
    }
}
