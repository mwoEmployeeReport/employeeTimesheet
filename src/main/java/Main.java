import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("Witaj w programie EmployeeTimesheet\n");

		boolean isLoggedIn = true;

		while (isLoggedIn) {

			System.out.println("Z ponizszej listy wybierz numer raportu/ wykresu, ktory chcesz wygenerowac\n");
			System.out.println(
					"1 - Raport: 'Ilosc godzin przepracowanych przez poszczegolnych pracownikow w wybranym roku'");
			System.out.println("2 - Raport: 'Ilosc godzin przepracowanych nad danym projektem w wybranym roku'");
			System.out.println(
					"3 - Raport: 'Ilosc godzin przepracowanych przez danego pracownika z podzialem na projekty i miesiace'");
			System.out.println(
					"4 - Raport: 'Procentowe zestawienie udzialu pracownika w poszczegolnych projektach w wybranym roku'");
			System.out.println("5 - Wykres slupkowy: 'Ilosc godzin na project w danym roku'");
			System.out.println("6 - Wykres kolowy: 'Procentowy udzial pracownika w poszczegolnych projektach'");
			System.out.println("7 - Raport: 'Szczegolowy wykaz czas pracy pracownikow w poszczegolnych projektach'");
			System.out.println("x - Wyjdz z programu");

			Scanner input = new Scanner(System.in);

			String value = input.nextLine();

			switch (value) {

			case "1":

				System.out.println(
						"To jest Twoj raport. Jesli chcesz importowac raport do formatu PDF nacisnij 1, jesli do formatu doc wcisnij 2. Jesli chcesz wrocic do menu glownego wcisnij cokolwiek");

				String choice = input.nextLine();

				if (choice.equals("1")) {
					System.out.println("Twoj raport zosta³ wygenerowany w formacie PDF\n");
					continue;
				} else if (choice.equals("2")) {
					System.out.println("Twoj raport zosta³ wygenerowany w formacie doc\n");
					continue;
				}

				break;

			case "2":

				System.out.println(
						"To jest Twoj raport. Jesli chcesz importowac raport do formatu PDF nacisnij 1, jesli do formatu doc wcisnij 2. Jesli chcesz wrocic do menu glownego wcisnij cokolwiek");

				String choice2 = input.nextLine();

				if (choice2.equals("1")) {
					System.out.println("Twoj raport zosta³ wygenerowany w formacie PDF\n");
					continue;
				} else if (choice2.equals("2")) {
					System.out.println("Twoj raport zosta³ wygenerowany w formacie doc\n");
					continue;
				}

				break;
			case "3":
				System.out.println("Raport nie zostal zaimplementowany. Za utrudnienia przepraszamy.\n");
				break;
			case "4":
				System.out.println("Raport nie zostal zaimplementowany. Za utrudnienia przepraszamy.\n");
				break;
			case "5":
				System.out.println("Raport nie zostal zaimplementowany. Za utrudnienia przepraszamy.\n");
				break;
			case "6":
				System.out.println("Raport nie zostal zaimplementowany. Za utrudnienia przepraszamy.\n");
				break;
			case "7":
				System.out.println("Raport nie zostal zaimplementowany. Za utrudnienia przepraszamy.\n");
				break;
			case "x":
				System.out.println("Do widzenia.");
				break;
			default:
				System.out.println("Podaj poprawna liczbe z zakresu od 1 do 7\n");
				break;
			}

			if (value.equals("x")) {
				isLoggedIn = false;
			}
		}

	}

}
