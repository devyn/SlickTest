package devyn.slicktest;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

/**
 *
 * @author devyn
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Logger.getLogger(Main.class.getName()).log(Level.INFO, "Starting game...");
        AppGameContainer c;
        try {
            c = new AppGameContainer(new SlickTest(), 800, 600, false);
            c.start();
        } catch (SlickException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
