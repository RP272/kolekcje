package tb.soft.zad1;

import java.util.*;

public class Words {
    private final Set words_hash = new HashSet();
    private final Set words_tree = new TreeSet();

    public String get_words_hash(){
        return "HashSet: " + words_hash + "\n" +
                "TreeSet:  " + words_tree + "\n";
    }
    public List<Long> add_word(String word){
        Long start, end;
        ArrayList<Long> times = new ArrayList<>();
        start = System.nanoTime();
        words_hash.add(word);
        end = System.nanoTime();
        times.add(end - start);
        start = System.nanoTime();
        words_tree.add(word);
        end = System.nanoTime();
        times.add(end - start);
        return times;
    }

    public List<Long> remove_word(String word){
        Long start, end;
        ArrayList<Long> times = new ArrayList<>();
        start = System.nanoTime();
        words_hash.remove(word);
        end = System.nanoTime();
        times.add(end - start);

        start = System.nanoTime();
        words_tree.remove(word);
        end = System.nanoTime();
        times.add(end - start);
        return times;
    }

    public String generate_random_word() {
        Random r = new Random();
        int wordLength = r.nextInt(3, 50);
        StringBuilder sb = new StringBuilder(wordLength);
        for(int i = 0; i < wordLength; i++) {
            char c = (char)('a' + r.nextInt('z' - 'a'));
            sb.append(c);
        }
        return sb.toString();
    }
}
