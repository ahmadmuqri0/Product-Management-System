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
                StringTokenizer token = new StringTokenizer(line, "|");
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

    public void updateReview(Queue reviews) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            Queue tempQueue = new Queue();

            while (!reviews.isEmpty()) {
                Review review = (Review) reviews.dequeue();
                String entry = review.toString();
                writer.println(entry);
                tempQueue.enqueue(entry);
            }

            while(!tempQueue.isEmpty()){
                reviews.enqueue(tempQueue.dequeue());
            }
            
        } catch (IOException e) {
            System.out.println("Error writing to user file: " + e.getMessage());
        }
    }

    public void addReviewToFile(Review newReview) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            String entry = newReview.toString();
            writer.println(entry);
        } catch (IOException e) {
            System.out.println("Error writing to review file: " + e.getMessage());
        }
    }

    // public void removeReviewFromFile(String productName){
    //     Queue reviews = loadReview();
    //     Queue temp = new Queue();
    //     Object data;

    //     while(!reviews.isEmpty()){
    //         data = reviews.dequeue();
    //         Review review = (Review) data;

    //         if(!review.getProductName().equalsIgnoreCase(productName)){
    //             temp.enqueue(review);
    //         }
    //     }

    //     try(PrintWriter writer = new PrintWriter(new FileWriter(filePath))){
    //         while (!temp.isEmpty()){
    //             data = temp.dequeue();
    //             Review review = (Review) data;
    //             String entry = review.toString();
    //             writer.println(entry);
    //         }
    //     }
    //     catch (IOException e){
    //         System.out.println("Error writing to review file: " + e.getMessage());
    //     }

    //     System.out.println("Reviews for product '" + productName + "' removed successfully.");
    // }
}
