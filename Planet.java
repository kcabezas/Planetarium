import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
/**
* Representation of the planets Mercury, Venus, Earth, and Mars.
* @author Katherine Cabezas
* @version 1.0
*/
public enum Planet {

    MERCURY(Color.SILVER, 0.1915, 0.387, 0.24),
    VENUS(Color.GREEN, 0.4745, 0.723, 0.62),
    EARTH(Color.SPRINGGREEN, 1, 1, 1),
    MARS(Color.RED, 0.266, 1.52, 1.88);


    /** DO NOT MODIFY IT'S FOR YOUR OWN GOOD**/
    private final int earthRadius = 35;
    private final int earthDistance = 265;
    private final int earthPeriod = 5;
    /** OK YOU'RE GOOD GO AHEAD AND DO WORK NOW **/

    /**
    * Constructor for planets.
    */
    Planet(Color color, double radius, double distance, double period) {
        this.color = color;
        this.radius = earthRadius * radius;
        this.distance = earthDistance * distance;
        this.period = earthPeriod * period;
        circle = new Circle(this.radius, this.color);
        path = new Path();
    }

    private final Color color;
    private final double radius;
    private final double distance;
    private final double period;
    private final Circle circle;
    private final Path path;

    /**
    * Returns color of planet.
    * @return color of planet
    */
    public Color getColor() {
        return this.color;
    }

    /**
    * Returns radius of planet.
    * @return radius
    */
    public double getRadius() {
        return this.radius;
    }

    /**
    * Returns distance of planet.
    * @return distance
    */
    public double getDistance() {
        return this.distance;
    }

    /**
    * Returns period of time it takes for planet to revolve sun.
    * @return period
    */
    public double getPeriod() {
        return this.period;
    }

    /**
    * Returns circle representation of Planet.
    * @return circle
    */
    public Circle getCircle() {
        return this.circle;
    }

    /**
    * Returns path of planet's orbit.
    * @return path
    */
    public Path getPath() {
        return this.path;
    }

}
