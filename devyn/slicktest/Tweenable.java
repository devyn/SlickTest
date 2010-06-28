package devyn.slicktest;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author devyn
 */
public class Tweenable {

    HashMap<String,Float>   properties;
    ArrayList<TweenTarget> targets;

    public Tweenable(String[] props) {
        properties = new HashMap();
        targets    = new ArrayList();

        for (String p : props) {
            properties.put(p, new Float(0));
        }
    }

    public void jump(String name, float dest) throws Exception {
        if (!properties.containsKey(name)) {
            throw new Exception("key "+name+" doesn't exist.");
        }
        properties.put(name, new Float(dest));
    }

    public void target(String name, float dest, int time) throws Exception {
        if (!properties.containsKey(name)) {
            throw new Exception("key "+name+" doesn't exist.");
        }
        targets.add(new TweenTarget(name, dest, time));
    }

    public void clearTarget(String name) throws Exception {
        if (!properties.containsKey(name)) {
            throw new Exception("key "+name+" doesn't exist.");
        }
        for (TweenTarget t : targets) {
            if (t.name.equals(name)) targets.remove(t);
        }
    }

    public void update(int delta) {
        ArrayList<String> done = new ArrayList();
        ArrayList<TweenTarget> forRemoval = new ArrayList();

        for (TweenTarget t : targets) {
            if (!done.contains(t.name)) {
                if (t.time < delta) {
                    properties.put(t.name, t.dest);
                    forRemoval.add(t);
                } else {
                    float cv = properties.get(t.name).floatValue();
                    float sp = (t.dest - cv) / t.time;
                    properties.put(t.name, cv + sp * delta);
                    t.time -= delta;
                }
                done.add(t.name);
            }
        }

        targets.removeAll(forRemoval);
    }

    float get(String name) throws Exception {
        if (!properties.containsKey(name)) {
            throw new Exception("key "+name+" doesn't exist.");
        }
        return properties.get(name).floatValue();
    }

}

class TweenTarget {

    public String name;
    public float  dest;
    public int    time;

    public TweenTarget(String name, float dest, int time) {
        this.name = name; this.dest = dest; this.time = time;
    }

}