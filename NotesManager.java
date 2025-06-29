import java.io.*;

public class NotesManager {
    private String notesDir; // directory path where notes will be saved

    public NotesManager(String directory){
        this.notesDir=directory;
        createDirIfNoExists(); // to make sure that the directory exists
    }
    private void createDirIfNoExists(){
        File dir= new File(notesDir); // create a File object for the directory path
        if(! dir.exists()){  // it checks that what if the directory didn't exists
            dir.mkdirs(); // create directory
        }
    }

    // method to save a note with a given title and content
    public void saveNote(String title, String content){

        try (BufferedWriter writer= new BufferedWriter (
                new FileWriter(notesDir + "/" + title + ".txt"))) {
            writer.write(content);
            System.out.println("Note saved successfully");
        } catch (IOException e) {
            System.err.println("Error saving note: " + e.getMessage());
        }
    }
    public String readNote(String title){
        StringBuilder content= new StringBuilder();

        try(BufferedReader reader=new BufferedReader(
                new FileReader(notesDir + "/" + title + ".txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch(IOException e){
            return "Note not found";
        }
        return content.toString();
    }
}
