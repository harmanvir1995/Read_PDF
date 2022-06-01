import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class CreateExcelFileFromCSV {

	public static void main(String[] args) throws IOException {
		//----------------------------------------------------------------//
		// Reading file from the CSV
		FileInputStream fis = new FileInputStream("accountactivity 2.csv");
		Scanner input = new Scanner(fis);
		//----------------------------------------------------------------//
		// Creating the workbook needed for the excel file.
		FileOutputStream fos = new FileOutputStream("myfile.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		//Creating the work sheet.
		XSSFSheet spreadsheet = workbook.createSheet("Company Data");
		//Creating the row object.
		XSSFRow row; 
		// Creating row id.
		int rowid = 2;
		// Creating the title row
		row = spreadsheet.createRow(0);
		Cell firstRowcell = row.createCell(0);
		firstRowcell.setCellValue("COMPANY NAMES");
		//----------------------------------------------------------------//
		// Creating all the cells needed for the first row.
		firstRowcell = row.createCell(1);
		firstRowcell.setCellValue("AMOUNT");
		
		firstRowcell = row.createCell(2);
		firstRowcell.setCellValue("SUSPENSE");
		
		firstRowcell = row.createCell(3);
		firstRowcell.setCellValue("CASH");
		
		firstRowcell = row.createCell(4);
		firstRowcell.setCellValue("CASH");
		
		firstRowcell = row.createCell(5);
		firstRowcell.setCellValue("GST");
		
		firstRowcell = row.createCell(6);
		firstRowcell.setCellValue("QST");
		
		firstRowcell = row.createCell(7);
		firstRowcell.setCellValue("A/P");
		
		firstRowcell = row.createCell(8);
		firstRowcell.setCellValue("TRUCK");
		
		firstRowcell = row.createCell(9);
		firstRowcell.setCellValue("CONTR");
		
		firstRowcell = row.createCell(10);
		firstRowcell.setCellValue("FUEL");
		
		firstRowcell = row.createCell(11);
		firstRowcell.setCellValue("REPAIR");
		
		firstRowcell = row.createCell(12);
		firstRowcell.setCellValue("INSURANCE");
		
		firstRowcell = row.createCell(13);
		firstRowcell.setCellValue("LIC");
		
		firstRowcell = row.createCell(14);
		firstRowcell.setCellValue("ACCOUNT FEE");
		
		firstRowcell = row.createCell(15);
		firstRowcell.setCellValue("MISC");
		
		firstRowcell = row.createCell(16);
		firstRowcell.setCellValue("B/C");
		
		//----------------------------------------------------------------//
		// This is just to print on the console.
		System.out.println("\n****************************************************");
		System.out.println("\tReading Data from the CSV file....");
		System.out.println("****************************************************");
		int counter = 0;
		//Reading from the CSV file.
		while(input.hasNext()){
			//Creating the row.
			row = spreadsheet.createRow(rowid);
			//Storing the value in the data array after reading from csv file.
			String[] data = input.nextLine().split(",", -1);
			//Creating the cells and storing the values in the each cell.
			if(data[2].trim() != "") {
				System.out.println("[....]\tWritting data to the file, row " + counter + " ....");
				Cell cell = row.createCell(0);
				cell.setCellValue(data[1]);
				cell = row.createCell(1);
				cell.setCellValue(data[2]);
				if(data[1].equals("SAAQ")) {
					cell = row.createCell(13);
					cell.setCellValue(data[2]);
				}
				counter++;
				rowid++;
			}	
		}
		
		// This is the just to print on the console.
		System.out.println("\n****************************************************");
		System.out.println("Data has been written to the file successfuly....!! ");
		System.out.println("****************************************************");
		input.close();
		workbook.write(fos);
		fos.close();
		workbook.close();
	}
}
