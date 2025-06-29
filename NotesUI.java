public class NotesUI {
    private InputHandler inputHandler;
    private NotesManager notesManager;

    public NotesUI() {
        inputHandler = new InputHandler();
        notesManager = new NotesManager("./notes");
    }

    public void displayMenu() {
        System.out.println("\n=== Notes Manager ===");
        System.out.println("1. Add Note");
        System.out.println("2. View Note");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    public void addNote() {
        String title = inputHandler.readLine("Enter note title: ");
        String content = inputHandler.readMultiLineInput(
                "Enter note content (press Enter twice to finish):");

        notesManager.saveNote(title, content);
    }

    public void viewNote() {
        String title = inputHandler.readLine("Enter note title: ");
        String content = notesManager.readNote(title);
        System.out.println("\nNote Content:");
        System.out.println(content);
    }

    public void exit() {
        System.out.println("Goodbye!");
        System.exit(0);
    }

    public void run() {
        while (true) {
            displayMenu();

            try {
                int choice = Integer.parseInt(inputHandler.readLine(""));

                switch (choice) {
                    case 1:
                        addNote();
                        break;
                    case 2:
                        viewNote();
                        break;
                    case 3:
                        exit();
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    public static void main(String[] args) {
        NotesUI ui = new NotesUI();
        ui.run();
    }
}