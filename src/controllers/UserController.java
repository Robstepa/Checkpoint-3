package controllers;

import java.util.ArrayList;

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
            //view.clearScreen();
            view.printUserMenu();
            String userInput = view.getUserInput("Choose: ");
            switch (userInput){
                case "1":
                    addNewBook();
                    break;
                case "2":
                    editBook(); //doesn`t work for now!!
                    break;
                case "3":
                    deleteBook();
                    break;
                case "4":
                    searchBooksBy();
                    break;
                case "5":
                    showAllBooks();
                    break;
                case "6":
                    showBooksByAuthor();
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

    private void editBook(){
        BookModel book = chooseBook();
        boolean isBookDataEdited = false;
        if (book != null){
            while(!isBookDataEdited){
                view.clearScreen();
                view.showEditBookMenu();
                String userInput = view.getUserInput("Choose: ");
                switch (userInput){
                    case "1":
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
                        isBookDataEdited = true;
                        break;
                }
            }
        } else {
            view.printMessege("There`s nothing to edit...");
        }
    }

    private BookModel chooseBook(){
        showAllBooks();
        ArrayList<BookModel> books = dao.getAllBooks();
        String userInput = view.getUserInput("Choose title: ");
        for (BookModel book : books){
            if (book.getTitle().equals(userInput)){
                return book;
            }
        }
        view.printMessege("There`s no such book..");
        return null; 
    }

    private void deleteBook(){
        BookModel book = chooseBook();
        dao.deleteBook(book);
    }

    private void searchBooksBy(){
        String parameter = view.getUserInput("Enter paremeter name: ");
        String searchPhrase = view.getUserInput("Enter search phrase: ");
        ArrayList<BookModel> searchedBooks = dao.searchBooksBy(parameter, searchPhrase);
        for (BookModel book : searchedBooks){
            view.printMessege(book.toString());
        }
    }

    private void showAllBooks(){
        ArrayList<BookModel> books = dao.getAllBooks();
        for (BookModel book : books){
            view.printMessege(book.toString());
        }
    }

    private void showBooksByAuthor(){
        String author = view.getUserInput("Enter author name: ");
        ArrayList<BookModel> books = dao.searchBooksByAuthor(author);
        for (BookModel book : books){
            view.printMessege(book.toString());
        }
    }
}