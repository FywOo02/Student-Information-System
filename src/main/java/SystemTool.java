import java.io.IOException;

/**
 * @Author: Cho
 * @Date: 2022/05/12/0:30
 * @Description: System tool interface
 */
public interface SystemTool {
    public void insertData();
    public void deleteData();
    public void findData();
    public void modifyData();
    public void displayData();
    public void calculateData();
    public void printData() throws IOException;
}
