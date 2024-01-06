import java.util.Scanner;

public class User 
{
    private String userName;
    private int userID;

    public User(String userName, int userID) {
        this.userName = userName;
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserID() {
        return userID;
    }

    public String toString() {
        return ("username: " + userName + "\npassword: " + userID);
    }

    public void totalProduct(LinkedList products){
    
            Object data = products.getFirst();
            int count = 0;
    
            while(data != null){
                Product product = (Product) data;
                count++;
                data = products.getNext();
                
            }
            System.out.println("\nTotal Product : " + count);
            System.out.println("==================");
        }
    
    public void displayProduct(LinkedList products) {
        
        Object data = products.getFirst();    
        
        while (data != null) {
            Product product = (Product) data;

            System.out.println("\n" + "Product ID   : " + product.getProductID() + "\n"+ "Name         : " +  product.getProductName() +
                              "\n" + "Brand        : " + product.getProductBrand() + "\n" + "Price        : " + product.getProductPrice() + "\n" 
                               + "Availability : " + product.getProductAvailability());
            data = products.getNext();
        }
    } 
    
    public void searchProduct(LinkedList products){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter product name");
        String productName = sc.nextLine();

        Product product = new Product(productName,"","",0.0,"");
        Object data = products.getFirst();

        String[] items = {"\nS","E","A","R","C","H","I","N","G",".",".",".\n"};
            
                    for (String item : items) 
                    {
                        System.out.print(item);

                        try {
                            Thread.sleep(150);
                        }
                        catch (InterruptedException e) 
                        {
                            e.printStackTrace();
                        }
                    }
        System.out.println("\nRESULT OF SEARCH");
        System.out.println("====================");
        
        while(data != null){
            product = (Product) data;
            int count = 0;
            
            
            if(product.getProductName().equalsIgnoreCase(productName)){
                
                count++;
                System.out.println("\nProduct found : "+ count);
                System.out.println("\n==================");
                System.out.println("\n" + "Product ID   : " + product.getProductID() + "\n"+ "Name         : " +  product.getProductName() +
                                   "\n" + "Brand        : " + product.getProductBrand() + "\n" + "Price        : " + product.getProductPrice() + "\n" 
                                        + "Availability : " + product.getProductAvailability());
            }
            data = products.getNext();
        }

    }

    public void displayReview(Queue reviews) {
        Queue temp = new Queue();
        Object data;
        int count = 0;

        System.out.println("==============================================================");
        System.out.println("                         Review List                          ");
        System.out.println("==============================================================");
        
        while (!reviews.isEmpty()) {
            data = reviews.dequeue();
            Review review = (Review) data;

            count++;
            System.out.println("TOTAL REVIEW : " + count);
            System.out.println("==============");
            System.out.println("\n" + "Product Name : " +review.getProductName() + "\n"+ "Type         : " +  review.getReviewType() +
                              "\n" + "Title        : " +review.getReviewTitle() + "\n" + "Rating       : " + review.getRating() + "/5" + "\n" 
                               + "Description  : \n" +review.getReviewDescription());
            temp.enqueue(review);
        }
        while (!temp.isEmpty())
        {
            data = temp.dequeue();
            reviews.enqueue(data);
        }
    }

    public void searchReview(Queue reviews)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter product name to search for review");
        String productName = sc.nextLine();

        Queue temp = new Queue();
        Object data;
        int count = 0;

        String[] items = {"\nS","E","A","R","C","H","I","N","G",".",".",".\n"};
                
                        for (String item : items) 
                        {
                            System.out.print(item);
    
                            try {
                                Thread.sleep(150);
                            }
                            catch (InterruptedException e) 
                            {
                                e.printStackTrace();
                            }
                        }

        while(!reviews.isEmpty())
        {
            data = reviews.dequeue();
            Review review = (Review) data;

            if(review.getProductName().equalsIgnoreCase(productName))
            {
                count++;
                System.out.println("TOTAL REVIEW FOUND : " + count);
                System.out.println("=====================");
                System.out.println("\nProduct Name : " +review.getProductName() + "\n"+ "Review Type  : " +  review.getReviewType() +
                                   "\n" + "Title        : " +review.getReviewTitle() + "\n" + "Rating       : " + review.getRating() + "/5" + "\n" +
                                   "Description  : \n" +review.getReviewDescription());
            }
            else
            {
                System.out.println("\nThe product not found!!!");
            }
            temp.enqueue(review);

        }

        while(!temp.isEmpty())
        {
            data = temp.dequeue();
            reviews.enqueue(data);
        }
    }

    public boolean addReview(Review review, Queue reviews){

        reviews.enqueue(review);
        return true;
    }
}