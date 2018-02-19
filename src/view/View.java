package view;

import java.util.Scanner;

public class View{

    public void printMessege(String messege){
        System.out.println(messege);
    }

    public String getUserInput(String messege){
        System.out.print(messege);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        return input;
    }

    public void clearScreen() {  
        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (Exception exception)
        {
            System.out.println(exception.getClass().getName() + ": " + exception.getMessage());
        } 
    }  
}