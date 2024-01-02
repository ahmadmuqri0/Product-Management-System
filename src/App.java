import java.util.Scanner;
// import java.io.IOException;

public class App 
{

    static Scanner sc = new Scanner(System.in);
    
    static FileUser userData = null;
    static LinkedList users = null;

    public static void main(String[] args) {

        userData = new FileUser("../data/user.txt");
        users = userData.loadUser();

        String[] items = {".",".",".","M", "E", "G", "A", "H", " ", "H", "O", "L", "D", "I", "N", "G",".",".",".",};
            for (String item : items) 
            {
                System.out.print(item + " "); // Add a space between items

                try {
                    Thread.sleep(250); // Delay for 250 milliseconds
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
            System.out.println("||    Search every product's or review based on your desire!!!  ||");
            System.out.println("||                                                              ||");
            System.out.println("||              ==================================              ||");
            System.out.println("||              |             WELCOME            |              ||");
            System.out.println("||              |================================|              ||");
            System.out.println("||              | 1.| Login as Admin             |              ||");
            System.out.println("||              | 2.| Login as User              |              ||");
            System.out.println("||              | 3.| Exit                       |              ||");
            System.out.println("||              ==================================              ||");
            System.out.println("||                                                              ||");
            System.out.println("==================================================================");
            
            System.out.println("\nEnter number (1/2/3) according your category: ");
            int option = sc.nextInt();

            if (option == 1) {
                adminAuth();
            }
            else if (option == 2) {
                userAuth();
            }
            else if (option == 3) {
                break;
            }
            else {
                System.out.println("Invalid input. Try again");
            }
        }
        sc.close();
    }
    

    private static void adminAuth() {

        FileAdmin adminData = new FileAdmin("../data/admin.txt");
        LinkedList admins = adminData.loadAdmin();

        while (true) 
        {
            System.out.println();
            System.out.println("Enter your ID: ");
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
            System.out.print("Enter username: ");
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
            System.out.println("==============================");
            System.out.println("|   welcome to Admin Page!   |\n");
            System.out.println("|============================|");
            System.out.println("| 1.| Add User               |");
            System.out.println("| 2.| Remove User            |");
            System.out.println("| 3.| Remove Review          |");
            System.out.println("| 4.| Add Product            |");
            System.out.println("| 5.| Remove Product         |");
            System.out.println("| 6.| Log out                |");
            System.out.println("==============================");
            int option = sc.nextInt();

            if (option == 1) 
            {
                System.out.print("Register username: ");
                String username = sc.next();

                System.out.print("Register User's ID: ");
                int id = sc.nextInt();

                User user = new User(username, id);
                boolean added = admin.addUser(user, users);

                if (added) 
                {
                    userData.updateUser(users);
                }
            }

            else if (option == 2) 
            {
                System.out.print("Enter username: ");
                String username = sc.next();

                System.out.print("Enter user's ID: ");
                int id = sc.nextInt();

                User user = new User(username, id);
                boolean removed = admin.removeUser(user, users);

                if (removed) 
                {
                    userData.updateUser(users);
                }
            }

            else if (option == 3) 
            {
                
            }

            else if (option == 4) 
            {
                
            }

            else if (option == 5) 
            {
                
            }
            
            else if (option == 6) 
            {
                break;
            }

            else 
            {
                System.out.println("Invalid input. Please enter correctly.");
            }
        }
        
    }
    
    private static void userSession(User user) 
    {
        while (true) 
        {
            System.out.println();
            System.out.println("=====================================");
            System.out.println("||      Welcome to User Page!      ||"); 
            System.out.println("||=================================||");
            System.out.println("|| 1. | Display product            ||");
            System.out.println("|| 2. | Display Review             ||");
            System.out.println("|| 3. | Add Review                 ||");
            System.out.println("|| 4. | Log out                    ||");
            System.out.println("=====================================");
            int option = sc.nextInt();

            if (option == 1) 
            {
                
            }

            else if (option == 2) 
            {
                
            }

            else if (option == 3) 
            {
                
            }

            else if (option == 4) 
            {
                break;
            }

            else 
            {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
    

    /* private static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {}
    } */

}
