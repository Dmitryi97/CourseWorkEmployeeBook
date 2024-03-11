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
        System.out.println("Hello world!");
        for (int i = 0; i < EMPLOYEES.length; i++) {
            EMPLOYEES[i] = generateEmployee();
        }
        //Базовая сложность
        print();
        System.out.println();
        System.out.println("Сумма затрат на ЗП в месяц = " + numberFormat.format(calculationSalaryAmount()));
        System.out.println();
        System.out.println("Сотрудник с минимальной ЗП: " + "\n" + searchMinSalary());
        System.out.println();
        System.out.println("Сотрудник с максимальной ЗП: " + "\n" + searchMaxSalary());
        System.out.println();
        System.out.println("Среднее значение зарплаты = " + numberFormat.format(calculationAverageSalary()));
        System.out.println();
        printName();
        //Повышенная сложность
        int numberDepartment = 2;
        int setSalary = 50_000;
        System.out.println();
        indexationSalary(0.15);
        print();
        System.out.println();
        System.out.println("Сотрудник с минимальной ЗП в отделе № " + +numberDepartment + "\n" + searchMinSalaryDepartment(numberDepartment));
        System.out.println();
        System.out.println("Сотрудник с максимальной ЗП в отделе № " + numberDepartment + "\n" + searchMaxSalaryDepartment(numberDepartment));
        System.out.println();
        System.out.println("Сумма затрат на ЗП в месяцв в отделе № " + numberDepartment + " = " + numberFormat.format(calculationSalaryAmountDepartment(numberDepartment)));
        System.out.println();
        System.out.println("Среднее значение зарплаты в отделе № " + numberDepartment + " = " + numberFormat.format(calculationAverageSalaryDepartment(numberDepartment)));
        System.out.println();
        indexationSalaryDepartment(0.1, numberDepartment);
        System.out.println();
        printDepartment(numberDepartment);
        System.out.println();
        findingEmployeesMinSetSalary(setSalary);
        System.out.println();
        findingEmployeesMaxSetSalary(setSalary);
    }

    //Пункт 8.а базовая сложгость
    public static void print() {
        System.out.println("Списов сотрудников: ");
        for (Employee employee : EMPLOYEES) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    //Пункт 8.b базовая сложность
    public static double calculationSalaryAmount() {
        double sumSalary = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null) {
                sumSalary += employee.getSalary();
            }
        }
        return sumSalary;
    }

    //Пункт 8.с базовая сложность
    public static Employee searchMinSalary() {
        int index = 0;
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] != null && EMPLOYEES[i].getSalary() < EMPLOYEES[index].getSalary()) {
                index = i;
            }
        }
        return EMPLOYEES[index];
    }

    //Пункт 8.d базовая сложность
    public static Employee searchMaxSalary() {
        int index = 0;
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] != null && EMPLOYEES[i].getSalary() > EMPLOYEES[index].getSalary()) {
                index = i;
            }
        }
        return EMPLOYEES[index];
    }

    //Пункт 8.e базовая сложность
    public static double calculationAverageSalary() {
        int index = 0;
        double sumSalary = 0;
        double averageSalary = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null) {
                sumSalary += employee.getSalary();
                index++;
            }
        }
        if (index == 0) {
            System.out.println("В базе данных нет сотрудников!");
        } else {
            averageSalary = sumSalary / index;
        }
        return averageSalary;
    }

    //Пункт 8.f базовая сложность
    public static void printName() {
        System.out.println("Список ФИО сотрудников:");
        for (Employee employee : EMPLOYEES) {
            if (employee != null) {
                System.out.println(employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic());
            }
        }
    }

    //Повышенная слосность
    //Пункт 1 повышенная сложность
    public static void indexationSalary(double percentageIndexing) {
        for (Employee employee : EMPLOYEES) {
            if (employee != null) {
                double salary = employee.getSalary() + employee.getSalary() * percentageIndexing;
                employee.setSalary(salary);
            }
        }
    }

    //Пункт 2.a повышенная сложность
    public static Employee searchMinSalaryDepartment(int department) {
        int index = 0;
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] != null && EMPLOYEES[i].getSalary() < EMPLOYEES[index].getSalary() && EMPLOYEES[i].getDepartment() == department) {
                index = i;
            }
        }
        return EMPLOYEES[index];
    }

    //Пункт 2.b повышенная сложность
    public static Employee searchMaxSalaryDepartment(int department) {
        int index = 0;
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] != null && EMPLOYEES[i].getSalary() > EMPLOYEES[index].getSalary() && EMPLOYEES[i].getDepartment() == department) {
                index = i;
            }
        }
        return EMPLOYEES[index];
    }

    //Пункт 2.c повышенная сложность
    public static double calculationSalaryAmountDepartment(int department) {
        double sumSalaryDepartment = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartment() == department) {
                sumSalaryDepartment += employee.getSalary();
            }
        }
        return sumSalaryDepartment;
    }

    //Пункт 2.d повышенная сложность
    public static double calculationAverageSalaryDepartment(int department) {
        int index = 0;
        double sumSalary = 0;
        double averageSalary = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartment() == department) {
                sumSalary += employee.getSalary();
                index++;
            }
        }
        if (index == 0) {
            System.out.println("В данном отделе нет сотрудников!");
        } else {
            averageSalary = sumSalary / index;
        }
        return averageSalary;
    }

    //Пункт 2.e повышенная сложность
    public static void indexationSalaryDepartment(double percentageIndexingDepartment, int department) {
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartment() == department) {
                double salary = employee.getSalary() + employee.getSalary() * percentageIndexingDepartment;
                employee.setSalary(salary);
            }
        }
    }

    //Пункт 2.f повышенная сложность
    public static void printDepartment(int department) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        System.out.println("Отдел № " + department);
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("id " + employee.getId() + " " + "ФИО: " + employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic() + ". "
                        + "Зарплата: " + numberFormat.format(employee.getSalary()));
            }
        }
    }

    //Пункт 3.а повышенной сложности
    public static void findingEmployeesMinSetSalary(int setSalary) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        System.out.println("Сотрудники с ЗП меньше " + numberFormat.format(setSalary) + ":");
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getSalary() < setSalary) {
                System.out.println("id " + employee.getId() + " " + "ФИО: " + employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic() + ". "
                        + "Зарплата: " + numberFormat.format(employee.getSalary()));
            }
        }
    }

    //Пункт 3.b повышенной сложности
    public static void findingEmployeesMaxSetSalary(int setSalary) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        System.out.println("Сотрудники с ЗП больше " + numberFormat.format(setSalary) + ":");
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getSalary() > setSalary) {
                System.out.println("id " + employee.getId() + " " + "ФИО: " + employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic() + ". "
                        + "Зарплата: " + numberFormat.format(employee.getSalary()));
            }
        }
    }
}

