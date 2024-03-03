import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        System.out.println("Hello world!");
        int numberEmployees = 10;
        Employee[] employee = new Employee[numberEmployees];
        employee[0] = new Employee("a", "b", "c", 1, 10_000);
        employee[1] = new Employee("a", "b", "w", 2, 10_000);
        employee[2] = new Employee("b", "b", "c", 3, 100_000);
        employee[3] = new Employee("a", "r", "t", 4, 10_000);
        employee[4] = new Employee("a", "b", "c", 5, 10_000);
        employee[5] = new Employee("e", "b", "u", 5, 60_000);
        employee[6] = new Employee("a", "d", "c", 1, 10_000);
        employee[7] = new Employee("r", "b", "q", 2, 10_000);
        employee[8] = new Employee("a", "e", "c", 4, 125_000);
        employee[9] = new Employee("a", "b", "c", 1, 90_000);
        //проверка методов
        print(employee);
        System.out.println();
        System.out.println("Сумма затрат на ЗП в месяц: " + numberFormat.format(sumSalary(employee)));
        System.out.println();
        minSalary(employee);
        System.out.println();
        maxSalary(employee);
        System.out.println();
        System.out.println("Среднее значение зарплаты " + numberFormat.format(averageSalary(employee)));
        System.out.println();
        printName(employee);
        //проверил счетчик
        System.out.println(employee[7].getId());
        System.out.println(employee[6].getId());
    }

    public static void print(Employee[] employee) {
        for (int i = 0; i < employee.length; i++) {
            System.out.println(employee[i]);
        }
    }

    public static int sumSalary(Employee[] employee) {
        int sumSalary = 0;
        for (int i = 0; i < employee.length; i++) {
            sumSalary += employee[i].getSalary();
        }
        return sumSalary;
    }

    public static void minSalary(Employee[] employee) {
        int minSalary = employee[0].getSalary();
        for (int i = 0; i < employee.length; i++) {
            if (minSalary > employee[i].getSalary()) {
                minSalary = employee[i].getSalary();
            }
            System.out.println("Сотрудник с минимальной ЗП: " + employee[i].getSurname() + " " + employee[i].getName() + " " + employee[i].getPatronymic());
        }
    }

    public static void maxSalary(Employee[] employee) {
        int maxSalary = employee[0].getSalary();
        for (int i = 0; i < employee.length; i++) {
            if (maxSalary < employee[i].getSalary()) {
                maxSalary = employee[i].getSalary();
            }
            System.out.println("Сотрудник с максимальной ЗП: " + employee[i].getSurname() + " " + employee[i].getName() + " " + employee[i].getPatronymic());
        }
    }

    public static int averageSalary(Employee[] employee) {
        int averageSalary = sumSalary(employee) / employee.length;
        return averageSalary;
    }

    public static void printName(Employee[] employee) {
        for (int i = 0; i < employee.length; i++) {
            System.out.println(employee[i].getId() + ") " + employee[i].getSurname() + " " + employee[i].getName() + " " + employee[i].getPatronymic());
        }
    }
}

