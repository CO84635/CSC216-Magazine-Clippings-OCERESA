package csc216.magazine.clippings.oceresa;
import java.util.HashMap;

public class App {
    boolean canCreateNote(String note, String[] articles) {
        if (note == null) {
            return false;
        }

        for (String article : articles) {
            if (article == null) {
                return false;
            }
        }

        HashMap<Character, Integer> noteCharCount = new HashMap<>(68);
        note = note.toLowerCase();
        note = note.replaceAll("\\s", "");
        for (char c : note.toCharArray()) {
            noteCharCount.put(c, noteCharCount.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> articlesCharCount = new HashMap<>(68);
        for (String article : articles) {
            article = article.toLowerCase();
            article = article.replaceAll("\\s", "");
            for (char c : article.toCharArray()) {
                articlesCharCount.put(c, articlesCharCount.getOrDefault(c, 0) + 1);
            }
        }

        for (Character c : note.toCharArray()) {
            if (articlesCharCount.getOrDefault(c, 0) < noteCharCount.getOrDefault(c, 0)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
    }
}