import java.time.LocalDate;
import java.util.Scanner;

public class BorrowCardManagement {
    private BorrowCard[] borrowCards;

    public BorrowCardManagement() {
    }

    public BorrowCardManagement(BorrowCard[] borrowCards) {
        this.borrowCards = borrowCards;
    }

    public BorrowCardManagement(int size) {
        this.borrowCards = new  BorrowCard[size];
    }

    public BorrowCard[] getBorrowCards() {
        return borrowCards;
    }

    public void setBorrowCards(BorrowCard[] borrowCards) {
        this.borrowCards = borrowCards;
    }

    public Student initStudent(Scanner scanner) {
        System.out.print("Enter student full name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter student code : ");
        String studentCode = scanner.nextLine();
        System.out.print("Enter date of birth : ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Enter class name : ");
        String className = scanner.nextLine();
        return new Student(studentName, studentCode, dateOfBirth, className);
    }

    public BorrowCard initBorrowCard(Scanner scanner) {
        System.out.print("Enter borrow card number : ");
        String borrowCardNumber = scanner.nextLine();
        System.out.print("Enter borrow date (yyyy-mm-dd)  : ");
        String borrowDate = scanner.nextLine();
        LocalDate borrowCreatedDate = LocalDate.parse(borrowDate);
        System.out.print("Enter term date (yyyy-mm-dd) : ");
        String termDate = scanner.nextLine();
        LocalDate termCreatedDate = LocalDate.parse(termDate);
        System.out.print("Enter book number : ");
        String bookNumber = scanner.nextLine();
        Student student = initStudent(scanner);
        return new BorrowCard(borrowCardNumber, borrowCreatedDate, termCreatedDate, bookNumber, student);
    }

    public int findIndex(String borrowCardNumber) {
        int index = -1;
        for (int i = 0; i < this.borrowCards.length; i++) {
            if (borrowCardNumber.equals(this.borrowCards[i].getBorrowCardNumber())){
                index = i;
                break;
            }
            index = -1;
        }
        return  index;
    }

    public BorrowCard[] deleteBorrowCardInArray(String borrowCardNumber) {
        BorrowCard[] newBorrowCards = new BorrowCard[this.borrowCards.length -1];
        int index = findIndex(borrowCardNumber);
        if (index == -1) {
            System.out.println("Not found");
        }else {
            for (int i = 0; i < newBorrowCards.length; i++) {
                if (i < index){
                    newBorrowCards[i] = borrowCards[i];
                } else {
                    newBorrowCards[i] = borrowCards[i + 1];
                }
            }
            borrowCards = newBorrowCards;
        }
        return borrowCards;
    }

    public BorrowCard[] addBorrowCardInArray(int index, Scanner scanner) {
        BorrowCard[] newBorrowCards = new BorrowCard[this.borrowCards.length + 1];
        for (int i = 0; i < newBorrowCards.length; i++) {
            if (i < index) {
                newBorrowCards[i] = this.borrowCards[i];
            }else if (i == index) {
                newBorrowCards[index] = initBorrowCard(scanner);
            }else {
                newBorrowCards[i] = this.borrowCards[i - 1];
            }
        }
        borrowCards = newBorrowCards;
        return borrowCards;
    }
}
