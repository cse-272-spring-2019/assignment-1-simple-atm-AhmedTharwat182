
/*
 * Ahmed Tharwat Wagdy
 * 5336
 * 
 * 
 * 
 * 
 * */




import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class GUI extends Application {
//	ATM head =new ATM();
ATM client =new ATM();

ATM[] transactions =new ATM[5];

int count=0,maxCount=0;
String type;


	public void start(Stage primaryStage) {
		

		
		Button balance = new Button("Check\nBalance");
		Button deposit = new Button("Deposit");
		Button withdraw = new Button("Withdraw");
		Button next = new Button("Next");
		Button previous = new Button("Previous");
		Button Exit = new Button("Exit");

		Label message2 = new Label("Enter the desired amount");

		VBox right = new VBox();
		VBox left = new VBox();
		HBox buttom = new HBox();

		right.getChildren().addAll(balance, Exit);
		left.getChildren().addAll(deposit, withdraw);
		buttom.getChildren().addAll(previous, next);
		balance.setMinSize(50, 90);
		withdraw.setMinSize(50, 90);
		deposit.setMinSize(50, 90);


		right.setSpacing(400);
		buttom.setSpacing(400);
		left.setSpacing(350);
		left.setAlignment(Pos.CENTER_RIGHT);
		right.setAlignment(Pos.CENTER_LEFT);
		buttom.setAlignment(Pos.CENTER);

		Label screen = new Label();
		screen.setLayoutX(40);
		screen.setLayoutY(50);
		screen.setText("WELCOME TO JAVA");

		VBox v2 = new VBox();

		BorderPane pane = new BorderPane();
		pane.setCenter(screen);
		pane.setLeft(left);
		pane.setRight(right);
		pane.setBottom(buttom);

		Scene scene = new Scene(pane);

		primaryStage.setScene(scene);
		primaryStage.setMinHeight(600);
		primaryStage.setMinWidth(900);
		primaryStage.setResizable(false);
		primaryStage.setTitle("JAVA ATM");

		Window pin = new Window();
		pin.message.setText("Enter your Pin");
		pin.check.setText("CHECK THE ATM CLASS");
		pin.secondaryStage.show();
		pin.enter.setOnAction(e -> {
			if (Integer.parseInt(pin.Number.getText()) == client.getCardNumber()) {
				pin.secondaryStage.close();
				primaryStage.show();
			}
			if (Integer.parseInt(pin.Number.getText()) != client.getCardNumber()) {
				pin.check.setText("Invalid Pin");
			pin.Number.clear();}

		});
		
		pin.Number.setOnKeyPressed(e->{
			if(e.getCode().equals(KeyCode.ENTER)) {
				if (Integer.parseInt(pin.Number.getText()) == client.getCardNumber()) {
					pin.secondaryStage.close();
					primaryStage.show();
				}
				if (Integer.parseInt(pin.Number.getText()) != client.getCardNumber()) {
					pin.check.setText("Invalid Pin");
				pin.Number.clear();}	
				
			}
			
		});
		pin.enter.setOnKeyPressed(e -> {
			
			if(e.getCode().equals(KeyCode.ENTER)) {
			if (Integer.parseInt(pin.Number.getText()) == client.getCardNumber()) {
				pin.secondaryStage.close();
				primaryStage.show();
			}
			if (Integer.parseInt(pin.Number.getText()) != client.getCardNumber()) {
				pin.check.setText("Invalid Pin");
			pin.Number.clear();}}

		});
		
		
		
		
		
		
		next.setDisable(true);
		if(count<1)	previous.setDisable(true);
		
		
		
		Window with = new Window();

		with.message.setText("Enter the desired amount");
		with.enter.setOnAction(e -> {
			if (Integer.parseInt(with.Number.getText()) > client.getCurrentBalance()) {
				with.check.setText("Your balance us not enough");
				with.Number.clear();
				}
			else if (Integer.parseInt(with.Number.getText()) <= client.getCurrentBalance()) {
				client.setCurrentBalance(client.getCurrentBalance() - Integer.parseInt(with.Number.getText()));
				transactions[count]=new ATM();
				maxCount=count;
				transactions[count].setCurrentBalance(client.getCurrentBalance());
				with.secondaryStage.close();
				screen.setText("Sucessful Operation");
				deposit.setDisable(true);
				withdraw.setDisable(true);
				balance.setDisable(true);
				previous.setDisable(true);
				next.setDisable(false);
			
			}

		});
		with.Number.setOnKeyPressed(e->{
			if(e.getCode().equals(KeyCode.ENTER)) {
				if (Integer.parseInt(with.Number.getText()) > client.getCurrentBalance()) {
					with.check.setText("Your balance us not enough");
					with.Number.clear();
					}
				else if (Integer.parseInt(with.Number.getText()) <= client.getCurrentBalance()) {
					client.setCurrentBalance(client.getCurrentBalance() - Integer.parseInt(with.Number.getText()));
					transactions[count]=new ATM();
					maxCount=count;
					transactions[count].setCurrentBalance(client.getCurrentBalance());
					with.secondaryStage.close();
					screen.setText("Sucessful Operation");
					deposit.setDisable(true);
					withdraw.setDisable(true);
					balance.setDisable(true);
					previous.setDisable(true);
					next.setDisable(false);
				
				}
				
			}
			
		});
		with.enter.setOnKeyPressed(e -> {
			if(e.getCode().equals(KeyCode.ENTER)) {
			if (Integer.parseInt(with.Number.getText()) > client.getCurrentBalance()) {
				with.check.setText("Your balance us not enough");
				with.Number.clear();
				}
			else if (Integer.parseInt(with.Number.getText()) <= client.getCurrentBalance()) {
				client.setCurrentBalance(client.getCurrentBalance() - Integer.parseInt(with.Number.getText()));
				transactions[count]=new ATM();
				maxCount=count;
				transactions[count].setCurrentBalance(client.getCurrentBalance());
				with.secondaryStage.close();
				screen.setText("Sucessful Operation");
				deposit.setDisable(true);
				withdraw.setDisable(true);
				balance.setDisable(true);
				previous.setDisable(true);
				next.setDisable(false);
			
			}

			}});
		
		
		
		
		withdraw.setOnAction(e -> {
			with.secondaryStage.show();
		});
		withdraw.setOnKeyPressed(e->{
			if(e.getCode().equals(KeyCode.ENTER))
				with.secondaryStage.show();
			
			
		});

		Window dep = new Window();
		dep.message.setText("Enter the desired value");
		dep.enter.setOnAction(e -> {

			client.setCurrentBalance(client.getCurrentBalance()+Integer.parseInt(dep.Number.getText()));

			
			transactions[count]=new ATM();
			maxCount=count;
			transactions[count].setCurrentBalance(client.getCurrentBalance());
			dep.secondaryStage.close();
			screen.setText("Sucessful Operation");
			deposit.setDisable(true);
			withdraw.setDisable(true);
			balance.setDisable(true);
			previous.setDisable(true);
			next.setDisable(false);
			
	
		});
		dep.Number.setOnKeyPressed(e->{
			if(e.getCode().equals(KeyCode.ENTER)) {
				client.setCurrentBalance(client.getCurrentBalance()+Integer.parseInt(dep.Number.getText()));

				
				transactions[count]=new ATM();
				maxCount=count;
				transactions[count].setCurrentBalance(client.getCurrentBalance());
				dep.secondaryStage.close();
				screen.setText("Sucessful Operation");
				deposit.setDisable(true);
				withdraw.setDisable(true);
				balance.setDisable(true);
				previous.setDisable(true);
				next.setDisable(false);
			}
			
		});
		dep.enter.setOnKeyPressed(e -> {
			if(e.getCode().equals(KeyCode.ENTER)) {
			client.setCurrentBalance(client.getCurrentBalance()+Integer.parseInt(dep.Number.getText()));

			
			transactions[count]=new ATM();
			maxCount=count;
			transactions[count].setCurrentBalance(client.getCurrentBalance());
			dep.secondaryStage.close();
			screen.setText("Sucessful Operation");
			deposit.setDisable(true);
			withdraw.setDisable(true);
			balance.setDisable(true);
			previous.setDisable(true);
			next.setDisable(false);
			
	
			}	});
		
		
		deposit.setOnAction(e -> {
			dep.secondaryStage.show();

		});
		deposit.setOnKeyPressed(e->{
			if(e.getCode().equals(KeyCode.ENTER)) 
				dep.secondaryStage.show();
			
		});
		
	
		next.setOnAction(e -> {
			
			
			
				if(count==maxCount) {
			deposit.setDisable(false);
			withdraw.setDisable(false);
			balance.setDisable(false);
			previous.setDisable(false);
			next.setDisable(true);
			screen.setText("WELCOME TO JAVA");		
}	
			
			
				else  {
					count++;
					if(count<1) {
						if(transactions[count].getCurrentBalance()==1500.75)
							screen.setText("Balance Enguiry"+"\nBalance Before:  "+1500.75
									+"\nBalance After: "+transactions[count].getCurrentBalance());
						else if(transactions[count].getCurrentBalance()>1500.75)
							screen.setText("Deposition"+"\nBalance Before:  "+1500.75
									+"\nBalance After: "+transactions[count].getCurrentBalance());
						else if(transactions[count].getCurrentBalance()<1500.75)
							screen.setText("Withdrawal"+"\nBalance Before:  "+1500.75
									+"\nBalance After: "+transactions[count].getCurrentBalance());
							
						}
						if(count>=1) {
							if(transactions[count].getCurrentBalance()==transactions[count-1].getCurrentBalance())
								screen.setText("Balance Enguiry"+"\nBalance Before:  "+transactions[count-1].getCurrentBalance()
										+"\nBalance After: "+transactions[count].getCurrentBalance());
							
							else if(transactions[count].getCurrentBalance()>transactions[count-1].getCurrentBalance())
								screen.setText("Deposition"+"\nBalance Before:  "+transactions[count-1].getCurrentBalance()
										+"\nBalance After: "+transactions[count].getCurrentBalance());
									else if(transactions[count].getCurrentBalance()<transactions[count-1].getCurrentBalance())
								screen.setText("Withdrawal"+"\nBalance Before:  "+transactions[count-1].getCurrentBalance()
										+"\nBalance After: "+transactions[count].getCurrentBalance());				
							}
				count--;
				}
			
				count++;
			
			if(count>=1)	previous.setDisable(false);
		
		
			if(count==transactions.length) {
				
				deposit.setDisable(true);
				withdraw.setDisable(true);
				balance.setDisable(true);
			}
			
		
		});
		
		next.setOnKeyPressed(e->{
			if(e.getCode().equals(KeyCode.ENTER)) {
				if(count==maxCount) {
					deposit.setDisable(false);
					withdraw.setDisable(false);
					balance.setDisable(false);
					previous.setDisable(false);
					next.setDisable(true);
					screen.setText("WELCOME TO JAVA");		
		}	
					
					
						else  {
							count++;
							if(count<1) {
								if(transactions[count].getCurrentBalance()==1500.75)
									screen.setText("Balance Enguiry"+"\nBalance Before:  "+1500.75
											+"\nBalance After: "+transactions[count].getCurrentBalance());
								else if(transactions[count].getCurrentBalance()>1500.75)
									screen.setText("Deposition"+"\nBalance Before:  "+1500.75
											+"\nBalance After: "+transactions[count].getCurrentBalance());
								else if(transactions[count].getCurrentBalance()<1500.75)
									screen.setText("Withdrawal"+"\nBalance Before:  "+1500.75
											+"\nBalance After: "+transactions[count].getCurrentBalance());
									
								}
								if(count>=1) {
									if(transactions[count].getCurrentBalance()==transactions[count-1].getCurrentBalance())
										screen.setText("Balance Enguiry"+"\nBalance Before:  "+transactions[count-1].getCurrentBalance()
												+"\nBalance After: "+transactions[count].getCurrentBalance());
									
									else if(transactions[count].getCurrentBalance()>transactions[count-1].getCurrentBalance())
										screen.setText("Deposition"+"\nBalance Before:  "+transactions[count-1].getCurrentBalance()
												+"\nBalance After: "+transactions[count].getCurrentBalance());
											else if(transactions[count].getCurrentBalance()<transactions[count-1].getCurrentBalance())
										screen.setText("Withdrawal"+"\nBalance Before:  "+transactions[count-1].getCurrentBalance()
												+"\nBalance After: "+transactions[count].getCurrentBalance());				
									}
						count--;
						}
					
						count++;
					
					if(count>=1)	previous.setDisable(false);
				
				
					if(count==transactions.length) {
						
						deposit.setDisable(true);
						withdraw.setDisable(true);
						balance.setDisable(true);
					}
					
				
				
				
				
			}
				
		});
		
		
		
		
		
		
		previous.setOnAction(e -> {
			
						deposit.setDisable(true);
			withdraw.setDisable(true);
			balance.setDisable(true);
		 next.setDisable(false);
			if(count<=0)count=0;
		else	count--;
		
			
			
			if(count<1) {
				if(transactions[count].getCurrentBalance()==1500.75)
					screen.setText("Balance Enguiry"+"\nBalance Before:  "+1500.75
							+"\nBalance After: "+transactions[count].getCurrentBalance());
				else if(transactions[count].getCurrentBalance()>1500.75)
					screen.setText("Deposition"+"\nBalance Before:  "+1500.75
							+"\nBalance After: "+transactions[count].getCurrentBalance());
				else if(transactions[count].getCurrentBalance()<1500.75)
					screen.setText("Withdrawal"+"\nBalance Before:  "+1500.75
							+"\nBalance After: "+transactions[count].getCurrentBalance());
					
				}
				if(count>=1) {
					if(transactions[count].getCurrentBalance()==transactions[count-1].getCurrentBalance())
						screen.setText("Balance Enguiry"+"\nBalance Before:  "+transactions[count-1].getCurrentBalance()
								+"\nBalance After: "+transactions[count].getCurrentBalance());
					
					else if(transactions[count].getCurrentBalance()>transactions[count-1].getCurrentBalance())
						screen.setText("Deposition"+"\nBalance Before:  "+transactions[count-1].getCurrentBalance()
								+"\nBalance After: "+transactions[count].getCurrentBalance());
							else if(transactions[count].getCurrentBalance()<transactions[count-1].getCurrentBalance())
						screen.setText("Withdrawal"+"\nBalance Before:  "+transactions[count-1].getCurrentBalance()
								+"\nBalance After: "+transactions[count].getCurrentBalance());				
					}
		
	});

previous.setOnKeyPressed(e->{
	if(e.getCode().equals(KeyCode.ENTER)) {
		deposit.setDisable(true);
	withdraw.setDisable(true);
	balance.setDisable(true);
 next.setDisable(false);
	if(count<=0)count=0;
else	count--;

	
	
	if(count<1) {
		if(transactions[count].getCurrentBalance()==1500.75)
			screen.setText("Balance Enguiry"+"\nBalance Before:  "+1500.75
					+"\nBalance After: "+transactions[count].getCurrentBalance());
		else if(transactions[count].getCurrentBalance()>1500.75)
			screen.setText("Deposition"+"\nBalance Before:  "+1500.75
					+"\nBalance After: "+transactions[count].getCurrentBalance());
		else if(transactions[count].getCurrentBalance()<1500.75)
			screen.setText("Withdrawal"+"\nBalance Before:  "+1500.75
					+"\nBalance After: "+transactions[count].getCurrentBalance());
			
		}
		if(count>=1) {
			if(transactions[count].getCurrentBalance()==transactions[count-1].getCurrentBalance())
				screen.setText("Balance Enguiry"+"\nBalance Before:  "+transactions[count-1].getCurrentBalance()
						+"\nBalance After: "+transactions[count].getCurrentBalance());
			
			else if(transactions[count].getCurrentBalance()>transactions[count-1].getCurrentBalance())
				screen.setText("Deposition"+"\nBalance Before:  "+transactions[count-1].getCurrentBalance()
						+"\nBalance After: "+transactions[count].getCurrentBalance());
					else if(transactions[count].getCurrentBalance()<transactions[count-1].getCurrentBalance())
				screen.setText("Withdrawal"+"\nBalance Before:  "+transactions[count-1].getCurrentBalance()
						+"\nBalance After: "+transactions[count].getCurrentBalance());				
			}

		
		
	}
	
});
	
		
		balance.setOnAction(e -> {
			screen.setText("Your Current balance is\n\t\t" + String.valueOf(client.getCurrentBalance()));
			transactions[count]=new ATM();
			maxCount=count;
			transactions[count].setCurrentBalance(client.getCurrentBalance());


			deposit.setDisable(true);
			withdraw.setDisable(true);
			balance.setDisable(true);
			previous.setDisable(true);
			next.setDisable(false);
		});
balance.setOnKeyPressed(e->{
	if(e.getCode().equals(KeyCode.ENTER)) {
		screen.setText("Your Current balance is\n\t\t" + String.valueOf(client.getCurrentBalance()));
		transactions[count]=new ATM();
		maxCount=count;
		transactions[count].setCurrentBalance(client.getCurrentBalance());


		deposit.setDisable(true);
		withdraw.setDisable(true);
		balance.setDisable(true);
		previous.setDisable(true);
		next.setDisable(false);
	}
	
});

		
		
		
		
		
		Exit.setOnAction(e -> {
			primaryStage.close();
		});
		
Exit.setOnKeyPressed(e->{
	if(e.getCode().equals(KeyCode.ENTER)) {
		
		primaryStage.close();
	}
	
});
		
	}

	public static void main(String[] args) {

		Application.launch();
	}

}
