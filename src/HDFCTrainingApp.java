import java.util.*;

class Employee {
    int id;
    String name;
    String department;
    TrainingModule module;

    Employee() {
        this(0, "Unknown", "Unknown");
    }

    Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    void showDetails() {
        System.out.println("Name: " + name + " | ID: " + id + " | Department: " + department);
    }

    void showDetails(String extra) {
        showDetails();
        System.out.println(extra);
    }

    int calculateBonus(int base) {
        return base / 10;
    }

    int calculateBonus(int base, int rating) {
        return (base / 10) * rating;
    }
}

class TrainingModule {
    String title;
    int durationInHrs;

    TrainingModule(String title, int durationInHrs) {
        this.title = title;
        this.durationInHrs = durationInHrs;
    }

    void showModule() {
        System.out.println("Training Module: " + title + " | Duration: " + durationInHrs + " hrs");
    }
}

class EmployeeUtils {
    static boolean validateID(String id) {
        return id.matches("\\d{5}");
    }
}

class StringAnalyzer {
    void reverseSentence(String sentence) {
        StringBuilder sb = new StringBuilder(sentence);
        System.out.println("Original: " + sentence);
        System.out.println("Reversed: " + sb.reverse().toString());
    }

    void compareStrings(String s1, String s2) {
        System.out.println("String Comparison: " + s1 + " equals " + s2 + " → " + s1.equals(s2));
        System.out.println("String Comparison: " + s1 + " compareTo " + s1 + " → " + s1.compareTo(s1));
    }
}

public class HDFCTrainingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee ID: ");
        String empIdStr = sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        System.out.println("                       ");
        boolean valid = EmployeeUtils.validateID(empIdStr);
        int empId = valid ? Integer.parseInt(empIdStr) : 0;
        System.out.println("Employee Info:");

        Employee emp = new Employee(empId, name, dept);
        emp.showDetails();
        System.out.println("Valid ID: " + valid);

        System.out.println("                    ");

        TrainingModule tm = new TrainingModule("Java Basics", 10);
        emp.module = tm;
        tm.showModule();

        System.out.println("                    ");


        System.out.println("Bonus (base 5000): " + emp.calculateBonus(5000));
        System.out.println("Bonus (base 5000, rating 5): " + emp.calculateBonus(5000, 5));
        System.out.println("                    ");

        StringAnalyzer sa = new StringAnalyzer();
        sa.reverseSentence("Welcome to HDFC Life");

        System.out.println("                    ");

        sa.compareStrings("HDFC", "hdfc");
        System.out.println("                    ");

        int[] scores = {78, 90, 67, 82, 85};
        int sum = 0, max = scores[0], min = scores[0];
        for (int s : scores) {
            sum += s;
            if (s > max) max = s;
            if (s < min) min = s;
        }
        double avg = (double) sum / scores.length;
        System.out.println("Scores: " + Arrays.toString(scores).replaceAll("[\\[\\],]", ""));
        System.out.println("Average: " + avg + " | Max: " + max + " | Min: " + min);

        System.out.println("                    ");


        System.out.println("Multiplication Table:");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }

        int argsSum = 0;
        for (String arg : args) {
            argsSum += Integer.parseInt(arg);
        }

        System.out.println("                    ");

        System.out.println("Sum from args: " + argsSum);
    }
}
