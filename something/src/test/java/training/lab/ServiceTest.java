package training.lab;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static training.lab.IndividualType.ADULT;
import static training.lab.IndividualType.CHILD;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ServiceTest {

    private Service service;

    @BeforeEach
    void setup() {
        service = new Service();
    }

    @Test
    void computeForSingle() {
        // Arrange
        final Household household = new Household();
        household.add(new Individual(ADULT, new BigDecimal("32000")));
        // Act
        final BigDecimal tax = this.service.compute(household);
        // Assert
        assertEquals(0, new BigDecimal("3893.26").compareTo(tax));
    }

    @Test
    void computeForCoupleAndTwoChildren() {
        // Arrange
        final Household household = new Household();
        household.add(new Individual(ADULT, new BigDecimal("32000")));
        household.add(new Individual(ADULT, new BigDecimal("23950")));
        household.add(new Individual(CHILD, null));
        household.add(new Individual(CHILD, null));
        // Act
        final BigDecimal tax = this.service.compute(household);
        // Assert
        assertEquals(0, new BigDecimal("3714.06").compareTo(tax));
    }

}
