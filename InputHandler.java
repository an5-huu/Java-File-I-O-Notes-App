import java.io.*;
import java.util.Scanner;

public class InputHandler {
    private BufferedReader reader;

    public InputHandler() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readLine(String prompt) {
        System.out.print(prompt);
        try {
            return reader.readLine();
        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
            return "";
        }
    }

    public String readMultiLineInput(String prompt) {
        StringBuilder content = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        System.out.println(prompt);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty() && content.length() > 0)
                break;
            content.append(line).append("\n");
        }
        return content.toString().trim();
    }
}