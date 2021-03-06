
//Dan Champagne
//Carl Weber
//Databases Project 

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
import java.sql.*;
import javax.swing.BoxLayout;
import javax.swing.table.DefaultTableModel;

class Customers{
	// CustomerID,FirstName,LastName,DOB,PhoneNumber
	String CustomerID;
	String FirstName;
	String LastName;
	String DOB;
	String PhoneNumber;
	
	
	Customers (String CustomerID, String FirstName , String LastName, String DOB, String PhoneNumber){
		
		this.CustomerID = CustomerID;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.DOB = DOB;
		this.PhoneNumber = PhoneNumber;
		
		
		
	}

	public String getCustomerID() {
		
		return CustomerID;
		
	}
	
	public String getFirstName() {
		
		return FirstName;
		
	}

	public String getLastName() {
	
		return LastName;
	
	}
	
	public String getDOB() {
		
			return DOB;
		
	}

	public String getPhoneNumber() {
	
		return PhoneNumber;
	
	}
}
class Employees{
	//EmployeeID,FirstName,LastName,DOB,DateOfEmployment,Wage
	String EmployeeID;
	String FirstName;
	String LastName;
	String DOB;
	String DateOfEmployment;
	String Wage;
	
	Employees (String EmployeeID, String FirstName , String LastName, String DOB, String DateOfEmployment, String Wage){
		
		this.EmployeeID = EmployeeID;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.DOB = DOB;
		this.DateOfEmployment = DateOfEmployment;
		this.Wage = Wage;
		
		
	}

	public String getEmployeeID() {
		
		return EmployeeID;
		
	}
	
	public String getFirstName() {
		
		return FirstName;
		
	}

	public String getLastName() {
	
		return LastName;
	
	}
	
	public String getDOB() {
		
			return DOB;
		
	}

	public String getDateOfEmployment() {
	
		return DateOfEmployment;
	
	}
	
	public String getWage() {
		
		return Wage;
	
	}
	
	
}
class Cars{
	
	String CarID;
	String Make;
	String Model;
	int Year;
	String Color;
	String Price;
	String ForSale;
	
	Cars(String CarID, String Make, String Model, int Year, String Color, String Price, String ForSale){
		
		this.CarID = CarID;
		this.Make = Make;
		this.Model = Model;
		this.Year = Year;
		this.Color = Color;
		this.Price = Price;
		this.ForSale = ForSale;
		
	}

	public String getCarID() {
		
		return CarID;
		
	}
	
	public String getMake() {
		
		return Make;
		
	}

	public String getModel() {
	
		return Model;
	
	}
	
	public int getYear() {
		
			return Year;
		
	}

	public String getColor() {
	
		return Color;
	
	}
	
	public String getPrice() {
		
		return Price;
	
	}
	
	public String getForSale() {
		
		return ForSale;
	
	}
}

class CarsOwners{
	
	String CustomerID;
	String FirstName;
	String LastName;
	String CarID;
	String Make;
	String Model;
	int Year;
	String Color;
	String SalePrice;

	
	CarsOwners(String CustomerID, String FirstName, String LastName, 
			   String CarID, String Make, String Model, 
			   int Year, String Color, String SalePrice){
		
		this.CustomerID = CustomerID;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.CarID = CarID;
		this.Make = Make;
		this.Model = Model;
		this.Year = Year;
		this.Color = Color;
		this.SalePrice = SalePrice;
		
	}

	public String getCustomerID() {
		
		return CustomerID;
		
	}

	public String getFirstName() {
		
		return FirstName;
		
	}

	public String getLastName() {
		
		return LastName;
		
	}

	public String getCarID() {
		
		return CarID;
		
	}
	
	public String getMake() {
		
		return Make;
		
	}

	public String getModel() {
	
		return Model;
	
	}
	
	public int getYear() {
		
			return Year;
		
	}

	public String getColor() {
	
		return Color;
	
	}
	
	public String getSalePrice() {
		
		return SalePrice;
	
	}
	
}

public class CarDB{
	
	static Connection con;
	static Statement stmt;
	
	public static void HomeView(){
		
		String SortDefault = "All";
		
		JFrame frame = new JFrame("Home");
		
		JPanel panel = new JPanel();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
			
		JLabel label = new JLabel("Welcome to the USED CAR DataBase");
			
		JButton AddCar = new JButton();
		JButton ViewDataBase = new JButton();
		JButton AddEmployee = new JButton();
		JButton AddCustomer = new JButton();
		JButton AddSale = new JButton();
		JButton ViewCarsByOwner = new JButton();
		
		AddCar.setText("Add Car");
		AddEmployee.setText("Add Employee");
		AddSale.setText("Add Sale");
		AddCustomer.setText("Add Customer");
		ViewDataBase.setText("View Car Data Base");
		ViewCarsByOwner.setText("View Car Data Base By Owner");
		
		frame.getContentPane().add(label);
		frame.getContentPane().add(AddCar);
		frame.getContentPane().add(AddEmployee);
		frame.getContentPane().add(AddCustomer);
		frame.getContentPane().add(AddSale);
		frame.getContentPane().add(ViewDataBase);
		frame.getContentPane().add(ViewCarsByOwner);
		
		frame.add(panel);
		frame.setSize(300,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true); 
		
		AddCar.addActionListener(new ActionListener(){
			
			public void actionPerformed( ActionEvent e ){
				addCar(); 
	        }  
		});
		AddEmployee.addActionListener(new ActionListener(){
			
			public void actionPerformed( ActionEvent e ){
				addEmployee(); 
	        }  
		});
		AddSale.addActionListener(new ActionListener(){
			
			public void actionPerformed( ActionEvent e ){
				addSale(); 
	        }  
		});
		AddCustomer.addActionListener(new ActionListener(){
			
			public void actionPerformed( ActionEvent e ){
				addCustomer(); 
	        }  
		});
		ViewDataBase.addActionListener(new ActionListener(){
			
			public void actionPerformed( ActionEvent e ){
				viewCars(SortDefault); 
	        }  
		});
		ViewCarsByOwner.addActionListener(new ActionListener(){
			
			public void actionPerformed( ActionEvent e ){
				viewCarsByOwner(SortDefault); 
	        }  
		});
	}
	
	//Add Car =======================================================================================
	public static void addCar() {

		JFrame frame = new JFrame("Add Car");
		JLabel CarIDTxt= new JLabel("Enter the VIN of the car (Must be unique).");	
		JLabel MakeTxt= new JLabel("Enter the make of the car.");
		JLabel ModelTxt= new JLabel("Enter the model of the car.");
		JLabel YearTxt= new JLabel("Enter the year of the car.");
		JLabel ColorTxt= new JLabel("Enter the color of the car.");
		JLabel ListingPriceTxt= new JLabel("Enter the listing price(Format of: $00.00).");
		JLabel ForsaleTxt= new JLabel("Select 'Yes' if the car is for sale, 'No' if otherwise.");
		
		String[] ComboBoxPatterns = {"Yes", "No"};
		JComboBox ComboBox = new JComboBox(ComboBoxPatterns);
		
		JPanel panel = new JPanel();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
		
		JTextField CarID,Make,Model,Year,Color,Price;
			
		CarID = new JTextField("");
		Make = new JTextField("");
		Model = new JTextField("");
		Year = new JTextField("");
		Color = new JTextField("");
		Price = new JTextField("");
		
		CarID.setBounds(50,100, 200,30);  
		Make.setBounds(50,100, 200,30);  
		Model.setBounds(50,100, 200,30);  
		Year.setBounds(50,100, 200,30);  
		Color.setBounds(50,100, 200,30);  
			
		JButton Submit = new JButton();
		Submit.setText("Submit");
			
		frame.add(CarIDTxt);
		frame.add(CarID);
		frame.add(MakeTxt);
		frame.add(Make);
		frame.add(ModelTxt);
		frame.add(Model);
		frame.add(YearTxt);
		frame.add(Year);
		frame.add(ColorTxt);
		frame.add(Color);
		frame.add(ListingPriceTxt);
		frame.add(Price);
		frame.add(ForsaleTxt);
		frame.add(ComboBox);
		frame.add(Submit);
			
		frame.add(panel);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
			
		Submit.addActionListener(new ActionListener(){
			
		  public void actionPerformed( ActionEvent f ){
					
			    String CarIDInput =CarID.getText(); 
				String MakeInput =Make.getText(); 
				String ModelInput =Model.getText(); 
				String YearInput =Year.getText(); 
				String ColorInput =Color.getText(); 
				String PriceInput =Price.getText();
				String ForsaleInput = ComboBox.getSelectedItem().toString();
					
				try{
					
					Class.forName("org.sqlite.JDBC");
					con = DriverManager.getConnection("jdbc:sqlite:/Users/cjlaptop/Desktop/UsedCars.DB");
					
					stmt = con.createStatement();
					
					stmt.executeUpdate("INSERT INTO Cars(CarID,Make,Model,Year,Color,Price,Forsale) VALUES ('"+CarIDInput+"','"+MakeInput+"','"+ModelInput+"','"+YearInput+"','"+ColorInput+"','"+PriceInput+"','"+ForsaleInput+"')");	
					
					stmt.close();
					con.close();

				}
					
				catch ( Exception e ) {
				    	  
				  System.err.println( e.getClass().getName() + ": " + e.getMessage() );
					System.exit(0);
			 
				}	
			}
		});
	}
	//=======================================================================================
	
	//Add Employee=======================================================================================
	public static void addEmployee() {

		JFrame frame = new JFrame("Add Employee");
		JLabel EmployeeIDTxt= new JLabel("Enter the employees ID(Must be unique).");
		JLabel FirstNameTxt= new JLabel("Enter the employees first name.");
		JLabel LastNameTxt= new JLabel("Enter the employees last name.");
		JLabel DOBTxt= new JLabel("Enter the employees DOB.");
		JLabel DateOfEmploymentTxt= new JLabel("Enter the date of employment.");
		JLabel WageTxt= new JLabel("Enter the employees pay per hour.(Format: $00.00).");
		
		JPanel panel = new JPanel();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
				
		JTextField EmployeeID,FirstName,LastName,DOB,DateOfEmployment,Wage;
				
		EmployeeID = new JTextField("");
		FirstName = new JTextField("");
		LastName = new JTextField("");
		DOB = new JTextField("");
		DateOfEmployment = new JTextField("");
		Wage = new JTextField("");
			
				
		EmployeeID.setBounds(50,100, 200,30);  
		FirstName.setBounds(50,100, 200,30);  
		DOB.setBounds(50,100, 200,30);  
		DateOfEmployment.setBounds(50,100, 200,30);  
		Wage.setBounds(50,100, 200,30);  
				
		JButton Submit = new JButton();
		Submit.setText("Submit");
		
		frame.add(EmployeeIDTxt);
		frame.add(EmployeeID);
		frame.add(FirstNameTxt);
		frame.add(FirstName);
		frame.add(LastNameTxt);
		frame.add(LastName);
		frame.add(DOBTxt);
		frame.add(DOB);
		frame.add(DateOfEmploymentTxt);
		frame.add(DateOfEmployment);
		frame.add(WageTxt);
		frame.add(Wage);
		frame.add(Submit);
				
		frame.add(panel);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
				
		Submit.addActionListener(new ActionListener(){
				
			public void actionPerformed( ActionEvent f ){
						
				String EmployeeIDInput =EmployeeID.getText(); 
				String FirstNameInput =FirstName.getText(); 
				String LastNameInput =LastName.getText(); 
				String DOBInput =DOB.getText(); 
				String DateOfEmploymentInput =DateOfEmployment.getText(); 
				String WageInput =Wage.getText(); 
						
				try{
						
					Class.forName("org.sqlite.JDBC");
					con = DriverManager.getConnection("jdbc:sqlite:/Users/cjlaptop/Desktop/UsedCars.DB");
						
					stmt = con.createStatement();
						
					stmt.executeUpdate("INSERT INTO Employees(EmployeeID,FirstName,LastName,DOB,DateOfEmployment,Wage) VALUES ('"+EmployeeIDInput+"','"+FirstNameInput+"','"+LastNameInput+"','"+DOBInput+"','"+DateOfEmploymentInput+"','"+WageInput+"')");	
						
					stmt.close();
					con.close();

				}
						
				catch ( Exception e ) {
					    	  
					System.err.println( e.getClass().getName() + ": " + e.getMessage() );
					System.exit(0);
				 
				}	
			}
		});
	}
	//=======================================================================================
	
	//Add Customer=======================================================================================
	public static void addCustomer() {

		JFrame frame = new JFrame("Add Customer");
		JLabel CustomerIDTxt= new JLabel("Enter the customers ID(Must be unique).");
		JLabel FirstNameTxt= new JLabel("Enter the customers first name.");
		JLabel LastNameTxt= new JLabel("Enter the customers last name.");
		JLabel DOBTxt= new JLabel("Enter the customers DOB.");
		JLabel PhoneNumberTxt= new JLabel("Enter the customers phone number(Format: 000-000-0000 ).");
		
		JPanel panel = new JPanel();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
				
		JTextField CustomerID,FirstName,LastName,DOB,PhoneNumber;
				
		CustomerID = new JTextField("");
		FirstName = new JTextField("");
		LastName = new JTextField("");
		DOB = new JTextField("");
		PhoneNumber = new JTextField("");
			
		CustomerID.setBounds(50,100, 200,30);  
		FirstName.setBounds(50,100, 200,30);  
		LastName.setBounds(50,100, 200,30);  
		DOB.setBounds(50,100, 200,30);  
		PhoneNumber.setBounds(50,100, 200,30);  
				
		JButton Submit = new JButton();
		Submit.setText("Submit");
				
		frame.add(CustomerIDTxt);
		frame.add(CustomerID);
		frame.add(FirstNameTxt);
		frame.add(FirstName);
		frame.add(LastNameTxt);
		frame.add(LastName);
		frame.add(DOBTxt);
		frame.add(DOB);
		frame.add(PhoneNumberTxt);
		frame.add(PhoneNumber);
		
		frame.add(Submit);
				
		frame.add(panel);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
				
		Submit.addActionListener(new ActionListener(){
				
			public void actionPerformed( ActionEvent f ){
						
				String CustomerIDInput =CustomerID.getText(); 
				String FirstNameInput =FirstName.getText(); 
				String LastNameInput =LastName.getText(); 
				String DOBInput =DOB.getText(); 
				String PhoneNumberInput =PhoneNumber.getText(); 
						
				try{
						
					Class.forName("org.sqlite.JDBC");
					con = DriverManager.getConnection("jdbc:sqlite:/Users/cjlaptop/Desktop/UsedCars.DB");
						
					stmt = con.createStatement();
						
					stmt.executeUpdate("INSERT INTO Customers(CustomerID,FirstName,LastName,DOB,PhoneNumber) VALUES ('"+CustomerIDInput+"','"+FirstNameInput+"','"+LastNameInput+"','"+DOBInput+"','"+PhoneNumberInput+"')");	
						
					stmt.close();
					con.close();

				}
						
				catch ( Exception e ) {
					    	  
					System.err.println( e.getClass().getName() + ": " + e.getMessage() );
					System.exit(0);
				 
				}	
			}
		});
	}
	
	//Add Sale=======================================================================================
	public static void addSale() {

		JFrame frame = new JFrame("Add Sale");
		JLabel SaleIDTxt= new JLabel("Enter the saleID(MustBeUnique).");
		JLabel CarIDTxt= new JLabel("Enter the cars VIN");
		JLabel CustomerIDTxt= new JLabel("Enter the customers ID");
		JLabel EmployeeIDTxt= new JLabel("Enter the employees ID");
		JLabel DateOfSaleTxt= new JLabel("Enter the date of the sale.");
		JLabel SalePriceTxt= new JLabel("Enter the sales price (Format: $00.00).");
				
		JPanel panel = new JPanel();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
				
		JTextField SaleID,CarID,CustomerID,EmployeeID,DateOfSale,SalePrice;
				
		SaleID = new JTextField("");
		CarID = new JTextField("");
		CustomerID = new JTextField("");
		EmployeeID = new JTextField("");
		DateOfSale = new JTextField("");
		SalePrice = new JTextField("");
			
				
		SaleID.setBounds(50,100, 200,30);  
		CarID.setBounds(50,100, 200,30);  
		CustomerID.setBounds(50,100, 200,30);  
		EmployeeID.setBounds(50,100, 200,30);  
		DateOfSale.setBounds(50,100, 200,30);  
		SalePrice.setBounds(50,100, 200,30);  
				
		JButton Submit = new JButton();
		Submit.setText("Submit");
				
		frame.add(SaleIDTxt);
		frame.add(SaleID);
		frame.add(CarIDTxt);
		frame.add(CarID);
		frame.add(CustomerIDTxt);
		frame.add(CustomerID);
		frame.add(EmployeeIDTxt);
		frame.add(EmployeeID);
		frame.add(DateOfSaleTxt);
		frame.add(DateOfSale);
		frame.add(SalePriceTxt);
		frame.add(SalePrice);
		frame.add(Submit);
				
		frame.add(panel);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
				
		Submit.addActionListener(new ActionListener(){
				
			public void actionPerformed( ActionEvent f ){
						
				String SaleIDInput =SaleID.getText();
				String CarIDInput =CarID.getText(); 
				String CustomerIDInput =CustomerID.getText(); 
				String EmployeeIDInput =EmployeeID.getText(); 
				String DateOfSaleInput =DateOfSale.getText(); 
				String SalePriceInput =SalePrice.getText(); 
						
				try{
						
					Class.forName("org.sqlite.JDBC");
					con = DriverManager.getConnection("jdbc:sqlite:/Users/cjlaptop/Desktop/UsedCars.DB");
						
					stmt = con.createStatement();
						
					//Insert the new sale and update the 'Cars' table to set the sold cars 'Forsale' value to 'No'
					stmt.executeUpdate("INSERT INTO Sales(SaleID,CarID,CustomerID,EmployeeID,DateOfSale,SalePrice) VALUES ('"+SaleIDInput+"','"+CarIDInput+"','"+CustomerIDInput+"','"+EmployeeIDInput+"','"+DateOfSaleInput+"','"+SalePriceInput+"')");	
					stmt.executeUpdate("UPDATE Cars SET Forsale = 'No' WHERE CarID = '"+CarIDInput+"'");	
					
					stmt.close();
					con.close();

				}
						
				catch ( Exception e ) {
					    	  
					System.err.println( e.getClass().getName() + ": " + e.getMessage() );
					System.exit(0);
				 
				}	
			}
		});
	}
public static void viewEmployees(String SortInput) {
		
		ArrayList<Employees> EmployeeTable = new ArrayList<Employees>();
		String column[]= {"EmployeeID","FirstName","LastName","DOB","DateOfEmployment","Wage"};
		String Query = null;
		
		//Connect to db and get table values
		try{
			
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:Users/cjlaptop/Desktop/UsedCars.db");
			
			stmt = con.createStatement();
			
			switch (SortInput) {
				
				case "All": Query = "SELECT * FROM Employees;";
				break;
			
			} 
			
			ResultSet rs = stmt.executeQuery(Query);
			
			while(rs.next()) {
				
				Employees employee = new Employees(rs.getString("EmployeeID"),rs.getString("FirstName"),rs.getString("LastName"),rs.getString("DOB"),
									rs.getString("DateOfEmployment"),rs.getString("Wage"));
				
				EmployeeTable.add(employee);
				
			}
			
			stmt.close();
			con.close();

		}
				
		catch ( Exception e ) {
			    	  
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		 
		}	
			
		JPanel panel = new JPanel();
		JFrame frame = new JFrame("ViewEmployeeDataBase");
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
		
		String[] ComboBoxPatterns = {"All"};
		JComboBox SortByForSale = new JComboBox(ComboBoxPatterns);
		
		JLabel ComboBoxTxt= new JLabel("You must look at all of the employees, you idiot");
		JButton Update = new JButton();
		Update.setText("Update");
		
		DefaultTableModel tableModel = new DefaultTableModel(column, 0);
		JTable table = new JTable(tableModel);
		
		
		for (int i = 0; i < EmployeeTable.size(); i++) {
			
			String EmployeeID = EmployeeTable.get(i).getEmployeeID();
			String FirstName = EmployeeTable.get(i).getFirstName();
			String LastName = EmployeeTable.get(i).getLastName();
			String DOB = EmployeeTable.get(i).getDOB();
			String DateOfEmployment = EmployeeTable.get(i).getDateOfEmployment();
			String Wage = EmployeeTable.get(i).getWage();
			
			
			Object[] data = { EmployeeID, FirstName, LastName, DOB, 
							  DateOfEmployment, Wage };
			
			tableModel.addRow(data);
		}
	
		frame.add(new JScrollPane(table));
		frame.add(ComboBoxTxt);
		frame.add(SortByForSale);
		frame.add(Update);
		frame.add(panel);
		frame.setSize(1000, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		Update.addActionListener(new ActionListener(){
			
			public void actionPerformed( ActionEvent e ){
				
				String ComboBoxInput = SortByForSale.getSelectedItem().toString();
				viewCars(ComboBoxInput); 
				frame.dispose();
	        }  
		});
	}

public static void viewCustomers(String SortInput) {
	
	ArrayList<Customers> CustomerTable = new ArrayList<Customers>();
	String column[]= {"CustomerID","FirstName","LastName","DOB","PhoneNumber"};
	String Query = null;
	
	//Connect to db and get table values
	try{
		
		Class.forName("org.sqlite.JDBC");
		con = DriverManager.getConnection("jdbc:sqlite:Users/cjlaptop/Desktop/UsedCars.db");
		
		stmt = con.createStatement();
		
		switch (SortInput) {
			
			case "All": Query = "SELECT * FROM Customers;";
			break;
		
		} 
		
		ResultSet rs = stmt.executeQuery(Query);
		
		while(rs.next()) {
			
			Customers customer = new Customers(rs.getString("CustomerID"),rs.getString("FirstName"),rs.getString("LastName"),rs.getString("DOB"),
								rs.getString("PhoneNumber"));
			
			CustomerTable.add(customer);
			
		}
		
		stmt.close();
		con.close();

	}
			
	catch ( Exception e ) {
		    	  
		System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		System.exit(0);
	 
	}	
		
	JPanel panel = new JPanel();
	JFrame frame = new JFrame("ViewCustomerDataBase");
	frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
	
	String[] ComboBoxPatterns = {"All"};
	JComboBox SortByForSale = new JComboBox(ComboBoxPatterns);
	
	JLabel ComboBoxTxt= new JLabel("You must look at all of the customers, you idiot");
	JButton Update = new JButton();
	Update.setText("Update");
	
	DefaultTableModel tableModel = new DefaultTableModel(column, 0);
	JTable table = new JTable(tableModel);
	
	
	for (int i = 0; i < CustomerTable.size(); i++) {
		
		String CustomerID = CustomerTable.get(i).getCustomerID();
		String FirstName = CustomerTable.get(i).getFirstName();
		String LastName = CustomerTable.get(i).getLastName();
		String DOB = CustomerTable.get(i).getDOB();
		String PhoneNumber = CustomerTable.get(i).getPhoneNumber();
		
		
		
		Object[] data = { CustomerID, FirstName, LastName, DOB, 
						  PhoneNumber};
		
		tableModel.addRow(data);
	}

	frame.add(new JScrollPane(table));
	frame.add(ComboBoxTxt);
	frame.add(SortByForSale);
	frame.add(Update);
	frame.add(panel);
	frame.setSize(1000, 400);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	
	Update.addActionListener(new ActionListener(){
		
		public void actionPerformed( ActionEvent e ){
			
			String ComboBoxInput = SortByForSale.getSelectedItem().toString();
			viewCars(ComboBoxInput); 
			frame.dispose();
        }  
	});
}
	public static void viewCars(String SortInput) {
		
		ArrayList<Cars> CarTable = new ArrayList<Cars>();
		String column[]= {"CarID", "Make" ,"Model","Year","Color","Price","Forsale"};
		String Query = null;
		
		//Connect to db and get table values
		try{
			
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:/Users/cjlaptop/Desktop/UsedCars.DB");
			
			stmt = con.createStatement();
			
			switch (SortInput) {
				
				case "All": Query = "SELECT * FROM Cars;";
				break;
			
				case "Yes": Query = "SELECT * FROM Cars where ForSale is 'Yes';"; 	
				break;
				
				case "No": 	Query = "SELECT * FROM Cars where ForSale is 'No';"; 	
				break;
			
			} 
			
			ResultSet rs = stmt.executeQuery(Query);
			
			while(rs.next()) {
				
				Cars car = new Cars(rs.getString("CarID"),rs.getString("Make"),rs.getString("Model"),rs.getInt("Year"),
									rs.getString("Color"),rs.getString("Price"),rs.getString("Forsale"));
				
				CarTable.add(car);
				
			}
			
			stmt.close();
			con.close();

		}
				
		catch ( Exception e ) {
			    	  
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		 
		}	
			
		JPanel panel = new JPanel();
		JFrame frame = new JFrame("ViewCarDataBase");
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
		
		String[] ComboBoxPatterns = {"Yes", "No", "All"};
		JComboBox SortByForSale = new JComboBox(ComboBoxPatterns);
		
		JLabel ComboBoxTxt= new JLabel("Sort by cars for sale. Select 'Yes','No' or 'All' then update.");
		JButton Update = new JButton();
		Update.setText("Update");
		
		DefaultTableModel tableModel = new DefaultTableModel(column, 0);
		JTable table = new JTable(tableModel);
		
		
		for (int i = 0; i < CarTable.size(); i++) {
			
			String CarID = CarTable.get(i).getCarID();
			String Make = CarTable.get(i).getMake();
			String Model = CarTable.get(i).getModel();
			int Year = CarTable.get(i).getYear();
			String Color = CarTable.get(i).getColor();
			String Price = CarTable.get(i).getPrice();
			String ForSale = CarTable.get(i).getForSale();
			
			Object[] data = { CarID, Make, Model, Year, 
							  Color, Price, ForSale };
			
			tableModel.addRow(data);
		}
	
		frame.add(new JScrollPane(table));
		frame.add(ComboBoxTxt);
		frame.add(SortByForSale);
		frame.add(Update);
		frame.add(panel);
		frame.setSize(1000, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		Update.addActionListener(new ActionListener(){
			
			public void actionPerformed( ActionEvent e ){
				
				String ComboBoxInput = SortByForSale.getSelectedItem().toString();
				viewCars(ComboBoxInput); 
				frame.dispose();
	        }  
		});
	}
	
	public static void viewCarsByOwner(String Owner) {
		
		ArrayList<CarsOwners> CarOwnerTable = new ArrayList<CarsOwners>();
		String column[]= {"OwnerID","FirstName","LastName","CarID", "Make" ,"Model","Year","Color","SalePrice"};
		String Query = null;
		
		Query = "Select Customers.CustomerID,"
				+ "Customers.FirstName,"
				+ "Customers.LastName,"
				+ "Cars.CarID,"
				+ "Cars.Make,"
				+ "Cars.Model,"
				+ "Cars.Year,"
				+ "Cars.Color,"
				+ "Sales.SalePrice "
				+ "from Customers "
					+ "left join Sales "
						+ "on Customers.CustomerID = Sales.CustomerID "
					+ "left join cars "
						+ "on Cars.CarID = Sales.CarID" ;
		try{
			
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:/Users/cjlaptop/Desktop/UsedCars.DB");
			
			stmt = con.createStatement();
		
			ResultSet rs = stmt.executeQuery(Query);
		
			while(rs.next()) {
			
				CarsOwners owner = new CarsOwners(rs.getString("CustomerID"),rs.getString("FirstName"),rs.getString("LastName"),
												  rs.getString("CarID"),rs.getString("Make"),rs.getString("Model"),rs.getInt("Year"),
												  rs.getString("Color"),rs.getString("SalePrice"));
				
				CarOwnerTable.add(owner);
			
			}

			stmt.close();
			con.close();

		}
			
		catch ( Exception e ) {
		    	  
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
	 
		}	
		
		JPanel panel = new JPanel();
		JFrame frame = new JFrame("ViewCarOwners");
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
		
		DefaultTableModel tableModel = new DefaultTableModel(column, 0);
		JTable table = new JTable(tableModel);
		
		for (int i = 0; i < CarOwnerTable.size(); i++) {
			
			String CustomerID = CarOwnerTable.get(i).getCustomerID();
			String FirstName = CarOwnerTable.get(i).getFirstName();
			String LastName = CarOwnerTable.get(i).getLastName();
			String CarID = CarOwnerTable.get(i).getCarID();
			String Make = CarOwnerTable.get(i).getMake();
			String Model = CarOwnerTable.get(i).getModel();
			int Year = CarOwnerTable.get(i).getYear();
			String Color = CarOwnerTable.get(i).getColor();
			String SalePrice = CarOwnerTable.get(i).getSalePrice();
			
			Object[] data = { CustomerID, FirstName, LastName, CarID, Make, Model, Year, 
							  Color, SalePrice};
			
			tableModel.addRow(data);
		}
	
		frame.add(new JScrollPane(table));
		frame.add(panel);
		frame.setSize(1000, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		         
	}
	
	public static void main(String[] args) {
		
		HomeView();
		
	}
