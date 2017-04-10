import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.geometry.*;

public class Demo extends Application {
	private static Manager app;

	// javafx stuff
	private Button submitStart, submitInitial, importY, importN, submitImport;
	private Scene start, initial, initial2, importStudents, courseMenu;
	private Stage main;
	private TextField profNameInput, initialCourseInput, stuFiInput, numFiInput, gradeFiInput;
	private Text initialInfo, initial2Info, importInfo1;

	public void start(Stage primaryStage) {
		Font titleBold = Font.font("Arial", FontWeight.BOLD, 20);
		Font fontReg1 = Font.font("Arial", FontWeight.NORMAL, 14);
		main = primaryStage;

		// start menu Scene
		HBox profBox = new HBox();
		Label namePrompt = new Label("Please enter your name: ");
		profNameInput = new TextField();
		submitStart = new Button("Submit");
		submitStart.setOnAction(this::buttonPressed);
		profBox.getChildren().addAll(namePrompt, profNameInput, submitStart);
		profBox.setSpacing(10);
		profBox.setAlignment(Pos.CENTER);
		Text welcome = new Text("Welcome to M.G.G.A.");
		welcome.setFont(titleBold);

		VBox startMain = new VBox();
		startMain.getChildren().addAll(welcome, profBox);
		startMain.setAlignment(Pos.TOP_CENTER);
		startMain.setSpacing(20);
		startMain.setPadding(new Insets(20, 0, 0, 0));

		start = new Scene(startMain, 500, 500);
		// End of start menu scene

		// start Inital Scene
		HBox initialBox = new HBox();
		Label initialCourse = new Label("Please enter the name of the course: ");
		initialCourseInput = new TextField();
		submitInitial = new Button("Submit");
		submitInitial.setOnAction(this::buttonPressed);
		initialBox.getChildren().addAll(initialCourse, initialCourseInput, submitInitial);
		initialBox.setSpacing(10);
		initialBox.setAlignment(Pos.CENTER);

		initialInfo = new Text("");

		VBox initialMain = new VBox();
		initialMain.getChildren().addAll(initialInfo, initialBox);
		initialMain.setAlignment(Pos.TOP_CENTER);
		initialMain.setSpacing(20);
		initialMain.setPadding(new Insets(20, 0, 0, 0));

		initial = new Scene(initialMain, 500, 500);
		// end of Initial Scene

		// start Inital2 Scene
		HBox initial2Box = new HBox();
		importY = new Button("Yes");
		importN = new Button("No");
		importY.setOnAction(this::buttonPressed);
		importN.setOnAction(this::buttonPressed);
		initial2Box.getChildren().addAll(importY, importN);
		initial2Box.setSpacing(10);
		initial2Box.setAlignment(Pos.CENTER);

		initial2Info = new Text("");

		VBox initial2Main = new VBox();
		initial2Main.getChildren().addAll(initial2Info, initial2Box);
		initial2Main.setAlignment(Pos.TOP_CENTER);
		initial2Main.setSpacing(20);
		initial2Main.setPadding(new Insets(20, 0, 0, 0));

		initial2 = new Scene(initial2Main, 500, 500);
		// end of Initial2 Scene
		
		//import students from text files
		GridPane inputFilePane = new GridPane();
		Label stuFiLabel = new Label("Name of file with Student Names: ");
		stuFiInput = new TextField();
		Label numFiLabel = new Label("Name of file with Student ID Numbers: ");
		numFiInput = new TextField();
		Label gradeFiLabel = new Label("Name of file with Student Grades: ");
		gradeFiInput = new TextField();
		inputFilePane.add(stuFiLabel, 0, 0);
		inputFilePane.add(stuFiInput, 1, 0);
		inputFilePane.add(numFiLabel, 0, 1);
		inputFilePane.add(numFiInput, 1, 1);
		inputFilePane.add(gradeFiLabel, 0, 2);
		inputFilePane.add(gradeFiInput, 1, 2);
		submitImport = new Button("Import Students");
		submitImport.setOnAction(this::buttonPressed);
		inputFilePane.add(submitImport, 1, 3);
		inputFilePane.setVgap(20);
		inputFilePane.setAlignment(Pos.CENTER);

		importInfo1 = new Text("Please enter the file names.");

		VBox importMain = new VBox();
		importMain.getChildren().addAll(importInfo1, inputFilePane);
		importMain.setAlignment(Pos.TOP_CENTER);
		importMain.setSpacing(20);
		importMain.setPadding(new Insets(20, 0, 0, 0));

		importStudents = new Scene(importMain, 500, 500);
		//end of import students from text files

		main.setTitle("Make Groups Great Again");
		main.setScene(start);
		main.show();
	}

	public void buttonPressed(ActionEvent e) {
		if (e.getSource() == submitStart) {
			if (profNameInput.getText() != null && !profNameInput.getText().isEmpty()) {
				app = new Manager(new Prof(profNameInput.getText()));
				main.setScene(initial);
				initialInfo.setText(app.getProf().getName() + ", you currently are not teaching any courses. Please add a course.");
			}
		}
		if (e.getSource() == submitInitial) {
			if (initialCourseInput.getText() != null && !initialCourseInput.getText().isEmpty()) {
				app.addCourse(new Course(initialCourseInput.getText()));
				main.setScene(initial2);
				initial2Info.setText("Would you like to import a student list for " + app.getCourses().get(0).getname() + "?");
			}
		}
		if (e.getSource() == importY) {
			main.setScene(importStudents);
		}
		if (e.getSource() == importN) {
			main.setScene(courseMenu);
		}
		if (e.getSource() == submitImport) {
			
		}
	}

	public static void main(String[] args) {
		launch();

	}// save groups.txt below this line

	/*
	 * Old Text based code below
	 * 
	 * public static void menu() { System.out.println("Main Menu: ");
	 * System.out.println("1. Add a Course");
	 * System.out.println("2. Import students to a course");
	 * System.out.println("3. Add a single student to a course");
	 * System.out.println("4. Auto-assign groups for a course");
	 * System.out.println("5. "); System.out.println(""); }
	 * 
	 * public static void tut() { Scanner kb = new Scanner(System.in);
	 * try {
	 * app.getCourses().get(0).importStudents(stuFile, idFile, gradesFile); }
	 * catch (IOException e) {
	 * System.out.println("Sorry, there was an error reading the file."); } } }
	 */
}
