import java.io.File;
import java.util.Vector;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class User {
////////////////////////////////////////////// user variable////////////////////////////////////////////////////////////
    public static String teacherName, studentName,teaUsername,tealogName;
    public static File mangern , stuName,teaName,stuProperty;
    public static boolean teaLogin,stuLogin;
    public static Vector<String> manager = new Vector<String>();
    public static Vector<String> studentArr = new Vector<String>();
    public static Vector<String> teacherArr = new Vector<String>();
    public static Scanner sc = new Scanner(System.in);
    public static String stuSigninUsername;
//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--

    public static String getStuSigninUsername() {
    return stuSigninUsername;
}

    public static void managerSignUp() {
        String managerName, managerPassword, userName ;
       mangern = new File("managerName.txt");
        if (mangern.exists()) {
            mangern.delete();
        }
        try {
////////////////////////////////////make file & get manager name & write in to the file/////////////////////////////////
            FileWriter myWriter = new FileWriter("managerName.txt",true);

            System.out.println("Hello dear manager!\nplease enter your full name.");
            managerName = sc.next();
            myWriter.write(managerName);
            myWriter.write("\n");
//////////////////////////////////////get username//////////////////////////////////////////////////////////////////////
            System.out.println("please enter your username");
            userName= sc.next();
            myWriter.write(userName);
            myWriter.write("\n");
//////////////////////////////////////get password & write in to the file/////////////////////////////////////////
            System.out.println("please enter your password.");
            managerPassword = sc.next();
            myWriter.write(managerPassword );
            myWriter.write("\n");
/////////////////////////////////////get random number for username/////////////////////////////////////////////////////
            int mId = (int)Math.floor(Math.random()*(1000000000));
            System.out.println("your ID is :\n m"+mId + "\n don't forget your information;)");
            myWriter.write("m"+mId);
            myWriter.close();
            System.out.println("please enter 'm' to go to the menu to sign in.");
            char m = sc.next().charAt(0);
            Modiriat check = new Modiriat();
            switch (m){
                case 'm': {
                    check.mupOrIn();
                    break;
                }
                default: {
                    System.out.println("command was not valid\n");
                }
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static void managerSignIn(){
        readManagerfile();
///////////////////////////////////////get password & user name & check it  for manager sign in/////////////////////////
        System.out.println("Hello dear manager!\nplease enter your User name");
        String username= sc.nextLine();
        System.out.println("please enter your password");
        String password = sc.nextLine();
        Manager login = new Manager();
        if(manager.get(1).equalsIgnoreCase(username) ){
            if(password.equals(manager.get(2))){
                login.managerMenu();
            }
        }
    }

    public static void teacherSignUp(){
        readTeacherfile();
        String userName,password;
        stuProperty = new File("teachersProperty.txt");
        try {
            FileWriter myWriter = new FileWriter("teachersProperty.txt",true);
            boolean signUp = false;
            System.out.println("please enter your full name.");
            teacherName = sc.nextLine();
            for (int i = 0; i < teacherArr.size(); i++) {
                if (teacherArr.get(i).equalsIgnoreCase(teacherName)) {
                    signUp = true;
                }
            }
            if (signUp) {
//////////////////////////////////////get username/////////////////////////////////////////////////////////////////
                myWriter.write( teacherName+":");
                System.out.println("please enter your username.");
                userName = sc.nextLine();
                myWriter.write(userName);
                myWriter.write("/");
//////////////////////////////////////get password & write in to the file/////////////////////////////////////////
                System.out.println("please enter your password.");
                password = sc.nextLine();
                myWriter.write(password);
                myWriter.write("#");
/////////////////////////////////////get random number for username/////////////////////////////////////////////////////
                int tId = (int) Math.floor(Math.random() * (1000000000));
                System.out.println("your ID is :\n t" + tId + "\n don't forget your information;)");
                myWriter.write("t" + tId + "\n");
                myWriter.close();
                System.out.println("please enter 'm' to go to the menu to sign in.");
                char m = sc.next().charAt(0);
                sc.nextLine();
                Modiriat check = new Modiriat();
                switch (m) {
                    case 'm': {
                        check.supOrIn();
                        break;
                    }
                    default: {
                        System.out.println("command was not valid\n");
                    }
                }
            }
            else{
                System.out.println("Your name is not on the student list.\nplease enter a valid name.");
                studentSignUp();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void teacherSignIn(){
///////////////////////////////////////get password & user name & check it  for teacher sign in/////////////////////////
        System.out.println("please enter your username");
        teaUsername = sc.nextLine();
        System.out.println("please enter your password");
        String password = sc.nextLine();
        readTeaPropertyfile("teachersProperty.txt",(teaUsername+"/"+password));
        Teacher login= new Teacher();
        if(teaLogin){
            login.teacherThings();
        }
        else{
            System.out.println("this person is not find.\npress 'a' to try again or press 'b' to back to the menu:");
            String c = sc.nextLine();
            Modiriat ch = new Modiriat();
            switch (c){
                case "a": {
                    teacherSignIn();
                    break;
                }
                case "A":{
                    teacherSignIn();
                    break;
                }
                case "b": {
                    ch.tupOrIn();
                    break;
                }
                case "B": {
                    ch.tupOrIn();
                    break;
                }

            }
        }
    }

    public static void studentSignUp() {
        readStudentfile();
        String userName,password;
        stuProperty = new File("studentsProperies.txt");
        try {
            FileWriter myWriter = new FileWriter("studentsProperies.txt",true);
            boolean signUp = false;
            System.out.println("please enter your full name.");
            studentName = sc.nextLine();
            for (int i = 0; i < studentArr.size(); i++) {
                if (studentArr.get(i).equalsIgnoreCase(studentName)) {
                    signUp = true;
                }
            }
            if (signUp) {
//////////////////////////////////////get username/////////////////////////////////////////////////////////////////
                myWriter.write( studentName+":");
                System.out.println("please enter your username.");
                userName = sc.nextLine();
                myWriter.write(userName);
                myWriter.write("/");
//////////////////////////////////////get password  & write in to the file/////////////////////////////////////////
                System.out.println("please enter your password.");
                password = sc.nextLine();
                myWriter.write(password);
                myWriter.write("#");
/////////////////////////////////////get random number for username/////////////////////////////////////////////////////
                int sId = (int) Math.floor(Math.random() * (1000000000));
                System.out.println("your ID is :\n s" + sId + "\n don't forget your information;)");
                myWriter.write("s" + sId + "\n");
                myWriter.close();
                System.out.println("please enter 'm' to go to the menu to sign in.");
                char m = sc.next().charAt(0);
                sc.nextLine();
                Modiriat check = new Modiriat();
                switch (m) {
                    case 'm': {
                        check.supOrIn();
                        break;
                    }
                    default: {
                        System.out.println("command was not valid\n");
                    }
                }
            }
            else{
                System.out.println("Your name is not on the student list.\nplease enter a valid name.");
                studentSignUp();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void studentSignIn(){
/////////////////////////////////////////////////////check username and password for signin/////////////////////////////
        System.out.println("please enter your username");
        stuSigninUsername = sc.nextLine();
        System.out.println("please enter your password");
        String password = sc.nextLine();
        readStuPropertyFile("studentsProperies.txt",(stuSigninUsername+"/"+password));
        Student login = new Student();
        if(stuLogin){
            login.studentThings();
        }
        else{
            System.out.println("this person is not find.\npress 'a' to try again or press 'b' to back to the menu:");
            String c = sc.next();
            Modiriat ch = new Modiriat();
            switch (c) {
                case "a": {
                    teacherSignIn();
                    break;
                }
                case "A": {
                    teacherSignIn();
                    break;
                }
                case "b": {
                    ch.supOrIn();
                    break;
                }
                case "B": {
                    ch.supOrIn();
                    break;
                }
            }
            }
    }

    public static void readManagerfile()  {
/////////////////////////////////read manager file for signin///////////////////////////////////////////////////
        try {
            mangern = new File("managerName.txt");
            Scanner fileReader = new Scanner(mangern);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                manager.add(data);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readStudentfile(){
/////////////////////////////////read student file  for signup///////////////////////////////////////////////////
        try{
        stuName= new File("studentsName.txt");
            Scanner fileReader = new Scanner( stuName);
            while (fileReader.hasNextLine()) {
               String data = fileReader.nextLine();
                studentArr.add(data);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readTeacherfile(){
////////////////////////////////read teacher file for signup////////////////////////////////////////////////////
        try{
            teaName= new File("teachersName.txt");
            Scanner fileReader = new Scanner( teaName);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                teacherArr.add(data);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readTeaPropertyfile(String fileName,String searchStr) {
//////////////////////////////////////////////////search for teachers pass and user name for sign in////////////////////
        tealogName="";
        teaLogin=false;
        try {
            Scanner scan = new Scanner(new File(fileName));
            while(scan.hasNext()){
                String line = scan.nextLine().toLowerCase().toString();
                if(line.contains(searchStr)){
                    teaLogin=true;
                    for(int i=0;i<line.length();i++){
                        if(line.charAt(i) != ':'){
                            tealogName =tealogName +line.charAt(i);
                        }else {
                            break;
                        }

                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void readStuPropertyFile(String fileName,String searchStr){
//////////////////////////////////////////////////search for student pass and user name for sign in////////////////////
        stuLogin=false;
        try {
            Scanner scan = new Scanner(new File(fileName));
            while(scan.hasNext()){
                String line = scan.nextLine().toLowerCase().toString();
                if(line.contains(searchStr)){
                    stuLogin=true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}