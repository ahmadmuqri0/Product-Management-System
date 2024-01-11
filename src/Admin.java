import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Admin {
    private int adminID;
    private String password;

    public Admin(int adminID, String password) {
        this.adminID = adminID;
        this.password = password;
    }

    public int getAdminID() {
        return adminID;
    }

    public String getPassword() {
        return password;
    }

    public boolean addUser(User user, LinkedList users) {

        boolean found = false;
        Object data = users.getFirst();

       while (data != null) {
            User temp = (User) data;
            if (temp.getUserName().equals(user.getUserName())) {
                if (temp.getUserID() == user.getUserID()) {
                    found = true;
                }
            }
            data = users.getNext();
        }

        if (found) {
            System.out.println("User already exist!");
            return false;
        }
        
        users.insertAtBack(user);
        return true;
    }

    public boolean removeUser(User user, LinkedList users) {

        boolean found = false;
        Object data = users.getFirst();

        while (data != null) {
            User temp = (User) data;
            if (temp.getUserName().equals(user.getUserName())) {
                if (temp.getUserID() == user.getUserID()) {
                    found = true;
                    break;
                }
            }
            data = users.getNext();
        }

        if (found) {
            users.remove(data);
            return true;
        }
        
        System.out.println("User does not exist!");
        return false;
    }

    public boolean removeReview(Review review, Queue reviews){

        boolean found = false;
        Queue tempQueue = new Queue();

        while(!reviews.isEmpty()) {
            Review temp = (Review) reviews.dequeue();
            if(!temp.getProductName().equalsIgnoreCase(review.getProductName())){
                tempQueue.enqueue(temp);
            }
            else{
                found = true;
            }
        }

        while(!tempQueue.isEmpty()){
            reviews.enqueue(tempQueue.dequeue());
        }

        return found;
    }

    public boolean addProduct(Product product, LinkedList products){
    
        boolean found = false;
        Object data = products.getFirst();

        while(data != null){
            Product temp = (Product) data;
            if(temp.getProductName().equalsIgnoreCase(product.getProductName())){
                if(temp.getProductID().equalsIgnoreCase(product.getProductID())){
                    found = true;
                }
            }
            data = products.getNext();
        }
            if (found) {
                System.out.println("Product already exist!");
                return false;
            }
            
        products.insertAtBack(product);
        return true;
    }

    public boolean removeProduct(Product product, LinkedList products){

        boolean found = false;
        Object data = products.getFirst();

        while( data != null){
            Product temp = (Product) data;
            if(temp.getProductName().equalsIgnoreCase(product.getProductName())){
                found = true;
                break;
            }
            data = products.getNext();
        }

        if(found){
            products.remove(data);
            return true;
        }

        System.out.println("Product does not exist!");
        return false;
    }
    
    String filePath = "data/product.txt";
    FileProduct fileProduct = new FileProduct(filePath);

    public void updateProductName(LinkedList products) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter product name to update : ");
        String productName = sc.nextLine();
        System.out.println("Enter new product name : ");
        String newProductName = sc.nextLine();
    
        Object data = products.getFirst();
        boolean updated = false;
    
        while (data != null) {
            Product product = (Product) data;
            if (product.getProductName().equalsIgnoreCase(productName)) {
                product.setProductName(newProductName);
                break;  // Assuming product names are unique, exit loop once found
            }
            data = products.getNext();
        }
    
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            data = products.getFirst();  // Reset the pointer
            while (data != null) {
                String entry = ((Product) data).toString();
                writer.println(entry);
                data = products.getNext();
            }
        } catch (IOException e) {
            System.out.println("Error writing to user file : " + e.getMessage());
        }

        if (updated) {
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
        }
        
        else {
            System.out.println("Product name not found or no update performed.");
        }
    }

    public void updateProductID(LinkedList products) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product ID to update : ");
        String productID = sc.nextLine();
        System.out.print("Enter new product ID : ");
        String newProductID = sc.nextLine();
    
        Object data = products.getFirst();
    
        boolean updated = false;

        while (data != null) {
            Product product = (Product) data;
            if (product.getProductID().equalsIgnoreCase(productID)) {
                product.setProductID(newProductID);
                break;  // Assuming product names are unique, exit loop once found
            }
            data = products.getNext();
        }
    
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            data = products.getFirst();  // Reset the pointer
            while (data != null) {
                String entry = ((Product) data).toString();
                writer.println(entry);
                data = products.getNext();
            }
        } catch (IOException e) {
            System.out.println("Error writing to user file : " + e.getMessage());
        }

        if (updated) {
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
            System.out.println("Successfully updated");
            return;

        }
        
        else {
            System.out.println("Product name not found or no update performed.");
        }
    }

    public void updateProductBrand(LinkedList products) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter product ID to update: ");
        String productID = sc.nextLine();
        System.out.println("Enter new product brand : ");
        String newProductBrand = sc.nextLine();
    
        Object data = products.getFirst();
    
        boolean updated = false;

        while (data != null) {
            Product product = (Product) data;
            if (product.getProductID().equalsIgnoreCase(productID)) {
                product.setBrand(newProductBrand);
                break;  // Assuming product names are unique, exit loop once found
            }
            data = products.getNext();
        }
    
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            data = products.getFirst();  // Reset the pointer
            while (data != null) {
                String entry = ((Product) data).toString();
                writer.println(entry);
                data = products.getNext();
            }
        } catch (IOException e) {
            System.out.println("Error writing to user file : " + e.getMessage());
        }

        if (updated) {
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
        }
        
        else {
            System.out.println("Product name not found or no update performed.");
        }
    }

    public void updateProductPrice(LinkedList products) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter product ID to update : ");
        String productID = sc.nextLine();
        System.out.println("Enter new product price : ");
        double newProductPrice = sc.nextDouble();
    
        Object data = products.getFirst();
    
        boolean updated = false;
        while (data != null) {
            Product product = (Product) data;
            if (product.getProductID().equalsIgnoreCase(productID)) {
                product.setProductPrice(newProductPrice);
                break;  // Assuming product names are unique, exit loop once found
            }
            data = products.getNext();
        }
    
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            data = products.getFirst();  // Reset the pointer
            while (data != null) {
                String entry = ((Product) data).toString();
                writer.println(entry);
                data = products.getNext();
            }
        } catch (IOException e) {
            System.out.println("Error writing to user file : " + e.getMessage());
        }

        if (updated) {
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
        }
        
        else {
            System.out.println("Product name not found or no update performed.");
        }
    }
    
    public void updateProductAvailability(LinkedList products) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product ID to update: ");
        String productID = sc.nextLine();
        System.out.println("Enter new product availability: ");
        String newProductAvailability = sc.nextLine();
    
        Object data = products.getFirst();
    
        boolean updated = false;
        while (data != null) {
            Product product = (Product) data;
            if (product.getProductID().equalsIgnoreCase(productID)) {
                product.setProductAvailability(newProductAvailability);
                break;  // Assuming product names are unique, exit loop once found
            }
            data = products.getNext();
        }
    
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            data = products.getFirst();  // Reset the pointer
            while (data != null) {
                String entry = ((Product) data).toString();
                writer.println(entry);
                data = products.getNext();
            }
        } catch (IOException e) {
            System.out.println("Error writing to user file : " + e.getMessage());
        }

        if (updated) {
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
        }
        
        else {
            System.out.println("Product name not found or no update performed.");
        }
    }
    
}
