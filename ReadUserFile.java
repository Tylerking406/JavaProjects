import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// Read user file and print the files content
public class ReadUserFile {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in), file;
        System.out.println("Enter Filename:");
        String filename = input.nextLine();

        File f = new File(filename);
        file = new Scanner(f);


        while (file.hasNextLine()){
            System.out.println(file.nextLine());
        }

    }

}
