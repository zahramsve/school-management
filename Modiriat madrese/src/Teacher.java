import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Teacher extends User {
////////////////////////////////////////////// teacher variable/////////////////////////////////////////////////////////
    public static Vector<String> studentTeacherArr = new Vector<String>();
    public static Vector<String> scorekarname = new Vector<String>();
    public static String stuteaName;
//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--

    public static void teacherThings() {
//////////////////////////////////////////////show teacher properties///////////////////////////////////////////////////
        User teaUser = new User();
        User teaNa = new User();
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Name: " + teaNa.tealogName);
        System.out.println("Username: " + teaUser.teaUsername + "\nincome: 500000");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("1. Record scores\n2. teacher classes\n3. Exit");
        int x = sc.nextInt();
        sc.nextLine();
        switch (x) {
            case 1: {
                scoreRecord();
                break;
            }
            case 2:{
//////////////////////////////////////////////show teacher classes//////////////////////////////////////////////////////
                 User teacls = new User();
                 File stuclasName= new File("studentClasses.txt");
                 String clasnam = null;
                try {
                   Scanner  fileReader = new Scanner(stuclasName);
                while (fileReader.hasNextLine()) {
                    String data = fileReader.nextLine();
                    boolean m=false;
                    if (data.contains(teacls.tealogName)) {
                        m=true;
                        for (int i = 0; i < data.length(); i++) {
                            if (data.charAt(i) != ':') {
                                clasnam += data.charAt(i);
                            } else
                                break;
                        }
                        System.out.println("class name: "+clasnam);
                    }
                    if(m){
                        break;
                    }
                }
                  } catch (FileNotFoundException e) {
                      e.printStackTrace();
                  }


                break;
            }
            case 3:{
                break;
            }
            default:{
                System.out.println("command was not valid\n");
                teacherThings();
            }
        }
    }

    public static void scoreRecord(){
//////////////////////////entered student scores of each lessons by teacher & write into the file///////////////////////
        readteast();
        double score=0;
        System.out.println("please enter student that you want to get score:");
        String nam=sc.nextLine();
        for(int i=0;i<studentTeacherArr.size();i++) {
            if (studentTeacherArr.get(i).equalsIgnoreCase(nam)) {
                Lesson lesn = new Lesson();
                lesn.readLessonsName();
                System.out.println("please choose lesson number:(and enter any key exept lesson number to back to the menu.)");
                for(int j=0;j<Lesson.lessonName.size();j++){
                    System.out.println(Lesson.lessonName.get(j));
                }
                int f = sc.nextInt();
                switch (f){
                    case 1 : {
                        System.out.println("please enter score:");
                        score = sc.nextDouble();
                        sc.nextLine();
                        try {
                            FileWriter myWriter = new FileWriter("studentScore.txt", true);
                            myWriter.write(nam + ":" + Lesson.lessonName.get(0) + "===>" + score + "\n");
                            myWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("score registrated successfully.");
                        break;
                    }
                    case 2 :{
                        System.out.println("please enter score:");
                        score = sc.nextDouble();
                        sc.nextLine();
                        try {
                            FileWriter myWriter = new FileWriter("studentScore.txt", true);
                            myWriter.write(nam + ":" + Lesson.lessonName.get(1) + "===>" + score + "\n");
                            myWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("score registrated successfully.");
                        break;
                    }
                    case 3 :{
                        System.out.println("please enter score:");
                        score = sc.nextDouble();
                        sc.nextLine();
                        try {
                            FileWriter myWriter = new FileWriter("studentScore.txt", true);
                            myWriter.write(nam + ":" + Lesson.lessonName.get(2) + "===>" + score + "\n");
                            myWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("score registrated successfully.");
                        break;
                    }
                    case 4 :{
                        System.out.println("please enter score:");
                        score = sc.nextDouble();
                        sc.nextLine();
                        try {
                            FileWriter myWriter = new FileWriter("studentScore.txt", true);
                            myWriter.write(nam + ":" + Lesson.lessonName.get(3) + "===>" + score + "\n");
                            myWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("score registrated successfully.");
                        break;
                    }
                    case 5 :{
                        System.out.println("please enter score:");
                        score = sc.nextDouble();
                        sc.nextLine();
                        try {
                            FileWriter myWriter = new FileWriter("studentScore.txt", true);
                            myWriter.write(nam + ":" + Lesson.lessonName.get(4) + "===>" + score + "\n");
                            myWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("score registrated successfully.");
                        break;
                    }
                    default:{
                        teacherThings();
                    }
                }
            }
        }
        System.out.println("please enter 'E' to back to the menu & enter 'A' to add another score.");
        String e = sc.next();
        sc.nextLine();
        switch (e) {
            case "e": {
                teacherThings();
                break;
            }
            case "E": {
                teacherThings();
                break;
            }
            case "a": {
                scoreRecord();
                break;
            }
            case "A": {
                scoreRecord();
                break;
            }
            default: {
                System.out.println("command was not valid\n");
            }
        }
    }

    public static void readteast(){
///////////////////////////////////read file to figure out teacher students/////////////////////////////////////////////
           User teach = new User();
           stuteaName="";
        try {
             File stuclasName= new File("studentClasses.txt");
                 Scanner  fileReader = new Scanner(stuclasName);
            while (fileReader.hasNextLine()){
                   String data = fileReader.nextLine();
                   if(data.contains(teach.tealogName))  {
                       for(int i=0;i<data.length();i++){
                           if(data.charAt(i)=='/'){
                               for(int j=i+1;j<data.length();j++){
                                   if(data.charAt(j)!='#'){
                                      stuteaName+= data.charAt(j);
                                   }
                                   else
                                       break;
                               }
                                 studentTeacherArr.add(stuteaName);
                           }
                       }
                   }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readScoreRecord(){
//////////////////////////////////////////read file that students score is in that//////////////////////////////////////
             try{
                        File scr= new File("studentScore.txt");
                        Scanner fileReader = new Scanner( scr);
                        while (fileReader.hasNextLine()) {
                            String data = fileReader.nextLine();
                            scorekarname.add(data);
                        }
                        fileReader.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
       }

}