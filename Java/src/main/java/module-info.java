module com.lidiya.taxsystem.programmingcoursework {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;

    opens com.lidiya.taxsystem.programmingcoursework.model to javafx.base;
    opens com.lidiya.taxsystem.programmingcoursework to javafx.fxml;
    opens com.lidiya.taxsystem.programmingcoursework.controller to javafx.fxml;  // Add this line

    exports com.lidiya.taxsystem.programmingcoursework;
    exports com.lidiya.taxsystem.programmingcoursework.model;
    exports com.lidiya.taxsystem.programmingcoursework.controller;  // Export controller
}
