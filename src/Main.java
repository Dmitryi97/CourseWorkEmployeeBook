import java.text.NumberFormat;
import java.util.Random;

public class Main {
    private static final Employee[] EMPLOYEES = new Employee[10];
    private static final Random RANDOM = new Random();
    private static final String[] MALE_SURNAMES = {"Иванов", "Петров", "Сидоров", "Логинов", "Васильев"};
    private static final String[] MALE_NAMES = {"Иван", "Петр", "Алексей", "Дмитирий", "Василий"};
    private static final String[] MALE_PATRONYMIC_NAMES = {"Иванавич", "Петрович", "Алексеевич", "Дмитиреевич", "Васильевич"};

    private static Employee generateEmployee() {
        return new Employee(
                MALE_NAMES[RANDOM.nextInt(MALE_NAMES.length)] + " ",
                MALE_SURNAMES[RANDOM.nextInt(MALE_SURNAMES.length)] + " ",
                MALE_PATRONYMIC_NAMES[RANDOM.nextInt(MALE_PATRONYMIC_NAMES.length)] + " ",
                RANDOM.nextInt(1, 6),
                RANDOM.nextInt(15_000, 100_000)
        );
    }

    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        for (int i = 0; i < EMPLOYEES.length; i++) {
            EMPLOYEES[i] = generateEmployee();
        }
        EmployeeBook employeeBook = new EmployeeBook(EMPLOYEES,10);
        employeeBook.print();
        System.out.println();
        System.out.println("Сумма затрат на ЗП в месяц = " + numberFormat.format(employeeBook.calculationSalaryAmount()));
        System.out.println();
        System.out.println("Сотрудник с минимальной ЗП: " + "\n" + employeeBook.searchMinSalary());
        System.out.println();
        System.out.println("Сотрудник с максимальной ЗП: " + "\n" + employeeBook.searchMaxSalary());
        System.out.println();
        System.out.println("Среднее значение зарплаты = " + numberFormat.format(employeeBook.calculationAverageSalary()));
        System.out.println();
        employeeBook.printName();
        //Повышенная сложность
        int numberDepartment = 2;
        int setSalary = 50_000;
        System.out.println();
        employeeBook.indexationSalary(0.15);
        employeeBook.print();
        System.out.println();
        System.out.println("Сотрудник с минимальной ЗП в отделе № " + +numberDepartment + "\n" + employeeBook.searchMinSalaryDepartment(numberDepartment));
        System.out.println();
        System.out.println("Сотрудник с максимальной ЗП в отделе № " + numberDepartment + "\n" + employeeBook.searchMaxSalaryDepartment(numberDepartment));
        System.out.println();
        System.out.println("Сумма затрат на ЗП в месяцв в отделе № " + numberDepartment + " = " + numberFormat.format(employeeBook.calculationSalaryAmountDepartment(numberDepartment)));
        System.out.println();
        System.out.println("Среднее значение зарплаты в отделе № " + numberDepartment + " = " + numberFormat.format(employeeBook.calculationAverageSalaryDepartment(numberDepartment)));
        System.out.println();
        employeeBook.indexationSalaryDepartment(0.1, numberDepartment);
        System.out.println();
        employeeBook.printDepartment(numberDepartment);
        System.out.println();
        employeeBook.findingEmployeesMinSetSalary(setSalary);
        System.out.println();
        employeeBook.findingEmployeesMaxSetSalary(setSalary);
        System.out.println();
        //Проверка методов очень сложного уровня
        employeeBook.deletionEmployee(7);
        employeeBook.print();
        System.out.println();
        Employee n = new Employee("Дмитрий","Токарве","Андреевич",1,122_000);
        employeeBook.addNewEmployee(n);
        employeeBook.print();
        System.out.println();
        System.out.println(employeeBook.searchEmployee(11));
    }
}

