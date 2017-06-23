package procesor.wejście;

import com.restfb.json.JsonObject;

/**
 *
 * @author Grzesiek
 */
public class Facebook extends JsonObject implements Comparable<Facebook> {
    public int compareTo(Facebook face) {
        return this.getString("id", "default").compareTo(face.getString("id", "default"));
    }
}
