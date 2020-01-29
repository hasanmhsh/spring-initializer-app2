package com.lambdaschool.webemployees;

import java.util.ArrayList;

public class EmpList {
    public ArrayList<Employee> empList = new ArrayList<Employee>();

    public EmpList(){
        empList.add(new Employee("hasan1","mohamed1",100,false,1,1));
        empList.add(new Employee("ahmed1","ali1",200,false,1,1));
        empList.add(new Employee("karim1","saad1",300,false,1,1));
        empList.add(new Employee("Hasan2","mohamed2",100,false,1,1));
        empList.add(new Employee("Ahmed2","ali2",200,false,1,1));
        empList.add(new Employee("Karim2","saad2",300,false,1,1));
        empList.add(new Employee("hasan3","mohamed3",100,false,1,1));
        empList.add(new Employee("ahmed3","ali3",200,false,1,1));
        empList.add(new Employee("karim3","saad3",300,false,1,1));
        empList.add(new Employee("hasan4","mohamed4",100,false,1,1));
        empList.add(new Employee("ahmed4","ali4",200,false,1,1));
        empList.add(new Employee("karim4","saad4",300,false,1,1));
        empList.add(new Employee("hasan5","mohamed5",100,false,1,1));
        empList.add(new Employee("ahmed5","ali5",200,false,1,1));
        empList.add(new Employee("karim5","saad5",300,false,1,1));
    }

    public Employee findEmployee(CheckEmployee tester){
        for(Employee e : empList){
            if(tester.test(e))
                return e;
        }
        return null;
    }

    public ArrayList<Employee> findEmployees(CheckEmployee tester){
        ArrayList<Employee> employees = new ArrayList<>();
        empList.forEach(e->{
            if(tester.test(e))
                employees.add(e);
        });
        employees.sort((e1,e2)->e1.getFname().compareToIgnoreCase(e2.getFname()));
        return employees;
    }
}
