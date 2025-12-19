// Custom Exception Class
class WrongAge extends Exception {
    public WrongAge(String message) {
        super(message);
    }
}

// Base Class
class Father {
    int fatherAge;

    Father(int age) throws WrongAge {
        if (age < 0) {
            throw new WrongAge("Father's age cannot be negative");
        }
        fatherAge = age;
        System.out.println("Father age: " + fatherAge);
    }
}

// Derived Class
class Son extends Father {
    int sonAge;

    Son(int fatherAge, int sonAge) throws WrongAge {
        super(fatherAge);

        if (sonAge >= fatherAge) {
            throw new WrongAge("Son's age must be less than Father's age");
        }
        if (sonAge < 0) {
            throw new WrongAge("Son's age cannot be negative");
        }

        this.sonAge = sonAge;
        System.out.println("Son age: " + sonAge);
    }
}

// Main Class
public class ExceptionInheritanceDemo {
    public static void main(String[] args) {

        try {
            Son s = new Son(45, 20);   // valid case
        } 
        catch (WrongAge e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}

