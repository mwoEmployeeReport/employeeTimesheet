
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import dataModel.ImportDataFromXlx;
import reports.EmployeeTotalHoursReport;

public class Main {

    public static void main(String[] args) throws IOException {
        ImportDataFromXlx importDataFromXlx = new ImportDataFromXlx();


        boolean isLoggedIn = false;

        while (!isLoggedIn) {

            System.out.println("Z ponizszej listy wybierz numer raportu/ wykresu, ktory chcesz wygenerowac\n");
            System.out.println("0 - Podaj sciezke do pliku'");
            System.out.println("1 - Raport: 'Ilosc godzin przepracowanych przez poszczegolnych pracownikow w wybranym roku'");
            System.out.println("2 - Raport: 'Ilosc godzin przepracowanych nad danym projektem w wybranym roku'");
            System.out.println("3 - Raport: 'Ilosc godzin przepracowanych przez danego pracownika z podzialem na projekty i miesiace'");
            System.out.println("4 - Raport: 'Procentowe zestawienie udzialu pracownika w poszczegolnych projektach w wybranym roku'");
            System.out.println("5 - Wykres slupkowy: 'Ilosc godzin na project w danym roku'");
            System.out.println("6 - Wykres kolowy: 'Procentowy udzial pracownika w poszczegolnych projektach'");
            System.out.println("7 - Raport: 'Szczegolowy wykaz czas pracy pracownikow w poszczegolnych projektach'");
            System.out.println("x - Wyjdz z programu");

            Scanner input = new Scanner(System.in);

            String value = input.nextLine();

            switch (value) {

                case "0":

                    System.out.println(
                            "Podaj siezke do pliku");

                    String path = input.nextLine();

                    if (!path.equals(null)) {
                        File dir = new File(path);
                        importDataFromXlx.findAllFiles(dir);
                        importDataFromXlx.PrintAllProjects();
                        continue;
                    } else {
                        System.out.println("Podano zlą sciezke!\n");
                        break;
                    }


                case "1":
                    System.out.println(
                            "Podaj rok");
                    String choice = input.nextLine();
                    EmployeeTotalHoursReport employeeTotalHoursReport = new EmployeeTotalHoursReport();
                    employeeTotalHoursReport.setDataModel(importDataFromXlx.getTimeSheetModel());
                    employeeTotalHoursReport.calculate(Integer.valueOf(choice));
                    employeeTotalHoursReport.printReportToConsole();
                    if (choice.equals("1")) {
                        System.out.println("Twoj raport został wygenerowany w formacie PDF\n");
                        continue;
                    } else if (choice.equals("2")) {
                        System.out.println("Twoj raport został wygenerowany w formacie doc\n");
                        continue;
                    }

                    break;

                case "2":

                    System.out.println(
                            "To jest Twoj raport. Jesli chcesz importowac raport do formatu PDF nacisnij 1, jesli do formatu doc wcisnij 2. Jesli chcesz wrocic do menu glownego wcisnij cokolwiek");

                    String choice2 = input.nextLine();

                    if (choice2.equals("1")) {
                        System.out.println("Twoj raport zosta� wygenerowany w formacie PDF\n");
                        continue;
                    } else if (choice2.equals("2")) {
                        System.out.println("Twoj raport zosta� wygenerowany w formacie doc\n");
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