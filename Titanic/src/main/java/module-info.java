module com.example.titanic {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.opencsv;

    opens com.example.titanic to javafx.fxml;
    exports com.example.titanic;
}