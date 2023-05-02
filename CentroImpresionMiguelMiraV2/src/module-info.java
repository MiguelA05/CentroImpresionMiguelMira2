module CentroImpresionMiguelMira {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires java.desktop;
	requires javafx.graphics;
	
	exports co.uniquindio.pg2.CentroImpresionMiguelMira;
	opens co.uniquindio.pg2.CentroImpresionMiguelMira to javafx.fxml,org.controlsfx;

	opens co.uniquindio.pg2.CentroImpresionMiguelMira.controllers to javafx.fxml;
}
