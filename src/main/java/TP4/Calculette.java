package TP4;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Calculette utilisant une pile de nombres flottants.
 */
public class Calculette {
    private final Deque<Double> pile = new ArrayDeque<>();

    public void empiler(double valeur) {
        pile.push(valeur);
    }

    public double depiler() {
        if (pile.isEmpty()) {
            throw new IllegalStateException("La pile est vide");
        }
        return pile.pop();
    }

    public void addition() {
        double droite = depiler();
        double gauche = depiler();
        empiler(gauche + droite);
    }

    public void soustraction() {
        double droite = depiler();
        double gauche = depiler();
        empiler(gauche - droite);
    }

    public void multiplication() {
        double droite = depiler();
        double gauche = depiler();
        empiler(gauche * droite);
    }

    public void division() {
        double droite = depiler();
        double gauche = depiler();
        if (droite == 0.0) {
            throw new ArithmeticException("Division par zero");
        }
        empiler(gauche / droite);
    }

    public double calculer(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException("L'expression est vide");
        }

        pile.clear();
        for (String element : expression.trim().split("\\s+")) {
            switch (element) {
                case "+" -> addition();
                case "-" -> soustraction();
                case "*" -> multiplication();
                case "/" -> division();
                default -> empiler(lireNombre(element));
            }
        }

        if (pile.size() != 1) {
            throw new IllegalArgumentException(
                    "Expression NPI invalide : il doit rester un seul resultat");
        }
        return depiler();
    }

    private double lireNombre(String element) {
        try {
            return Double.parseDouble(element);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Element invalide : " + element, exception);
        }
    }
}