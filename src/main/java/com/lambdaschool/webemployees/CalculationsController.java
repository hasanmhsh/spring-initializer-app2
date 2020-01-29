package com.lambdaschool.webemployees;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/calc")
public class CalculationsController {
    // localhost:port/calc/salary/1/0.05
    // localhost:port/calc/salary/2/0.03

    //This method simulates a raise in salary for certain employee by GETting its id and the ration of raise
    //path variables is matched by the spelling of params in both annotation and param list , and order doesn't matter
    @GetMapping(value = "/salary/{id}/{ratio}",produces = {"application/json"})
    public ResponseEntity<?> checkRaise(@PathVariable long id, @PathVariable double ratio){
        Employee e = new Employee(WebemployeesApplication.ourEmpList.findEmployee(emp->emp.getId()==id));
        e.setSalary(e.getSalary() + (e.getSalary() * ratio) );
        return new ResponseEntity<Employee>(e, HttpStatus.OK);
    }
}
