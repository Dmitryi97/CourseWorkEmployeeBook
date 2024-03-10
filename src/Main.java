import java.text.NumberFormat;

public class Main {
    static int cize = 10;
    static Employee[] employee = new Employee[cize];
    static int numberDepartment = 2;
    static int setSalary = 50_000;


    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        System.out.println("Hello world!");
        employee[0] = new Employee("Никита", "Сидоров", "Витальевич", 2, 18_000);
        employee[3] = new Employee("Никита", "Сидоров", "Витальевич", 2, 115_050);
        employee[6] = new Employee("Никита", "Сидоров", "Витальевич", 2, 17_050);
        employee[7] = new Employee("Стас", "Логинов", "Алексеевич", 5, 167_500);
        employee[9] = new Employee("Егор", "Пакетов", "Андреевич", 3, 19_000);
        //проверка методов
        print(employee);
        System.out.println();
        System.out.println("Сумма затрат на ЗП в месяц: " + numberFormat.format(calculationSalaryAmount(employee)));
        System.out.println();
        System.out.println("Сотрудник с минимальной ЗП - " + searchMinSalary(employee));
        System.out.println();
        System.out.println("Сотрудник с максимальной ЗП - " + searchMaxSalary(employee));
        System.out.println();
        System.out.println("Среднее значение зарплаты " + numberFormat.format(calculationAverageSalary(employee)));
        System.out.println();
        printName(employee);
        //
        System.out.println();
        indexationSalary(employee, 0.15);
        print(employee);
        System.out.println();
        System.out.println("Сотрудник с минимальной ЗП в отделе № " + numberDepartment + " - " + searchMinSalaryDepartment(employee, numberDepartment));
        System.out.println();
        System.out.println("Сотрудник с максимальной ЗП в отделе № " + numberDepartment + " - " + searchMaxSalaryDepartment(employee, numberDepartment));
        System.out.println();
        System.out.println("Сумма затрат на ЗП в месяцв в отделе № " + numberDepartment + " - " + numberFormat.format(calculationSalaryAmountDepartment(employee, numberDepartment)));
        System.out.println();
        System.out.println("Среднее значение зарплаты в отделе № " + numberDepartment + " - " + numberFormat.format(calculationAverageSalaryDepartment(employee, numberDepartment)));
        System.out.println();
        indexationSalaryDepartment(employee, 0.1, numberDepartment);
        System.out.println();
        printDepartment(employee, numberDepartment);
        System.out.println();
        findingEmployeesMinSetSalary(employee, setSalary);
        System.out.println();
        findingEmployeesMaxSetSalary(employee,setSalary);
    }

    //Пункт 8.а базовая сложгость
    public static void print(Employee[] employee) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                System.out.println(employee[i]);
            }
        }
    }

    //Пункт 8.b базовая сложность
    public static int calculationSalaryAmount(Employee[] employee) {
        int sumSalary = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                sumSalary += employee[i].getSalary();
            }
        }
        return sumSalary;
    }

    //Пункт 8.с базовая сложность
    public static Employee searchMinSalary(Employee[] employee) {
        int index = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getSalary() < employee[index].getSalary()) {
                index = i;
            }
        }
        return employee[index];
    }

    //Пункт 8.d базовая сложность
    public static Employee searchMaxSalary(Employee[] employee) {
        int index = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getSalary() > employee[index].getSalary()) {
                index = i;
            }
        }
        return employee[index];
    }

    //Пункт 8.e базовая сложность
    public static double calculationAverageSalary(Employee[] employee) {
        int index = 0;
        int sumSalary = 0;
        double averageSalary = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                sumSalary += employee[i].getSalary();
                index++;
            }
        }
        if (index == 0) {
            System.exit(Integer.parseInt("В базе данных нет сотрудников!"));
        } else {
            averageSalary = sumSalary / index;
        }
        return averageSalary;
    }

    //Пункт 8.f базовая сложность
    public static void printName(Employee[] employee) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                System.out.println(employee[i].getId() + ") " + employee[i].getSurname() + " " + employee[i].getName() + " " + employee[i].getPatronymic());
            }
        }
    }

    //Повышенная слосность
    //Пункт 1 повышенная сложность
    public static void indexationSalary(Employee[] employee, double percentageIndexing) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                double salary = employee[i].getSalary() + employee[i].getSalary() * percentageIndexing;
                employee[i].setSalary(salary);
            }
        }
    }

    //Пункт 2.a повышенная сложность
    public static Employee searchMinSalaryDepartment(Employee[] employee, int department) {
        int index = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getSalary() < employee[index].getSalary() && employee[i].getDepartment() == department) {
                index = i;
            }
        }
        return employee[index];
    }

    //Пункт 2.b повышенная сложность
    public static Employee searchMaxSalaryDepartment(Employee[] employee, int department) {
        int index = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getSalary() > employee[index].getSalary() && employee[i].getDepartment() == department) {
                index = i;
            }
        }
        return employee[index];
    }

    //Пункт 2.c повышенная сложность
    public static int calculationSalaryAmountDepartment(Employee[] employee, int department) {
        int sumSalaryDepartment = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getDepartment() == department) {
                sumSalaryDepartment += employee[i].getSalary();
            }
        }
        return sumSalaryDepartment;
    }

    //Пункт 2.d повышенная сложность
    public static double calculationAverageSalaryDepartment(Employee[] employee, int department) {
        int index = 0;
        int sumSalary = 0;
        double averageSalary = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getDepartment() == department) {
                sumSalary += employee[i].getSalary();
                index++;
            }
        }
        if (index == 0) {
            System.exit(Integer.parseInt("В данном отделе нет сотрудников!"));
        } else {
            averageSalary = sumSalary / index;
        }
        return averageSalary;
    }

    //Пункт 2.e повышенная сложность
    public static void indexationSalaryDepartment(Employee[] employee, double percentageIndexingDepartment, int department) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getDepartment() == department) {
                double salary = employee[i].getSalary() + employee[i].getSalary() * percentageIndexingDepartment;
                employee[i].setSalary(salary);
            }
        }
    }

    //Пункт 2.f повышенная сложность
    public static void printDepartment(Employee[] employee, int department) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        System.out.println("Отдел № " + department);
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getDepartment() == department) {
                System.out.println(employee[i].getId() + ") " + "ФИО: " + employee[i].getSurname() + " " + employee[i].getName() + " " + employee[i].getPatronymic() + ". "
                        + "Зарплата: " + numberFormat.format(employee[i].getSalary()));
            }
        }
    }

    //Пункт 3.а повышенной сложности
    public static void findingEmployeesMinSetSalary(Employee[] employee, int setSalary) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        System.out.println("Сотрудники с ЗП меньше " + numberFormat.format(setSalary) + ":");
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getSalary() < setSalary) {
                System.out.println(employee[i].getId() + ") " + "ФИО: " + employee[i].getSurname() + " " + employee[i].getName() + " " + employee[i].getPatronymic() + ". "
                        + "Зарплата: " + numberFormat.format(employee[i].getSalary()));
            }
        }
    }
    public static void findingEmployeesMaxSetSalary(Employee[] employee, int setSalary) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        System.out.println("Сотрудники с ЗП больше " + numberFormat.format(setSalary) + ":");
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getSalary() > setSalary) {
                System.out.println(employee[i].getId() + ") " + "ФИО: " + employee[i].getSurname() + " " + employee[i].getName() + " " + employee[i].getPatronymic() + ". "
                        + "Зарплата: " + numberFormat.format(employee[i].getSalary()));
            }
        }
    }
}

