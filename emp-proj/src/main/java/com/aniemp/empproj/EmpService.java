package com.aniemp.empproj;

import java.util.List;

public interface EmpService {
    boolean createEmp(Employee employee);
    List<Employee> readEmp();
    Employee readEmp(Long id);
    boolean deleteEmp(Long id);
    String updateEmp(Long id, Employee employee);
}
