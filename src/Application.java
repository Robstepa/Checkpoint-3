import java.io.File;

public class Application{

    public static void main(String[] args) {
        DbDAO db = new DbDAO();
        File file = new File("database/BookStore.db");
        if (!file.exists()){
            db.createDataBase();
        } 
    }
}