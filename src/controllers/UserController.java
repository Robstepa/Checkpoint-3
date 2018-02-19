package controllers;

import dao.DbDAO;
import model.BookModel;
import view.UserView;

public class UserController{

    private UserView view;
    private DbDAO dao;

    public UserController(){
        view = new UserView();
        dao = new DbDAO();
    }

    public void handleMenu(){
        boolean isDone = false;
        while (!isDone){
            view.clearScreen();
            view.printUserMenu();
            String userInput = view.getUserInput("Choose: ");
            switch (userInput){
                case "1":
                    addNewBook();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;    
                case "0":
                    isDone = true;
                    break;
            }
        }
    }

    private void addNewBook(){
        String isbn = view.getUserInput("Enter ISBN: ");
        String author = view.getUserInput("Enter author: ");
        String title = view.getUserInput("Enter title: ");
        String publisher = view.getUserInput("Enter publisher: ");
        int publicationYear = Integer.parseInt(view.getUserInput("Enter publication year: "));
        int price = Integer.parseInt(view.getUserInput("Enter price: "));
        String type = view.getUserInput("Enter type: ");
        dao.addNewBook(new BookModel(isbn, author, title, publisher, publicationYear, price, type));
        view.printMessege("Done");
    }
}