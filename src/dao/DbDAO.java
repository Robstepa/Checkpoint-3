package dao;

import view.View;
import model.BookModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class DbDAO{

    View view;
    Connection connection;
    Statement statement;

    public DbDAO(){
        view = new View();
        connection = null;
        statement = null;
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
}