package dao;

import view.View;
import model.BookModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DbDAO{

    View view;
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    public DbDAO(){
        view = new View();
        connection = null;
        statement = null;
        resultSet = null;
    }

    public void createDataBase(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database/BookStore.db");
            statement = connection.createStatement();
            String sql = readFromFile("database/init.sql");
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
            view.printMessege("Opened database successfully");
    }

    public String readFromFile(String filename){
        String data = "";
        try{
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNext()){
                data += scanner.nextLine() + "\n";
            }
        } catch (FileNotFoundException e){
            view.printMessege(e.getMessage());
        }
        return data;
    }


    public void addNewBook(BookModel book){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database/BookStore.db");
            statement = connection.createStatement();
            String sql = "INSERT INTO Books (ISBN, author, title, publisher, publication_year, price, type)" +
                         "VALUES('" +  
                         book.getIsbn() + "','" +
                         book.getAuthor() + "','" +
                         book.getTitle() + "','" +
                         book.getPublisher() + "'," +
                         book.getPublicationYear() + "," +
                         book.getPrice() + ",'" +
                         book.getType() + "');";
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }    

    public ArrayList<BookModel> getAllBooks(){
        ArrayList<BookModel> books= new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database/BookStore.db");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Books ORDER BY title ASC;");
            while(resultSet.next()){
                books.add(new BookModel(resultSet.getString("ISBN"),
                                        resultSet.getString("author"),
                                        resultSet.getString("title"),
                                        resultSet.getString("publisher"),
                                        resultSet.getInt("publication_year"),
                                        resultSet.getInt("price"),
                                        resultSet.getString("type")));
            }
        
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return books;
    }

    public void editBookData(){
    }

    public void deleteBook(BookModel book){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database/BookStore.db");
            statement = connection.createStatement();
            String sql = "DELETE from Books where title='" + book.getTitle() + "';";
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public ArrayList<BookModel> searchBooksBy(String parameter, String searchPhrase){
        ArrayList<BookModel> books= new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database/BookStore.db");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT *  from Books where " + parameter.toLowerCase() +  " ='" + searchPhrase + "';");
            while(resultSet.next()){
                books.add(new BookModel(resultSet.getString("ISBN"),
                                        resultSet.getString("author"),
                                        resultSet.getString("title"),
                                        resultSet.getString("publisher"),
                                        resultSet.getInt("publication_year"),
                                        resultSet.getInt("price"),
                                        resultSet.getString("type")));
            }
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return books;
    }

    public ArrayList<BookModel> searchBooksByAuthor(String author){
        ArrayList<BookModel> books= new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database/BookStore.db");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT *  FROM Books WHERE author ='" + author + "';");
            while(resultSet.next()){
                books.add(new BookModel(resultSet.getString("ISBN"),
                                        resultSet.getString("author"),
                                        resultSet.getString("title"),
                                        resultSet.getString("publisher"),
                                        resultSet.getInt("publication_year"),
                                        resultSet.getInt("price"),
                                        resultSet.getString("type")));
            }
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return books;
    }
}