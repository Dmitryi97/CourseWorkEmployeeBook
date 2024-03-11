import java.text.NumberFormat;
import java.util.Objects;

public class Employee {
    private final String name;
    private final String surname;
    private final String patronymic;
    private int department;
    private double salary;
    private final int id;
    private static int counter = 1;

    public Employee(String name, String surname, String patronymic, int department, double salary) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.department = department;
        this.salary = salary;
        this.id = counter++;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, patronymic, department, salary, id);
    }

    @Override
    public String toString() {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        return "id " + id + " " + "ФИО: " + surname + " " + name + " " + patronymic + ". "
                + "Отдел № " + department + ". "
                + "Зарплата: " + numberFormat.format(salary);
    }
}
