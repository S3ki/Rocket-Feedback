package Model;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Luodaan uusi kurssi
        Kurssi kurssi = new Kurssi("Ohjelmointi 101");

        // Simuloidaan palautteen lisäämistä ja poistamista
        Scanner scanner = new Scanner(System.in);
        String input;
        int choice;

        do {
            System.out.println("\nValitse toiminto:");
            System.out.println("1. Lisää palaute");
            System.out.println("2. Poista palaute");
            System.out.println("3. Näytä palautteet");
            System.out.println("4. Lopeta");
            choice = scanner.nextInt();
            scanner.nextLine();  // Tyhjennä skannerin rivinluku

            switch (choice) {
                case 1:
                    System.out.print("Syötä palaute: ");
                    input = scanner.nextLine();
                    System.out.print("Syötä palautteen tekijän nimi: ");
                    String opiskelijanNimi = scanner.nextLine();
                    kurssi.addFeedback(input, opiskelijanNimi);
                    break;
                case 2:
                    kurssi.printFeedback();
                    System.out.print("Anna poistettavan palautteen numero: ");
                    int index = scanner.nextInt();
                    scanner.nextLine(); // Tyhjennä skannerin rivinluku
                    kurssi.removeFeedback(index - 1);  // Indeksi alkaa 0:sta
                    break;
                case 3:
                    kurssi.printFeedback();
                    break;
                case 4:
                    System.out.println("Ohjelma lopetetaan.");
                    break;
                default:
                    System.out.println("Virheellinen valinta, yritä uudelleen.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
