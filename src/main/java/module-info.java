module com.olim.employeemanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
        requires javafx.web;
            
        requires org.controlsfx.controls;
                requires net.synedra.validatorfx;
            requires org.kordamp.ikonli.javafx;
            requires org.kordamp.bootstrapfx.core;
            requires eu.hansolo.tilesfx;
        
    opens com.olim.employeemanagementsystem to javafx.fxml;
    exports com.olim.employeemanagementsystem;
}