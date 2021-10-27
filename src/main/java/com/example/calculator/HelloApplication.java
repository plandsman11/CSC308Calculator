package com.example.calculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    Button button0;
    Label label1;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button addButton;
    Button subButton;
    Button multiplyButton;
    Button divideButton;
    Button clearButton;
    String operator;
    String first;
    String second;
    Button equalsButton;
    boolean done = false;
    String notSet = "ERROR!";

    public void setUpLabels(){
        label1 = new Label("Ready to do some math :)");
        operator = notSet;
        first = "";
        second = "";
    }

    public double doMath(){
        if(operator.equals("+")){
            return Integer.parseInt(first) + (double)Integer.parseInt(second);
        }
        else if(operator.equals("-")){
            return Integer.parseInt(first) - (double)Integer.parseInt(second);
        }
        else if(operator.equals("*")){
            return Integer.parseInt(first) * (double)Integer.parseInt(second);
        }
        else if(operator.equals("/") && Integer.parseInt(second) != 0) {
            return (double) Integer.parseInt(first) / (double)Integer.parseInt(second);
        }
        return 0;
    }

    public void reset(){
        label1.setText("Ready to do some math :)");
        first = "";
        second = "";
        operator = notSet;
        done = false;
    }

    public void handleHelper(String num){
        if(done)
            reset();
        if (operator.equals(notSet)) {
            first = first + num;
            label1.setText(first);
        }
        else {
            second = second + num;
            label1.setText(first + operator + second);
        }
    }

    public void setUpButtons(){
        button0 = new Button("0");
        button0.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                handleHelper("0");
            }
        });
        button1 = new Button("1");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                handleHelper("1");
            }
        });
        button2 = new Button("2");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                handleHelper("2");
            }
        });
        button3 = new Button("3");
        button3.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                handleHelper("3");
            }
        });
        button4 = new Button("4");
        button4.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                handleHelper("4");
            }
        });
        button5 = new Button("5");
        button5.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                handleHelper("5");
            }
        });
        button6 = new Button("6");
        button6.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                handleHelper("6");
            }
        });
        button7 = new Button("7");
        button7.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                handleHelper("6");
            }
        });
        button8 = new Button("8");
        button8.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                handleHelper("8");
            }
        });
        button9 = new Button("9");
        button9.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                handleHelper("9");
            }
        });
        addButton = new Button("+");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                if (operator.equals(notSet) && !first.equals("")) {
                    label1.setText(first + "+");
                    operator = "+";
                }
            }
        });
        subButton = new Button("-");
        subButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                if (operator.equals(notSet) && !first.equals("")) {
                    label1.setText(first + "-");
                    operator = "-";
                }
            }
        });
        multiplyButton = new Button("*");
        multiplyButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                if (operator.equals(notSet) && !first.equals("")) {
                    label1.setText(first + "*");
                    operator = "*";
                }
            }
        });
        divideButton = new Button("/");
        divideButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                if (operator.equals(notSet) && !first.equals("")) {
                    label1.setText(first + "/");
                    operator = "/";
                }
            }
        });
        clearButton = new Button("Clear");
        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                reset();
            }
        });
        equalsButton = new Button("=");
        equalsButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                if(second.equals("0")){
                    reset();
                    label1.setText("Cannot divide by zero, try new numbers");
                }
                else if(!done && !first.equals("") && !second.equals("") && !operator.equals(notSet)){
                    double answer = doMath();
                    label1.setText(label1.getText() + "=" + answer);
                    done = true;
                }
            }
        });
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Calculator");
        HBox row0 = new HBox();
        HBox row1 = new HBox();
        HBox row2 = new HBox();
        HBox row3 = new HBox();
        HBox row4 = new HBox();
        VBox root = new VBox();
        Scene scene = new Scene(root, 220,170);
        stage.setScene(scene);
        setUpLabels();
        setUpButtons();

        row0.getChildren().addAll(addButton, subButton, multiplyButton, divideButton);
        row1.getChildren().addAll(button1, button2, button3);
        row2.getChildren().addAll(button4, button5, button6);
        row3.getChildren().addAll(button7, button8, button9);
        row4.getChildren().addAll(button0, equalsButton, clearButton);

        root.getChildren().addAll(label1, row0, row1, row2, row3, row4);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}