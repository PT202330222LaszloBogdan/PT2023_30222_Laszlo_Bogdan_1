module com.example.pt2023_3022_laszlo_bogdan_1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.pt2023_3022_laszlo_bogdan_1 to javafx.fxml;
    exports com.example.pt2023_3022_laszlo_bogdan_1.Interfata;
    opens com.example.pt2023_3022_laszlo_bogdan_1.Interfata to javafx.fxml;
    exports com.example.pt2023_3022_laszlo_bogdan_1.App;
    opens com.example.pt2023_3022_laszlo_bogdan_1.App to javafx.fxml;
}