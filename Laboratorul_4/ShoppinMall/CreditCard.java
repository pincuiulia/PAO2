package ShoppinMall;

public record CreditCard(String utilizator) implements BankCard {
    private static double spentAmount = 0;

    @Override
    public void doTransaction(double amount) {
        spentAmount += amount;
        System.out.println("Utilizator " + utilizator + " a cheltuit " + amount);
        System.out.println("Suma totală cheltuită cu carduri de credit este " + spentAmount);
    }
}
