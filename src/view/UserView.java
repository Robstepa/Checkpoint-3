package view;

public class UserView extends View{

    public void printUserMenu(){
        System.out.println("   MENU   \n" +
                           "1. Add new book\n" +
                           "2. Edit book\n" +
                           "3. Delete book\n" +
                           "4. Search book by parameter\n" +
                           "5. See all books\n" +
                           "6. See all books written by author\n" +
                           "0. Exit\n");
    }

    public void showEditBookMenu(){
        System.out.println("   MENU   \n" +
                           "1. Edit ISBN\n" +
                           "2. Edit author\n" +
                           "3. Edit title\n" +
                           "4. Edit publisher\n" +
                           "5. Edit publication year\n" +
                           "6. Edit price\n" +
                           "7. Edit type\n" +
                           "0. Exit\n");
    }
}