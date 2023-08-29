import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import static java.nio.file.StandardOpenOption.CREATE;
public class PersonReader
{
    private static ArrayList<String> lines = new ArrayList<>();
    public static void main(String[] args)
    {
        JFileChooser fileChooser = new JFileChooser();
        File chosenFile;
        String readLine = "";
        String columnTitle1 = "ID#";
        String columnTitle2 = "Firstname";
        String columnTitle3 = "Lastname";
        String columnTitle4 = "Title";
        String columnTitle5 = "YOB";
        String str = "";

        try
        {
            File workingDirectory = new File(System.getProperty("user.dir"));
            fileChooser.setCurrentDirectory(workingDirectory);
            if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                chosenFile = fileChooser.getSelectedFile();
                Path file = chosenFile.toPath();
                InputStream stream = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader fileReader = new BufferedReader(new InputStreamReader(stream));
                //str = String.format("%s%d", columnTitle1);
                System.out.println(str);
                System.out.println(String.format("%s %13s %s %s %s",columnTitle1, columnTitle2, columnTitle3, columnTitle4, columnTitle5));
                for(int i = 0; i < 40; i++ )
                {
                    System.out.print("=");
                }
                while(fileReader.ready())
                {
                    readLine = fileReader.readLine();
                    System.out.printf("\n%s", readLine);
                    //System.out.printf("\nLine %4d %-60s ", readLine);
                }
                fileReader.close();
                System.out.println("\n\nData file has been opened and read!");
            }
            else
            {
                System.out.println("Failed to choose a file to process");
                System.out.println("Run the program again!");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}