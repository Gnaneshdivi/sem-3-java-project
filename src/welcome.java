import java.util.*;
public class welcome {
static void type(Scanner x) {
	
	int choose= x.nextInt();
	if(choose==0) {
		
		System.out.println("user login ");
		uesr_login login= new uesr_login();	
		login.login(x);//method from user_login class for getting the user to register or login(phone number and )
		
	}
	
	
	else if(choose==1){
		System.out.println("Hotel managemnet login ");
		hotel_login login= new hotel_login();
		login.login(x);//method from hotel_login class for getting the user to register or login
			
	}
	else {
		System.out.println("You have Entered a wrong code please retry ");
		type(x);///recursive call for the wrong option
		
		
	}
}
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		System.out.println("Welcome to the Group-13 ");
		System.out.println("Group members are\n 1)\n 2)\n 3)");
		System.out.println("----> To login as user press (0) ");
		System.out.println("----> To login as Hotel Management press (1) ");
		type(in);
	}

 }
