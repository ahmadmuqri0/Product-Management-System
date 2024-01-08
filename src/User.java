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

    public void totalProduct(LinkedList products) {
    
            Object data = products.getFirst();
            int count = 0;
    
            while(data != null){
                Product product = (Product) data;
                count++;
                data = products.getNext();
                
            }
            System.out.println("\nTotal Product : " + count);
            System.out.println("-------------------");
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
    
    public void searchProductName(LinkedList products){
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
        
        int count = 0;

        while(data != null){
            product = (Product) data;
            
            if(product.getProductName().equalsIgnoreCase(productName)){ 
                count++;
            }
            data = products.getNext();
        }
        
        System.out.println("\nTotal Product Found : "+ count);
        System.out.println("=======================");

        data = products.getFirst();
        
        while(data != null){
            product = (Product) data;
  
            if(product.getProductName().equalsIgnoreCase(productName)){

                System.out.println("\n" + "Product ID   : " + product.getProductID() + "\n"+ "Name         : " +  product.getProductName() +
                                   "\n" + "Brand        : " + product.getProductBrand() + "\n" + "Price        : " + product.getProductPrice() + "\n" 
                                        + "Availability : " + product.getProductAvailability());
            }
            data = products.getNext();
        }
        sc.close();
    }

    public void searchProductID(LinkedList products){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter product ID");
        String productID = sc.nextLine();

        Product product = new Product(productID,"","",0.0,"");
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

        int count = 0;

        while(data != null){
            product = (Product) data;
            
            if(product.getProductID().equalsIgnoreCase(productID)){ 
                count++;
            }
            data = products.getNext();
        }
        
        System.out.println("\nTotal Product Found : "+ count);
        System.out.println("=======================");

        data = products.getFirst();
        
        while(data != null){
            product = (Product) data;           
            
            if(product.getProductID().equalsIgnoreCase(productID)){

                System.out.println("\n" + "Product ID   : " + product.getProductID() + "\n"+ "Name         : " +  product.getProductName() +
                                   "\n" + "Brand        : " + product.getProductBrand() + "\n" + "Price        : " + product.getProductPrice() + "\n" 
                                        + "Availability : " + product.getProductAvailability());
            }
            data = products.getNext();
        }
        sc.close();
    }

    public void searchProductBrand(LinkedList products){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter product ID");
        String productBrand = sc.nextLine();

        Product product = new Product("","",productBrand,0.0,"");
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

        int count = 0;

        while(data != null){
            product = (Product) data;
            
            if(product.getProductBrand().equalsIgnoreCase(productBrand)){ 
                count++;
            }
            data = products.getNext();
        }
        
        System.out.println("\nTotal Product Found : "+ count);
        System.out.println("=======================");

        data = products.getFirst();
        
        while(data != null){
            product = (Product) data;
                
            if(product.getProductBrand().equalsIgnoreCase(productBrand)){

                System.out.println("\n" + "Product ID   : " + product.getProductID() + "\n"+ "Name         : " +  product.getProductName() +
                                   "\n" + "Brand        : " + product.getProductBrand() + "\n" + "Price        : " + product.getProductPrice() + "\n" 
                                        + "Availability : " + product.getProductAvailability());
            }
            data = products.getNext();
        }
        sc.close();
    }

    public void searchProductPrice(LinkedList products){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter product price");
        double productPrice = sc.nextDouble();
   
        Product product = new Product("","","",productPrice,"");
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
        
        int count = 0;

        while(data != null){
            product = (Product) data;
            
            if(product.getProductPrice() == productPrice){ 
                count++;
            }
            data = products.getNext();
        }

        System.out.println("\nTotal Product Found : "+ count);
        System.out.println("------------------------");

        data = products.getFirst();

        while(data != null){
            product = (Product) data;

            if(product.getProductPrice() == productPrice){
                System.out.println("\n" + "Product ID   : " + product.getProductID() + "\n"+ "Name         : " +  product.getProductName() +
                "\n" + "Brand        : " + product.getProductBrand() + "\n" + "Price        : " + product.getProductPrice() + "\n" 
                + "Availability : " + product.getProductAvailability());
            }
            data = products.getNext();
        }
        sc.close();
    }
    
    public void totalReview(Queue reviews){
        Queue temp = new Queue();
        Object data;
        int count = 0;
     
        while(!reviews.isEmpty()){
           data = reviews.dequeue();
           Review review = (Review) data;
           count++;
           temp.enqueue(review);
        }
     
        System.out.println("Total Reviews : " + count);
        System.out.println("------------------");
     
        while(!temp.isEmpty()){
            data = temp.dequeue();
            reviews.enqueue(data);
        }
     }

    public void displayReview(Queue reviews) {
        Queue temp = new Queue();
        Object data;
        int count = 0;
        
        while (!reviews.isEmpty()) {
            data = reviews.dequeue();
            Review review = (Review) data;

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

    public void searchReviewName(Queue reviews)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter product name to search for review");
        String productName = sc.nextLine();

        Queue temp = new Queue();
        Queue display = new Queue();
        boolean found = false;
        Object data;
        int count = 0;

        String[] items = {"\nS","E","A","R","C","H","I","N","G",".",".",".\n"};
                
        for (String item : items) 
        {
            System.out.print(item);

            try 
            {
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
                display.enqueue(review);
                found = true;
                count++;
            }
            temp.enqueue(review);
        }
        
        System.out.println("Total Review Found : " + count);
        System.out.println("----------------------");

        while(!temp.isEmpty())
        {
            data = temp.dequeue();
            reviews.enqueue(data);
        }

        if (found)
        {
            while (!display.isEmpty()) {

                data = display.dequeue();
                Review review = (Review) data;

                System.out.println(
                    "\nProduct Name : " +review.getProductName() + "\n"+ "Review Type  : " +  review.getReviewType() +
                    "\n" + "Title        : " +review.getReviewTitle() + "\n" + "Rating       : " + review.getRating() + "/5" + "\n" +
                    "Description  : \n" +review.getReviewDescription()
                );
            }
        }
        else
        {
            System.out.println("\nThe product not found!!!");
        }

        while(!temp.isEmpty())
        {
            data = temp.dequeue();
            reviews.enqueue(data);
        }
        sc.close();
    }

    public void searchReviewType(Queue reviews)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter review type ( Bad / Good )");
        String reviewType = sc.nextLine();

        Queue temp = new Queue();
        Queue display = new Queue();
        boolean found = false;
        Object data;
        int count = 0;

        String[] items = {"\nS","E","A","R","C","H","I","N","G",".",".",".\n"};
                
        for (String item : items) 
        {
            System.out.print(item);

            try 
            {
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

            if(review.getReviewType().equalsIgnoreCase(reviewType))
            {
                display.enqueue(review);
                found = true;
                count++;
            }
            temp.enqueue(review);
        }
        
        System.out.println("Total Review Found : " + count);
        System.out.println("--------------------=");

        while(!temp.isEmpty())
        {
            data = temp.dequeue();
            reviews.enqueue(data);
        }

        if (found)
        {
            while (!display.isEmpty()) {

                data = display.dequeue();
                Review review = (Review) data;

                System.out.println(
                    "\nProduct Name : " +review.getProductName() + "\n"+ "Review Type  : " +  review.getReviewType() +
                    "\n" + "Title        : " +review.getReviewTitle() + "\n" + "Rating       : " + review.getRating() + "/5" + "\n" +
                    "Description  : \n" +review.getReviewDescription()
                );
            }
        }
        else
        {
            System.out.println("\nThe product not found!!!");
        }

        while(!temp.isEmpty())
        {
            data = temp.dequeue();
            reviews.enqueue(data);
        }
        sc.close();
    }

    public void searchReviewRating(Queue reviews)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter review rating (1-5)");
        int rate = sc.nextInt();

        Queue temp = new Queue();
        Queue display = new Queue();
        boolean found = false;
        Object data;
        int count = 0;

        String[] items = {"\nS","E","A","R","C","H","I","N","G",".",".",".\n"};
                
        for (String item : items) 
        {
            System.out.print(item);

            try 
            {
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

            if(review.getRating() == rate)
            {
                display.enqueue(review);
                found = true;
                count++;
            }
            temp.enqueue(review);
        }
        
        System.out.println("Total Review Found : " + count);
        System.out.println("---------------------");

        while(!temp.isEmpty())
        {
            data = temp.dequeue();
            reviews.enqueue(data);
        }

        if (found)
        {
            while (!display.isEmpty()) {

                data = display.dequeue();
                Review review = (Review) data;

                System.out.println(
                    "\nProduct Name : " +review.getProductName() + "\n"+ "Review Type  : " +  review.getReviewType() +
                    "\n" + "Title        : " +review.getReviewTitle() + "\n" + "Rating       : " + review.getRating() + "/5" + "\n" +
                    "Description  : \n" +review.getReviewDescription()
                );
            }
        }
        else
        {
            System.out.println("\nThe product not found!!!");
        }

        while(!temp.isEmpty())
        {
            data = temp.dequeue();
            reviews.enqueue(data);
        }
        sc.close();
    }

    public boolean addReview(Review review, Queue reviews){

        reviews.enqueue(review);
        return true;
    }
}
