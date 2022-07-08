import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Manager extends User{
    ////////////////////////////////////////////// manager variable/////////////////////////////////////////////////////
    public static File schoolPro,stuproName;
    public static String schoolName, schoolType, addName,clas;
    public static Scanner sc = new Scanner(System.in);
    public static Vector<String> stuproArr = new Vector<String>();
    public static void managerMenu() {
        Modiriat system= new Modiriat();
        system.systemcls();
///////////////////////////////////////////manager menu/////////////////////////////////////////////////////////////////
        System.out.println("1.School property" + "\n2. add student" + "\n3. remove student" +
                "\n4. choose student class" + "\n5. show student classmates" + "\n6. show student teacher" +
                "\n7. show student score" + "\n8. show Student payments" + "\n9. edit student Specifications" +
                "\n10.search student" + "\n11.show school income and expenses" + "\n12.show teacher income" +
                "\n13.Exit");
//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--

        System.out.println(" \n --Enter a number:\n");
        int inputmenu = sc.nextInt();
        sc.nextLine();
        switch (inputmenu) {
            case 1: {
//////////////////////////////////////////show or enter school property/////////////////////////////////////////////////
                System.out.println("1. show property\n2. edit property\n3. back");
                int input = sc.nextInt();
                sc.nextLine();
                switch (input){
                    case 1 :{
                        School schpr = new School();
                        schpr.schoolPro();
                        System.out.println("\n please enter any key to back to the menu.");
                        String e = sc.next();
                        managerMenu();
                        break;
                    }
                    case 2 :{
//////////////////////////////////////////import school name and type and write them into the file//////////////////////
                        schoolPro = new File("schoolProperty.txt");
                        try {
                            FileWriter myWriter = new FileWriter("schoolProperty.txt");
                            System.out.println("please enter school name:");
                            schoolName = sc.nextLine();
                            myWriter.write(schoolName+"\n");
                            System.out.println("please enter school type:");
                            schoolType = sc.nextLine();
                            myWriter.write(schoolType);
                            System.out.println("school property saved successfully.");
                            myWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("please enter 'E' to back to the menu.");
                        String e = sc.next();
                        sc.nextLine();
                        switch (e) {
                            case "e": {
                                managerMenu();
                                break;
                            }
                            case "E": {
                                managerMenu();
                                break;
                            }
                            default: {
                                System.out.println("command was not valid\n");
                            }
                        }
                        break;
                    }
                    case 3 :{
                        managerMenu();
                        break;
                    }
                }
                break;
            }

            case 2: {
//////////////////////////////////////////get students name to write in file////////////////////////////////////////////
                try {
                    FileWriter myWriter = new FileWriter("studentsName.txt", true);
                    System.out.println("please enter student name:\n (for stop adding and back to menu press '1'.)");
                    while (!addName.equals("1")) {
                        addName = sc.nextLine();
                        if (addName.contains("1")) {
                            System.out.println("please go to the 'choose student class' to choose student class.");
                            managerMenu();
                        } else {
                            myWriter.write(addName+"\n");
                        }

                    }
                    myWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("\n please enter any key to back to the menu.");
                String e = sc.next();
                managerMenu();
                break;
            }

            case 3: {
///////////////////////////////////get student name and search in to the file if exist delete it////////////////////////
                File remove = new File("studentsName.txt");
                System.out.println("please enter student name that you want to remove that:");
                String removestu = sc.nextLine();
                boolean find=false;
                readStudentfile();
                for(int i=0;i< User.studentArr.size();i++){
                    if(studentArr.get(i).equalsIgnoreCase(removestu)){//check student name is equal to students name in file
                        readStuPro();
                        find=true;
                        studentArr.set(i,null);//replace student name to null
                        remove.delete();
                        File create = new File("studentsName.txt");
                        try {
                            FileWriter myWriter = new FileWriter("studentsName.txt",true);
                            for(int j=0;j<studentArr.size();j++){
                                if(studentArr.get(j)==null){
                                    continue;
                                }
                                myWriter.write(studentArr.get(j)+"\n");

                            }
                            myWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
                if (find) {//also delete student name from student properties and delete name and pass... from file
                    for(int x=0;x<stuproArr.size();x++){
                        if( stuproArr.get(x).contains(removestu)) {
                            stuproArr.set(x,null);
                            stuproName.delete();
                            File createPro = new File("studentsProperies.txt");
                            try {
                                FileWriter Writer = new FileWriter("studentsProperies.txt",true);
                                for(int y=0; y<stuproArr.size(); y++){
                                    if(stuproArr.get(y)==null){
                                        continue;
                                    }
                                    Writer.write( stuproArr.get(y));
                                }  Writer.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    System.out.println("student deleted successfully.\nplease enter 'b' to back to the menu.");
                    String b = sc.nextLine();
                    switch (b){
                        case "b": {
                            managerMenu();
                        }
                        case "B":{
                            managerMenu();
                        }
                        default:{
                            System.out.println("command was not valid\n");
                        }
                    }
                }
              else {
                    System.out.println("student doesn't found.\nplease enter 'b' to back to the menu.");
                    String b = sc.nextLine();
                    switch (b){
                        case "b": {
                            managerMenu();
                        }
                        case "B":{
                            managerMenu();
                        }
                    }
                }
                break;
            }

            case 4: {
///////////////////////////////////////////set student to one class/////////////////////////////////////////////////////
                System.out.println("please enter class name:");
                String class_name = sc.nextLine();
                Classs checkClass = new Classs();
                checkClass.readClassesName();
                for (int i = 0; i < Classs.clasName.size(); i++) {
                    if (Classs.clasName.get(i).contains(class_name)) {
                        System.out.println("please enter students name:");
                           String getName = sc.nextLine();
                            readStudentfile();
///////////////////////////////////write students in file///////////////////////////////////////////////////////////////
                            for (int j = 0; j < studentArr.size(); j++) {
                                if (studentArr.get(j).contains(getName)) {
                                    File stuclas = new File("studentClasses.txt");
                                    try {
                                        FileWriter myWriter = new FileWriter("studentClasses.txt",true);
                                        myWriter.write(Classs.clasName.get(i)+"/"+studentArr.get(j)+"#\n");
                                        myWriter.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                System.out.println("student registrated in to the class successfully.");
                            }


                    }

                }
                    System.out.println("class not exist\n please enter 'E' to back to the menu.");
                    String e = sc.next();
                    sc.nextLine();
                    switch (e) {
                        case "e": {
                            managerMenu();
                            break;
                        }
                        case "E": {
                            managerMenu();
                            break;
                        }
                        default: {
                            System.out.println("command was not valid\n");
                        }

                    }

                break;
            }

            case 5: {
///////////////////////////////////////// check student class to show his or her classmates/////////////////////////////
                System.out.println("please enter student name:");
                String st= sc.nextLine();
                readStudentfile();
                for (int i = 0; i < studentArr.size(); i++) {
                    if (studentArr.get(i).contains(st)){
                        try {

                            File stuclasName= new File("studentClasses.txt");
                            Scanner fileReader = new Scanner(stuclasName);
                            while (fileReader.hasNextLine()) {
                                String data = fileReader.nextLine();
                                clas="";
                                boolean ch=false;
                                if(data.contains(st)){
                                    ch=true;
                                    for(int j=0;j<10;j++){
                                        if (data.charAt(j) != ':'){
                                            clas=clas+data.charAt(j);
                                        }
                                        else{
                                            break;
                                        }
                                    }
                                }
                                if(ch){
                                    try {
                                    File stucclasName= new File("studentClasses.txt");
                                    Scanner fileeReader = new Scanner(stucclasName);
                                    while (fileeReader.hasNextLine()) {
                                        String data1 = fileeReader.nextLine();
                                        if(data1.contains(clas)){
                                            for(int j=0;j<data1.length();j++){
                                                if(data1.charAt(j)=='/'){
                                                    String stclm="";
                                                    for(int x=j+1;x<data1.length();x++){
                                                        if (data1.charAt(x) != '#'){
                                                            stclm=stclm+data1.charAt(x);
                                                        }
                                                        else
                                                            break;
                                                    }
                                                    System.out.println(st+" classmates:\n"+stclm+"\n");
                                                }
                                            }
                                        }
                                    }
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }
                                }
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }

                    }
                }
                System.out.println("\n please enter any key to back to the menu.");
                String e = sc.next();
                managerMenu();
                break;
            }

            case 6: {
//////////////////////////////////////////check student class to show student teacher///////////////////////////////////
                System.out.println("please enter student name:");
                String st= sc.nextLine();
                try {
                    File stuclasName= new File("studentClasses.txt");
                    Scanner  fileReader = new Scanner(stuclasName);
                    while (fileReader.hasNextLine()) {
                        String data = fileReader.nextLine();
                        if(data.contains(st)){
                            String stutea="";
                            for(int i=0;i<data.length();i++){
                                if(data.charAt(i)==':'){
                                    for(int j=i+1;j<data.length();j++){
                                        if(data.charAt(j)!='/'){
                                            stutea=stutea+data.charAt(j);
                                        }
                                        else
                                            break;
                                    }
                                }

                            }
                            System.out.println("teacher name:"+stutea);
                            System.out.println("\n please enter any key to back to the menu.");
                            String e = sc.next();
                            managerMenu();
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                break;
            }

            case 7: {
/////////////////////////////check score file and write student number that teacher entered/////////////////////////////
                System.out.println("please enter student name:");
                String n=sc.nextLine();
                Teacher karname = new Teacher();
                karname.readScoreRecord();
                for(int i=0;i<Teacher.scorekarname.size();i++){
                    if(Teacher.scorekarname.get(i).contains(n)){
                        System.out.println(Teacher.scorekarname.get(i));
                    }
                }
                System.out.println("these are every score of lessons that teacher entered." +
                        "\nif any lesson is not here it mean that teacher does't entered that.");
                System.out.println("please enter any key to back to the menu");
                String y=sc.nextLine();
                managerMenu();
                break;
            }

            case 8: {
//////////////////////////////////check student class to check how much money that he/she payed/////////////////////////
                System.out.println("please enter student name:");
                String n=sc.nextLine();
                Student ps=new Student();
                ps.readPayfile();
                System.out.println("please enter student name:");
                for(int i=0;i< Student.stpay.size();i++){
                    if(Student.stpay.get(i).contains(n)){
                        System.out.println(Student.stpay.get(i));
                    }
                }
                break;
            }

            case 9: {
//////////////////////////////////////edit student name or username/////////////////////////////////////////////////////
                System.out.println("please enter student name that you want to edit:");
                String edit=sc.nextLine();
                readStudentfile();
                for (int i = 0; i < studentArr.size(); i++) {
                    if (studentArr.get(i).equalsIgnoreCase(edit)) {

                                System.out.println("please enter name that you want want replace to old name:");
                               String newName =sc.nextLine();
                                studentArr.set(i,newName);
                                stuName.delete();
                                File remove = new File("studentsName.txt");
                                try {
                                    FileWriter myWriter = new FileWriter("studentsName.txt",true);
                                    for(int j=0; j<studentArr.size();j++) {
                                        myWriter.write( studentArr.get(j)+"\n");
                                        myWriter.close();
                                    }
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                }
                                break;
                        }

                    }
                        break;
            }

            case 10: {
///////////////////////////////////check file to figerout that student exist or not/////////////////////////////////////
                System.out.println("\n please enter student name or ID who you want to found it.");
                String found =sc.nextLine();
                readStudentfile();
                boolean foundCh=false;
                for (int i = 0; i < studentArr.size(); i++) {
                    if (studentArr.get(i).equalsIgnoreCase(found)) {
                        System.out.println("student is found:"+studentArr.get(i));
                        foundCh=true;
                        break;
                    }
                }
                if(!foundCh){
                    readStuPropertyFile("studentsProperies.txt",found);
                        if(stuLogin){
                            System.out.println("student is found.");
                    }
                        else{
                            System.out.println("student not found.");
                        }
                }
                System.out.println("\n please enter 'E' to back to the menu.");
                String e = sc.next();
                sc.nextLine();
                switch (e) {
                    case "e": {
                        managerMenu();
                        break;
                    }
                    case "E": {
                        managerMenu();
                        break;
                    }
                    default: {
                        System.out.println("command was not valid\n");
                    }

                }
                break;
            }

            case 11: {
//////////////////////////////////////show school income and expenditures///////////////////////////////////////////////
                School inc = new School();
                inc.incomeCheck();
                School exp = new School();
                exp.expendituresCheck();
                System.out.println("\n please enter 'E' to back to the menu.");
                String e = sc.next();
                sc.nextLine();
                switch (e) {
                    case "e": {
                        managerMenu();
                        break;
                    }
                    case "E": {
                        managerMenu();
                        break;
                    }
                    default: {
                        System.out.println("command was not valid\n");
                    }

                }
                break;
            }

            case 12: {
///////////////////////search that teacher is exist or not and if exist show his/her income/////////////////////////////
                readTeacherfile();
                System.out.println("please enter teacher name:");
                String tean =sc.nextLine();
                for(int i=0;i< teacherArr.size();i++) {
                    if (teacherArr.get(i).equalsIgnoreCase(tean)){
                        System.out.println("-=-="+teacherArr.get(i)+" income is: 500000");
                    }
                }
                System.out.println("\n please enter 'E' to back to the menu.");
                String e = sc.next();
                sc.nextLine();
                switch (e) {
                    case "e": {
                        managerMenu();
                        break;
                    }
                    case "E": {
                        managerMenu();
                        break;
                    }
                    default: {
                        System.out.println("command was not valid\n");
                    }

                }
                break;
            }

            case 13: {
/////////////////////////////////back to first menu/////////////////////////////////////////////////////////////////////
                Modiriat go= new Modiriat();
                go.menu();
                break;
            }

            default: {
                System.out.println("command was not valid\n");
                managerMenu();
            }
        }
    }
    public static void readStuPro(){
//////////////////////////read student name and pass and username file for s.th that we see them up/////////////////////
        try{
            stuproName= new File("studentsProperies.txt");
            Scanner fileReader = new Scanner(stuproName);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                stuproArr.add(data);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}