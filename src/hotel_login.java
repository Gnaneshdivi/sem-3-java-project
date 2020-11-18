import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class hotel_login {
	int no=0;
	String[] hotelname= new String[20];
	double[] hotelid= new double[20];
	String[] menu= new String[20];
	
 void login(Scanner x) {
	 System.out.print("please enter your hotel id :  ");
	 int id=x.nextInt();
	 check(id,x);
		
		
		
		
		
	}
	void check(int id,Scanner x){
		try  
		{  
		File file = new File("/Users/divignanesh/eclipse-workspace/MID-@ project/src/Hotels.xlsx");  
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
		
	
		if (cell.getCellType()==Cell.CELL_TYPE_NUMERIC && cell.getNumericCellValue()==id)               
		{String actual=row.getCell(5).getStringCellValue();
			System.out.println(actual);
			System.out.print("PLease enter password :  "+actual);
		
			
			
			String password=x.next();
			
			if(actual.equals(password)) {
				System.out.println("Loged in succefully ");
				flag=true;}
			else{
				System.out.println("Wrong password please try again ");
				login(x);
				break;
				
				
				//if statement for the id exist
			}
				
		
		break;
		} 
		//if statement for the id exist
		} 
		if(!flag) {
			System.out.print( " Press (0) If You Want To Register Or (1) To Exit");
			if(x.nextInt()==0) {
				register(x);
				
			}
			
			
		}
		for(int i=0;i<no;i++) {
			System.out.println(hotelname[i]);
			
			
		}
		}  
		catch(Exception e)  
		{  
		  
		}  
		
		
		
	}
	void register(Scanner x) {
		try  
		{  
		File file = new File("/Users/divignanesh/eclipse-workspace/MID-@ project/src/Hotels.xlsx");  
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);   
		XSSFSheet sheet = wb.getSheetAt(0);  
		int rows=sheet.getLastRowNum();
		 InputStream inp = new FileInputStream("/Users/divignanesh/eclipse-workspace/MID-@ project/src/Hotels.xlsx");
		 System.out.println("Enter the id of your hotel");
		int id=x.nextInt();
		System.out.println("Enter the name of your hotel");
		String name=x.next();
		System.out.println("Enter the Pin Code where hotel is situated");
		String pin=x.next();
		System.out.println("Enter the Pan card number of the hotel or the owner");
		String pan=x.next();
		System.out.println("Enter the phone nmuuber of the hotel");
		String phone=x.next();
		System.out.println("Enter the Password");
		String password=x.next();
		
	
		 Row ro = sheet.createRow(100);
		 sheet.shiftRows(1, sheet.getLastRowNum()+1, 1, true,true);
		 ro.createCell(0).setCellValue(id);///hotel id saving
		    ro.createCell(1).setCellValue(name);//hotel name
		    ro.createCell(2).setCellValue(pin);//area Pin
		    ro.createCell(3).setCellValue(pan);//pan number
		    ro.createCell(4).setCellValue(phone);//phone number
		    ro.createCell(5).setCellValue(password);//password
		    Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
		    while (itr.hasNext())                 
		    {  
		    Row row = itr.next();  
		    Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
		    while (cellIterator.hasNext())   
		    {  
		    Cell cell = cellIterator.next();  
		    switch (cell.getCellType())               
		    {  
		    case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
		    System.out.print(cell.getStringCellValue() + "\t");  
		    break;  
		    case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
		    System.out.print(cell.getNumericCellValue() + "\t\t");  
		    break;  
		    default:  
		    }  
		    }  
		    System.out.println("");  
		    }  
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
