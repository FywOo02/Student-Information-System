/**
 * @Author: Cho
 * @Date: 2022/05/12/0:30
 * @Description: Student information encapsulation class
 */
public class StudentInfo {
    private String studentId;
    private String studentName;
    private double studentMark;
    public  static StudentInfo[] studentInfos = new StudentInfo[999];
    public  static Object[][] Marks = new Object[999][2];

    public StudentInfo() {
    }

    public StudentInfo(String studentId, String studentName, double studentMark) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentMark = studentMark;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getStudentMark() {
        return studentMark;
    }

    public void setStudentMark(double studentMark) {
        this.studentMark = studentMark;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentMark=" + studentMark +
                '}';
    }
}
