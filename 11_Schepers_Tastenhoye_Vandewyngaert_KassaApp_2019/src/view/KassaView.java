package view;

import controller.ArtikelController;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import jxl.read.biff.BiffException;

import java.io.IOException;
/**
 * //@author Eline
 */
public class KassaView  {
	private Stage stage = new Stage();

	public KassaView() throws BiffException, IOException {
		stage.setTitle("KASSA VIEW");
		stage.setResizable(false);
		stage.setX(20);
		stage.setY(20);

		Group root = new Group();
		Scene scene = new Scene(root, 750, 500);

		ArtikelController controller = new ArtikelController();

		String s = controller.loggen();

		KassaTab kassa = new KassaTab();
		ArtikelTab artikel = new ArtikelTab();
		InstellingTab instelling = new InstellingTab();
		LogTab log = new LogTab(s);

		BorderPane borderPane = new KassaMainPane(kassa, artikel, instelling, log);

		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());

		root.getChildren().add(borderPane);

		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}
}