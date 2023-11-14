package christmas.domain;

import java.util.Arrays;
import java.util.Comparator;

public enum Badge {
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000);

    private String name;
    private int criterionAmount;

    Badge(String name, int criterionAmount) {
        this.name = name;
        this.criterionAmount = criterionAmount;
    }

    public static Badge findByTotalBenefitAmount(final int totalAmount) {
        return Arrays.stream(Badge.values())
            .filter(badge -> badge.criterionAmount <= totalAmount)
            .max(Comparator.comparingInt(badge -> badge.criterionAmount))
            .orElse(null);
    }

    @Override
    public String toString() {
        return name;
    }
}
