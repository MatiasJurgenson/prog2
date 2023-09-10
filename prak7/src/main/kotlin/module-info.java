module com.example.prak7 {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens com.example.prak7 to javafx.fxml;
    exports com.example.prak7;
}