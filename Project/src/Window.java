//import com.sun.security.ntlm.Client;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Window {
	Button enter=new Button("Enter");
	PasswordField Number=new PasswordField();
	Stage secondaryStage =new Stage();
	Label message=new Label();
	Label check =new Label();

	public Window() {
	
	
	
	Number.setLayoutX(10);
	Number.setLayoutY(5);
//	Button enter =new Button("ENTER");
	GridPane GPane=new GridPane(); 
	Button []bt=new Button[10];
	bt[0]=new Button("0");
	for(int i=1;i<bt.length;i++)
		 bt[i]=new Button(Integer.toString(i));
	GPane.add(bt[0], 2, 4);
	GPane.add(bt[1], 1, 1);
	GPane.add(bt[2], 2, 1);
	GPane.add(bt[3], 3, 1);
	GPane.add(bt[4], 1, 2);
	GPane.add(bt[5], 2, 2);
	GPane.add(bt[6], 3, 2);
	GPane.add(bt[7], 1, 3);
	GPane.add(bt[8], 2, 3);
	GPane.add(bt[9], 3, 3);

		bt[0].setOnAction(e->{
			Number.setText(Number.getText()+bt[0].getText());});
		bt[1].setOnAction(e->{
			Number.setText(Number.getText()+bt[1].getText());});
		bt[2].setOnAction(e->{
			Number.setText(Number.getText()+bt[2].getText());});
		bt[3].setOnAction(e->{
			Number.setText(Number.getText()+bt[3].getText());});
		bt[4].setOnAction(e->{
			Number.setText(Number.getText()+bt[4].getText());});
		bt[5].setOnAction(e->{
			Number.setText(Number.getText()+bt[5].getText());});
		bt[6].setOnAction(e->{
			Number.setText(Number.getText()+bt[6].getText());});
		bt[7].setOnAction(e->{
			Number.setText(Number.getText()+bt[7].getText());});
		bt[8].setOnAction(e->{
			Number.setText(Number.getText()+bt[8].getText());});
		bt[9].setOnAction(e->{
			Number.setText(Number.getText()+bt[9].getText());});
bt[0].setOnKeyPressed(e->{
	if(e.getCode().equals(KeyCode.ENTER))
		Number.setText(Number.getText()+bt[0].getText());});
bt[1].setOnKeyPressed(e->{
	if(e.getCode().equals(KeyCode.ENTER))
		Number.setText(Number.getText()+bt[1].getText());});
bt[2].setOnKeyPressed(e->{
	if(e.getCode().equals(KeyCode.ENTER))
		Number.setText(Number.getText()+bt[2].getText());});
bt[3].setOnKeyPressed(e->{
	if(e.getCode().equals(KeyCode.ENTER))
		Number.setText(Number.getText()+bt[3].getText());});
bt[4].setOnKeyPressed(e->{
	if(e.getCode().equals(KeyCode.ENTER))
		Number.setText(Number.getText()+bt[4].getText());});
bt[5].setOnKeyPressed(e->{
	if(e.getCode().equals(KeyCode.ENTER))
		Number.setText(Number.getText()+bt[5].getText());});
bt[6].setOnKeyPressed(e->{
	if(e.getCode().equals(KeyCode.ENTER))
		Number.setText(Number.getText()+bt[6].getText());});
bt[7].setOnKeyPressed(e->{
	if(e.getCode().equals(KeyCode.ENTER))
		Number.setText(Number.getText()+bt[7].getText());});
bt[8].setOnKeyPressed(e->{
	if(e.getCode().equals(KeyCode.ENTER))
		Number.setText(Number.getText()+bt[8].getText());});
bt[9].setOnKeyPressed(e->{
	if(e.getCode().equals(KeyCode.ENTER))
		Number.setText(Number.getText()+bt[9].getText());});
	
	
		
		
		
		
		
		
		
		HBox h=new HBox();
	h.getChildren().addAll(GPane,enter);
	
	VBox v=new VBox();
	v.getChildren().addAll(message,Number,h,check);
	
	Scene valid =new Scene(v);
	
	secondaryStage.setScene(valid);
}
}
