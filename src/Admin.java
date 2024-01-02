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
    
}
