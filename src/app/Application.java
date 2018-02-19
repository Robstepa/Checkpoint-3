package app;

import java.io.File;

import dao.DbDAO;
import controllers.UserController;

public class Application{
    
    private DbDAO db;
    private UserController user;
    private String default_database_path;
    private File file;

    public Application(){
        db = new DbDAO();
        user = new UserController();
        default_database_path = "database/BookStore.db";
        file = new File(default_database_path);
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run(){
        if (!file.exists()){
            db.createDataBase();
        }
        user.handleMenu();
    }


}