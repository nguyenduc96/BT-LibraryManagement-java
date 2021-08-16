import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter borrow card amount : ");
        int size = scanner.nextInt();
        scanner.nextLine();
        BorrowCardManagement borrowCardManagement = new BorrowCardManagement(size);
        BorrowCard[] borrowCards = borrowCardManagement.getBorrowCards();
        initBorrowCard(scanner, borrowCardManagement, borrowCards);
        displayBorrowCardArray(borrowCards);
        runMenu(scanner, borrowCardManagement, borrowCards);
    }

    private static void runMenu(Scanner scanner, BorrowCardManagement borrowCardManagement,BorrowCard[] borrowCards) {

        int choice = -1;
        do {
            menu();
            System.out.println("Enter choice");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1: {
                    System.out.println("Enter borrow card number ");
                    String borrowCardNumber = scanner.nextLine();
                    borrowCards = borrowCardManagement.deleteBorrowCardInArray(borrowCardNumber);
                    displayBorrowCardArray(borrowCards);
                    break;
                }
                case 2: {
                    System.out.println("Enter index you want add");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    borrowCards = borrowCardManagement.addBorrowCardInArray(index, scanner);
                    displayBorrowCardArray(borrowCards);
                    break;
                }
                case 3: {
                    displayBorrowCardArray(borrowCards);
                    break;
                }
                case 0: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("PLEASE RE-ENTER!!!");
                    break;
                }
            }
        } while (choice != 0);
    }

    private static void initBorrowCard(Scanner scanner, BorrowCardManagement borrowCardManagement, BorrowCard[] borrowCards) {
        for (int i = 0; i < borrowCards.length; i++) {
            System.out.println("ENTER BORROW CARD " + (i + 1));
            borrowCards[i] = borrowCardManagement.initBorrowCard(scanner);
        }
    }

    private static void displayBorrowCardArray(BorrowCard[] borrowCards) {
        for (int i = 0; i < borrowCards.length; i++) {
            System.out.println(borrowCards[i].toString());
        }
    }

    public static void menu() {
        System.out.println("1: Delete borrow card");
        System.out.println("2: Add borrow card");
        System.out.println("3: Display list");
        System.out.println("0: Exit");
    }
}
