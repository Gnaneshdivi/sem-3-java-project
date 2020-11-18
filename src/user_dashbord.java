import java.util.Scanner;

public class user_dashbord {

	public static void main(String[] args) {


	}
	int hotellist(double[] id,String[] name ,Scanner x){
		int i;
		System.out.println("Here Are The Hotels And Their Names \n PLease Enter The Hotel ID To Look Into The Menu");
		for(int j=0;j<id.length;j++) {
			if(id[j]==0.0) {
				break;}
			
			System.out.println(id[j] +"\t"+ name[j]);
			
		}
		i=x.nextInt();
		return i;
		
		

		
	}
	void checkmenu(double[] id,String[] name ,String[] menu, Scanner x,double hotel) {
	
		for(int j=0;j<id.length;j++) {
			if(id[j]==hotel) {
				System.out.println(menu[j]);
				break;
				
			}
			
			
			
		}
		
		
	}

}

