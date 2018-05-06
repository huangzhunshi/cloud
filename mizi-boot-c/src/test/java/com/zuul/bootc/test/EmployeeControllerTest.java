package com.zuul.bootc.test;


import com.zuul.bootc.powermock.Employee;
import com.zuul.bootc.powermock.EmployeeController;
import com.zuul.bootc.powermock.EmployeeService;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.assertEquals;

/**
 * powermock 测试demo类
 */
public class EmployeeControllerTest {
    @Test
    public void shouldReturnProjectedCountOfEmployeesFromTheService() {

        EmployeeService mock = PowerMockito.mock(EmployeeService.class);
        PowerMockito.when(mock.getEmployeeCount()).thenReturn(8);
        EmployeeController employeeController = new EmployeeController(mock);
        assertEquals(10, employeeController.getProjectedEmployeeCount());
    }

    @Test
    public void shouldInvokeSaveEmployeeOnTheServiceWhileSavingTheEmployee() {

        EmployeeService mock = PowerMockito.mock(EmployeeService.class);
        EmployeeController employeeController = new EmployeeController(mock);
        Employee employee = new Employee();
        employeeController.saveEmployee(employee);
        Mockito.verify(mock).saveEmployee(employee);
    }
}
