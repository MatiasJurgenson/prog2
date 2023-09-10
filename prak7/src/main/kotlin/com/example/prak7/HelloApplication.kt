package com.example.prak7

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class HelloApplication : Application() {
    public void start(Stage peaLava) {

        Group juur = new Group(); // luuakse juur

        Canvas lõuend = new Canvas(535, 535); // luuakse lõuend

        GraphicsContext gc = lõuend.getGraphicsContext2D(); // graafiline sisu

        gc.fillRect(50, 50, 435, 435); // ruut

        juur.getChildren().add(lõuend);  // lõuend lisatakse juure alluvaks

        Scene stseen1 = new Scene(juur);  // luuakse stseen

        peaLava.setTitle("Must ruut");  // lava tiitelribale pannakse tekst

        peaLava.setScene(stseen1);  // lavale lisatakse stseen

        peaLava.show();  // lava tehakse nähtavaks
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}