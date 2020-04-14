import java.util.*;
import java.io.*;
import java.io.IOException;

abstract class One
{
	abstract void options();
}
class Hotel extends One
{	
	int option;
	Scanner sc = new Scanner(System.in);
	
	void options()
	{
		System.out.println("******** HOTEL MANAGEMENT SYSTEM ********");
		System.out.println();
		System.out.println(" ****** WELCOME TO HOTEL TAVANSHIM *****");
		System.out.println();
		System.out.println("             OPTIONS PROVIDED");
		System.out.println("      *****   1. BOOK A ROOM   ****");
		System.out.println("      **   2. CUSTOMER DETAILS   **");
		System.out.println("      ***   3. FOOD CUISINES    ***");
		System.out.println("      **      4. CHECK OUT       **");
	}
	
	void select() throws IOException
	{
		System.out.println("PLEASE SELECT AN OPTION FROM THE ONES PROVIDED");
		option = sc.nextInt();
	
		switch(option)
		{
			case 1:
				BookRoom b = new BookRoom();
				b.book();
				break;
			case 2:
				System.out.println("DETAILS OF THE CUSTOMER ARE AS FOLLOWS:");
				Read r = new Read();
				r.read_file();
				break;
			case 3:
				Food f = new Food();
				f.fooditems();
			case 4:
				System.out.println("THANK YOU FOR VISITING US!!!");
				System.out.println("WE HOPE TO SEE YOU SOON");
				break;
			default:
				 System.out.println("MAKE A CORRECT SELECTION");
				 break;
		}
		
		System.out.println("DO YOU WANT TO SELECT ANY OTHER OPTION? y/n");
		String choose = sc.next();
		
		if(choose.equals("y") || choose.equals("Y"))
		{
			options();
			select();
		}
		else if(choose.equals("n") || choose.equals("N"))
		{
			System.exit(0);
		}
	}
}
class BookRoom
{
	Scanner sc = new Scanner(System.in);
	static int roomno = 200;
	String name,mobile;
	void book() throws IOException
	{
		File f1 = new File("file1.txt");
		f1.createNewFile();
		PrintWriter obj = new PrintWriter(f1);
		
		System.out.println("WELCOME TO ROOM BOOKING");
		System.out.println("PLEASE ENTER YOUR NAME");
		name = sc.nextLine();
		System.out.println("PLEASE ENTER YOUR MOBILE NUMBER");
		mobile = sc.nextLine();
		
		System.out.println("PLEASE CHOOSE THE TYPE OF ROOM YOU WISH TO STAY IN");
		View v = new View();
		v.viewprices();
		
		System.out.println("THANK YOU FOR JOINING WITH US, YOUR ROOM NUMBER WILL BE GENERATED SHORTLY");
		System.out.println(".....");
		System.out.println(".....");
		roomno++;
		System.out.println("ROOM NUMBER: "+roomno);
		
		obj.println(name);
		obj.println(mobile);
		obj.close();
		obj.flush();
	}	
}
class View
{ 
	private static  String [][] roomtype = {
			{"Single Bed Room", "1500"},
			{"Double Bed Room" , "2500"},
			{"Queen-Sized Bed Room", "4000"},
			{"King-Sized Bed Room","5000"},
			{"Twin Bed Room","3500"}
		     };
			 
		int room,days;
		int total=0;
		Scanner sc = new Scanner(System.in);
	void viewprices() 
	{ 		
		System.out.println("1. Single Bed Room -> Rs.1500 per day");
		System.out.println("2. Double Bed Room -> Rs.2500");
		System.out.println("3. Queen-Sized Bed Room -> Rs.4000");
		System.out.println("4. King-Sized Bed Room -> Rs.5000");
		System.out.println("5. Twin Bed Room -> Rs.3500");
		
		room = sc.nextInt();
		System.out.println("PLEASE ENTER THE NUMBER OF DAYS YOU WANT TO STAY");
		days = sc.nextInt();
		
		System.out.println("YOU HAVE SELECTED "+roomtype[room-1][0]);
		int p=Integer.parseInt(roomtype[room-1][1]);
		
		total=days*p;
		System.out.println("YOUR TOTAL BILL FOR THE ROOM IS: "+total);
	}	
}
class Read
{
	void read_file() throws IOException
	{
		String line;
		FileReader fileReader = new FileReader("file1.txt");    
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null)
            {
                System.out.println(line);
            }
	}
}
interface FoodView
{
	public void fooditems();
}
class Food implements FoodView
{	 
	Scanner sc = new Scanner(System.in);
	int cuisine;
	public void fooditems()
	{
		System.out.println("****** THE FOOD CAN BE ORDERED FROM THE RESTAURANT ON THE SECOND FLOOR ******");
		System.out.println();
		System.out.println("THE FOOD OPTIONS AVAILABLE WITH US ARE SHOWN BELOW");
		System.out.println("PLEASE CHOOSE THE TYPE OF CUISINE FIRST");
		System.out.println("1. INDIAN");
		System.out.println("2. ITALIAN");
		System.out.println("3. CHINESE");
		System.out.println("4. MEDITERRANEAN");
		cuisine = sc.nextInt();
		
		if(cuisine==1)
		{
			System.out.println("We offer the following dishes under this category");
			System.out.println("1. Daal Makhni => Rs.180 per plate");
			System.out.println("2. Shahi Paneer => Rs.250 per plate");
			System.out.println("3. Butter Naan => Rs.20 per piece");
			System.out.println("4. Dhokla => Rs.80 per plate");
			System.out.println("5. Vada Pav => Rs.40 per piece");
			System.out.println("6. Curry Chicken => Rs.300 per plate");
		}
		else if(cuisine==2)
		{
			System.out.println("We offer the following dishes under this category");
			System.out.println("1. Pizza => Rs.270");
			System.out.println("2. Bottarga => Rs.210");
			System.out.println("3. Lasagne => Rs.140");
			System.out.println("4. Risotto => Rs.334");
			System.out.println("5. Polenta => Rs.440");
		}
		else if(cuisine==3)
		{
			System.out.println("We offer the following dishes under this category");
			System.out.println("1. Chowmein => Rs.120");
			System.out.println("2. Steamed Vermicelli Rolls => Rs.140");
			System.out.println("3. Peking Roasted Duck => Rs.390");
			System.out.println("4. Sichuan Pork => Rs.402");
			System.out.println("5. Dumplings => Rs.200");
		}
		else if(cuisine==4)
		{
			System.out.println("We offer the following dishes under this category");
			System.out.println("1. Chicken => Rs.403");
			System.out.println("2. Fish => Rs.280");
			System.out.println("3. Legumes => Rs.230");
			System.out.println("4. Fresh Fruits => Rs.100");
		}
		else
		{
			System.out.println("Please enter a valid option!!!");
		}
	}
}
class Management extends Hotel
{
	public static void main(String []args) throws IOException
	{
		try
		{
			One obj = new Hotel();
			obj.options();
			Management obj1 = new Management();
			obj1.select();
		}
		catch (Exception e)
		{
			System.out.println("Our system caught an exception!!!");
			System.out.println("Please come back after sometime");
		}
	}
}
