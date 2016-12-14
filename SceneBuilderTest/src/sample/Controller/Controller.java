package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import sample.Main.ImageMatrix;
import sample.Main.MainRun;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller extends MainRun implements Initializable  {

    @FXML
    private Button open;

    @FXML
    private Pane pane;

    private FileChooser fileChooser;
    private File mediaFile;
    private String SmediaFIle=null;
    private javafx.stage.Stage theStage;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        open.setOnAction(e ->
        {
            try {
                fileChooser = new FileChooser();
                mediaFile = fileChooser.showOpenDialog(pane.getScene().getWindow());
                SmediaFIle = mediaFile.getAbsolutePath();
                BufferedImage MainImage = ImageIO.read(mediaFile);
                ImageMatrix ImageMatrix = new ImageMatrix(MainImage);

                if (mediaFile != null) {
                    pane.getChildren().add(new ImageView(mediaFile.toURI().toURL().toExternalForm()));
                }

                System.out.println("That was easy, wasn't it?");
            } catch (Exception el) {
                el.printStackTrace();
            }

        });

    }

}
