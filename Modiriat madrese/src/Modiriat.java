import java.util.Scanner;
public class Modiriat {

    static Scanner scanner = new Scanner(System.in);
    public static char ui;
    public static int inputmenue;
    public static void main(String[] args){
        menu();
    }
    public static void menu(){
////////////////////////////////////////////school official menu ///////////////////////////////////////////////////////////
       systemcls();
        System.out.println("1. I'm student"+"\n2. I'm teacher"+"\n3. I'm manager"+"\n4. Exit ");
        System.out.println(" \n --Enter a number:\n");
        inputmenue = scanner.nextInt();

        switch (inputmenue) {
            case 1: {
                supOrIn();
                break;
            }
            case 2:{
               tupOrIn();
                break;
            }
            case 3: {
              mupOrIn();
                break;
            }
            case 4: {
                break;
            }
            default: {
                System.out.println("command was not valid\n");
                menu();
            }
        }
    }
    public static void supOrIn(){
///////////////////////////////////////// student signin and signup///////////////////////////////////////////////////////
        User check = new User();
        System.out.println(" pick one!!\n(if you don't have any account choose \"SIGN UP\" ;  but if you have an account choose \"SIGN IN\". )");
        System.out.println("1. signin \n"+"2. signup"+ "\n3.back to menu\n"+"4.Exit");
        ui = scanner.next().charAt(0);
        scanner.nextLine();
        switch (ui){
            case '1' :{
                check.studentSignIn();
                break;
            }
            case '2' :{
                check.studentSignUp();
                break;
            }
            case '3': {
                menu();
                break;
            }
            case '4':{
                break;
            }
            default: {
                System.out.println("command was not valid\n");
                supOrIn();
            }
        }
    }

    public static void tupOrIn(){
/////////////////////////////////////////teacher signin and signup ///////////////////////////////////////////////////////
        User check = new User();
        System.out.println(" pick one!!\n(if you don't have any account choose \"SIGN UP\" ;  but if you have an account choose \"SIGN IN\". )");
        System.out.println("1. signin \n"+"2. signup"+ "\n3.back to menu\n"+"4.Exit");
        ui = scanner.next().charAt(0);
        scanner.nextLine();
        switch (ui){
            case '1' :{
                check.teacherSignIn();
                break;
            }
            case '2' :{
                check.teacherSignUp();
                break;
            }
            case '3': {
                menu();
                break;
            }
            case '4':{
                break;
            }
            default: {
                System.out.println("command was not valid\n");
                tupOrIn();
            }
        }
    }

    public static void mupOrIn(){
/////////////////////////////////////////manager signin add signup/////////////////////////////////////////////////////////
        User check = new User();
        System.out.println(" pick one!!\n(if you don't have any account choose \"SIGN UP\" ;  but if you have an account choose \"SIGN IN\". )");
        System.out.println("1. signin \n"+"2. signup\n"+ "3.back to menu\n"+"4.Exit");
        ui = scanner.next().charAt(0);
        switch (ui){
            case '1' :{
                check.managerSignIn();
                break;
            }
            case '2' :{
                check.managerSignUp();
                break;
            }
            case '3': {
                menu();
                break;
            }
            case '4':{
                break;
            }
            default: {
                System.out.println("command was not valid\n");
                mupOrIn();
            }
        }

    }

    public static void systemcls() {
/////////////////////////////////////////////////to have clean code/////////////////////////////////////////////////////
        for (int m = 0; m < 25; m++) {
            System.out.println("\n");
        }
    }
}