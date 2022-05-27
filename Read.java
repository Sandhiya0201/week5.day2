package week5.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Read {
	@Test
	public static String[][] read(String excelFileName) throws IOException {
		
		XSSFWorkbook book= new XSSFWorkbook("./testData/tc001.xlsx");
		XSSFSheet sheet=book.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		System.out.println("Row Count:" + rowCount);
		XSSFRow headerRow =sheet.getRow(0);
		short colCount=headerRow.getLastCellNum();
		System.out.println("Column Count" +colCount);
		String[][] data = new String[rowCount][colCount];
		for(int i=1; i<=rowCount; i++) {
			XSSFRow eachRow=sheet.getRow(i);
			for(int j=0; j<colCount; j++) {
				XSSFCell eachCell=eachRow.getCell(j);
				String value = eachCell.getStringCellValue();
				data[i-1][j]=value;
			}
			System.out.println();
			}
			return data;
		}

}
