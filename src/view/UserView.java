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
}