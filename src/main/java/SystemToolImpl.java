import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * @Author: Cho
 * @Date: 2022/05/12/0:31
 * @Description: System tool interface implementation class
 */
public class SystemToolImpl extends StudentInfo implements SystemTool {

    /**
     *  insert Data from user to student information array
     */
    @Override
    public void insertData() {
        StudentInfo student = new StudentInfo();
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the id of student?");
        String id = sc.next();
        student.setStudentId(id);
        System.out.println("What is the name of student?");
        student.setStudentName(sc.next());
        System.out.println("What is student's mark in the final test?");
        double score = sc.nextDouble();
        student.setStudentMark(score);

        // Check the number of elements in array
        int count = checkNumberOfElement();
        // insert element to array
        studentInfos[count] = student;
        Marks[count][0] = id;
        Marks[count][1] = score;
        System.out.println("Inserting successful!");
    }
    /**
     *  delete Data from student information array
     */
    @Override
    public void deleteData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the id of student you want to delete data?");
        String id = sc.next();

        boolean check = false;
        int count = checkNumberOfElement();
        // delete the element of studentInfos
        for(int i=0; i<count; i++){
            if (studentInfos[i].getStudentId().equals(id)){
                for(int j=i; j<count; j++) {
                    studentInfos[j] = studentInfos[j + 1];
                    check = true;
                }
            }
        }
        // exception check
        if(!check)
            System.out.println("Cannot find specified id");
        else
            System.out.println("Deleting successful!");
    }

    /**
     *  search Data from student information array
     */
    @Override
    public void findData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the id of student that the data you want to search?");
        String id = sc.next();
        int count = checkNumberOfElement();
        boolean check = false;
        // iterate array and find out the specified element
        System.out.printf("%s %8s %8s","ID","Name","Mark");
        for(int i=0; i<count; i++){
            if(studentInfos[i].getStudentId().equals(id)){
                System.out.printf("%s %8s %8s%n",studentInfos[i].getStudentId(),
                        studentInfos[i].getStudentName(),
                        String.valueOf(studentInfos[i].getStudentMark()));
            }
        }
        // exception check
        if(check){
            System.out.println("Cannot find the id");
        }
    }

    /**
     *  modify Data from student information array
     */
    @Override
    public void modifyData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the id of student that data you want to modify?");
        String id = sc.next();
        int count = checkNumberOfElement();
        // iterate the array and modify the element
        for(int i=0; i<count; i++){
            if (studentInfos[i].getStudentId().equals(id)){
                System.out.println("What is the id of student?");
                studentInfos[i].setStudentId(sc.next());
                System.out.println("What is the name of student?");
                studentInfos[i].setStudentName(sc.next());
                System.out.println("What is the mark of student?");
                studentInfos[i].setStudentMark(sc.nextDouble());
            }
        }
        System.out.println("Modifying successful!");
    }

    /**
     *  display Data from student information array
     */
    @Override
    public void displayData() {
        int count = checkNumberOfElement();
        //using bubble sort to implement
        for(int i=0; i<count-1; i++){
            for(int j=i+1; j<count; j++){
                if(studentInfos[i].getStudentMark()>studentInfos[j].getStudentMark()){
                    StudentInfo temp = studentInfos[i];
                    studentInfos[i] = studentInfos[j];
                    studentInfos[j] = temp;
                }
            }
        }
        System.out.printf("%s %8s %8s%n","ID","Name","Mark");
        for (int k=0; k<count; k++){
            System.out.printf("%s %8s %8s%n",studentInfos[k].getStudentId(),
                    studentInfos[k].getStudentName(),
                    String.valueOf(studentInfos[k].getStudentMark()));
        }
    }


    /**
     * calculate the average mark of students
     */
    @Override
    public void calculateData() {
        int count = checkNumberOfElement();
        double sum = 0;
        for(int i=0; i<count; i++){
            sum = sum+ Double.parseDouble(Marks[i][1].toString());
        }
        System.out.println("The average mark of students is "+Math.round(sum/count*100)/100.0);
    }

    /**
     * print the data to another file
     */
    @Override
    public void printData() throws IOException {
        int count = checkNumberOfElement();
        PrintWriter printWriter = new PrintWriter(new FileWriter("StudentInfo.txt"));
        printWriter.printf("%s %8s %8s%n","ID","Name","Mark");
        for(int i=0; i<count; i++){
            printWriter.printf("%s %8s %8s%n",studentInfos[i].getStudentId(),
                    studentInfos[i].getStudentName(),
                    String.valueOf(studentInfos[i].getStudentMark()));
        }
        printWriter.close();
        System.out.println("printing successful!");
    }

    /**
     * a method for checking the number of element in array
     * @return
     */
    public int checkNumberOfElement(){
        int count = 0;
        for(int i=0; i<studentInfos.length; i++){
            if(studentInfos[i] != null)
                count++;
            else
                break;
        }
        return count;
    }
}
