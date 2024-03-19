package ShoppinMall;

public record DebitCard(String utilizator, double limitAmount) implements BankCard {
    private static double spentAmount = 0;

    @Override
    public void doTransaction(double amount) {
        if (amount > limitAmount -spentAmount) {
            System.out.println("Utilizator " + utilizator + " nu are suficienți bani.");
        } else {
            spentAmount += amount;
            System.out.println("Utilizator " + utilizator + " a cheltuit " + amount);
            System.out.println("Suma totală cheltuită cu carduri de debit este " + spentAmount);
        }
    }
}
