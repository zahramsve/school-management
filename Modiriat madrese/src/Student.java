import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Student {
////////////////////////////////////////////// student variable/////////////////////////////////////////////////////////
    public static Scanner sc = new Scanner(System.in);
    public static File pay;
    public static String namx;
    public static double payment=100000;
    public static double remain=800000;
    public static Vector<String> stpay = new Vector<String>();
//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--

    public static void studentThings(){
//////////////////////////////////////////////////student menu//////////////////////////////////////////////////////////
       System.out.println("1. lessons\n2. Payments made\n3. Remaining payments\n4. report card\n5. pay money\n6. Exit");

       int x= sc.nextInt();
       sc.nextLine();
       switch (x){
           case 1:{
////////////////////////////////////////////////show lessons that student have//////////////////////////////////////////
               Lesson n= new Lesson();
               n.readLessonsName();
               for(int i=0;i<Lesson.lessonName.size();i++){
                   System.out.println(Lesson.lessonName.get(i));
               }
               System.out.println("please enter any key to back to the menu");
               String y=sc.nextLine();
               studentThings();
               break;
           }
           case 2:{
/////////////////////////////////////////money that student payed///////////////////////////////////////////////////////
               readPayfile();
               String change="";
               String change2="";
               stnm();
                for(int i=0;i<stpay.size();i++){//chek vecttor that students name and money that they payed in that
                   if(stpay.get(i).contains(namx))
                        change = stpay.get(i);//cast home that student name in that
               }
                for(int i=0;i<change.length();i++){
                   if(change.charAt(i)==':'){//get money that student payed
                       for(int j=i+1;j<change.length();j++){
                           change2+=change.charAt(j);
                       }
                   }

                }
               payment= Double.parseDouble(change2);
               System.out.println(payment);
               System.out.println("please enter any key to back to the menu");
               String y=sc.nextLine();
               studentThings();
               break;
           }
           case 3:{
//////////////////////////////////////////////show pay that student must pay////////////////////////////////////////////
               remain=remain-payment;
               System.out.println(remain);
               System.out.println("please enter any key to back to the menu");
               String y=sc.nextLine();
               studentThings();
               break;
           }
           case 4:{
/////////////////////////////////////////////show student score that teacher entered////////////////////////////////////
               Teacher karname = new Teacher();
               karname.readScoreRecord();
               stnm();
               for(int i=0;i<Teacher.scorekarname.size();i++){
                   if(Teacher.scorekarname.get(i).contains(namx))
                   System.out.println(Teacher.scorekarname.get(i));
               }
               System.out.println("these are every score of lessons that teacher entered." +
                       "\nif any lesson is not here it mean that teacher does't entered that.");
               System.out.println("please enter any key to back to the menu");
               String y=sc.nextLine();
               studentThings();
               break;
           }
           case 5:{
//////////////////////////////////////pay how much money that student want to pay///////////////////////////////////////
               System.out.println("you must pay 800000 and you payed "+remain+"right now");
               System.out.println("please enter money that you payed");
               double m= sc.nextDouble();
               payment+=m;
               writing();
               System.out.println("successed...");
               System.out.println("please enter any key to back to the menu");
               String y=sc.nextLine();
               studentThings();
               break;
           }
           case 6:{
               break;
           }
           default:{
               studentThings();
           }
       }
    }

    public static void readPayfile(){
//////////////////////////////////////read file that student pay is in that/////////////////////////////////////////////
        pay= new File("StudentPay.txt");
        try {
            Scanner fileReader = new Scanner( pay);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                stpay.add(data);
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void stnm(){
///////////////////////use student username that student signin with that to findout his/her name///////////////////////
         namx ="";
        File rea= new File("studentsProperies.txt");
        try {
            User n= new User();
            Scanner fileReader = new Scanner( rea);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                if(data.contains(n.getStuSigninUsername())){
                    for(int i=0;i<data.length();i++){
                        if(data.charAt(i)!=':'){
                            namx +=data.charAt(i);
                        }
                        else
                            break;
                    }
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writing(){
///////////////////////////////////write student name and money that payed in to the file///////////////////////////////
        stnm();
        readPayfile();
        for(int i=0;i<stpay.size();i++){
            if(stpay.get(i).contains(namx)){
                stpay.set(i,(namx+":"+payment));
                pay.delete();
                File create = new File("StudentPay.txt");
                if(create.exists())
                    create.delete();
                try {
                    FileWriter myWriter = new FileWriter("StudentPay.txt",true);
                    for(int j=0;j<stpay.size();j++){
                        myWriter.write(stpay.get(j)+"\n");
                    }
                    myWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}