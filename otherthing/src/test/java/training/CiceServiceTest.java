package training;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CiceServiceTest {

    private CiceService service;

    @BeforeEach
    void setup() {
        service = new CiceService();
    }

    @Test
    void compute() {
        // Arrange
        final Employee intern = new Employee();
        intern.setIntern(true);
        intern.setEarnings(new ArrayList<>());
        intern.getEarnings().add(new Earning("500", EarningType.BONUS));

        final Employee employee = new Employee();
        employee.setIntern(false);
        employee.setEarnings(new ArrayList<>());
        employee.getEarnings().add(new Earning("2000", EarningType.SALARY));
        employee.getEarnings().add(new Earning("100", EarningType.BONUS));
        employee.getEarnings().add(new Earning("100", EarningType.VOUCHERS));

        final Employee manager = new Employee();
        manager.setIntern(false);
        manager.setEarnings(new ArrayList<>());
        manager.getEarnings().add(new Earning("3000", EarningType.SALARY));
        manager.getEarnings().add(new Earning("1000", EarningType.BONUS));

        final List<Employee> employees = List.of(intern, employee, manager);
        // Act
        final BigDecimal cice = service.compute(employees);
        // Assert
        assertEquals(new BigDecimal("126"), cice);
    }

}
