package tb.soft.zad1;

import tb.soft.ConsoleUserDialog;
import tb.soft.JOptionUserDialog;

import java.util.ArrayList;
import java.util.List;

public class Zadanie1App {
    private static final String GREETING_MESSAGE =
            "Program zadanie1 - wersja okienkowa\n" +
                    "Autor: Robert Pytel\n" +
                    "Data:  listopad 2023 r.\n";

    private static final String MENU =
            "    M E N U   G Ł Ó W N E  \n" +
                    "1 - Wyświetl słowa. \n" +
                    "2 - Dodaj nowe słowa.        \n" +
                    "3 - Usuń słowo.   \n" +
                    "4 - Dodawanie - test dla wielu losowych.   \n" +
                    "5 - Usuwanie - test dla wielu losowych.   \n" +
                    "0 - Zakończ program        \n";
    private static final ConsoleUserDialog UI = new JOptionUserDialog();

    public static void main(String[] args) {
        Zadanie1App application = new Zadanie1App();
        application.runMainLoop();
    }

    public void runMainLoop() {
        UI.printMessage(GREETING_MESSAGE);

        Words w = new Words();
        String input;
        List<Long> times;

        while (true) {
            UI.clearConsole();

            switch (UI.enterInt(MENU + "==>> ")) {
                case 1:
                    // wyświetlanie słów
                    UI.printMessage(w.get_words_hash());
                    break;
                case 2:
                    // dodawanie słów.
                    input = UI.enterString("Podaj słowo, które chcesz dodać: ");
                    times = w.add_word(input);
                    UI.printMessage("Dodanie słowa do HashSetu zajęło: " + times.get(0) + " ns. Dodanie słowa do TreeSetu zajęło: " + times.get(1) + " ns.");
                    break;
                case 3:
                    // usuwanie słowa.
                    input = UI.enterString("Podaj słowo, które chcesz usunąć: ");
                    times = w.remove_word(input);
                    UI.printMessage("Usunięcie dla HashSetu zajęło: " + times.get(0) + " ns. Usunięcie dla TreeSetu zajęło: " + times.get(1) + " ns.");
                    break;
                case 4:
                    List<List<Long>> results = new ArrayList<>();
                    List<String> remove_after = new ArrayList<>();
                    for(int i = 0; i < 20; i++){
                        String word = w.generate_random_word();
                        remove_after.add(word);
                        results.add(w.add_word(word));
                    }
                    String output = "";
                    for(int j = 0; j < results.size(); j++){
                        output += "HashSet: " + results.get(j).get(0) + " ns. TreeSet: " + results.get(j).get(1) + " ns.\n";
                    }
                    for(int a = 0; a < remove_after.size(); a++){
                        w.remove_word(remove_after.get(a));
                    }
                    UI.printMessage(output);
                    break;
                case 5:
                    List<List<Long>> results2 = new ArrayList<>();
                    for(int i = 0; i < 20; i++){
                        String word = w.generate_random_word();
                        w.add_word(word);
                        results2.add(w.remove_word(word));
                    }
                    String output2 = "";
                    for(int j = 0; j < results2.size(); j++){
                        output2 += "HashSet: " + results2.get(j).get(0) + " ns. TreeSet: " + results2.get(j).get(1) + " ns.\n";
                    }
                    UI.printMessage(output2);
                    break;
                case 0:
                    // zakończenie działania programu
                    UI.printInfoMessage("\nProgram zakończył działanie!");
                    System.exit(0);
            } // koniec instrukcji switch
        } // koniec pętli while
    }
}
