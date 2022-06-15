package training;

import java.math.BigDecimal;
import java.util.List;

public class CiceService {
    private static final BigDecimal MIN_WAGE = new BigDecimal("1014.00");
    BigDecimal incomeSuperior = new BigDecimal("2.5").multiply(MIN_WAGE);

    public BigDecimal compute(final List<Employee> employees) {
        BigDecimal basis = BigDecimal.ZERO;
        for (final Employee employee : employees) {
            if (employee.getIntern().equals(false)) {
                BigDecimal income = BigDecimal.ZERO;
                BigDecimal earnings = BigDecimal.ZERO;
                for (final Earning earning : employee.getEarnings()) {
                    if ((earning.getType() == EarningType.SALARY ||
                            earning.getType() == EarningType.OVERTIME ||
                            earning.getType() == EarningType.BONUS ||
                            earning.getType() == EarningType.VACATION_PAY)) {
                        earnings = earnings.add(earning.getAmount());
                    }
                }

                income = earnings;
                if (income.compareTo(incomeSuperior) < 0) {
                    basis = basis.add(income);
                }
            }
        }
        BigDecimal cice = basis.multiply(new BigDecimal("0.06"));
        return cice.stripTrailingZeros();
    }
}