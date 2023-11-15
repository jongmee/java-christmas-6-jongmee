package christmas.domain;

import java.util.Arrays;
import java.util.Comparator;

public enum Badge {
    NONE("없음", 0),
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000);

    private String name;
    private int criterionAmount;

    Badge(final String name, final int criterionAmount) {
        this.name = name;
        this.criterionAmount = criterionAmount;
    }

    public static Badge findByTotalBenefitAmount(final int totalAmount) {
        return Arrays.stream(Badge.values())
            .filter(badge -> badge.criterionAmount <= totalAmount)
            .max(Comparator.comparingInt(badge -> badge.criterionAmount))
            .get();
    }

    @Override
    public String toString() {
        return name;
    }
}
