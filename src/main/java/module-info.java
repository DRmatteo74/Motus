module fr.esgi {
    requires javafx.controls;
    requires javafx.fxml;
	requires org.apache.commons.csv;

    opens fr.esgi to javafx.fxml;
    exports fr.esgi;
}
