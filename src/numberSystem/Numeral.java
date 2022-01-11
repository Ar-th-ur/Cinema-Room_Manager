package numberSystem;

enum Numeral {
    DECIMAL("^-?[0-9]+$", 2, ""),
    BINARY("^0b[10]+$", 2, "0b");

    private final String match;
    private final String defining;
    private final int pow;

    Numeral(String match, int pow, String defining) {
        this.match = match;
        this.defining = defining;
        this.pow = pow;
    }

    public String getMatch() {
        return match;
    }

    public int getPow() {
        return pow;
    }

    public String getDefining() {
        return defining;
    }
}
