import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    static int cize = 10;
    static Employee[] employee = new Employee[cize];

    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        System.out.println("Hello world!");
        employee[0] = new Employee("Никита", "Сидоров", "Витальевич", 2, 17_000);
        employee[3] = new Employee("Никита", "Сидоров", "Витальевич", 2, 115_050);
        employee[6] = new Employee("Никита", "Сидоров", "Витальевич", 2, 17_050);
        employee[7] = new Employee("Стас", "Логинов", "Алексеевич", 5, 167_500);
        employee[9] = new Employee("Егор", "Пакетов", "Андреевич", 3, 19_000);
        //проверка методов
        print(employee);
        System.out.println();
        System.out.println("Сумма затрат на ЗП в месяц: " + numberFormat.format(sumSalary(employee)));
        System.out.println();
        System.out.println("Сотрудник с минимальной ЗП - " + employee[minSalary(employee)]);
        System.out.println();
        System.out.println("Сотрудник с максимальной ЗП - " + employee[maxSalary(employee)]);
        System.out.println();
        System.out.println("Среднее значение зарплаты " + numberFormat.format(averageSalary(employee)));
        System.out.println();
        printName(employee);
    }

    public static void print(Employee[] employee) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) System.out.println(employee[i]);
        }
    }

    public static int sumSalary(Employee[] employee) {
        int sumSalary = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                sumSalary += employee[i].getSalary();
            }
        }
        return sumSalary;
    }

    public static int minSalary(Employee[] employee) {
        int index = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                if (employee[i].getSalary() < employee[index].getSalary()) {
                    index = i;
                }
            }
        }
        return index;
    }

    public static int maxSalary(Employee[] employee) {
        int index = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                if (employee[i].getSalary() > employee[index].getSalary()) {
                    index = i;
                }
            }
        }
        return index;
    }

    public static double averageSalary(Employee[] employee) {
        double averageSalary = sumSalary(employee) / employee.length;
        return averageSalary;
    }

    public static void printName(Employee[] employee) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                System.out.println(employee[i].getId() + ") " + employee[i].getSurname() + " " + employee[i].getName() + " " + employee[i].getPatronymic());
            }
        }
    }
}

