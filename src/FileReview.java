import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FileReview {
    private String filePath;

    public FileReview(String filePath) {
        this.filePath = filePath;
    }

    public Queue loadReview() {
        Queue reviews = new Queue();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                StringTokenizer token = new StringTokenizer(line, ",");
                if (token.countTokens() == 5) {
                    String name = token.nextToken();
                    String title = token.nextToken();
                    String type = token.nextToken();
                    String description = token.nextToken();
                    int rating = Integer.parseInt(token.nextToken());

                    Review review = new Review(name, title, type, description, rating);
                    reviews.enqueue(review);
                }
            }
            return reviews;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviews;
    }

    public void updateProduct(Queue reviews) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {

            Object data = reviews.getFirst();
            while (data != null) {
                Product product = (Product) data;
                String entry = product.toString();
                writer.println(entry);
                data = reviews.getNext();
            }
            
        } catch (IOException e) {
            System.out.println("Error writing to user file: " + e.getMessage());
        }
    }
}
