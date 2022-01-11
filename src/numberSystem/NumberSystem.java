package numberSystem;

import java.util.Arrays;

public class NumberSystem {
    private String number;
    private Numeral numeral;
    private int discharge;

    NumberSystem(String number) {
        if (number.matches(Numeral.DECIMAL.getMatch())) {
            numeral = Numeral.DECIMAL;
            this.number = number;
        } else if (number.matches(Numeral.BINARY.getMatch())) {
            numeral = Numeral.BINARY;
            this.number = number.substring(2);
        }
        if (numeral != null) {
            discharge = this.number.length() - 1;
            return;
        }
        throw new RuntimeException("can not cast");
    }

    public String convertInto(Numeral n) {
        if (n != numeral) {
            if (n == Numeral.DECIMAL) {
                number = String.valueOf(
                        Arrays.stream(number.split(""))
                                .mapToInt(Integer::parseInt)// [1, 0]
                                .map(v -> v * (int) Math.pow(2, discharge--))
                                .sum());
            } else if (n == Numeral.BINARY) {
                StringBuilder res = new StringBuilder();
                int num = Integer.parseInt(number);
                while (num != 1) {
                    res.append(num % 2);
                    num = num / 2;
                }
                number = res.append(num).reverse().toString();
            }
        }
        return n.getDefining() + number;
    }

    public Numeral getNumeral() {
        return numeral;
    }

    public String getNumber() {
        return number;
    }
}
