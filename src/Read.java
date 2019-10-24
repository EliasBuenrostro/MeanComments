import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Read {
    public static void main(String[] args) {
        //TODO: write code to convert to arrayList of words
        //TODO: Return a string list of derrogatory words in the corpi
        String groupOfWords = readFileAsString("bad-words.txt");
        ArrayList<String> words = makeArrayList(groupOfWords);
    }

    private static ArrayList<String> makeArrayList(String groupOfWords){
        ArrayList<String> words = new ArrayList<>();
        Scanner scanner;
        StringBuilder output = new StringBuilder();
        scanner = new Scanner(groupOfWords);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            output.append(line.trim() + "\n");
            words.add(line);
        }
        return words;
    }
    private static String readFileAsString(String filename) {
        Scanner scanner;
        StringBuilder output = new StringBuilder();

        try {
            scanner = new Scanner(new FileInputStream(filename), "UTF-8");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                output.append(line.trim()+"\n");
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found " + filename);
        }

        return output.toString();
    }
}
