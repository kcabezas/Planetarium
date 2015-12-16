import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Circle;
import javafx.scene.shape.MoveTo;
import javafx.util.Duration;
/**
* Visual representation of the first half of the solar system.
* @author Katherine Cabezas
* @version 1.0
*/
public class Planetarium extends Application {

    @Override public void start(Stage stage) {

        final int sceneHeight = 700;
        final int sceneWidth = 800;

        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, sceneWidth, sceneHeight);
        Circle sun = new Circle(65, Color.YELLOW);
        sun.setCenterX(sceneWidth / 2);
        sun.setCenterY(sceneHeight / 2);
        canvas.getChildren().add(sun);

        for (Planet p : Planet.values()) {

            canvas.getChildren().addAll(p.getCircle(), p.getPath());
            p.getCircle().toFront();

            p.getCircle().setCenterX(sun.getCenterX() - p.getDistance());
            p.getCircle().setCenterY(sun.getCenterY());

            p.getPath().setStroke(Color.WHITE);

            MoveTo moveTo = new MoveTo();
            moveTo.setX(p.getCircle().getCenterX());
            moveTo.setY(p.getCircle().getCenterY());
            p.getPath().getElements().add(moveTo);

            ArcTo arc1 = new ArcTo();
            arc1.setX(sun.getCenterX());
            arc1.setY(sun.getCenterY() - p.getDistance());
            arc1.setRadiusX(p.getDistance());
            arc1.setRadiusY(p.getDistance());
            arc1.setLargeArcFlag(true);
            p.getPath().getElements().add(arc1);

            ArcTo arc2 = new ArcTo();
            arc2.setX(sun.getCenterX() - p.getDistance());
            arc2.setY(sun.getCenterY());
            arc2.setRadiusX(p.getDistance());
            arc2.setRadiusY(p.getDistance());
            arc2.setLargeArcFlag(false);
            arc2.setSweepFlag(false);
            p.getPath().getElements().add(arc2);

            PathTransition pathTransition = new PathTransition();
            pathTransition.setDuration(Duration.seconds(p.getPeriod()));
            pathTransition.setPath(p.getPath());
            pathTransition.setNode(p.getCircle());
            pathTransition.setOrientation(
                    PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
            pathTransition.setCycleCount(Timeline.INDEFINITE);
            pathTransition.setAutoReverse(false);
            pathTransition.setInterpolator(Interpolator.LINEAR);
            pathTransition.play();

        }

        canvas.setStyle("-fx-background-color: black;");
        stage.setScene(scene);
        stage.setTitle("Planetarium");
        stage.show();
    }
}
