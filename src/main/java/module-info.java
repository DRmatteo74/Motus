module fr.esgi {
    requires javafx.controls;
    requires javafx.fxml;
	requires org.apache.commons.csv;
	requires javafx.base;

    opens fr.esgi to javafx.fxml;
    exports fr.esgi;
}
