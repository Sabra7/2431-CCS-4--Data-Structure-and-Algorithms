// my name is Mohammed Al-Shaharani my uni ID 445801999
class Employee {
    int empId;
    String name;
    int age;
    String department;
    float salary;

    public Employee(int id, String name, int age, String dept, float salary) {
        this.empId = id;
        this.name = name;
        this.age = age;
        this.department = dept;
        this.salary = salary;
    }

    public void display() {
        System.out.println("ID: " + empId + " | Name: " + name + " | Age: " + age + " | Salary: " + salary);
    }
}

public class EmployeeManagement {
    // 1. Initialize Database (Capacity 40)
    private Employee[] db = new Employee[40];
    private int count = 0;
    private int capacity = 40;

    // 2. Add Employee (Sorted by ID)
    public void addEmployee(int id, String name, int age, String dept, float salary) {
        // Resizing to 45
        if (count >= capacity) {
            if (capacity < 45) {
                System.out.println(">> Resizing array to 45...");
                Employee[] newDb = new Employee[45];
                for (int i = 0; i < count; i++) newDb[i] = db[i];
                db = newDb;
                capacity = 45;
            } else {
                System.out.println("Full!"); return;
            }
        }

        Employee newEmp = new Employee(id, name, age, dept, salary);
        int i = count - 1;
        // Shifting elements to keep ID sequence
        while (i >= 0 && db[i].empId > id) {
            db[i + 1] = db[i];
            i--;
        }
        db[i + 1] = newEmp;
        count++;
    }

    public void runRequiredOperations() {
        // searching for 1, 10, 20, 30
        System.out.println("\n--- Search by Indices (1, 10, 20, 30) ---");
        int[] targets = {1, 10, 20, 30};
        for (int idx : targets) {
            if (idx < count) db[idx].display();
        }

        
        System.out.println("\n--- Search: Age > 30 & Salary > 5000 ---");
        for (int i = 0; i < count; i++) {
            if (db[i].age > 30 && db[i].salary > 5000) db[i].display();
        }

        
        System.out.println("\n--- Update Salaries (Indices 1, 10, 20, 30) ---");
        for (int idx : targets) {
            if (idx < count) {
                float oldSal = db[idx].salary;
                db[idx].salary = 8000.0f; // قيمة افتراضية للتحديث
                System.out.println("Index " + idx + ": Old=" + oldSal + " | New=" + db[idx].salary);
            }
        }

  
        calculateStats();
    }

    public void calculateStats() {
        float sum = 0;
        Employee highest = db[0], lowest = db[0];
        int lowCat = 0, midCat = 0, highCat = 0;

        for (int i = 0; i < count; i++) {
            sum += db[i].salary;
            if (db[i].salary > highest.salary) highest = db[i];
            if (db[i].salary < lowest.salary) lowest = db[i];
            
            if (db[i].salary < 3000) lowCat++;
            else if (db[i].salary <= 7000) midCat++;
            else highCat++;
        }

        System.out.println("\n--- Statistics ---");
        System.out.println("Average Salary: " + (sum / count));
        System.out.println("Highest Salary: " + highest.name + " (" + highest.salary + ")");
        System.out.println("Lowest Salary: " + lowest.name + " (" + lowest.salary + ")");
        System.out.println("Categories: <3k: " + lowCat + " | 3k-7k: " + midCat + " | >7k: " + highCat);
    }

    public static void main(String[] args) {
        EmployeeManagement app = new EmployeeManagement();
        //trying to add user number 41 to test resizing
        for (int i = 1; i <= 41; i++) {
            app.addEmployee(100 + i, "Emp" + i, 25 + (i % 15), "Sales", 2000 + (i * 200));
        }
        app.runRequiredOperations();
    }
}

