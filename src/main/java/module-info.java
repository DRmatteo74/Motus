module fr.esgi {
    requires javafx.controls;
    requires javafx.fxml;
	requires org.apache.commons.csv;
	requires javafx.base;
	requires javafx.graphics;

    opens fr.esgi to javafx.fxml;
    exports fr.esgi;
}
