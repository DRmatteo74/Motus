module fr.esgi {
    requires javafx.controls;
    requires javafx.fxml;
	requires org.apache.commons.csv;
	requires javafx.base;
	requires javafx.graphics;
    requires java.desktop;

    opens fr.esgi to javafx.fxml;
    exports fr.esgi;
    exports fr.esgi.controller;
    opens fr.esgi.controller to javafx.fxml;
}
