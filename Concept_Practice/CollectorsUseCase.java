package Concept_Practice;





import Object_to_test.Employee;
import Object_to_test.Student;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsUseCase {

    public static void main(String[] args) {
        // Object_to_test.Employee data
        List<Object_to_test.Employee> employees = Arrays.asList(
                new Object_to_test.Employee(1, "Sonu", "IT", 100000),
                new Employee(5, "Fam", "IT", 900000),
                new Employee(2, "Aman", "CE", 25000),
                new Object_to_test.Employee(6, "Dolly", "CE", 35000),
                new Object_to_test.Employee(3, "Alok", "IT", 4500),
                new Employee(4, "Naina", "ASO", 600000)
        );

        // Object_to_test.Student data
        List<Student> students = Arrays.asList(
                new Student("Alice", 85),
                new Student("Bob", 45),
                new Student("Charlie", 72),
                new Student("David", 58),
                new Student("Eve", 91),
                new Student("Frank", 39),
                new Student("Grace", 67)
        );

        // Accumulate names into a List
        List<String> list = students.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println("Object_to_test.Student names as List: " + list);

        // Accumulate names into a TreeSet
        Set<String> set = students.stream()
                .map(Student::getName)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("Object_to_test.Student names as TreeSet (sorted): " + set);

        // Convert elements to strings and concatenate them, separated by commas
        String str = "Programming";
        String joined = str.chars()
                .mapToObj(c -> String.valueOf((char)c))
                .collect(Collectors.joining(", "));
        System.out.println("String characters joined: " + joined);

        // Compute sum of salaries of employee
        double total = employees.stream()
                .collect(Collectors.summingDouble(Object_to_test.Employee::getSalary));
        System.out.println("Total salary of all employees: " + total);

        // Group employees by department
        Map<String, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Object_to_test.Employee::getDepartment));
        System.out.println("Employees grouped by department: " + byDept);

        // Compute sum of salaries by department
        Map<String, Double> totalByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingDouble(Employee::getSalary)));
        System.out.println("Total salary by department: " + totalByDept);

        // Partition students into passing and failing
        final int PASS_THRESHOLD = 33;
        Map<Boolean, List<Student>> passingFailing = students.stream()
                .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));
        System.out.println("Passing students (grade >= " + PASS_THRESHOLD + "): " + passingFailing.get(true));
        System.out.println("Failing students (grade < " + PASS_THRESHOLD + "): " + passingFailing.get(false));
    }
}
