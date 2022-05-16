import java.io.IOException;

/**
 * @Author: Cho
 * @Date: 2022/05/12/0:30
 * @Description: the test class for project
 */
public class ProjectTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        int count = 0;
        SystemToolImpl test = new SystemToolImpl();
        //test.insertData();
        //test.insertData();
        //test.insertData();aaaa
        //test.deleteData();
        //test.findData();
        //test.modifyData();
        //test.displayData();
        //test.calculateData();
        SystemMenu systemMenu = new SystemMenu();
        systemMenu.welcomeMenu();

        while(StudentInfo.studentInfos[count] != null){
            System.out.println(StudentInfo.studentInfos[count].toString());
            count++;
        }
    }
}
