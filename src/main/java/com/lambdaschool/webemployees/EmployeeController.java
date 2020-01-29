package com.lambdaschool.webemployees;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;

@RestController
@RequestMapping("/data")
public class EmployeeController {

    // localhost:port/data/allemployees
    @RequestMapping(value = "/allemployees",produces = {"application/json"})
    public ResponseEntity<?> getAllEmployees(){//? -> means that you dont know the type
        Collections.sort(WebemployeesApplication.ourEmpList.empList,(o1,o2)->{
            return o1.getFname().compareToIgnoreCase(o2.getFname());
        });

        return new ResponseEntity<>(WebemployeesApplication.ourEmpList.empList, HttpStatus.OK);
        /*
        result of response
        [{"id":2,"fname":"ahmed","lname":"ali","salary":200.0,"has401K":false,"companyID":1,"healthPlanID":1},{"id":1,"fname":"hasan","lname":"mohamed","salary":100.0,"has401K":false,"companyID":1,"healthPlanID":1},{"id":3,"fname":"karim","lname":"saad","salary":300.0,"has401K":false,"companyID":1,"healthPlanID":1}]

         */
    }


    // localhost:port/data/employee/2
    //GET employee by id
    @RequestMapping(value = "/employee/{id}", produces = {"application/json"})
    public ResponseEntity<?> getEmployeeById(@PathVariable long id){
        Employee e = WebemployeesApplication.ourEmpList.findEmployee(emp->emp.getId()==id);
        return new ResponseEntity<Employee>(e, HttpStatus.OK);
    }

    // localhost:port/data/employees/s   //end point to get all employees that fname starts with s
    @RequestMapping(value = "/employees/{str}", produces = {"application/json"})
    public ResponseEntity<?> getEmployeesWithMatchedFNameStrAtStart(@PathVariable String str){
        ArrayList<Employee> filteredEmpList = WebemployeesApplication.ourEmpList.findEmployees(e -> {
            return e.getFname().substring(0,str.length()).compareToIgnoreCase(str)==0;
        });
        return new ResponseEntity<>(filteredEmpList, HttpStatus.OK);
    }
}
