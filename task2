// my name mohammed my id 445801999
// Node structure for the linked list
class DepartmentNode {
    int EmpID;
    String EmpName;
    DepartmentNode next;

    public DepartmentNode(int EmpID, String EmpName) {
        this.EmpID = EmpID;
        this.EmpName = EmpName;
        this.next = null;
    }
}

// Main class to manage the Singly Linked List
public class DepartmentManager {
    private DepartmentNode head;

    public DepartmentManager() {
        this.head = null;
    }

    // Add a new employee to the end of the list
    public void addLast(int id, String name) {
        DepartmentNode newNode = new DepartmentNode(id, name);
        if (head == null) {
            head = newNode;
        } else {
            DepartmentNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Employee " + name + " added to the end.");
    }

    // Add a new employee to the front of the list
    public void addFirst(int id, String name) {
        DepartmentNode newNode = new DepartmentNode(id, name);
        newNode.next = head;
        head = newNode;
        System.out.println("Employee " + name + " added to the front.");
    }

    // Remove an employee from the list by ID
    public void removeEmployee(int id) {
        if (head == null) {
            System.out.println("The list is currently empty.");
            return;
        }

        // Case: The employee to remove is the head
        if (head.EmpID == id) {
            head = head.next;
            System.out.println("Employee with ID " + id + " has been removed.");
            return;
        }

        // Case: Look for the employee in the middle or end
        DepartmentNode current = head;
        while (current.next != null && current.next.EmpID != id) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next; // Skip the node to remove it
            System.out.println("Employee with ID " + id + " has been removed.");
        } else {
            System.out.println("Employee with ID " + id + " was not found.");
        }
    }

    // Print all employees in the list
    public void display() {
        System.out.println("\n--- Department Employee List ---");
        DepartmentNode temp = head;
        if (temp == null) {
            System.out.println("No employees to display.");
            return;
        }
        while (temp != null) {
            System.out.print("[" + temp.EmpID + ": " + temp.EmpName + "] -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Helper method for reverse display using recursion
    private void printReverse(DepartmentNode node) {
        if (node == null) return;
        printReverse(node.next);
        System.out.print("[" + node.EmpID + ": " + node.EmpName + "] ");
    }

    // Public method to trigger the reverse display
    public void showReverse() {
        System.out.println("\n--- Reverse Display (Original list unchanged) ---");
        printReverse(head);
        System.out.println();
    }

    // Entry point for testing the operations
    public static void main(String[] args) {
        DepartmentManager dept = new DepartmentManager();

        // Testing additions
        dept.addLast(101, "Ahmed");
        dept.addLast(102, "Sara");
        dept.addFirst(100, "Khalid");
        dept.addLast(103, "Mona");

        // Show the list
        dept.display();

        // Testing removal from the middle (ID 102 - Sara)
        dept.removeEmployee(102);

        // Show updated list
        dept.display();

        // Show reverse order
        dept.showReverse();
    }
}
