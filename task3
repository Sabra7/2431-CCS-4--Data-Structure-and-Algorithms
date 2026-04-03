// Node structure for a Doubly Linked List
class DepartmentNode {
    int EmpID;
    String EmpName;
    DepartmentNode next;
    DepartmentNode prev; // Pointer to the previous node

    public DepartmentNode(int EmpID, String EmpName) {
        this.EmpID = EmpID;
        this.EmpName = EmpName;
        this.next = null;
        this.prev = null;
    }
}

// Main class to manage the Doubly Linked List
public class DepartmentManager {
    private DepartmentNode head;
    private DepartmentNode tail; // Keep track of the end for easier operations

    public DepartmentManager() {
        this.head = null;
        this.tail = null;
    }

    // Add a new employee to the front of the list
    public void addFirst(int id, String name) {
        DepartmentNode newNode = new DepartmentNode(id, name);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Employee " + name + " added to the front.");
    }

    // Add a new employee to the end of the list
    public void addLast(int id, String name) {
        DepartmentNode newNode = new DepartmentNode(id, name);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Employee " + name + " added to the end.");
    }

    // Remove an employee from the list by ID (Middle, Front, or End)
    public void removeEmployee(int id) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        DepartmentNode current = head;
        // Search for the node with the matching ID
        while (current != null && current.EmpID != id) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Employee with ID " + id + " was not found.");
            return;
        }

        // Adjust pointers to remove the current node
        if (current == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null; // List became empty
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            // Middle removal logic
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        System.out.println("Employee with ID " + id + " has been removed.");
    }

    // Display all employees from front to back
    public void display() {
        System.out.println("\n--- Department Employee List (Forward) ---");
        DepartmentNode temp = head;
        if (temp == null) {
            System.out.println("List is empty.");
            return;
        }
        while (temp != null) {
            System.out.print("[" + temp.EmpID + ": " + temp.EmpName + "] <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Display all employees in reverse order (using the prev pointers)
    public void showReverse() {
        System.out.println("\n--- Reverse Display (Backward using prev) ---");
        DepartmentNode temp = tail;
        if (temp == null) {
            System.out.println("List is empty.");
            return;
        }
        while (temp != null) {
            System.out.print("[" + temp.EmpID + ": " + temp.EmpName + "] <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    // Main method for testing
    public static void main(String[] args) {
        DepartmentManager dept = new DepartmentManager();

        // Testing additions
        dept.addLast(101, "Ahmed");
        dept.addLast(102, "Sara");
        dept.addFirst(100, "Khalid");
        dept.addLast(103, "Mona");

        dept.display(); // Khalid <-> Ahmed <-> Sara <-> Mona

        // Testing removal (ID 102 - Sara) from the middle
        dept.removeEmployee(102);

        dept.display(); // Khalid <-> Ahmed <-> Mona

        // Reverse display using the doubly linked structure
        dept.showReverse(); // Mona <-> Ahmed <-> Khalid
    }
}
