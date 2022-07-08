import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

    public class Classs {
////////////////////////////////////////////// school variable//////////////////////////////////////////////////////////
        public static Vector<String> clasName = new Vector<String>();
//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--

        public Classs() {
//////////////////////////lessons name for every time that make new class have this are/////////////////////////////////
            File lessName = new File("lessonsName.txt");
            try {
                FileWriter myWriter = new FileWriter("studentsProperies.txt",true);
                myWriter.write("mamathematics\nholy quran\nart\nscience\nlanguage");
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public static void classesName(){
///////////////////////////////////teacher and class nameand write in file////////////////////////////////////////////
            File className = new File("classnames.txt");
            if(className.exists())
                className.delete();
            try {
                FileWriter myWriter = new FileWriter("classnames.txt",true);
                myWriter.write("class1:fatemeh nazari fard\nclass2:fatemeh dehghani\nclass3:mostafa ahmadi" +
                        "\nclass4:mohammad hassan kargar\nclass5:jalil kariman\n");
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void readClassesName(){
//////////////////////////////////////////read class name file//////////////////////////////////////////////////////////
            classesName();
            try{
                File className = new File("classnames.txt");
                Scanner fileReader = new Scanner(className);
                while (fileReader.hasNextLine()) {
                    String data = fileReader.nextLine();
                    clasName.add(data);
                }
                fileReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }