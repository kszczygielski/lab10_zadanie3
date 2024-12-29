import java.io.*;
import java.nio.file.*;

public class FileCopyWithReplacement {
    public static void main(String[] args) {
        // Ścieżki do plików
        Path sourcePath = Paths.get("source.txt"); // Plik wejściowy
        Path destinationPath = Paths.get("destination.txt"); // Plik wyjściowy

        // Sprawdzanie, czy plik wejściowy istnieje
        if (!Files.exists(sourcePath)) {
            System.out.println("Plik źródłowy nie istnieje: " + sourcePath);
            return;
        }

        // Kopiowanie i zastępowanie spacji myślnikami
        try (
                BufferedReader reader = Files.newBufferedReader(sourcePath);
                BufferedWriter writer = Files.newBufferedWriter(destinationPath)
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Zamiana spacji na myślniki
                String modifiedLine = line.replace(" ", "-");
                // Zapis zmodyfikowanej linii do pliku wyjściowego
                writer.write(modifiedLine);
                writer.newLine(); // Dodanie nowej linii
            }
            System.out.println("Kopiowanie zakończone sukcesem.");
        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas kopiowania: " + e.getMessage());
        }
    }
}
