import java.util.*;
import java.io.*;
public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = getInputText(scanner);
        if (text != null && !text.isEmpty()) {
            String[] words = splitTextIntoWords(text);
            if (words != null) {
                int totalWords = countWords(words);
                System.out.println("Total number of words: " + totalWords);
                Map<String, Integer> wordFrequency = getWordFrequency(words);
                System.out.println("Number of unique words: " + wordFrequency.size());
                displayWordFrequency(wordFrequency);
            }
        }
    }
    private static String getInputText(Scanner scanner) {
        System.out.println("Enter text or provide the path of a file:");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            System.out.println("Invalid input. Text or file path cannot be empty.");
            return null;
        }
        try {
            if (new File(input).isFile()) {
                return readFileContent(input);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return input;
    }

    private static String readFileContent(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    private static String[] splitTextIntoWords(String text) {
        // Use regex to split words by spaces and punctuation marks
        // [\\p{Punct}\\s] matches any punctuation or whitespace character
        return text.split("[\\p{Punct}\\s]+");
    }

    private static int countWords(String[] words) {
        return words.length;
    }

    private static Map<String, Integer> getWordFrequency(String[] words) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        Set<String> commonWords = getCommonWords();
        for (String word : words) {
            word = word.toLowerCase(); // Convert to lowercase for case-insensitive counting
            if (!commonWords.contains(word)) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }
        return wordFrequency;
    }

    private static Set<String> getCommonWords() {
        // Add common words to this set to ignore them in word counting
        Set<String> commonWords = new HashSet<>();
        commonWords.add("the");
        commonWords.add("and");
        commonWords.add("is");
        // Add more common words as needed
        return commonWords;
    }
    private static void displayWordFrequency(Map<String, Integer> wordFrequency) {
        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

