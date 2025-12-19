import java.util.Scanner;
import CIE.*;
import SEE.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details of Student " + (i + 1));

            System.out.print("USN: ");
            String usn = sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Semester: ");
            int sem = sc.nextInt();

            int[] internal = new int[5];
            int[] external = new int[5];

            System.out.println("Enter Internal Marks (5 subjects):");
            for (int j = 0; j < 5; j++) {
                internal[j] = sc.nextInt();
            }

            System.out.println("Enter SEE Marks (5 subjects):");
            for (int j = 0; j < 5; j++) {
                external[j] = sc.nextInt();
            }
            sc.nextLine();

            Personal p = new Personal(usn, name, sem);
            Internals in = new Internals(internal);
            External ex = new External(usn, name, sem, external);

            System.out.println("\nFinal Marks (Internal + SEE):");
            for (int j = 0; j < 5; j++) {
                int finalMarks = in.internalMarks[j] + ex.seeMarks[j];
                System.out.println("Subject " + (j + 1) + ": " + finalMarks);
            }
        }

        sc.close();
    }
}
