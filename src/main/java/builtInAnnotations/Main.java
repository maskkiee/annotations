package builtInAnnotations;

public class Main {
    public static void main(String[] args) {
        Pojazd pojazd = new Pojazd();
        Samochod samochod = new Samochod();
        System.out.println(pojazd.opis());
        pojazd.staraMetoda();
        System.out.println(samochod.opis());
        samochod.nowaMetoda();
//        samochod.staraMetoda(); <- nie działa

        Obliczenie add = (a, b) -> a + b;
        Obliczenie multiply = (a, b) -> a * b;
        System.out.println("add(7, 5) = " + add.wykonaj(7, 5));
        System.out.println("multiply(7, 5)  = " + multiply.wykonaj(7, 5));
    }
}
