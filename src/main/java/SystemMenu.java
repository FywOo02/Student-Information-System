import java.io.IOException;
import java.util.Scanner;

/**
 * @Author: Cho
 * @Date: 2022/05/12/0:30
 * @Description: class for designing the program menu
 */
public class SystemMenu extends StudentInfo{
    public void welcomeMenu() throws InterruptedException, IOException {
        SystemToolImpl tool = new SystemToolImpl();
        boolean check = false;
        String decision = "";
        Scanner sc = new Scanner(System.in);

        //Use the concept of circulation to design interactive programs
        while(!check){
            mainMenuWord();
            switch (sc.nextInt()){
                case 1:
                    tool.insertData();
                    while (true){
                        System.out.println("Press Y to continue inserting; Press N to go back main menu.");
                        decision = sc.next();
                        if(decision.equals("Y")){
                            tool.insertData();
                        } else if (decision.equals("N")) {
                            welcomeMenu();
                        }
                    }

                case 2:
                    if(studentInfos[0] == null) {
                        noParameterException();
                    }else {
                        tool.deleteData();
                        while (true){
                            System.out.println("Press Y to continue deleting; Press N to go back main menu.");
                            decision = sc.next();
                            if(decision.equals("Y")){
                                tool.deleteData();
                            } else if (decision.equals("N")) {
                                welcomeMenu();
                            }
                        }
                    }

                case 3:
                    if(studentInfos[0] == null) {
                        noParameterException();
                    }else {
                        tool.findData();
                        while (true){
                            System.out.println("Press Y to search another data; Press N to go back main menu.");
                            decision = sc.next();
                            if(decision.equals("Y")){
                                tool.findData();
                            } else if (decision.equals("N")) {
                                welcomeMenu();
                            }
                        }
                    }
                case 4:
                    if(studentInfos[0] == null) {
                       noParameterException();
                    }else {
                        tool.modifyData();
                        while (true){
                            System.out.println("Press Y to modify another data; Press N to go back main menu.");
                            decision = sc.next();
                            if(decision.equals("Y")){
                                tool.modifyData();
                            } else if (decision.equals("N")) {
                                welcomeMenu();
                            }
                        }
                    }
                case 5:
                    if(studentInfos[0] == null) {
                       noParameterException();
                    }else {
                        tool.displayData();
                        System.out.println("Press N to go back main menu.");
                        decision = sc.next();
                        if (decision.equals("N"))
                            welcomeMenu();
                    }
                case 6:
                    if(studentInfos[0] == null) {
                        noParameterException();
                    }else {
                        tool.calculateData();
                        System.out.println("Press N to go back main menu.");
                        decision = sc.next();
                        if (decision.equals("N"))
                            welcomeMenu();
                    }
                case 7:
                    if(studentInfos[0] == null) {
                        noParameterException();
                    }else {
                        tool.printData();
                        System.out.println("Press N to go back main menu.");
                        decision = sc.next();
                        if (decision.equals("N"))
                            welcomeMenu();
                    }
                case 8:
                    System.out.println("Thank you for using Student Information System");
                    System.exit(0);
                default:
                    System.out.println("Value error, please enter again");
                    Thread.sleep(1000);
            }
        }
    }
    public void mainMenuWord(){
        System.out.println("****************************************************************************************************");
        System.out.println("Welcome to use the Student Information System.");
        System.out.println("Please follow the instructions below to hit the number on your keyboard to perform the operation.");
        System.out.println("1. insert a student's information");
        System.out.println("2. delete a student's information");
        System.out.println("3. search a student's information");
        System.out.println("4. modify a student's information");
        System.out.println("5. display all information of students(Ascending Order By Mark)");
        System.out.println("6. find the average mark of students");
        System.out.println("7. print all information of students to another file");
        System.out.println("8. exit");
        System.out.println("****************************************************************************************************");
        System.out.println();
    }
    public void noParameterException() throws InterruptedException, IOException {
        Scanner sc = new Scanner(System.in);
        String decision = "";
            System.out.println("There is not any recording in system, please insert the information and try again.");
            System.out.println("Press N to go back main menu.");
            decision = sc.next();
            if(decision.equals("N"))
                welcomeMenu();
    }
}
