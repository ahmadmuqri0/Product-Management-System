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
}
