package training;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CiceServiceTest {

    private final CiceService service = new CiceService();

    @Test
    public void compute() {
        final List<Employee> employees = new ArrayList<>();
        final Employee intern = new Employee();
        intern.setIntern(true);
        intern.setEarnings(new ArrayList<>());
        intern.getEarnings().add(new Earning("500", EarningType.BONUS));
        employees.add(intern);
        final Employee employee = new Employee();
        employee.setIntern(false);
        employee.setEarnings(new ArrayList<>());
        employee.getEarnings().add(new Earning("2000", EarningType.SALARY));
        employee.getEarnings().add(new Earning("100", EarningType.BONUS));
        employee.getEarnings().add(new Earning("100", EarningType.VOUCHERS));
        employees.add(employee);
        final Employee manager = new Employee();
        manager.setIntern(false);
        manager.setEarnings(new ArrayList<>());
        manager.getEarnings().add(new Earning("3000", EarningType.SALARY));
        manager.getEarnings().add(new Earning("1000", EarningType.BONUS));
        employees.add(manager);
        assertEquals(new BigDecimal("126"), this.service.compute(employees));
    }
}
