public class Student {
    private String fullName;
    private String studentCode;
    private String dateOfBirth;
    private String className;

    public Student() {
    }

    public Student(String fullName, String studentCode, String dateOfBirth, String className) {
        this.fullName = fullName;
        this.studentCode = studentCode;
        this.dateOfBirth = dateOfBirth;
        this.className = className;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Thông tin sinh viên =>{" +
                "Họ và tên : '" + fullName + '\'' +
                ", Mã sinh viên : '" + studentCode + '\'' +
                ", Ngày sinh : '" + dateOfBirth + '\'' +
                ", Lớp'" + className + '\'' +
                '}';
    }
}
