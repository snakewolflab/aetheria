import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

public class main extends Application {

    @Override
    public void start(Stage stage) {
        // --- 3Dオブジェクトの作成 ---
        // ここを球体ではなく「独自の多角形メッシュ」にすることでブロック感を消す
        Sphere island = new Sphere(15);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BROWN);
        island.setMaterial(material);
        island.setTranslateZ(100); // プレイヤーの前方に配置

        // --- カメラ（自分の視点） ---
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-200);
        camera.setNearClip(0.1);
        camera.setFarClip(10000.0);

        // --- シーン（世界）の設定 ---
        Group root = new Group(island, new AmbientLight(Color.WHITE));
        Scene scene = new Scene(root, 1024, 768, true, SceneAntialiasing.BALANCED);
        scene.setFill(Color.SKYBLUE); // 無限の空
        scene.setCamera(camera);

        stage.setTitle("Aetheria - Next Gen Flight Adventure");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}