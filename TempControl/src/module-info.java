module TempControl {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens tempControl to javafx.graphics, javafx.fxml;
}
