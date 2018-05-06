package com.zuul.bootc.test;


import com.zuul.bootc.powermock.Employee;
import com.zuul.bootc.powermock.EmployeeController;
import com.zuul.bootc.powermock.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertEquals;

/**
 * powermock 测试demo类
 */
public class EmployeeControllerTest {


    @Mock
    private EmployeeService employeeService;

    @Mock
    private EmployeeController employeeController;


    @Before
    public void setup() {
        //ReflectionTestUtils.setField(invoiceFacade, "invoiceAccessToken", "test");
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void hzTest(){
        PowerMockito.when(employeeController.getProjectedEmployeeCount()).thenReturn(10);
        System.out.println(employeeController.getProjectedEmployeeCount());


        PowerMockito.when(employeeService.getEmployeeCount()).thenReturn(10202);
        System.out.println(employeeService.getEmployeeCount());

        Mockito.verify(employeeService).getEmployeeCount();
       // Mockito.verify(employeeService,Mockito.times(1));
       // Mockito.verify(employeeService,Mockito.timeout(100));
    }

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
