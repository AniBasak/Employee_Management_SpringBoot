package com.aniemp.empproj;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
// import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class EmpServiceImpl implements EmpService {

    private final EmpRepository empRepository;

    //@Autowired
    public EmpServiceImpl(EmpRepository empRepository){
        this.empRepository = empRepository;
    };

    //List<Employee> allemp = new ArrayList<>();

    @Override
    public boolean createEmp(Employee employee) {
        EmpEntity empEntity = new EmpEntity();
        BeanUtils.copyProperties(employee, empEntity);
        //BeanUtils.copyProperties(employee, empEntity);
        empRepository.save(empEntity);
        // allemp.add(employee);
        return true;
    }

    @Override
    public List<Employee> readEmp() {
        List<EmpEntity> allemplList = empRepository.findAll();
        List<Employee> allemp = new ArrayList<>();

        for (EmpEntity empEntity : allemplList) {
            Employee emp = new Employee();
            emp.setId(empEntity.getId());
            emp.setName(empEntity.getName());
            emp.setPhone(empEntity.getPhone());
            emp.setEmail(empEntity.getEmail());
            allemp.add(emp);
        }
        return allemp;
    }

    @Override
    public boolean deleteEmp(Long id) {
        //allemp.remove(id);
        EmpEntity emp = empRepository.findById(id).get();
        empRepository.delete(emp);
        return true;
    }

    @Override
    public String updateEmp(Long id, Employee employee) {
        EmpEntity exempEntity = empRepository.findById(id).get();
        exempEntity.setName(employee.getName());
        exempEntity.setPhone(employee.getPhone());
        exempEntity.setEmail(employee.getEmail());
        empRepository.save(exempEntity);
        return "Updated Successfully";
    }

    @Override
    public Employee readEmp(Long id) {
        EmpEntity empEntity = empRepository.findById(id).get();
        Employee emp = new Employee();
        BeanUtils.copyProperties(empEntity, emp);
        return emp;   
    }

}
