package SeconHighestSalary;

import java.awt.desktop.SystemSleepEvent;
import java.util.*;
import java.util.stream.Collectors;

public class SecondHighestSalary {

    public static void main(String[] args) {

        List<Employee> empList = List.of(
                new Employee(1, "Sonu", 3000L),
                new Employee(2, "Aman", 60000L),
                new Employee(3, "Alok", 3000L),
                new Employee(4, "Ram", 80000L),
                new Employee(5, "Harry", 23400L));

        findHighestSalaryUsingStreamAPI(empList);
        findHighestSalaryUsingCollections_Sort(empList);

    }


    // using stream API
    public static void findHighestSalaryUsingStreamAPI(List<Employee> empList){

       Long secondHighestSalary = empList.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
       System.out.println("Second Highest Salary is using stream API - " + secondHighestSalary);
    }

    public static void findHighestSalaryUsingCollections_Sort(List<Employee> empList){
        List<Long> salaries = empList.stream().map(Employee::getSalary).collect(Collectors.toList());

        Collections.sort(salaries);
        Long secondHighest = salaries.get(salaries.size() - 2);

        System.out.println("Second Highest Salary collections_Sort " + secondHighest);

    }
}
