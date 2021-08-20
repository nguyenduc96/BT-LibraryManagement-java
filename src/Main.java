import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BorrowCardManagement borrowCardManagement = new BorrowCardManagement();
        runMainProgram(scanner, borrowCardManagement);
    }

    private static void runMainProgram(Scanner scanner, BorrowCardManagement borrowCardManagement) {
        int choice;
        do {
            menu();
            System.out.println("Mời bạn chọn : ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    addBorrowInList(scanner, borrowCardManagement);
                    break;
                }
                case 2: {
                    deleteBorrowCardWithIdBorrowCard(scanner, borrowCardManagement);
                    break;
                }
                case 3: {
                    borrowCardManagement.displayBorrowCard();
                    break;
                }
                case 4: {
                    editBorrowCardWithIdBorrowcard(scanner, borrowCardManagement);
                    break;
                }
                case 5: {
                    findBorrowCardWithIdBorrowCard(scanner, borrowCardManagement);
                    break;
                }
                case 0: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Số bạn nhập không đúng mời nhập lại");
                    break;
                }
            }
        } while (choice != 0);
    }

    private static void addBorrowInList(Scanner scanner, BorrowCardManagement borrowCardManagement) {
        System.out.println("THÊM THẺ MƯỢN");
        BorrowCard borrowCard = initBorrowCard(scanner);
        borrowCardManagement.addBorrowCard(borrowCard);
        System.out.println("ĐÃ THÊM THÀNH CÔNG");
    }

    private static void findBorrowCardWithIdBorrowCard(Scanner scanner, BorrowCardManagement borrowCardManagement) {
        System.out.println("TÌM KIẾM THÔNG TIN THẺ MƯỢN");
        System.out.print("Mời bạn nhập mã thẻ mượn : ");
        String idBorrowCard = scanner.nextLine();
        int index = findIndexFromIdBorrowCard(idBorrowCard, borrowCardManagement);
        if (index == -1) {
            System.out.println("Không tìm thấy mã thẻ " + idBorrowCard + " trong danh sách");
        } else {
            System.out.println("TÌM THẤY THÔNG TIN : ");
            System.out.println(borrowCardManagement.findBorrowCard(index));
        }
    }

    private static void editBorrowCardWithIdBorrowcard(Scanner scanner, BorrowCardManagement borrowCardManagement) {
        System.out.println("SỬA THÔNG TIN THẺ MƯỢN");
        System.out.print("Mời bạn nhập mã thẻ mượn : ");
        String idBorrowCard = scanner.nextLine();
        int index = findIndexFromIdBorrowCard(idBorrowCard, borrowCardManagement);
        if (index == -1) {
            System.out.println("Không tìm thấy mã thẻ " + idBorrowCard + " trong danh sách");
        } else {
            BorrowCard borrowCard = initBorrowCard(scanner);
            borrowCardManagement.editBorrowCard(index, borrowCard);
        }
        System.out.println("CHỈNH SỬA THÀNH CÔNG");
    }

    private static void deleteBorrowCardWithIdBorrowCard(Scanner scanner, BorrowCardManagement borrowCardManagement) {
        System.out.println("XÓA THẺ MƯỢN");
        System.out.print("Mời bạn nhập mã thẻ mượn : ");
        String idBorrowCard = scanner.nextLine();
        int index = findIndexFromIdBorrowCard(idBorrowCard, borrowCardManagement);
        if (index == -1) {
            System.out.println("Không tìm thấy mã thẻ " + idBorrowCard + " trong danh sách");
        } else {
            borrowCardManagement.removeBorrowCard(index);
        }
    }

    private static BorrowCard initBorrowCard(Scanner scanner) {
        Student student = initStudent(scanner);
        System.out.print("Mã thẻ mượn : ");
        String idBorrowCard = scanner.nextLine();
        System.out.print("Ngày mượn (yyyy-mm-dd) : ");
        String borrowDate = scanner.nextLine();
        System.out.print("Ngày trả (yyyy-mm-dd) : ");
        String termDate = scanner.nextLine();
        System.out.print("Mã số sách : ");
        String idBook = scanner.nextLine();
        return new BorrowCard(idBorrowCard, LocalDate.parse(borrowDate), LocalDate.parse(termDate), idBook, student);
    }

    private static Student initStudent(Scanner scanner) {
        System.out.print("Họ và tên : ");
        String fullName = scanner.nextLine();
        System.out.print("Mã SV : ");
        String studentCode = scanner.nextLine();
        System.out.print("Ngày sinh : ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Lớp : ");
        String className = scanner.nextLine();
        return new Student(fullName, studentCode, dateOfBirth, className);
    }

    private static int findIndexFromIdBorrowCard(String idBorrowCard, BorrowCardManagement borrowCardManagement) {
        int index = -1;
        for (int i = 0; i < borrowCardManagement.getBorrowCards().size(); i++) {
            if (idBorrowCard.equals(borrowCardManagement.getBorrowCards().get(i).getBorrowCardNumber())) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void menu() {
        System.out.println("------------------------");
        System.out.println("1: Thêm thẻ mượn");
        System.out.println("2: Xóa thẻ mượn");
        System.out.println("3: In ra danh sách thẻ mượn");
        System.out.println("4: Sửa thông tin thẻ mượn");
        System.out.println("5: Tìm kiếm thông tin thẻ mượn");
        System.out.println("0: Exit");
        System.out.println("------------------------");
    }
}
