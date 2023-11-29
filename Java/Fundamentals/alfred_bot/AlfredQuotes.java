import java.text.SimpleDateFormat;
import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        String greeting = String.format("Hello, %s. " + "Lovely to see you", name);
        return greeting;
    }
    
    public String dateAnnouncement() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //Date formatting
        Date date = new Date();
        String dateAnnounce = "It is currently, " + formatter.format(date);
        return dateAnnounce;
    }
    
    public String respondBeforeAlexis(String conversation) {
    
        if (conversation.indexOf("Alexis") >= 0){  //Alexis search
            String snarky = "Right away, sir. She certainly isn't sophisticated enough for that";
            return snarky;
        }
        else if (conversation.indexOf("Alfred") >= 0){ // Alfred search
            String snarky = "At your service. As you wish, naturally";
            return snarky;
        }
        else{  // Irrelevant return
            String snarky = "Right. And with that I shall retire";
            return snarky;
        }
        
    }
    
	// NINJA BONUS
	// See the specs to overload the guestGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

