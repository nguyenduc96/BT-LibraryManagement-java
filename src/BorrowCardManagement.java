import java.util.ArrayList;
import java.util.List;

public class BorrowCardManagement {
    List<BorrowCard> borrowCards = new ArrayList<>();

    public List<BorrowCard> getBorrowCards() {
        return borrowCards;
    }

    public void setBorrowCards(List<BorrowCard> borrowCards) {
        this.borrowCards = borrowCards;
    }

    public void displayBorrowCard() {
        for (BorrowCard borrowCard : borrowCards) {
            System.out.println(borrowCard);
        }
    }

    public void addBorrowCard(BorrowCard borrowCard) {
        borrowCards.add(borrowCard);
    }

    public void removeBorrowCard(int index) {
        borrowCards.remove(index);
    }

    public void editBorrowCard(int index, BorrowCard borrowCard) {
        borrowCards.set(index, borrowCard);
    }

    public BorrowCard findBorrowCard(int index) {
        return borrowCards.get(index);
    }
}
