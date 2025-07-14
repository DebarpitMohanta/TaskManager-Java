import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {

    // Inner class to store task data
    static class Task {
        String name;
        boolean isDone;

        Task(String name) {
            this.name = name;
            this.isDone = false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        while (true) {
            System.out.println("\n===== TASK MANAGER =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();
                    tasks.add(new Task(name));
                    System.out.println("✅ Task added!");
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("📭 No tasks found.");
                    } else {
                        System.out.println("\n📝 Your Tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            Task t = tasks.get(i);
                            String status = t.isDone ? "✅ Done" : "❌ Not Done";
                            System.out.println((i + 1) + ". " + t.name + " [" + status + "]");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter task number to mark as done: ");
                    int doneIndex = scanner.nextInt() - 1;
                    if (doneIndex >= 0 && doneIndex < tasks.size()) {
                        tasks.get(doneIndex).isDone = true;
                        System.out.println("🎉 Task marked as done!");
                    } else {
                        System.out.println("❌ Invalid task number.");
                    }
                    break;

                case 4:
                    System.out.print("Enter task number to delete: ");
                    int delIndex = scanner.nextInt() - 1;
                    if (delIndex >= 0 && delIndex < tasks.size()) {
                        tasks.remove(delIndex);
                        System.out.println("🗑️ Task deleted.");
                    } else {
                        System.out.println("❌ Invalid task number.");
                    }
                    break;

                case 5:
                    System.out.println("👋 Exiting... Goodbye!");
                    return;

                default:
                    System.out.println("⚠️ Invalid choice. Try again.");
            }
        }
    }
}
