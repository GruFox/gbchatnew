module ru.gb.gbchat {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.gb.gbchat to javafx.fxml;
    exports ru.gb.gbchat;
}