package training.lab;

import java.math.BigDecimal;

public class Service {
    public BigDecimal compute(final Household household) {
        // Expected behavior :
        // - 1 adult with 32000 revenues should pay 3893.26
        if (null != household.getIndividuals().get(0)) {
            BigDecimal totalIncome = household.getIndividuals().get(0).getRevenue();
            Integer familuQuotient = null;
            if (household.getIndividuals().get(0).getType() == IndividualType.ADULT) {
                familuQuotient = 1;
            }
        }
        // - 2 adults with 32000 + 23950 revenues and 2
        return null;
    }
}
