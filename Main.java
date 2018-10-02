package sample;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.security.auth.login.LoginContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class Main extends Application {

    Stage window;
    public static final LinkedList<String> slayerMonsters = new LinkedList<>();
    ComboBox<String> combatPref;
    String chosenNpc;

    Label helmLabel;
    Label bodyLabel;
    Label legsLabel;
    Label amuletLabel;
    Label gloveLabel;
    Label quiverLabel;
    Label capeLabel;
    Label ringLabel;
    Label weaponLabel;
    Label shieldLabel;
    Label bootLabel;


    Account currentAccount = new Account("vd84", 65, 65, 65, 65, 65, 65, 65);

    public static void main(String[] args) {

        launch(args);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        addSlayerMonsters();
        window = primaryStage;
        window.setTitle("RuneScape Slayer Helper");
        Scene welcomeScene, slayerTaskScene, newAccountScene, gearScene;

        System.out.println(currentAccount.getRangedRecEquip());


        //förstasidans layout
        GridPane welcomeLayOut = new GridPane();
        welcomeLayOut.setPadding(new Insets(10, 10, 10, 10));
        welcomeLayOut.setVgap(8);
        welcomeLayOut.setHgap(10);


        //new slayertask knapp
        Button newSlayerTaskButton = new Button("New Slayer Task");
        GridPane.setConstraints(newSlayerTaskButton, 0, 0);
        newSlayerTaskButton.setMinHeight(90);
        newSlayerTaskButton.setMinWidth(380);
        newSlayerTaskButton.setAlignment(Pos.CENTER);

        //new account knapp
        Button newAccountButton = new Button("New Account");
        GridPane.setConstraints(newAccountButton, 0, 1);
        newAccountButton.setMinHeight(90);
        newAccountButton.setMinWidth(380);
        newAccountButton.setAlignment(Pos.CENTER);


        //lägg till alla komponenter i denna
        welcomeLayOut.getChildren().addAll(newSlayerTaskButton, newAccountButton);
        //newAccountsida layout
        GridPane newAccountLayout = new GridPane();
        newAccountLayout.setPadding(new Insets(10, 10, 10, 10));
        newAccountLayout.setVgap(8);
        newAccountLayout.setHgap(10);

        //skapar förstamenyns scen
        welcomeScene = new Scene(welcomeLayOut, 400, 560);
        welcomeLayOut.setPrefHeight(250);

        welcomeScene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
        //komponenter till newAccountscene


        //user
        Label userLabel = new Label("User Name");
        GridPane.setConstraints(userLabel, 0, 0);

        Button generateStats = new Button("Generate stats");
        GridPane.setConstraints(generateStats, 0, 2);
        GridPane.setMargin(generateStats, new Insets(0, 0, 0, 135));


        TextField userField = new TextField();
        GridPane.setConstraints(userField, 0, 1);

        //attacklvl
        Label attackLabel = new Label("Attack Level");
        GridPane.setConstraints(attackLabel, 0, 3);
        attackLabel.setMaxSize(380, 100);


        TextField attackField = new TextField();
        GridPane.setConstraints(attackField, 0, 4);
        attackField.setMinWidth(380);

        //strenghtlvl
        Label strLabel = new Label("Strenght Level");
        GridPane.setConstraints(strLabel, 0, 5);

        TextField strField = new TextField();
        GridPane.setConstraints(strField, 0, 6);

        //user
        Label defLabel = new Label("Defence Level");
        GridPane.setConstraints(defLabel, 0, 7);


        TextField defField = new TextField();
        GridPane.setConstraints(defField, 0, 8);

        //range
        Label rangeLabel = new Label("Ranged Level");
        GridPane.setConstraints(rangeLabel, 0, 9);

        TextField rangeField = new TextField();
        GridPane.setConstraints(rangeField, 0, 10);

        //magic
        Label magicLabel = new Label("Magic Level");
        GridPane.setConstraints(magicLabel, 0, 11);

        TextField magicField = new TextField();
        GridPane.setConstraints(magicField, 0, 12);

        //prayer
        Label prayerLabel = new Label("Prayer Level");
        GridPane.setConstraints(prayerLabel, 0, 13);

        TextField prayerField = new TextField();
        GridPane.setConstraints(prayerField, 0, 14);

        //hitpoints
        Label hitPointLabel = new Label("Hitpoint Level ");
        GridPane.setConstraints(hitPointLabel, 0, 15);

        TextField hitPointField = new TextField();
        GridPane.setConstraints(hitPointField, 0, 16);

        //backButton
        Button newAccountbackButton = new Button("Back");
        GridPane.setConstraints(newAccountbackButton, 0, 17);
        newAccountbackButton.setMinWidth(185);

        //backButton onClick
        newAccountbackButton.setOnAction(event -> {

            window.setScene(welcomeScene);


        });

        //saveButton
        Button saveButton = new Button("Save");
        GridPane.setConstraints(saveButton, 0, 17);
        GridPane.setMargin(saveButton, new Insets(0, 0, 0, 195));
        saveButton.setMinWidth(185);

        //savebutton onClick
        saveButton.setOnAction(event -> {


            try {
                currentAccount.setName(userField.getText());
                currentAccount.setAttackLvl(Integer.parseInt(attackField.getText()));
                currentAccount.setStrenghtLvl(Integer.parseInt(strField.getText()));
                currentAccount.setDefenceLvl(Integer.parseInt(defField.getText()));
                currentAccount.setMageLvl(Integer.parseInt(magicField.getText()));
                currentAccount.setPrayLvl(Integer.parseInt(prayerField.getText()));
                currentAccount.setRangeLvl(Integer.parseInt(rangeField.getText()));
                currentAccount.setHitpointLvl(Integer.parseInt(hitPointField.getText()));

            } catch (NumberFormatException e) {
                Alert saveAlert = new Alert(Alert.AlertType.INFORMATION);
                saveAlert.setTitle("error");
                saveAlert.setHeaderText(null);
                saveAlert.setContentText("Please enter all account details");
                saveAlert.showAndWait();
                return;


            }

            Alert saveAlert = new Alert(Alert.AlertType.INFORMATION);
            saveAlert.setTitle("Account Saved");
            saveAlert.setHeaderText(null);
            saveAlert.setContentText("Your account information has been saved, returning to menu");
            saveAlert.showAndWait();
            window.setScene(welcomeScene);


        });


        generateStats.setOnAction(event -> {
            int overall = 1, attk = 3, defence = 5, str = 7, hp = 10, rng = 11, prayer = 13, magic = 15, cook = 17, wood = 19, fletch = 21, fish = 23, fire = 25, craft = 27,
                    smith = 29, mine = 31, herb = 33, agil = 35, theif = 37, slay = 39, farm = 41, rune = 43, hunt = 45, con = 47;

            int woodLevel = new CheckLevels("kalle%20anka", wood).getTargetLevel();


            //currentAccount = new Account(userField.getText(),attackLevel,strlevel,defLevel,rangeLevel, magicLevel, prayerLevel, hpLevel);


        });


        //lägg till komponenter
        newAccountLayout.getChildren().addAll(userLabel, userField, attackLabel, attackField, strLabel, strField, defLabel, defField, rangeLabel, rangeField, magicLabel, magicField, prayerLabel, prayerField, hitPointLabel, hitPointField, saveButton, newAccountbackButton, generateStats);

        //skapa newAccountsida scen
        newAccountScene = new Scene(newAccountLayout, 400, 560);
        newAccountScene.getStylesheets().add(Main.class.getResource("AccountStyle.css").toExternalForm());


        //slayertasksidan Layout
        GridPane slayerTaskLayout = new GridPane();
        slayerTaskLayout.setPadding(new Insets(10, 10, 10, 10));
        slayerTaskLayout.setVgap(8);
        slayerTaskLayout.setHgap(10);


        //komponenter på slayertasksidan
        Label searchLabel = new Label("What is you slayertask?");
        GridPane.setConstraints(searchLabel, 0, 0);
        GridPane.setMargin(searchLabel, new Insets(0, 0, 0, 22.5));


        TextField textField = new TextField();
        textField.setPromptText("Search here!");
        GridPane.setConstraints(textField, 0, 1);


        Button searchButton = new Button("Search");
        GridPane.setConstraints(searchButton, 0, 3);
        searchButton.setMinWidth(380);


        combatPref = new ComboBox<>();
        combatPref.getItems().addAll("Meele", "Ranged", "Mage");
        combatPref.setValue("Meele");
        GridPane.setConstraints(combatPref, 0, 2);
        combatPref.setMinWidth(275);


        CheckBox cannonBox = new CheckBox("Cannon?");
        GridPane.setConstraints(cannonBox, 0, 2);
        GridPane.setMargin(cannonBox, new Insets(0, 0, 0, 285));


        Button backButton = new Button("Back");
        GridPane.setConstraints(backButton, 0, 45);
        backButton.setMinWidth(185);


        backButton.setOnAction(event -> {
            window.setScene(welcomeScene);

        });

        Button menuButton = new Button("Menu");
        GridPane.setConstraints(menuButton, 0, 45);
        GridPane.setMargin(menuButton, new Insets(0, 0, 0, 195));

        menuButton.setMinWidth(185);

        menuButton.setOnAction(event -> {
            window.setScene(welcomeScene);

        });

        //Lägg till alla komponenter slayertasksidan
        slayerTaskLayout.getChildren().addAll(menuButton, backButton, cannonBox, combatPref, searchLabel, textField, searchButton);
        slayerTaskScene = new Scene(slayerTaskLayout, 400, 560);
        slayerTaskScene.getStylesheets().add(Main.class.getResource("SlayerTaskStyle.css").toExternalForm());

        //gearscene setup
        GridPane gearLayout = new GridPane();
        gearLayout.setPadding(new Insets(10, 10, 10, 10));
        gearLayout.setHgap(10);
        gearLayout.setVgap(8);


        Label helmText = new Label("Helm");
        GridPane.setConstraints(helmText, 0, 0);

        helmLabel = new Label();
        GridPane.setConstraints(helmLabel, 0, 0);
        GridPane.setMargin(helmLabel, new Insets(0, 0, 0, 195));


        Label bodyText = new Label("Body");
        GridPane.setConstraints(bodyText, 0, 1);

        bodyLabel = new Label();
        GridPane.setConstraints(bodyLabel, 0, 1);
        GridPane.setMargin(bodyLabel, new Insets(0, 0, 0, 195));


        Label legsText = new Label("Legs");
        GridPane.setConstraints(legsText, 0, 2);

        legsLabel = new Label();
        GridPane.setConstraints(legsLabel, 0, 2);
        GridPane.setMargin(legsLabel, new Insets(0, 0, 0, 195));


        Label amuletText = new Label("Amulet");
        GridPane.setConstraints(amuletText, 0, 3);

        amuletLabel = new Label();
        GridPane.setConstraints(amuletLabel, 0, 3);
        GridPane.setMargin(amuletLabel, new Insets(0, 0, 0, 195));


        Label quiverText = new Label("quiver");
        GridPane.setConstraints(quiverText, 0, 4);

        quiverLabel = new Label();
        GridPane.setConstraints(quiverLabel, 0, 4);
        GridPane.setMargin(quiverLabel, new Insets(0, 0, 0, 195));


        Label capeText = new Label("Cape");
        GridPane.setConstraints(capeText, 0, 5);

        capeLabel = new Label();
        GridPane.setConstraints(capeLabel, 0, 5);
        GridPane.setMargin(capeLabel, new Insets(0, 0, 0, 195));


        Label weaponText = new Label("Weapon");
        GridPane.setConstraints(weaponText, 0, 6);

        weaponLabel = new Label();
        GridPane.setConstraints(weaponLabel, 0, 6);
        GridPane.setMargin(weaponLabel, new Insets(0, 0, 0, 195));


        Label shieldText = new Label("Shield");
        GridPane.setConstraints(shieldText, 0, 8);

        shieldLabel = new Label();
        GridPane.setConstraints(shieldLabel, 0, 8);
        GridPane.setMargin(shieldLabel, new Insets(0, 0, 0, 195));


        Label ringText = new Label("Ring");
        GridPane.setConstraints(ringText, 0, 9);

        ringLabel = new Label();
        GridPane.setConstraints(ringLabel, 0, 9);
        GridPane.setMargin(ringLabel, new Insets(0, 0, 0, 195));


        Label bootText = new Label("Boots");
        GridPane.setConstraints(bootText, 0, 10);

        bootLabel = new Label();
        GridPane.setConstraints(bootLabel, 0, 10);
        GridPane.setMargin(bootLabel, new Insets(0, 0, 0, 195));


        Label gloveText = new Label("Gloves");
        GridPane.setConstraints(gloveText, 0, 11);

        gloveLabel = new Label();
        GridPane.setConstraints(gloveLabel, 0, 11);
        GridPane.setMargin(gloveLabel, new Insets(0, 0, 0, 195));


        Button gearSceneBackButton = new Button("Back");
        GridPane.setConstraints(gearSceneBackButton, 0, 17);
        gearSceneBackButton.setMinWidth(185);

        gearSceneBackButton.setOnAction(event -> {
            window.setScene(slayerTaskScene);


        });


        Button gearSceneMenuButton = new Button("Menu");
        GridPane.setConstraints(gearSceneMenuButton, 0, 17);
        GridPane.setMargin(gearSceneMenuButton, new Insets(0, 0, 0, 195));
        gearSceneMenuButton.setMinWidth(185);

        gearSceneMenuButton.setOnAction(event -> {

            window.setScene(welcomeScene);


        });


        gearScene = new Scene(gearLayout, 400, 560);
        gearLayout.setPrefHeight(250);
        gearLayout.getChildren().addAll(helmText, helmLabel, bodyText, bodyLabel, capeLabel, capeText, weaponLabel, weaponText, shieldLabel, shieldText, bootLabel, bootText, ringLabel, ringText, gloveLabel, gloveText, legsLabel, legsText, amuletLabel, amuletText, gearSceneBackButton, gearSceneMenuButton);
        gearScene.getStylesheets().add(Main.class.getResource("GearStyle").toExternalForm());


        newSlayerTaskButton.setOnAction(event -> window.setScene(slayerTaskScene));

        searchButton.setOnAction(event -> {

            String searchedText = textField.getText();

            if (slayerMonsters.contains(searchedText)) {


                switch (combatPref.getValue()) {
                    case "Meele":
                        setTextFieldsToReqGear(currentAccount.getMeeleRecEquip());
                        break;

                    case "Ranged":
                        setTextFieldsToReqGear(currentAccount.getRangedRecEquip());
                        break;

                    case "Mage":
                        setTextFieldsToReqGear(currentAccount.getMageReqEquip());
                        break;


                }
                window.setScene(gearScene);
                System.out.println(432432);
                chosenNpc = searchedText;

            }


        });


        newAccountButton.setOnAction(event -> window.setScene(newAccountScene));

        window.setScene(welcomeScene);
        window.show();

    }


    private void setTextFieldsToReqGear(Map<String, String> map) {

        helmLabel.setText(map.get("helm"));
        bodyLabel.setText(map.get("body"));
        legsLabel.setText(map.get("legs"));
        amuletLabel.setText(map.get("amulet"));
        gloveLabel.setText(map.get("gloves"));
        quiverLabel.setText(map.get("quiver"));
        capeLabel.setText(map.get("cape"));
        ringLabel.setText(map.get("ring"));
        quiverLabel.setText(map.get("quiver"));
        weaponLabel.setText(map.get("weapon"));
        shieldLabel.setText(map.get("shield"));
        bootLabel.setText(map.get("boots"));


    }

    private void addSlayerMonsters() {
        slayerMonsters.add("abberant spectre");
        slayerMonsters.add("cave horror");
        slayerMonsters.add("hellhound");
        slayerMonsters.add("cave kraken");
    }


    private void alertMessage(String titleText, String contentText) {
        Alert saveAlert = new Alert(Alert.AlertType.INFORMATION);
        saveAlert.setTitle(titleText);
        saveAlert.setHeaderText(null);
        saveAlert.setContentText(contentText);
        saveAlert.showAndWait();


    }


    public final Map<String, Stat> getStats(final String playerName) {


        final Map<String, Stat> stats = new HashMap<>(24);


        try {


            URL url = new URL("http://services.runescape.com/m=hiscore_oldschool/index_lite.ws?player=" + playerName);

            URLConnection con = url.openConnection();

            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");

            con.setUseCaches(true);

            try (InputStreamReader inputStreamReader = new InputStreamReader(con.getInputStream());

                 BufferedReader br = new BufferedReader(inputStreamReader)) {


                String[] splitVals = br.readLine().split(",");

                Stat overallStat = new Stat(Integer.parseInt(splitVals[0]), Integer.parseInt(splitVals[1]), Integer.parseInt(splitVals[2]));

                stats.put("Overall", overallStat);


                for (final Stat skill : stats.values()) {

                    splitVals = br.readLine().split(",");

                    stats.put(skill.toString(), new Stat(Integer.parseInt(splitVals[0]), Integer.parseInt(splitVals[1]), Integer.parseInt(splitVals[2])));

                }

            }


        } catch (final Exception e) {

            e.printStackTrace();

        }

        return stats;

    }


}