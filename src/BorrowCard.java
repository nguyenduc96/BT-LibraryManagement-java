import java.time.LocalDate;

public class BorrowCard {
    private String borrowCardNumber;
    private LocalDate borrowDate;
    private LocalDate termDate;
    private String bookNumber;
    private Student student;

    public BorrowCard() {
    }

    public BorrowCard(String borrowCardNumber, LocalDate borrowDate, LocalDate termDate, String bookNumber, Student student) {
        this.borrowCardNumber = borrowCardNumber;
        this.borrowDate = borrowDate;
        this.termDate = termDate;
        this.bookNumber = bookNumber;
        this.student = student;
    }

    public String getBorrowCardNumber() {
        return borrowCardNumber;
    }

    public void setBorrowCardNumber(String borrowCardNumber) {
        this.borrowCardNumber = borrowCardNumber;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getTermDate() {
        return termDate;
    }

    public void setTermDate(LocalDate termDate) {
        this.termDate = termDate;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "BorrowCard{" +
                "borrowCardNumber=" + borrowCardNumber +
                ", borrowDate='" + borrowDate + '\'' +
                ", term='" + termDate + '\'' +
                ", bookNumber='" + bookNumber + '\'' +
                ", student=" + student +
                '}';
    }
}
