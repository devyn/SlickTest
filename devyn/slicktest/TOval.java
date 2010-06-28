package devyn.slicktest;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 *
 * @author devyn
 */
public class TOval extends Tweenable implements Renderable {
    
    static String[] NAMES = {"x",  "y",  "w",  "h",
                             "lr", "lg", "lb", "la",
                             "fr", "fg", "fb", "fa"};

    public TOval() {
        super(NAMES);
    }

    int getcl(String p) throws Exception {
        return (new Float(get(p))).intValue();
    }
    
    public void render(GameContainer c, Graphics g) {
        try {
            float x = get("x")-get("w")/2;
            float y = get("y")-get("h")/2;
            g.setColor(new Color(getcl("fr"), getcl("fg"), getcl("fb"), getcl("fa")));
            g.fillOval(x, y, get("w"), get("h"));
            g.setColor(new Color(getcl("lr"), getcl("lg"), getcl("lb"), getcl("la")));
            g.setLineWidth(3);
            g.drawOval(x, y, get("w"), get("h"));
        } catch (Exception ex) {
            Logger.getLogger(TOval.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
