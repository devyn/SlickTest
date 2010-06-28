package devyn.slicktest;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author devyn
 */
public class SlickTest extends BasicGame {

    TOval o;

    public SlickTest() {
        super("Devyn's Slick Test");
    }

    @Override
    public void init(GameContainer c) throws SlickException {
        try {
            o = new TOval();
            o.jump("la", 255);
            o.jump("fa", 255);
            o.target("x",  150, 2000);
            o.target("y",  150, 2000);
            o.target("w",  200, 2000);
            o.target("h",  200, 2000);
            o.target("lr", 255, 2000);
            o.target("lg", 255, 2000);
            o.target("lb", 255, 2000);
            o.target("fr", 255, 5000);
            o.target("fg", 120, 5000);
        } catch (Exception ex) {
            Logger.getLogger(SlickTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(GameContainer c, int delta) throws SlickException {
        o.update(delta);
    }

    public void render(GameContainer c, Graphics g) throws SlickException {
        g.setAntiAlias(true);
        o.render(c, g);
    }

    @Override
    public void mousePressed(int button, int x, int y) {
        try {
            o.target("x", x, 500);
            o.target("y", y, 500);
        } catch (Exception ex) {
            Logger.getLogger(SlickTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
