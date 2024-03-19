package ShoppinMall;

public class Application {
    public static void main(String[] args) {
        DebitCard debitCard = new DebitCard("Razvan Popa", 500);
        CreditCard creditCard = new CreditCard("Andreea Marin");

        ShoppingMall mall = new ShoppingMall(debitCard);
        System.out.println("Achiziție cu DebitCard:");
        mall.achizitie(300);

        mall = new ShoppingMall(creditCard);
        System.out.println("\nAchiziție cu CreditCard:");
        mall.achizitie(150);

        // Cazul in care am depasit limita
        mall = new ShoppingMall(debitCard);
        System.out.println("\nAchiziție cu DebitCard:");
        mall.achizitie(300);
    }
}

