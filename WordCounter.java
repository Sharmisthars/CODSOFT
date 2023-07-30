import java.io.*;
import java.util.*;

public class WordCounter {
    // Common words to ignore in the word count
    private static final Set<String> commonWords = new HashSet<>(Arrays.asList(
            "the", "and", "in", "of", "to", "a", "for", "on", "with", "is", "it", "as" )); // Add more common words as needed
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text or provide a file path to count words: ");
        String input = scanner.nextLine().trim();
        String text;
        if (isFilePath(input)) {
            text = readTextFromFile(input);
        } else 
        {
            text = input;
        }
        if (text.isEmpty()) {
            System.out.println("No text found.");
        }
        scanner.close();
        String[] words = text.split("\\s+|(?=\\p{Punct})|(?<=\\p{Punct})"); // Split by space or punctuation
        int wordCount = 0;
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty() && !commonWords.contains(word.toLowerCase())) {
                wordCount++;
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        System.out.println("Total word count: " + wordCount);
        System.out.println("Number of unique words: " + wordFrequency.size());
        System.out.println("Word frequency:");

        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static boolean isFilePath(String input) {
        return new File(input).exists();
    }

    private static String readTextFromFile(String filePath) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
