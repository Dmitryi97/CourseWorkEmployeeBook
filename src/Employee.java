import java.text.NumberFormat;
import java.util.Objects;

public class Employee {
    private String name;
    private String surname;
    private String patronymic;
    private int department;
    private int salary;
    private int id;
    private static int conter = 1;

    public Employee(String name, String surname, String patronymic, int department, int salary) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.department = department;
        this.salary = salary;
        id = conter++;
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

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
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
        return id + ") " + "ФИО: " + surname + " " + name + " " + patronymic + ". "
                + "Отдел № " + department + ". "
                + "Зарплата: " + numberFormat.format(salary);
    }
}
