package fr.esgi;

import java.io.IOException;

import fr.esgi.service.MotService;
import fr.esgi.service.impl.MotServiceImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * h JavaFX App
 */
public class App extends Application {
	private static MotService motService = new MotServiceImpl();

	private static Scene scene;

	@Override
	public void start(Stage stage) throws IOException {
		scene = new Scene(loadFXML("primary"), 850, 650);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Modification de setRoot pour prendre un parametre qui va passer la difficulte
	 * et le nombre de partie Restante pour le jeu
	 */
	public static void setRoot(String fxml, Object data) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		Parent root = fxmlLoader.load();

		// Accéder au contrôleur associé au FXML et transmettre les données
		if (data != null) {
			if (fxmlLoader.getController() instanceof JeuController) {
				JeuController jeuController = (JeuController) fxmlLoader.getController();
				jeuController.initializeData(data);
			}
		}

		scene.setRoot(root);

	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	public static void main(String[] args) {
		motService.importerMot();
		launch();
	}

}