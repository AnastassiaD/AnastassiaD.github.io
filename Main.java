package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.String;
import javax.swing.JButton;
import java.util.Random;

import static javafx.application.Platform.exit;

public class Main extends Application {

    public class Game {

        private String userChoice;
        private String pcChoice;

        @Override
        public String toString() {
            return "user choice= " + userChoice + '\'' +
                    ", computer choice=" + pcChoice;
        }

        public Game(String userChoice, String pcChoice) {
            this.userChoice = userChoice;
            this.pcChoice = pcChoice;
        }

        public String compareChoices(Player player1, Computer computer1) {

            String result = "";
            int choice1 = player1.getPlayerChoice();
            int choice2 = computer1.getPlayerChoice();

            if (choice1 == choice2) {

                result = "Computer choice was - " + choice2 + "\n" + "Your choice was - " + choice1 + "\n" + " - so it is a tie!\n";
            } else if ((choice1 == 1 && choice2 == 2) || (choice1 == 2 && choice2 == 3) || (choice1 == 3 && choice2 == 1)) {

                result = "Computer choice was - " + choice2 + "\n" + "Your choice was - " + choice1 + "\n" + " - so " + player1.getName() + " is winner!\n";
            } else if ((choice1 == 1 && choice2 == 3) || (choice1 == 2 && choice2 == 1) || (choice1 == 3 && choice2 == 2)) {

                result = "Computer choice was - " + choice2 + "\n" + "Your choice was - " + choice1 + "\n" + " - so computer is winner!\n";
            }
            return result;
        }
    }

    public class Player {

        public int playerChoice;
        public String name;

        public Player(String name) {
            this.name = name;
        }

        public String toString() {
            return "Name: " + name + '\n';
        }

        public String getName() {
            return name;
        }

        public int getPlayerChoice() {
            return playerChoice;
        }

        public void setPlayerChoice(int playerChoice) {
            this.playerChoice = playerChoice;
        }
    }

    public class Computer extends Player {

        public Computer(String name) {
            super(name);
        }

        public int numberGenerator() {
            return new Random().nextInt(3) + 1;
        }
    }


    String username = "unknown";

    @Override
    public void start(Stage primaryStage) throws Exception, FileNotFoundException {

        Group root = new Group();
        Scene scene = new Scene(root, 500, 400, Color.YELLOW);
        primaryStage.setTitle("GAME");
        primaryStage.setScene(scene);

        Random random = new Random();

        Label label = new Label();
        label.setText("Welcome to the game --Stone, Scissors, Paper-- :)))!");
        label.prefWidth(600);
        label.prefHeight(100);

        label.setLayoutX(20);
        label.setLayoutY(30);
        label.setStyle("-fx-background-color: orange;");

        Label label2 = new Label();
//read from the .txt file
        try {
            File f = new File("rules of the game.txt");
            Scanner scan = new Scanner(f, "UTF-8");
            while (scan.hasNext()) {
                String line = scan.nextLine();
                label2.setText(label2.getText() + line + "\n");

            }
            scan.close();
        } catch (FileNotFoundException e) {

        }

        label2.prefWidth(400);
        label2.prefHeight(100);
        label2.setLayoutX(20);
        label2.setLayoutY(110);
        label2.setStyle("-fx-background-color: orange;");

        Button bt = new Button("OK!");
        bt.setLayoutX(100);
        bt.setLayoutY(330);
        root.getChildren().addAll(label, label2, bt);
// obrabotka sobytija
        bt.setOnMouseClicked(event -> {
            Group rroot = new Group();
            Scene sscene = new Scene(rroot, 400, 200, Color.YELLOW);
            primaryStage.setTitle("Name");
            primaryStage.setScene(sscene);

            Label label3 = new Label();
            label3.setText("Enter your name!");
            label3.prefWidth(600);
            label3.prefHeight(100);

            label3.setLayoutX(20);
            label3.setLayoutY(50);
            label3.setStyle("-fx-background-color: orange;");

            TextField tf1 = new TextField("over here");

            Button bt2 = new Button("Ok!");
            bt2.setLayoutX(170);
            bt2.setLayoutY(120);

            rroot.getChildren().addAll(tf1, bt2, label3);

            bt2.setOnMouseClicked(eevent -> {
                username = tf1.getText();
                Group root5 = new Group();
                Scene scene5 = new Scene(root5, 400, 350, Color.YELLOW);
                primaryStage.setTitle("Choose!");
                primaryStage.setScene(scene5);

                Label label4 = new Label();
                label4.setText("Make your choose!");
                label4.prefWidth(600);
                label4.prefHeight(100);

                label4.setLayoutX(130);
                label4.setLayoutY(35);
                label4.setStyle("-fx-background-color: orange;");
//vstavljajutsja szhatie kartinki i k nim nizhe - knopki
                try {
                    Image image = new Image(new FileInputStream("kam.jpg"));
                    ImageView iv = new ImageView();
                    iv.setImage(image);
                    iv.setFitWidth(100);
                    iv.setPreserveRatio(true);
                    iv.setSmooth(true);
                    iv.setCache(true);
                    iv.setX(10);
                    iv.setY(80);

                    Image image1 = new Image(new FileInputStream("nozn.jpg"));
                    ImageView iv1 = new ImageView();
                    iv1.setImage(image1);
                    iv1.setFitWidth(100);
                    iv1.setPreserveRatio(true);
                    iv1.setSmooth(true);
                    iv1.setCache(true);
                    iv1.setX(140);
                    iv1.setY(80);

                    Image image2 = new Image(new FileInputStream("bumag.jpg"));
                    ImageView iv2 = new ImageView();
                    iv2.setImage(image2);
                    iv2.setFitWidth(100);
                    iv2.setPreserveRatio(true);
                    iv2.setSmooth(true);
                    iv2.setCache(true);
                    iv2.setX(270);
                    iv2.setY(80);

                    root5.getChildren().addAll(iv, iv1, iv2);
                } catch (FileNotFoundException e) {

                }

                Button exit = new Button("Exit");
                exit.setLayoutX(130);
                exit.setLayoutY(280);

                Button bstone = new Button("1");
                bstone.setLayoutX(10);
                bstone.setLayoutY(170);
                Button bscissors = new Button("2");
                bscissors.setLayoutX(140);
                bscissors.setLayoutY(170);
                Button bpaper = new Button("3");
                bpaper.setLayoutX(270);
                bpaper.setLayoutY(170);

                root5.getChildren().addAll(label4, exit, bstone, bscissors, bpaper);

                exit.setOnMouseClicked(eeevent -> {
                    exit();
                });
                //nazhimaja na odnu iz kljuchevih knopok("stone" i t.d...) - zapuskaetsja sobstvenno glavnii process igry
                //cherez sozdanije objectov klassov i vizov metoda...
                bstone.setOnMouseClicked(event1 -> {
                    Group root7 = new Group();
                    Scene scene7 = new Scene(root7, 300, 300, Color.YELLOW);
                    primaryStage.setTitle("RESULT: ");
                    primaryStage.setScene(scene7);

                    Label label7 = new Label();

                    Player player1 = new Player(username);
                    player1.setPlayerChoice(1);
                    String computer = String.valueOf(new Random().nextInt(3) + 1);
                    Computer computer1 = new Computer("computer1");
                    computer1.setPlayerChoice(new Random().nextInt(3) + 1);
                    Game g = new Game("1", computer);
                    String resultat = g.compareChoices(player1, computer1);
                    label7.setText(resultat);

                    label7.prefWidth(600);
                    label7.prefHeight(100);

                    label7.setLayoutX(20);
                    label7.setLayoutY(50);
                    label7.setStyle("-fx-background-color: orange;");

                    Label labeldop1 = new Label();
                    labeldop1.setText(" 1 - stone, 2 - scissors, 3 - paper ");

                    labeldop1.prefWidth(600);
                    labeldop1.prefHeight(100);

                    labeldop1.setLayoutX(20);
                    labeldop1.setLayoutY(150);
                    labeldop1.setStyle("-fx-background-color: red;");

                    Button back = new Button("Back!");
                    back.setLayoutX(50);
                    back.setLayoutY(190);

                    root7.getChildren().addAll(label7, back, labeldop1);
                    back.setOnMouseClicked(evvent -> {
                        username = tf1.getText();
                        Group roott = new Group();
                        Scene scene55 = new Scene(roott, 400, 350, Color.YELLOW);
                        primaryStage.setTitle("Choose!");
                        primaryStage.setScene(scene55);

                        Label label44 = new Label();
                        label44.setText("Make your choose!");
                        label44.prefWidth(600);
                        label44.prefHeight(100);

                        label44.setLayoutX(130);
                        label44.setLayoutY(35);
                        label44.setStyle("-fx-background-color: orange;");

                        try {
                            Image image = new Image(new FileInputStream("kam.jpg"));
                            ImageView iv = new ImageView();
                            iv.setImage(image);
                            iv.setFitWidth(100);
                            iv.setPreserveRatio(true);
                            iv.setSmooth(true);
                            iv.setCache(true);
                            iv.setX(10);
                            iv.setY(80);

                            Image image1 = new Image(new FileInputStream("nozn.jpg"));
                            ImageView iv1 = new ImageView();
                            iv1.setImage(image1);
                            iv1.setFitWidth(100);
                            iv1.setPreserveRatio(true);
                            iv1.setSmooth(true);
                            iv1.setCache(true);
                            iv1.setX(140);
                            iv1.setY(80);

                            Image image2 = new Image(new FileInputStream("bumag.jpg"));
                            ImageView iv2 = new ImageView();
                            iv2.setImage(image2);
                            iv2.setFitWidth(100);
                            iv2.setPreserveRatio(true);
                            iv2.setSmooth(true);
                            iv2.setCache(true);
                            iv2.setX(270);
                            iv2.setY(80);

                            roott.getChildren().addAll(iv, iv1, iv2);
                        } catch (FileNotFoundException e) {

                        }
                        roott.getChildren().addAll(label44, exit, bstone, bscissors, bpaper);
                    });

                });
                bscissors.setOnMouseClicked(event2 -> {
                    Group root8 = new Group();
                    Scene scene8 = new Scene(root8, 300, 300, Color.YELLOW);
                    primaryStage.setTitle("RESULT: ");
                    primaryStage.setScene(scene8);

                    Label label8 = new Label();

                    Player player1 = new Player(username);
                    player1.setPlayerChoice(2);
                    String computer = String.valueOf(new Random().nextInt(3) + 1);
                    Computer computer1 = new Computer("computer1");
                    computer1.setPlayerChoice(new Random().nextInt(3) + 1);
                    Game g = new Game("2", computer);
                    String resultat = g.compareChoices(player1, computer1);
                    label8.setText(resultat);

                    label8.prefWidth(600);
                    label8.prefHeight(100);

                    label8.setLayoutX(20);
                    label8.setLayoutY(50);
                    label8.setStyle("-fx-background-color: orange;");

                    Label labeldop2 = new Label();
                    labeldop2.setText(" 1 - stone, 2 - scissors, 3 - paper ");

                    labeldop2.prefWidth(600);
                    labeldop2.prefHeight(100);

                    labeldop2.setLayoutX(20);
                    labeldop2.setLayoutY(150);
                    labeldop2.setStyle("-fx-background-color: red;");

                    Button back = new Button("Back!");
                    back.setLayoutX(50);
                    back.setLayoutY(190);

                    root8.getChildren().addAll(label8, back, labeldop2);
                    back.setOnMouseClicked(evvent -> {
                        username = tf1.getText();
                        Group roott = new Group();
                        Scene scene55 = new Scene(roott, 400, 350, Color.YELLOW);
                        primaryStage.setTitle("Choose!");
                        primaryStage.setScene(scene55);

                        Label label44 = new Label();
                        label44.setText("Make your choose!");
                        label44.prefWidth(600);
                        label44.prefHeight(100);

                        label44.setLayoutX(130);
                        label44.setLayoutY(35);
                        label44.setStyle("-fx-background-color: orange;");


                        try {
                            Image image = new Image(new FileInputStream("kam.jpg"));
                            ImageView iv = new ImageView();
                            iv.setImage(image);
                            iv.setFitWidth(100);
                            iv.setPreserveRatio(true);
                            iv.setSmooth(true);
                            iv.setCache(true);
                            iv.setX(10);
                            iv.setY(80);

                            Image image1 = new Image(new FileInputStream("nozn.jpg"));
                            ImageView iv1 = new ImageView();
                            iv1.setImage(image1);
                            iv1.setFitWidth(100);
                            iv1.setPreserveRatio(true);
                            iv1.setSmooth(true);
                            iv1.setCache(true);
                            iv1.setX(140);
                            iv1.setY(80);

                            Image image2 = new Image(new FileInputStream("bumag.jpg"));
                            ImageView iv2 = new ImageView();
                            iv2.setImage(image2);
                            iv2.setFitWidth(100);
                            iv2.setPreserveRatio(true);
                            iv2.setSmooth(true);
                            iv2.setCache(true);
                            iv2.setX(270);
                            iv2.setY(80);

                            roott.getChildren().addAll(iv, iv1, iv2);
                        } catch (FileNotFoundException e) {

                        }
                        roott.getChildren().addAll(label44, exit, bstone, bscissors, bpaper);
                    });
                });
                bpaper.setOnMouseClicked(event3 -> {
                    Group root9 = new Group();
                    Scene scene9 = new Scene(root9, 300, 300, Color.YELLOW);
                    primaryStage.setTitle("RESULT: ");
                    primaryStage.setScene(scene9);

                    Label label9 = new Label();

                    Player player1 = new Player(username);
                    player1.setPlayerChoice(3);
                    String computer = String.valueOf(new Random().nextInt(3) + 1);
                    Computer computer1 = new Computer("computer1");
                    computer1.setPlayerChoice(new Random().nextInt(3) + 1);
                    Game g = new Game("3", computer);
                    String resultat = g.compareChoices(player1, computer1);
                    label9.setText(resultat);
                    label9.prefWidth(600);
                    label9.prefHeight(100);

                    label9.setLayoutX(20);
                    label9.setLayoutY(50);
                    label9.setStyle("-fx-background-color: orange;");

                    Label labeldop3 = new Label();
                    labeldop3.setText(" 1 - stone, 2 - scissors, 3 - paper ");

                    labeldop3.prefWidth(600);
                    labeldop3.prefHeight(100);

                    labeldop3.setLayoutX(20);
                    labeldop3.setLayoutY(150);
                    labeldop3.setStyle("-fx-background-color: red;");

                    Button back = new Button("Back!");
                    back.setLayoutX(50);
                    back.setLayoutY(190);

                    root9.getChildren().addAll(label9, back, labeldop3);
                    back.setOnMouseClicked(evvent -> {
                        username = tf1.getText();
                        Group roott = new Group();
                        Scene scene55 = new Scene(roott, 400, 350, Color.YELLOW);
                        primaryStage.setTitle("Choose!");
                        primaryStage.setScene(scene55);

                        Label label44 = new Label();
                        label44.setText("Make your choose!");
                        label44.prefWidth(600);
                        label44.prefHeight(100);

                        label44.setLayoutX(130);
                        label44.setLayoutY(35);
                        label44.setStyle("-fx-background-color: orange;");

                        try {
                            Image image = new Image(new FileInputStream("kam.jpg"));
                            ImageView iv = new ImageView();
                            iv.setImage(image);
                            iv.setFitWidth(100);
                            iv.setPreserveRatio(true);
                            iv.setSmooth(true);
                            iv.setCache(true);
                            iv.setX(10);
                            iv.setY(80);

                            Image image1 = new Image(new FileInputStream("nozn.jpg"));
                            ImageView iv1 = new ImageView();
                            iv1.setImage(image1);
                            iv1.setFitWidth(100);
                            iv1.setPreserveRatio(true);
                            iv1.setSmooth(true);
                            iv1.setCache(true);
                            iv1.setX(140);
                            iv1.setY(80);

                            Image image2 = new Image(new FileInputStream("bumag.jpg"));
                            ImageView iv2 = new ImageView();
                            iv2.setImage(image2);
                            iv2.setFitWidth(100);
                            iv2.setPreserveRatio(true);
                            iv2.setSmooth(true);
                            iv2.setCache(true);
                            iv2.setX(270);
                            iv2.setY(80);

                            roott.getChildren().addAll(iv, iv1, iv2);
                        } catch (FileNotFoundException e) {

                        }
                        roott.getChildren().addAll(label44, exit, bstone, bscissors, bpaper);
                    });

                });

            });
        });
        //sdelaem vsjo vidimim
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception, FileNotFoundException {
        //eta muzyka budet igrat poka user ne nazhmjot "exit"

            try {
                String muz = "muzyka2.mp3";
                Media sound = new Media(new File("muzyka2.mp3").toURI().toString());
                MediaPlayer mediaPlayer2 = new MediaPlayer(sound);
                mediaPlayer2.setCycleCount(MediaPlayer.INDEFINITE);
                mediaPlayer2.play();
                launch(args);
            } catch (Exception e) {

            }



    }
}
