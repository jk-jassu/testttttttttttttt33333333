import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class jasbir extends Application {

    private TextField heightField;
    private TextField weightField;
    private TableView<BMIResult> resultTable;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("BMI Calculator");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label titleLabel = new Label("BMI Calculator");
        titleLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        grid.add(titleLabel, 0, 0, 2, 1);

        Label heightLabel = new Label("Height (in cm):");
        grid.add(heightLabel, 0, 1);

        heightField = new TextField();
        grid.add(heightField, 1, 1);

        Label weightLabel = new Label("Weight (in kg):");
        grid.add(weightLabel, 0, 2);

        weightField = new TextField();
        grid.add(weightField, 1, 2);

        Button calculateButton = new Button("Calculate BMI");
        grid.add(calculateButton, 0, 3, 2, 1);
        GridPane.setHalignment(calculateButton, Pos.CENTER);

        resultTable = new TableView<>();
        TableColumn<BMIResult, String> rangeColumn = new TableColumn<>("BMI Range");
        rangeColumn.setCellValueFactory(new PropertyValueFactory<>("range"));
        TableColumn<BMIResult, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        resultTable.getColumns().addAll(rangeColumn, categoryColumn);
        grid.add(resultTable, 0, 4, 2, 1);
        GridPane.setHalignment(resultTable, Pos.CENTER);

        resultTable.getItems().addAll(
                new BMIResult("0 - 18.4", "Underweight"),
                new BMIResult("18.5 - 24.9", "Normal weight"),
                new BMIResult("25.0 - 29.9", "Overweight"),
                new BMIResult("30.0 and above", "Obese")
        );

        calculateButton.setOnAction(event -> calculateBMI());

        Scene scene = new Scene(grid, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateBMI() {
        String heightText = heightField.getText();
        String weightText = weightField.getText();

        if (!heightText.isEmpty() && !weightText.isEmpty()) {
            double height = Double.parseDouble(heightText);
            double weight = Double.parseDouble(weightText);

            double bmi = weight / ((height / 100) * (height / 100));


            resultTable.getSelectionModel().clearSelection();
            resultTable.getItems().forEach(item -> {
                String[] rangeValues = item.getRange().split("-");
                double min
