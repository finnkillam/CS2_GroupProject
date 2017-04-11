import java.io.IOException;
import java.util.ArrayList;
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
	public static Manager app;
	private int courseIndex = 0;

	// javafx stuff
	private Button submitStart, submitInitial, importY, importN, submitImport, addCourseButton, removeCourseButton, submitChange, autoAssign, viewGroups, backButton, addStudent;
	private Scene start, initial, initial2, importStudents, courseMenu, courseMenu2;
	public Stage main;
	private TextField profNameInput, initialCourseInput, stuFiInput, numFiInput, gradeFiInput, courseNameAR;
	private Text initialInfo, initial2Info, importInfo1, importInfo2, aRCourseInfo, groupsContainer;
	private Label ar;
	private VBox coursesMain;
	private boolean addCourseOption;
	private LinkedList courseButtonArray = new LinkedList();

	public void start(Stage primaryStage) {
		Font titleBold = Font.font("Arial", FontWeight.BOLD, 20);
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

		// import students from text files
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
		importInfo2 = new Text("Sorry, there was an error reading the file.");
		importInfo2.setVisible(false);

		VBox importMain = new VBox();
		importMain.getChildren().addAll(importInfo1, inputFilePane, importInfo2);
		importMain.setAlignment(Pos.TOP_CENTER);
		importMain.setSpacing(20);
		importMain.setPadding(new Insets(20, 0, 0, 0));

		importStudents = new Scene(importMain, 500, 500);
		// end of import students from text files
		
		// courses menu pane-mainmenu
		Text courseMenuHeader = new Text("Select a Course");
		addCourseButton = new Button("Add a Course");
		removeCourseButton = new Button("Remove a Course");
		addCourseButton.setOnAction(this::buttonPressed);
		removeCourseButton.setOnAction(this::buttonPressed);
		
		coursesMain = new VBox();
		coursesMain.getChildren().addAll(courseMenuHeader, addCourseButton, removeCourseButton);
		coursesMain.setAlignment(Pos.TOP_CENTER);
		coursesMain.setSpacing(20);
		coursesMain.setPadding(new Insets(20, 0, 0, 0));
		
		courseMenu = new Scene(coursesMain, 500, 500);
		// end of courses menu-main menu
		
		// add-Remove course menu 
		HBox arHBOX = new HBox();
		ar = new Label("");
		courseNameAR = new TextField();
		submitChange = new Button("Submit");
		submitChange.setOnAction(this::buttonPressed);
		arHBOX.getChildren().addAll(initialCourse, courseNameAR, submitChange);
		arHBOX.setSpacing(10);
		arHBOX.setAlignment(Pos.CENTER);

		aRCourseInfo = new Text("");

		VBox courseMain2 = new VBox();
		courseMain2.getChildren().addAll(aRCourseInfo, arHBOX);
		courseMain2.setAlignment(Pos.TOP_CENTER);
		courseMain2.setSpacing(20);
		courseMain2.setPadding(new Insets(20, 0, 0, 0));

		courseMenu2 = new Scene(courseMain2, 500, 500);

		//end of courses menu-main menu */

		main.setTitle("Make Groups Great Again");
		main.setScene(start);
		main.show();
	}

	public void buttonPressed(ActionEvent e) {
		if (e.getSource() == submitStart) {
			if (!profNameInput.getText().isEmpty()) {
				app = new Manager(new Prof(profNameInput.getText()));
				main.setScene(initial);
				initialInfo.setText(app.getProf().getName() + ", you currently are not teaching any courses. Please add a course.");
			}
		}
		if (e.getSource() == submitInitial) {
			if (!initialCourseInput.getText().isEmpty()) {
				app.addCourse(new Course(initialCourseInput.getText()));
				main.setScene(initial2);
				initial2Info.setText("Would you like to import a student list for " + app.getCourses().get(0).getname() + "?");
			}
		}
		if (e.getSource() == importY) {
			main.setScene(importStudents);
			importInfo2.setText("");
		}
		if (e.getSource() == importN) {
			coursesMain.getChildren().add(1, getCoursesPane());
			main.setScene(courseMenu);
		}
		if (e.getSource() == submitImport) {
			if (!stuFiInput.getText().isEmpty() && !numFiInput.getText().isEmpty() && !gradeFiInput.getText().isEmpty()) {
				try {
					app.getCourses().get(courseIndex).importStudents(stuFiInput.getText(), numFiInput.getText(), gradeFiInput.getText());
					importInfo2.setVisible(true);
					importInfo2.setText("Students Imported Successfully");
					main.setScene(getCourseScene(courseIndex));
				} catch (IOException error) {
					importInfo2.setVisible(true);
					importInfo2.setText("There was an error reading a file. Please check the entered text");
				}
			}
		}
		if (e.getSource() == addCourseButton) {
			aRCourseInfo.setText("Add a Course");
			ar.setText("Name of the course to add: ");
			main.setScene(courseMenu2);
			addCourseOption = true;
		}
		if (e.getSource() == removeCourseButton) {
			aRCourseInfo.setText("Remove a Course");
			ar.setText("Name of the course to remove: ");
			main.setScene(courseMenu2);
			addCourseOption = false;
		}
		if (e.getSource() == submitChange) {
			if (!courseNameAR.getText().isEmpty()) {
				if (addCourseOption == true) {
					app.addCourse(new Course(courseNameAR.getText()));
					coursesMain.getChildren().add(1, getCoursesPane());
					coursesMain.getChildren().remove(2);
					main.setScene(courseMenu);
				}
				else if (addCourseOption == false) {
					app.removeCourse(courseNameAR.getText());
					coursesMain.getChildren().add(1, getCoursesPane());
					coursesMain.getChildren().remove(2);
					main.setScene(courseMenu);
				}
			}
		}
		if (!courseButtonArray.isEmpty()) {
			for (int i = 0; i < courseButtonArray.size(); i++) {
				if (e.getSource() == courseButtonArray.get(i)) {
					main.setScene(getCourseScene(i));
				
				}
			}
		}
		if (e.getSource() == autoAssign) {
			app.getCourses().get(courseIndex).autoMakeGroups();
			groupsContainer.setText("Groups have been made and saved");
		}
		if (e.getSource() == viewGroups) {
			groupsContainer.setText(app.getCourses().get(courseIndex).getAllGroups().toString());
		}
		
		if (e.getSource() == backButton) {
			if (courseButtonArray.size()==0) {
				coursesMain.getChildren().add(1, getCoursesPane());
			}
			main.setScene(courseMenu);
		}
		
	}

	public static void main(String[] args) {
		launch();
	}
	
	private Pane getCoursesPane () {
		GridPane courseList = new GridPane();
		courseButtonArray.clear();
		for (int i = 0; i < Demo.app.getCourses().size(); i++) {
			Button temp = new Button(Demo.app.getCourses().get(i).getname());
			courseButtonArray.addToEnd(temp);
			courseList.add(temp, 0, i);
			temp.setOnAction(this::buttonPressed);
		}
		courseList.setVgap(20);
		courseList.setAlignment(Pos.CENTER);
		return courseList;
	}
	
	private Scene getCourseScene(int index) {
		courseIndex = index;
		// add-Remove course menu 
		VBox arVBOX = new VBox();
		autoAssign = new Button("Auto-Assign Groups");
		autoAssign.setOnAction(this::buttonPressed);
		viewGroups = new Button("View Groups");
		viewGroups.setOnAction(this::buttonPressed);
		importY = new Button("Import Students");
		importY.setOnAction(this::buttonPressed);
		backButton = new Button("Back");
		backButton.setOnAction(this::buttonPressed);
		
		arVBOX.getChildren().addAll(importY,backButton);
		if (!app.getCourses().get(index).getAllStudents().isEmpty()) {
			arVBOX.getChildren().add(0, autoAssign);
			arVBOX.getChildren().add(1, viewGroups);
		}
		arVBOX.setSpacing(10);
		arVBOX.setAlignment(Pos.CENTER);

		Text coursequestion = new Text("What would you like to do in " + app.getCourses().get(index).getname() + "?");
		groupsContainer = new Text();

		VBox courseMain2 = new VBox();
		courseMain2.getChildren().addAll(coursequestion, arVBOX, groupsContainer);
		courseMain2.setAlignment(Pos.TOP_CENTER);
		courseMain2.setSpacing(20);
		courseMain2.setPadding(new Insets(20, 0, 0, 0));
		
		return new Scene(courseMain2, 700, 400);
	}
	
}
