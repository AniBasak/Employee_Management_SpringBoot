package com.aniemp.empproj;

import org.springframework.web.bind.annotation.RestController;
import java.util.*;

// import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestParam;





@RestController
public class EmpController {
    
    //List<Employee> allemp = new ArrayList<>();
    // @Autowired
    // EmpService empService;

    private final EmpService empService;

    // @Autowired
    public EmpController(EmpService empService){
        this.empService = empService;
    }

    //EmpService empService = new EmpServiceImpl(null);
    
    @GetMapping("employee")
    public List<Employee> getMethodName() {
        return empService.readEmp();
    }

    @GetMapping("employee/{id}")
    public Employee getMethodName(@PathVariable Long id) {
        Employee emp = empService.readEmp(id);
        return emp;
    }
    
    
    @PostMapping("employee")
    public String postMethodName(@RequestBody Employee emp) {
        // emp.getName("Ani");
        // emp.getPhone("123");
        // emp.getEmail("ani@ani.com");
        if(empService.createEmp(emp))
            return "Created Successfully";
        return "Could not create";
    }
    
    @DeleteMapping("employee/{id}")
    public String deleteMethodName(@PathVariable Long id){
        if(empService.deleteEmp(id))
            return "Deleted Succesfully";
        return "Not Found";
    }

    @PutMapping("employee/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Employee emp) {        
        return empService.updateEmp(id, emp);
    }
}
