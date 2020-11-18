import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class uesr_login {
	String[] hotelname= new String[20];
	double[] hotelid= new double[20];
	String[] menu= new String[20];
	
	
	 void login(Scanner x) {
		 System.out.print("please enter your phone number :  ");
		 String id=x.next();
		 getlist();
		 check(id,x);
			
		
			
			
			
			
		}
	 @SuppressWarnings("deprecation")
	void getlist() {
		 int no=0;
		 
		 try  
			{  
			File file = new File("/Users/divignanesh/eclipse-workspace/MID-@ project/src/Hotels.xlsx");  
			FileInputStream fis = new FileInputStream(file);
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
			Iterator<Row> itr = sheet.iterator(); //iterating over excel file  
			while (itr.hasNext())                 
			{  
			Row row = itr.next();  
			Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
			  
			Cell cell = cellIterator.next();
			if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC) {
			if (row.getCell(1).getCellType()==Cell.CELL_TYPE_STRING)               
		    {  
		      
		    hotelname[no]= row.getCell(1).getStringCellValue();
			hotelid[no]=  cell.getNumericCellValue();
			menu[no]= row.getCell(6).getStringCellValue();
			no+=1;}
			else{
		     
		    
		    hotelname[no]= String.valueOf(row.getCell(1).getNumericCellValue()); 
			hotelid[no]=  cell.getNumericCellValue();
			menu[no]= row.getCell(6).getStringCellValue();
			no+=1;
		     
		    
		    } 
			}
			

		
			
		
			
			
			}
			}  
			catch(Exception e)  
			{  
			  
			}
		


	 }
	 
	 
	 
	 
		void check(String id,Scanner x){
			try  
			{  
			File file = new File("/Users/divignanesh/eclipse-workspace/MID-@ project/src/users.xlsx");  
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
			Iterator<Row> itr = sheet.iterator(); //iterating over excel file  
			boolean flag=false;
			while (itr.hasNext())                 
			{  
			Row row = itr.next();  
			Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
			  
			Cell cell = cellIterator.next(); 
		
		String val=cell.getStringCellValue();
		user_dashbord dd=new user_dashbord();
		
			
		
			if (cell.getCellType()==Cell.CELL_TYPE_STRING && val.equals(id))               
			{
			
				System.out.print("PLease enter password :  ");
			String password=x.next();
				String actual=row.getCell(5).getStringCellValue();
				String name=row.getCell(2).getStringCellValue();
				
				if(actual.equals(password)) {
					System.out.println("Loged in succefully \n welcome " + name);
					
					double h=dd.hotellist(hotelid, hotelname, x);
					dd.checkmenu(hotelid,hotelname,menu,x,h);}
				else{
					System.out.println("Wrong password please try again ");
					login(x);
					break;
					
					
					//if statement for the id exist
				}
					
			flag=true;
			break;
			} 
			
			} 
			if(!flag) {
				System.out.print( " Press (0) If You Want To Register Or (1) To Exit");
				if(x.nextInt()==0) {
					register(x);
					
				}
				
				
				
			}
			
			
			}  
			catch(Exception e)  
			{  
			  
			}  
			
			
			
		}
		void register(Scanner x) {
			try  
			{  
			File file = new File("/Users/divignanesh/eclipse-workspace/MID-@ project/src/users.xlsx");  
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			XSSFSheet sheet = wb.getSheetAt(0);  
			int rows=sheet.getLastRowNum();
			 InputStream inp = new FileInputStream("/Users/divignanesh/eclipse-workspace/MID-@ project/src/Hotels.xlsx");
			 System.out.println("Enter your phone number");
			String id=x.next();
			System.out.println("Enter the DOB in (dd-mm-yy) format");
			String dob=x.next();
			System.out.println("Enter the name");
			String name=x.next();
			System.out.println("Enter the area pincode");
			String pin=x.next();
			System.out.println("Enter your occupation");
			String occupation=x.next();
			System.out.println("Enter the Password");
			String password=x.next();
			
		
			 Row ro = sheet.createRow(100);
			 sheet.shiftRows(1, sheet.getLastRowNum()+1, 1, true,true);
			 ro.createCell(0).setCellValue(id);///hotel id saving
			    ro.createCell(1).setCellValue(dob);//hotel name
			    ro.createCell(2).setCellValue(name);//area Pin
			    ro.createCell(3).setCellValue(pin);//pan number
			    ro.createCell(4).setCellValue(occupation);//phone number
			    ro.createCell(5).setCellValue(password);//password
			    FileOutputStream fileOut = new FileOutputStream(file);
			    wb.write(fileOut);
			    fileOut.close();
			    login(x);

			    



	 


			
			}  
			catch(Exception e)  
			{  
			  
			} 
		
			
			
			
		}
		

}
