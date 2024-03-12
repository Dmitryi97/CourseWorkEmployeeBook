import java.text.NumberFormat;

public class EmployeeBook {
    private static Employee[] employee;

    public EmployeeBook(Employee[] employee, int i) {
        this.employee = employee;
    }

    public void print() {
        System.out.println("Список сотрудников: ");
        for (Employee employee : employee) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public double calculationSalaryAmount() {
        double sumSalary = 0;
        for (Employee employee : employee) {
            if (employee != null) {
                sumSalary += employee.getSalary();
            }
        }
        return sumSalary;
    }

    public Employee searchMinSalary() {
        int index = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getSalary() < employee[index].getSalary()) {
                index = i;
            }
        }
        return employee[index];
    }

    public Employee searchMaxSalary() {
        int index = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getSalary() > employee[index].getSalary()) {
                index = i;
            }
        }
        return employee[index];
    }

    public double calculationAverageSalary() {
        int index = 0;
        double sumSalary = 0;
        double averageSalary = 0;
        for (Employee employee : employee) {
            if (employee != null) {
                sumSalary += employee.getSalary();
                index++;
            }
        }
        if (index != 0) {
            averageSalary = sumSalary / index;
        }
        return averageSalary;
    }

    public void printName() {
        System.out.println("Список ФИО сотрудников:");
        for (Employee employee : employee) {
            if (employee != null) {
                System.out.println(employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic());
            }
        }
    }

    public void indexationSalary(double percentageIndexing) {
        for (Employee employee : employee) {
            if (employee != null) {
                double salary = employee.getSalary() + employee.getSalary() * percentageIndexing;
                employee.setSalary(salary);
            }
        }
    }

    public Employee searchMinSalaryDepartment(int department) {
        int index = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getSalary() < employee[index].getSalary() && employee[i].getDepartment() == department) {
                index = i;
            }
        }
        return employee[index];
    }

    public Employee searchMaxSalaryDepartment(int department) {
        int index = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getSalary() > employee[index].getSalary() && employee[i].getDepartment() == department) {
                index = i;
            }
        }
        return employee[index];
    }

    public double calculationSalaryAmountDepartment(int department) {
        double sumSalaryDepartment = 0;
        for (Employee employee : employee) {
            if (employee != null && employee.getDepartment() == department) {
                sumSalaryDepartment += employee.getSalary();
            }
        }
        return sumSalaryDepartment;
    }

    public double calculationAverageSalaryDepartment(int department) {
        int index = 0;
        double sumSalary = 0;
        double averageSalary = 0;
        for (Employee employee : employee) {
            if (employee != null && employee.getDepartment() == department) {
                sumSalary += employee.getSalary();
                index++;
            }
        }
        if (index != 0) {
            averageSalary = sumSalary / index;
        }
        return averageSalary;
    }

    public void indexationSalaryDepartment(double percentageIndexingDepartment, int department) {
        for (Employee employee : employee) {
            if (employee != null && employee.getDepartment() == department) {
                double salary = employee.getSalary() + employee.getSalary() * percentageIndexingDepartment;
                employee.setSalary(salary);
            }
        }
    }

    public void printDepartment(int department) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        System.out.println("Отдел № " + department);
        for (Employee employee : employee) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("id " + employee.getId() + " " + "ФИО: " + employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic() + ". "
                        + "Зарплата: " + numberFormat.format(employee.getSalary()));
            }
        }
    }

    public void findingEmployeesMinSetSalary(int setSalary) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        System.out.println("Сотрудники с ЗП меньше " + numberFormat.format(setSalary) + ":");
        for (Employee employee : employee) {
            if (employee != null && employee.getSalary() < setSalary) {
                System.out.println("id " + employee.getId() + " " + "ФИО: " + employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic() + ". "
                        + "Зарплата: " + numberFormat.format(employee.getSalary()));
            }
        }
    }

    public void findingEmployeesMaxSetSalary(int setSalary) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        System.out.println("Сотрудники с ЗП больше " + numberFormat.format(setSalary) + ":");
        for (Employee employee : employee) {
            if (employee != null && employee.getSalary() > setSalary) {
                System.out.println("id " + employee.getId() + " " + "ФИО: " + employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic() + ". "
                        + "Зарплата: " + numberFormat.format(employee.getSalary()));
            }
        }
    }
    //Очень сложно пункт 4.а
    public boolean addNewEmployee(Employee n){
        boolean freeCell = false;
        for (int i = 0; i < employee.length-1; i++) {
            if (employee[i] == null){
                employee[i] = n;
                freeCell = true;
            }
        }
        return freeCell;
    }
    //Очень сложно пункт 4.b
    public void deletionEmployee(int id){
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getId() == id){
                employee[i] = null;
            }
        }
    }
    //Очень сложно пункт 5
    public Employee searchEmployee(int id){
        for (Employee employee : employee) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}
