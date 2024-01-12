import java.util.Scanner;
import java.io.IOException;

public class App 
{

    static Scanner sc = new Scanner(System.in);
    
    static FileUser userData = null;
    static LinkedList users = null;

    static FileReview reviewData = null;
    static Queue reviews = null;

    static FileProduct productData = null;
    static LinkedList products = null;

    public static void main(String[] args) {

        userData = new FileUser("data/user.txt");
        users = userData.loadUser();

        reviewData = new FileReview("data/review.txt");
        reviews = reviewData.loadReview();

        productData = new FileProduct("data/product.txt");
        products = productData.loadProduct();

        String[] items = {".",".",".",".",".",".","M","E","G","A","H", " ", "H","O","L", "D","I","N","G",".",".",".",".",".",".","\n"
                          ,"S","T","A","R","T","I","N","G"," T","H","E ","P","R","O","G","R","A","M",".",".",".",".","."};
            for (String item : items) 
            {
                System.out.print(item);
                sleep(70);
            }
            
            
        while (true) 
        {
            
            System.out.println("\n==================================================================");
            System.out.println("||                                                              ||");
            System.out.println("||    MEGAH HOLDING PRODUCT REVIEW SYSTEM                       ||");
            System.out.println("||                                                              ||");
            System.out.println("||    Search every product or review based on your desire!!!    ||");
            System.out.println("||                                                              ||");
            System.out.println("||              +================================+              ||");
            System.out.println("||              |             WELCOME            |              ||");
            System.out.println("||              +--------------------------------+              ||");
            System.out.println("||              | 1.| Login as Admin             |              ||");
            System.out.println("||              +--------------------------------+              ||");
            System.out.println("||              | 2.| Login as User              |              ||");
            System.out.println("||              +--------------------------------+              ||");
            System.out.println("||              | 3.| Exit                       |              ||");
            System.out.println("||              +================================+              ||");
            System.out.println("||                                                              ||");
            System.out.println("==================================================================");
            
            System.out.print("\nSelect prefered category : ");
            int option = sc.nextInt();

            if (option == 1) {
                adminAuth();
            }
            else if (option == 2) {
                userAuth();
            }
            else if (option == 3) {
                
                String[] itemss = {"\nT","H","A","N","K"," Y","O","U",".",".",".",".","."};
                for (String item : itemss) 
                {
                    System.out.print(item);
                    sleep(150);
                }
                
                break;
            }
            else {
                clearConsole();
                System.out.println("\nInvalid input. Please try again");
            }
        }
        sc.close();
    }

    private static void adminAuth() {

        FileAdmin adminData = new FileAdmin("data/admin.txt");
        LinkedList admins = adminData.loadAdmin();

        while (true) 
        {
            System.out.println("\nEnter your ID: ");
            int id = sc.nextInt();

            System.out.println("Enter your password: ");
            String password = sc.next();

            Admin admin = null;
            boolean found = false;
            Object data = admins.getFirst();

            while (data != null) {
                admin = (Admin) data;
                if (id == admin.getAdminID()) 
                {
                    if (password.equals(admin.getPassword())) {
                        found = true;
                        break;
                    }
                }
                data = admins.getNext();
            }
                

            if (found) 
            {
                clearConsole();
                adminSession(admin);
                break;
            }
            
            else 
            {
                System.out.println("Invalid credentials , please try again.");
            }
        }

    }

    private static void userAuth() 
    {
        while (true) 
        {
            System.out.print("\nEnter username: ");
            String username = sc.next();
    
            System.out.print("Enter user ID: ");
            int id = sc.nextInt();
    
            User user = null;
            boolean found = false;

            Object data = users.getFirst();
            while (data != null) 
            {
                user = (User) data;
                if (username.equals(user.getUserName())) 
                {
                    if (id == user.getUserID()) 
                    {
                        found = true;
                        break;
                    }
                }
                data = users.getNext();
            }
    
            if (found) 
            {
                clearConsole();
                userSession(user);
                break;
            }
            else 
            {
                System.out.println("Invalid credentials , please try again.");
            }
        }
    }

    private static void adminSession(Admin admin) 
    {
        while (true) 
        {
            System.out.println();
            System.out.println("    ======================================================");
            System.out.println("                   Welcome to Admin Page!                 ");
            System.out.println("    ======================================================");
            System.out.println("    ---------------   [1] Add User         ---------------");
            System.out.println("    ---------------   [2] Remove User      ---------------");
            System.out.println("    ---------------   [3] Remove Review    ---------------");
            System.out.println("    ---------------   [4] Add Product      ---------------");
            System.out.println("    ---------------   [5] Remove Product   ---------------");
            System.out.println("    ---------------   [6] Update Product   ---------------");
            System.out.println("    ---------------   [7] Log out          ---------------");
            System.out.println("    ======================================================");

            System.out.println("\nSelect prefered category : ");
            int option = sc.nextInt();

            if (option == 1) 
            {
                System.out.print("\nRegister username: ");
                String username = sc.next();
                
                System.out.print("Register User's ID: ");
                int id = sc.nextInt();
                
                User user = new User(username, id);
                boolean added = admin.addUser(user, users);
                
                if (added) 
                {
                    userData.updateUser(users);
                    
                    String[] items = {"\nU","P","D","A","T","I","N","G",".",".","."};
                    
                            for (String item : items) 
                            {
                                System.out.print(item);
                                sleep(150);
                            }
    
                    System.out.println("\nSuccessfully add new user");
                }
                else
                {
                    System.out.println("\nFailed to add the user.");
                }  
                pause();
                clearConsole();  
            }

            else if (option == 2) 
            {            
                System.out.print("\nEnter username: ");
                String username = sc.next();

                System.out.print("Enter user's ID: ");
                int id = sc.nextInt();

                User user = new User(username, id);
                boolean removed = admin.removeUser(user, users);

                if (removed) 
                {
                    userData.updateUser(users);
                    String[] items = {"\nU","P","D","A","T","I","N","G",".",".","."};
                    
                    for (String item : items) 
                    {
                        System.out.print(item);
                        sleep(150);
                    }
                    
                    System.out.println("\nUser successfully removed");
                }
                else
                {
                    System.out.println("\nFailed to remove the user.");
                }
                pause();
                clearConsole();
            }

            else if (option == 3) 
            {
                System.out.println("Enter product name");
                sc.nextLine();
                String productName = sc.nextLine();

                boolean removed = admin.removeReview(productName, reviews);
                
                String[] items = {"\nU","P","D","A","T","I","N","G",".",".",".\n"};
            
                for (String item : items) 
                {
                    System.out.print(item);
                    sleep(150);
                }

                if (removed)
                {
                    reviewData.updateReview(reviews);
                    System.out.println("Review has been removed from the system.");
                }
                else{
                    System.out.println("The review does not exist or invalid input.");
                }  
                pause();
                clearConsole();
            }

            else if (option == 4) 
            {                 
                System.out.println("Enter product id");
                String productID = sc.nextLine();

                System.out.println("Enter product name");
                String productName = sc.nextLine();

                System.out.println("Enter product brand");
                String productBrand = sc.nextLine();

                System.out.println("Enter product price");
                double productPrice = sc.nextDouble();
                sc.nextLine();

                System.out.println("Enter product availability");
                String productAvailability = sc.nextLine();

                Product product = new Product(productID, productName, productBrand, productPrice, productAvailability);

                String[] items = {"U","P","D","A","T","I","N","G",".",".","."};
            
                for (String item : items) 
                {
                    System.out.print(item);
                    sleep(150);
                }

                admin.addProduct(product, products);
                productData.updateProduct(products);

                pause();
                clearConsole();
            }
            

            else if (option == 5) 
            {                   
                System.out.println("Enter product name : ");
                String productName = sc.nextLine();

                Product product = new Product( "",productName, " ", 0.0 , "");
                
                String[] items = {"U","P","D","A","T","I","N","G"," .",".",". "};
            
                for (String item : items) 
                {
                    System.out.print(item);
                    sleep(150);
                }

                boolean removed = admin.removeProduct(product, products);

                if (removed) 
                {
                    System.out.println("\nProduct removed successfully");
                    productData.updateProduct(products);
                }
                else{
                    System.out.println("\nFailed to remove product or product does not exist");
                }
                pause();
                clearConsole();
            }

            else if(option == 6)
            {
                System.out.println("\n=============================");
                System.out.println("           UPDATE           ");
                System.out.println("=============================");
                System.out.println("           [1] ID              ");
                System.out.println("           [2] NAME            ");
                System.out.println("           [3] BRAND           ");
                System.out.println("           [4] PRICE           ");
                System.out.println("           [5] AVAILABILITY  \n");

                System.out.print("Enter update choice : ");
                int choice = sc.nextInt();

                if(choice == 1)
                {
                    admin.updateProductID(products);
                    String[] items = {"\nU","P","D","A","T","I","N","G",".",".",".\n"};

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
                    productData.updateProduct(products);
                }

                else if (choice == 2)
                {
                    admin.updateProductName(products);
                    String[] items = {"\nU","P","D","A","T","I","N","G",".",".",".\n"};

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
                    productData.updateProduct(products);
                }
                else if (choice == 3)
                {
                    admin.updateProductBrand(products);
                    String[] items = {"\nU","P","D","A","T","I","N","G",".",".",".\n"};

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
                    productData.updateProduct(products);
                }
                else if (choice == 4)
                {
                    admin.updateProductPrice(products);
                    String[] items = {"\nU","P","D","A","T","I","N","G",".",".",".\n"};

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
                    productData.updateProduct(products);
                }
                else if (choice == 5)
                {
                    admin.updateProductAvailability(products);
                    String[] items = {"\nU","P","D","A","T","I","N","G",".",".",".\n"};

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
                    productData.updateProduct(products);
                }
                pause();
                clearConsole();
            }
        
            else if (option == 7) 
            {
                clearConsole();
                break;
            }

            else 
            {
                System.out.println("\nInvalid input. Please enter correctly.");
            }
        }
        
    }
    
    private static void userSession(User user) 
    {
        while (true) 
        {

            System.out.println();
            System.out.println("    ===================================================");
            System.out.println("                   Welcome to User Page!               ");
            System.out.println("    ===================================================");
            System.out.println("                   [1] Display Product                 ");
            System.out.println("    ---------------------------------------------------");
            System.out.println("                   [2] Display Review                  ");
            System.out.println("    ---------------------------------------------------");
            System.out.println("                   [3] Add Review                      ");
            System.out.println("    ---------------------------------------------------");
            System.out.println("                   [4] Update Review                   ");
            System.out.println("    ---------------------------------------------------");
            System.out.println("                   [5] Log Out                         ");
            System.out.println("    ===================================================");

            System.out.print("\nSelect prefered category :");
            int option = sc.nextInt();
            clearConsole();

            if (option == 1) 
            {
                System.out.println("==============================================================");
                System.out.println("                        Product list                          ");
                System.out.println("==============================================================\n");
                user.totalProduct(products);
                user.displayProduct(products);

                System.out.println("\nDo you have specific product to find? (Y/N)");
                char search = sc.next().charAt(0);
                
                
                if(search == 'y' || search == 'Y')
                {
                    System.out.println("\n=============================");
                    System.out.println("           SEARCH BY           ");
                    System.out.println("=============================");
                    System.out.println("           [1] ID              ");
                    System.out.println("           [2] NAME            ");
                    System.out.println("           [3] BRAND           ");
                    System.out.println("           [4] PRICE           \n");

                    System.out.print("Enter searching option : ");
                    int searchMethod = sc.nextInt();
                    sc.nextLine();

                    if(searchMethod == 1){
                        user.searchProductID(products);
                    }
                    else if(searchMethod == 2){
                        user.searchProductName(products); 
                    }
                    else if(searchMethod == 3){
                        user.searchProductBrand(products);                
                    }
                    else if(searchMethod == 4){
                        user.searchProductPrice(products);
                    }
                    
                    else {
                        System.out.println("Please enter option correctly");
                    }                   
                }
                pause();
                clearConsole();
            }

            else if (option == 2) 
            {
                System.out.println("==============================================================");
                System.out.println("                         Review List                          ");
                System.out.println("==============================================================\n");
                user.totalReview(reviews);
                user.displayReview(reviews);
                System.out.println("\nDo you have specific review to find? (Y/N)");
                char answer = sc.next().charAt(0);
                
                
                if(answer == 'y' || answer == 'Y')
                {
                    System.out.println("\n====================================");
                    System.out.println("              SEARCH BY               ");
                    System.out.println("====================================");
                    System.out.println("           [1] PRODUCT NAME           ");
                    System.out.println("           [2] REVIEW TYPE            ");
                    System.out.println("           [3] RATING                 \n");
                    
                    System.out.print("Enter searching option : ");   
                    int searchMethod = sc.nextInt();
                    sc.nextLine();

                    if(searchMethod == 1){
                        user.searchReviewName(reviews);
                    }
                    else if(searchMethod == 2){
                        user.searchReviewType(reviews);
                    }
                    else if(searchMethod == 3){
                        user.searchReviewRating(reviews);
                    }
                    else{
                        System.out.println("Please enter option correctly");
                    }
                }
                pause();
                clearConsole();
            }

            else if (option == 3) 
            {                
                System.out.println("\nEnter product name");
                sc.nextLine();
                String productName = sc.nextLine();

                System.out.println("Enter review title");
                String title = sc.nextLine();

                System.out.println("Enter review type");
                String type = sc.nextLine();

                System.out.println("Enter description");
                String description = sc.nextLine();

                System.out.println("Enter rating");
                int rating = sc.nextInt();

                Review review = new Review(productName, title, type, description, rating);
                boolean added = user.addReview(review, reviews);
                    
                if (added) 
                {
                    reviewData.updateReview(reviews);
                    String[] items = {"\nU","P","D","A","T","I","N","G",".",".",".\n"};
                
                    for (String item : items) 
                    {
                        System.out.print(item);
                        sleep(150);
                    }

                    System.out.println("\nReview added successfully!");
                }
                else
                {
                    System.out.println("\nFailed to add review.");
                }

                pause();
                clearConsole();
            }

            else if (option == 4) 
            {
                System.out.println("\n=============================");
                System.out.println("         UPDATE REVIEW     ");
                System.out.println("=============================");
                System.out.println("         [1] TITLE           ");
                System.out.println("         [2] TYPE           ");
                System.out.println("         [3] DESCRIPTION          ");
                System.out.println("         [4] RATING  \n");

                System.out.print("Enter choice of update : ");
                int choice = sc.nextInt();

                if(choice == 1)
                {
                    user.updateReviewTitle(reviews);
                    String[] items = {"\nU","P","D","A","T","I","N","G",".",".",".\n"};

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
                    reviewData.updateReview(reviews);
                }
                else if(choice == 2)
                {
                    user.updateReviewType(reviews);
                    String[] items = {"\nU","P","D","A","T","I","N","G",".",".",".\n"};

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
                    reviewData.updateReview(reviews);
                }
                else if(choice == 3)
                {
                    user.updateReviewDescription(reviews);
                    String[] items = {"\nU","P","D","A","T","I","N","G",".",".",".\n"};

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
                    reviewData.updateReview(reviews);
                }
                else if(choice == 4)
                {
                    user.updateReviewRating(reviews);
                    String[] items = {"\nU","P","D","A","T","I","N","G",".",".",".\n"};

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
                    reviewData.updateReview(reviews);
                }
                else 
                {
                    System.out.println("Invalid choice. Enter choice correctly!");
                }
                pause();
                clearConsole();
            }
            
            else if (option == 5) 
            {
                clearConsole();
                break;
            }

            else 
            {
                System.out.println("\nInvalid input. Please try again.");
            }
            
        }
    }

    private static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {}
    }

    private static void sleep(int mili){

        try {
                Thread.sleep(mili);
            }
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
    }

    private static void pause(){
        System.out.println("\nPress Enter to continue . . .");
        try{System.in.read();}
        catch(Exception e){}
    }
}
