import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class School extends User{
////////////////////////////////////////////// school variable/////////////////////////////////////////////////////////
    public static double income,expenditures;
    private Vector<String> schoolProArr = new Vector<String>();
    private Vector<String> modirProArr = new Vector<String>();
    private File SchoolName,modirName;
//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--

    public void schoolPro(){
//////////////////////////////////////////////show school property//////////////////////////////////////////////////////
        readSchoolPro();
        System.out.println("school name: "+schoolProArr.get(0)+"\nschool type: "+schoolProArr.get(1)+"\nmanager name: "+modirProArr.get(0)+"\n\n");
    }
    public void incomeCheck(){
///////////////////////////////////////////set income///////////////////////////////////////////////////////////////////
        readStudentfile();
        income=studentArr.size()*800000;
        System.out.println("the income is: "+income);
    }

    public void expendituresCheck(){
///////////////////////////////////////////set expenditures/////////////////////////////////////////////////////////////
        readTeacherfile();
        expenditures=teacherArr.size()*500000;
        System.out.println("the expenditures is: "+expenditures);
    }

    public void readSchoolPro(){
        try{
             SchoolName= new File("schoolProperty.txt");
            Scanner fileReader = new Scanner(  SchoolName);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                schoolProArr.add(data);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try{
            modirName= new File("managerName.txt");
            Scanner fileReader = new Scanner(modirName);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                modirProArr.add(data);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}