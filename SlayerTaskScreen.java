package sample;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.paint.Paint;

public class SlayerTaskScreen extends Scene {


    public SlayerTaskScreen(Parent root) {
        super(root);
    }

    public SlayerTaskScreen(Parent root, double width, double height) {
        super(root, width, height);
    }

    public SlayerTaskScreen(Parent root, Paint fill) {
        super(root, fill);
    }

    public SlayerTaskScreen(Parent root, double width, double height, Paint fill) {
        super(root, width, height, fill);
    }

    public SlayerTaskScreen(Parent root, double width, double height, boolean depthBuffer) {
        super(root, width, height, depthBuffer);
    }

    public SlayerTaskScreen(Parent root, double width, double height, boolean depthBuffer, SceneAntialiasing antiAliasing) {
        super(root, width, height, depthBuffer, antiAliasing);
    }
}
