package Forme;

public class Application {

    public static void main(String[] args) {
        Cerc cerc = new Cerc(5); // Un cerc cu raza de 5
        Patrat patrat = new Patrat(7); // Un pătrat cu latura de 7

        System.out.println("Perimetrul cercului: " + cerc.calculPerimetru());
        System.out.println("Perimetrul pătratului: " + patrat.calculPerimetru());
    }
}
