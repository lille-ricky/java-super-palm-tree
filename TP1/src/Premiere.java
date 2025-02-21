/**
 * My first java class
 * @author Enrik Pashaj
 * @version 1.0
 * 
 */
public class Premiere {
    private String message = "Hello world!";

    /**
     * On utilise le constructeur par defaut
     */

    /**
     * Displays the content of the private attribute
     */
    public void affiche(){
        System.out.println(message);
    }

    /**
     * Returns the message
     */
    public String getMessage() {
        return message;
    }

    /** Redefiens the message  
     * 
    */
    public String setMessage(String newMessage) {
        this.message = newMessage;
        return message;
    }

}