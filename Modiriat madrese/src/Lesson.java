import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Lesson {
////////////////////////////////////////////// lessen variable//////////////////////////////////////////////////////////
    public static Vector<String> lessonName = new Vector<String>();
//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--

    public static void lessonsName(){
/////////////////////////////////////////////write lesson name in file//////////////////////////////////////////////////
        File lessName = new File("lessonsName.txt");
        if(lessName.exists())
            lessName.delete();
        try {
            FileWriter myWriter = new FileWriter("lessonsName.txt",true);
            myWriter.write("mamathematics\nholy quran\nart\nscience\nlanguage");
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readLessonsName(){
/////////////////////////////////////////////read lesson name from file/////////////////////////////////////////////////
        lessonsName();
        File stuclasName= new File("lessonsName.txt");
        try {
            Scanner  fileReader = new Scanner(stuclasName);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                lessonName.add(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}