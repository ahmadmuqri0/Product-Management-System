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

                try {
                    Thread.sleep(70);
                }
                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
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
            
            System.out.println("\nSelect prefered category : ");
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
    
                    try {
                        Thread.sleep(150);
                    }
                    catch (InterruptedException e) 
                    {
                        e.printStackTrace();
                    }
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
            System.out.println();
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
            System.out.println("");
            System.out.println("    ---------------   [2] Remove User      ---------------");
            System.out.println("");
            System.out.println("    ---------------   [3] Remove Review    ---------------");
            System.out.println("");
            System.out.println("    ---------------   [4] Add Product      ---------------");
            System.out.println("");
            System.out.println("    ---------------   [5] Remove Product   ---------------");
            System.out.println("");
            System.out.println("    ---------------   [6] Log out          ---------------");
            System.out.println("    ======================================================");

            System.out.println("\nSelect prefered category : ");
            int option = sc.nextInt();

            if (option == 1) 
            {
                System.out.println("How many user to add?");
                int newUser = sc.nextInt();

                for(int i = 0; i < newUser; i++)
                {
                    System.out.println("\nUser " + (i+1));

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
        
                                    try {
                                        Thread.sleep(150);
                                    }
                                    catch (InterruptedException e) 
                                    {
                                        e.printStackTrace();
                                    }
                                }
        
                        System.out.println("\nSuccessfully add new user");
                    }
                    else{
                        System.out.println("\nFailed to add the user.");
                    }
                    
                }
            }

            else if (option == 2) 
            {
                System.out.println("\nHow many user to remove?");
                int removeUser = sc.nextInt();

                for(int i = 0; i < removeUser; i++)
                {
                    System.out.println("\nUser " + (i+1));
                    
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
        
                                    try {
                                        Thread.sleep(125);
                                    }
                                    catch (InterruptedException e) 
                                    {
                                        e.printStackTrace();
                                    }
                                }
                        
                        System.out.println("\nUser successfully removed");
                    }
                    else{
                        System.out.println("\nFailed to remove the user.");
                    }
                }

            }

            else if (option == 3) 
            {
               System.out.println("\nHow many review to removed?");
               int remReview = sc.nextInt();
               sc.nextLine();

               for(int i = 0; i < remReview; i++)
               {
                    System.out.println("Enter product name");
                    String productName = sc.nextLine();

                    Review obj = null;
                    Queue tempQueue = new Queue();

                    while (!reviews.isEmpty()) {
                        obj = (Review) reviews.dequeue();
                        if (obj.getProductName().equalsIgnoreCase(productName)) {
                            tempQueue.enqueue(obj);
                            break;
                        }
                        tempQueue.enqueue(obj);
                    }

                    while (!tempQueue.isEmpty()) {
                        Object data = tempQueue.dequeue();
                        reviews.enqueue(data);
                    }

                    boolean removed = admin.removeReview(obj, reviews);
                    
                    String[] items = {"\nU","P","D","A","T","I","N","G",".",".","."};
                
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
                        

                    if (removed)
                    {
                        reviewData.updateReview(reviews);
                        System.out.println("Review has been removed from the system.");
                    }
                    else{
                        System.out.println("The review does not exist or invalid input.");
                    }
                }
                }
            }

            else if (option == 4) 
            {
                System.out.println("\nHow many product to add?");
                int addProd = sc.nextInt();
                sc.nextLine();

                for(int i = 0; i < addProd ; i++){
                   
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
                    //products.insertAtBack(product);

                    String[] items = {"U","P","D","A","T","I","N","G",".",".","."};
                
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

                    admin.addProduct(product, products);
                    productData.updateProduct(products);

                }
            }

            else if (option == 5) 
            {
                /*System.out.println("How many product to remove?");
                int remProd = sc.nextInt();
                sc.nextLine();

                for(int i = 0; i < remProd ; i++){*/
                    
                    System.out.println("Enter product name : ");
                    String productName = sc.nextLine();

                    Product product = new Product( "",productName, " ", 0.0 , "");
                    
                    String[] items = {"U","P","D","A","T","I","N","G"," .",".",". "};
                
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

                    boolean removed = admin.removeProduct(product, products);

                    if (removed) 
                    {
                        System.out.println("\nProduct removed successfully");
                        productData.updateProduct(products);
                    }
                    else{
                        System.out.println("\nFailed to remove product or product does not exist");
                    }
                //}
            }
            
            else if (option == 6) 
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
            System.out.println("                   [4] Log Out                         ");
            System.out.println("    ===================================================");

            System.out.println("\nSelect prefered category :");
            int option = sc.nextInt();
            clearConsole();

            if (option == 1) 
            {
                System.out.println("==============================================================");
                System.out.println("                        Product list                          ");
                System.out.println("==============================================================\n");
                user.totalProduct(products);
                user.displayProduct(products);

                System.out.println("Do you have specific product to find? (Y/N)");
                char search = sc.next().charAt(0);
                
                
                if(search == 'y' || search == 'Y')
                {
                    user.searchProduct(products); 

                    System.out.println("\nDo you want to search more product? (Y/N)");
                    char more = sc.next().charAt(0);
                    
                    while(more == 'y' || more == 'Y'){
                        user.searchProduct(products);
                        System.out.println("\nDo you want to search more product? (Y/N)");
                        more = sc.next().charAt(0);
                    }
                    
                }
                else
                {
                    clearConsole();
                    userSession(user);
                }

            }

            else if (option == 2) 
            {
                user.displayReview(reviews);
                System.out.println("\nDo you have specific review to find? (Y/N)");
                char answer = sc.next().charAt(0);
                
                
                if(answer == 'y' || answer == 'Y')
                {
                    user.searchReview(reviews);  
                }
                else
                {
                    clearConsole();
                    userSession(user);
                }
            }

            else if (option == 3) 
            {
                /*System.out.println("\nEnter number of review to add :");
                int addNumR = sc.nextInt();
                sc.nextLine();
                
                for(int i = 0; i < addNumR; i++)
                {*/
                    System.out.println("\nEnter product name");
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
                    reviewData.addReviewToFile(review);
                    
                    if (added) 
                    {
                        reviewData.updateReview(reviews);
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
    
                        System.out.println("\nReview added successfully!");
                    }
                    else{
                        System.out.println("\nFailed to add review.");
                    }
                //}
                

            }

            else if (option == 4) 
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
}

