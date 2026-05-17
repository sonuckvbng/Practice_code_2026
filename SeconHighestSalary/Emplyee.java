package SeconHighestSalary;

class Employee{

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getSalary() {
        return salary;
    }

    private Long salary;

    Employee (int id, String name, Long salary){
        this.id=id;
        this.name = name;
        this.salary= salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }


}