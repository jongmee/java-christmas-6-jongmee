package christmas.domain;

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

    @Override
    public String toString() {
        return name;
    }
}
