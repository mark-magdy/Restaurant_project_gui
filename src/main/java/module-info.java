module restpack.restaurant_project_gui {
    requires javafx.controls;
    requires javafx.fxml;

//    requires org.kordamp.bootstrapfx.core;
//
//    opens restpack.restaurant_project_gui to javafx.fxml;
    exports restpack.restaurant_project_gui;
    opens MenuPack to javafx.base;
}