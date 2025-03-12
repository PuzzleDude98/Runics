package net.pd98.types.data_types;

import java.util.function.BiPredicate;
import java.util.Map;

public class Comparison {
    private static final Map<String, BiPredicate<Integer, Integer>> OPERATORS = Map.of(
            "==", (x, y) -> x == y,
            "!=", (x, y) -> x != y,
            ">", (x, y) -> x > y,
            "<", (x, y) -> x < y,
            ">=", (x, y) -> x >= y,
            "<=", (x, y) -> x <= y
    );

    private final String operator;
    private final BiPredicate<Integer, Integer> predicate;

    public Comparison(String operator) {
        if (!OPERATORS.containsKey(operator)) {
            throw new IllegalArgumentException("Invalid comparison operator: " + operator);
        }
        this.operator = operator;
        this.predicate = OPERATORS.get(operator);
    }

    public boolean evaluate(int a, int b) {
        return predicate.test(a, b);
    }

    public String getOperator() {
        return operator;
    }
}
