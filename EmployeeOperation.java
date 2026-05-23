import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class EmployeeOperation {

    public static void main(String[] args) {

        List<Employee> empList = Arrays.asList(
                new Employee(1, "Sonu", "IT", 100000),
                new Employee(5, "Fam", "IT", 900000),
                new Employee(2, "Aman", "CE", 25000),
                new Employee(6, "Dolly", "CE", 35000),
                new Employee(3, "Alok", "IT", 4500),
                new Employee(4, "Naina", "ASO", 600000)
        );

        //Sort Employee List using Comparator & Streams
        empList.stream().map(Employee::getSalary)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        //Find Top 3 Highest Salaries from Employee List
        empList.stream().map(Employee::getSalary)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(System.out::println);

        //Find Top 3 Highest Salaries from Employee List  ------another way sorted()
        empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(3)
                .forEach(System.out::println);

        //Group Employees by Department using Streams
        Map<String,List<Employee>> mapEmp= empList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        mapEmp.forEach((k,v)->{
            System.out.println("Group Employees by Department using Streams");
            System.out.println(k + " " + v);
        });

        //Convert List<Employee> to Map<id, Employee>
        Map<Integer, Employee> mapEmpById= empList.stream()
                .collect(Collectors.toMap(Employee::getId,emp->emp));
        System.out.println("Convert List<Employee> to Map<id, Employee> is : " + mapEmpById);

        //OR by function.identity()
        Map<Integer, Employee> mapEmpByIdFunc= empList.stream()
                .collect(Collectors.toMap(Employee::getId, Function.identity()));
        System.out.println("Convert List<Employee> to Map<id, Employee> by function.identity() is : " + mapEmpByIdFunc);

        //Group Employees by Department and Count
        Map<String,Long> mapEmpCountByDepartment = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        System.out.println("Group Employees by Department and Count is : " + mapEmpCountByDepartment);

        //Group Employees by Department and Get Names
        Map<String, List<String>> grpByDeptAndGetName = empList.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName,Collectors.toList()))
                );
        System.out.println("Group Employees by Department and Count is : " + grpByDeptAndGetName);

        //Highest Salary by Department
        Map<String, Optional<Employee>> highestSalaryByDepartment = empList.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparing(Employee::getSalary)))
                );
        System.out.println("Highest Salary by Department is : " + highestSalaryByDepartment);
    }
}

//  Difference between groupingBy() and partitioningBy()
//  groupingBy	                partitioningBy
//  Multiple groups     	    Only 2 groups
//  Returns Map<K,List<V>>	    Returns Map<Boolean,List<V>>
