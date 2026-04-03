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

public class RecursiveEmployeeArray4 {
    private Employee[] db = new Employee[45];
    private int count = 0;

    // 1. Recursive Add (To maintain ID sequence)
    public void addRecursive(Employee emp, int index) {
        if (index < count && db[index].empId < emp.empId) {
            addRecursive(emp, index + 1);
            return;
        }
        
        // Shift elements to the right to make space
        shiftRight(count, index);
        db[index] = emp;
        count++;
    }

    private void shiftRight(int current, int target) {
        if (current <= target) return;
        db[current] = db[current - 1];
        shiftRight(current - 1, target);
    }

    // 2. Search by specific indices (Recursive)
    public void searchByIndices(int[] indices, int i) {
        if (i >= indices.length) return;
        int targetIdx = indices[i];
        if (targetIdx < count) {
            System.out.print("Index " + targetIdx + ": ");
            db[targetIdx].display();
        }
        searchByIndices(indices, i + 1);
    }

    // 3. Search Age > 30 (Recursive)
    public void searchAgeRecursive(int index) {
        if (index >= count) return;
        if (db[index].age > 30) db[index].display();
        searchAgeRecursive(index + 1);
    }

    // 4. Search Salary > 5000 (Recursive)
    public void searchSalaryRecursive(int index, float limit) {
        if (index >= count) return;
        if (db[index].salary > limit) db[index].display();
        searchSalaryRecursive(index + 1, limit);
    }

    // 5. Update Salary at Indices (Recursive)
    public void updateSalaryRecursive(int[] indices, int i, float newSal) {
        if (i >= indices.length) return;
        int targetIdx = indices[i];
        if (targetIdx < count) {
            float old = db[targetIdx].salary;
            db[targetIdx].salary = newSal;
            System.out.println("Index " + targetIdx + ": Old=" + old + " -> New=" + newSal);
        }
        updateSalaryRecursive(indices, i + 1, newSal);
    }

    // 6. Statistics: Average Salary (Recursive)
    public float sumSalariesRecursive(int index) {
        if (index >= count) return 0;
        return db[index].salary + sumSalariesRecursive(index + 1);
    }

    // 7. Statistics: Find Highest (Recursive)
    public Employee findMaxSalaryRecursive(int index, Employee currentMax) {
        if (index >= count) return currentMax;
        if (db[index].salary > currentMax.salary) {
            currentMax = db[index];
        }
        return findMaxSalaryRecursive(index + 1, currentMax);
    }

    public static void main(String[] args) {
        RecursiveEmployeeArray4 app = new RecursiveEmployeeArray4();

        // Adding some records
        app.addRecursive(new Employee(105, "Ahmed", 35, "IT", 6000), 0);
        app.addRecursive(new Employee(101, "Sara", 25, "HR", 4500), 0);
        app.addRecursive(new Employee(110, "Khalid", 40, "Ops", 7500), 0);
        app.addRecursive(new Employee(103, "Mona", 32, "IT", 5500), 0);

        System.out.println("--- All Records (Sorted by ID) ---");
        app.searchSalaryRecursive(0, 0); // Display all

        System.out.println("\n--- Search Indices 1, 3 ---");
        app.searchByIndices(new int[]{1, 3}, 0);

        System.out.println("\n--- Age > 30 ---");
        app.searchAgeRecursive(0);

        System.out.println("\n--- Update Salaries at Indices 1, 3 ---");
        app.updateSalaryRecursive(new int[]{1, 3}, 0, 9000.0f);

        System.out.println("\n--- Stats ---");
        float avg = app.sumSalariesRecursive(0) / app.count;
        System.out.println("Average Salary: " + avg);
        
        Employee top = app.findMaxSalaryRecursive(0, app.db[0]);
        System.out.println("Highest Paid: " + top.name + " (" + top.salary + ")");
    }
}
