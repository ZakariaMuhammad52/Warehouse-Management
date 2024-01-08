package stepdefinitions;

import com.dhl.constants.FrameworkConstants;
import com.dhl.constants.RunManagerConstants;
import com.dhl.enums.KeyboardKeys;
import com.dhl.exception.ExceptionHandling;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.GeneralUtils;
import com.dhl.utils.RandomUtils;
import com.dhl.utils.Variables;
import com.jayway.jsonpath.internal.function.text.Concatenate;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringJoiner;

@SuppressWarnings("unused")
public class ExcelUtil {

	public FileInputStream fis;

	public static XSSFWorkbook wbExcelFile;
	private static XSSFSheet shExcelFile;
	private static String fileDirPath = GeneralUtils.getDownloadPathAsPerOS()+"\\";	
	//String strRunMode = ConfigurationUtils.getFrameworkConfig(RUNMODE);
//	private static String ImportFilePath = FrameworkConstants.getTestDataDirPath() + "ImportFiles/";	// for open shift execution
	private static String ImportFilePath =FrameworkConstants.getProjectPath() + "\\TestData\\ImportFiles\\"; // For local execution
	
	private static final By bySaveBtn = By.xpath("//ion-button[contains(text(),'SAVE')]");
	private static final By byupload = By.xpath("//*[@id='documentInputId']");
	private static final By byChooseFileBtn = By.xpath("//label[contains(text(),'Choose File')]");  //For local execution

   public static String convert_variable_to_timestamp(String strInput) {
        String strDateFormat = strInput.substring(strInput.indexOf("<")+1, strInput.indexOf(">"));
        String strPrefix = strInput.substring(0, strInput.indexOf("<"));
        return RandomUtils.generateString_WithTimeStamp(strPrefix, strDateFormat);
    }

	public static void deleteExistingFile(String strFilename) { 
		try {		
				String filePath = fileDirPath + strFilename ;
				System.out.println("Download path : "+ filePath);
				File fileManger = new File(filePath);
				if (fileManger.exists() && !fileManger.isDirectory()) {
					fileManger.delete();
					FrameworkLogger.log(LogType.INFO, strFilename + " is deleted now at location "+ fileDirPath);
					System.out.println("File present : "+ filePath);
				}			
				System.out.println("File not present : "+ filePath);
			} 
		catch (Exception e) {
			new ExceptionHandling(e);
		}	
	}

	public static void verifyFilePresent(String strFilename) { 
		try {	String filePath = fileDirPath + strFilename ;
				File fileManger = new File(filePath);
				int iWaittime =0;
				System.out.println("Verify File present : "+ filePath);
				while (!fileManger.exists() && iWaittime < 180) 
				{GeneralUtils.wait(2 * 1000); iWaittime=+2;}
				System.out.println("File present : "+ filePath);
				if (fileManger.exists() && !fileManger.isDirectory()) { FrameworkLogger.log(LogType.PASS, strFilename + " is available at location "+ fileDirPath);	} 
				else {FrameworkLogger.log(LogType.FAIL, strFilename + " is not available at location "+ fileDirPath);}			
			} 
		catch (Exception e) {
			new ExceptionHandling(e);
		}
	}
	
	public static void readCellValue(String strFilename,String strSheet,int iRow, String strColumn) { 
		try {	String filePath = fileDirPath + strFilename ;
				File fileManger = new File(filePath);
				if (fileManger.exists() && !fileManger.isDirectory()) {
					FileInputStream fisFile = new FileInputStream(fileManger);			
					wbExcelFile = new XSSFWorkbook(fisFile);	
					shExcelFile = wbExcelFile.getSheet(strSheet);											
					Cell readCell = shExcelFile.getRow(iRow).getCell(getColumnHeaderIndex(shExcelFile,strColumn));		
					FrameworkLogger.log(LogType.INFO,readCell.getStringCellValue() );					
				}			
		} 
		catch (Exception e) {
			new ExceptionHandling(e);
		}
	}
	
	public static void readCellValueFormColumn(String strFilename, String strSheet, String strColumn) {
		try {
			String filePath = fileDirPath + strFilename;
			File fileManger = new File(filePath);
			if (fileManger.exists() && !fileManger.isDirectory()) {
				FileInputStream fisFile = new FileInputStream(fileManger);
				wbExcelFile = new XSSFWorkbook(fisFile);
				shExcelFile = wbExcelFile.getSheet(strSheet);
				int iLastRow = shExcelFile.getLastRowNum();
				for (int iRow = 2; iRow <= iLastRow; iRow++) {
					Cell readCell = shExcelFile.getRow(iRow).getCell(getColumnHeaderIndex(shExcelFile, strColumn));
					FrameworkLogger.log(LogType.INFO, readCell.getStringCellValue());
				}
			}
		} catch (Exception e) {
			new ExceptionHandling(e);
		}
	}
	
	public static void writeCellValue(String strFilename,String strSheet,int iRow, String strColumn,String strValue) { 
		try {	String filePath = fileDirPath + strFilename ;					
				File fileManger = new File(filePath);
				if (fileManger.exists() && !fileManger.isDirectory()) {
					FileInputStream fisFile = new FileInputStream(fileManger);			
					wbExcelFile = new XSSFWorkbook(fisFile);	
					shExcelFile = wbExcelFile.getSheet(strSheet);										
					Cell writeCell = shExcelFile.getRow(iRow).createCell(getColumnHeaderIndex(shExcelFile,strColumn));											 
					writeCell.setCellValue(strValue);						
					FrameworkLogger.log(LogType.INFO,"Row : " + iRow + " updated for column "+strColumn+ ":"+ writeCell.getStringCellValue() + " under file at "+filePath+ " with sheet :"+ strSheet);									
					FileOutputStream outputStream = new FileOutputStream(filePath);				
					wbExcelFile.write(outputStream);
					wbExcelFile.close();
					}			
			} 
		catch (Exception e) {
			new ExceptionHandling(e);
		}
	}
	
	public static void writeCellValueToColumn(String strFilename,String strSheet, String strColumn,String strValue) { 
		try {	String filePath = fileDirPath + strFilename ;					
				File fileManger = new File(filePath);
				if (fileManger.exists() && !fileManger.isDirectory()) {
					FileInputStream fisFile = new FileInputStream(fileManger);			
					wbExcelFile = new XSSFWorkbook(fisFile);	
					shExcelFile = wbExcelFile.getSheet(strSheet);	
					int iLastRow = shExcelFile.getLastRowNum();				
					for (int iRow = 1; iRow <= iLastRow; iRow++) {					
						Cell updateCell = shExcelFile.getRow(iRow).createCell(getColumnHeaderIndex(shExcelFile,strColumn));											 
						updateCell.setCellValue(strValue);						
						FrameworkLogger.log(LogType.INFO,"Row : " + iRow + " updated for column "+strColumn+ ":"+ updateCell.getStringCellValue() + " under file at "+filePath+ " with sheet :"+ strSheet);	
					}				
					FileOutputStream outputStream = new FileOutputStream(filePath);				
					wbExcelFile.write(outputStream);
					wbExcelFile.close();
					}			
			} 
		catch (Exception e) {
			new ExceptionHandling(e);
		}
	}

	public static void emptyCellValue(String strFilename,String strSheet,int iRow, String strColumn) { 
		try {	String filePath = fileDirPath + strFilename ;					
				File fileManger = new File(filePath);
				if (fileManger.exists() && !fileManger.isDirectory()) {
					FileInputStream fisFile = new FileInputStream(fileManger);			
					wbExcelFile = new XSSFWorkbook(fisFile);	
					shExcelFile = wbExcelFile.getSheet(strSheet);				
					Cell updateCell = shExcelFile.getRow(iRow).createCell(getColumnHeaderIndex(shExcelFile,strColumn));												 
					updateCell.setCellValue("");						
					FrameworkLogger.log(LogType.INFO,"Row : " + iRow + " updated for column "+strColumn+ ":"+ updateCell.getStringCellValue() + " under file at "+filePath+ " with sheet :"+ strSheet);	
					FileOutputStream outputStream = new FileOutputStream(filePath);				
					wbExcelFile.write(outputStream);
					wbExcelFile.close();
				}			
			} 
		catch (Exception e) {
			new ExceptionHandling(e);
		}
	}
	
	public static void emptyCellValueForColumn(String strFilename,String strSheet, String strColumn) { 
		try {	String filePath = fileDirPath + strFilename ;					
				File fileManger = new File(filePath);
				if (fileManger.exists() && !fileManger.isDirectory()) {
					FileInputStream fisFile = new FileInputStream(fileManger);			
					wbExcelFile = new XSSFWorkbook(fisFile);	
					shExcelFile = wbExcelFile.getSheet(strSheet);	
					int iLastRow = shExcelFile.getLastRowNum();				
					for (int iRow = 1; iRow <= iLastRow; iRow++) {							
						Cell updateCell = shExcelFile.getRow(iRow).createCell(getColumnHeaderIndex(shExcelFile,strColumn));												 
						updateCell.setCellValue("");						
						FrameworkLogger.log(LogType.INFO,"Row : " + iRow + " updated for column "+strColumn+ ":"+ updateCell.getStringCellValue() + " under file at "+filePath+ " with sheet :"+ strSheet);	
					}				
					FileOutputStream outputStream = new FileOutputStream(filePath);				
					wbExcelFile.write(outputStream);
					wbExcelFile.close();
				}			
			} 
		catch (Exception e) {
			new ExceptionHandling(e);
		}
	}
	
	public static void deleteRowDataFromSheet(String strFilename,String strSheet,int iRow) {
		try {	String filePath = fileDirPath + strFilename ;
			File fileManger = new File(filePath);
			if (fileManger.exists() && !fileManger.isDirectory()) {
				FileInputStream fisFile = new FileInputStream(fileManger);
				wbExcelFile = new XSSFWorkbook(fisFile);
				shExcelFile = wbExcelFile.getSheet(strSheet);	
				//add code check particular row exist in the sheet
				shExcelFile.removeRow( shExcelFile.getRow(iRow));
				FrameworkLogger.log(LogType.INFO,"Row : " + iRow +"deleted "+ " under file at "+filePath+ " with sheet :"+ strSheet);
				FileOutputStream outputStream = new FileOutputStream(filePath);
				wbExcelFile.write(outputStream);
				wbExcelFile.close();
			}
		}
		catch (Exception e) {
			new ExceptionHandling(e);
		}
	}

	/**
	 * Press keyboard keys with Robot class
	 * 
	 * @param  - Key to be pressed on keyboard
	 */
	public static void sendTextWithRobot(String strValue) {
		char strChar;
		int iStringLength = strValue.length();
		for (int ichar = 0; ichar < iStringLength; ichar++) {
			strChar = strValue.charAt(ichar);
		
		try {
			Robot robot = new Robot();
			switch (String.valueOf(strChar).toUpperCase()) {
			case "A":
				robot.keyPress(KeyEvent.VK_A);
				break;
			case "B":
				robot.keyPress(KeyEvent.VK_B);
				break;
			case "C":
				robot.keyPress(KeyEvent.VK_C);
				break;
			case "D":
				robot.keyPress(KeyEvent.VK_D);
				break;
			case "E":
				robot.keyPress(KeyEvent.VK_E);
				break;
			case "F":
				robot.keyPress(KeyEvent.VK_F);
				break;
			case "G":
				robot.keyPress(KeyEvent.VK_G);
				break;
			case "H":
				robot.keyPress(KeyEvent.VK_H);
				break;
			case "I":
				robot.keyPress(KeyEvent.VK_I);
				break;
			case "J":
				robot.keyPress(KeyEvent.VK_J);
				break;
			case "K":
				robot.keyPress(KeyEvent.VK_K);
				break;
			case "L":
				robot.keyPress(KeyEvent.VK_L);
				break;
			case "M":
				robot.keyPress(KeyEvent.VK_M);
				break;
			case "N":
				robot.keyPress(KeyEvent.VK_N);
				break;
			case "O":
				robot.keyPress(KeyEvent.VK_O);
				break;
			case "P":
				robot.keyPress(KeyEvent.VK_P);
				break;
			case "Q":
				robot.keyPress(KeyEvent.VK_Q);
				break;
			case "R":
				robot.keyPress(KeyEvent.VK_R);
				break;
			case "S":
				robot.keyPress(KeyEvent.VK_S);
				break;
			case "T":
				robot.keyPress(KeyEvent.VK_T);
				break;
			case "U":
				robot.keyPress(KeyEvent.VK_U);
				break;
			case "V":
				robot.keyPress(KeyEvent.VK_V);
				break;
			case "W":
				robot.keyPress(KeyEvent.VK_W);
				break;
			case "X":
				robot.keyPress(KeyEvent.VK_X);
				break;
			case "Y":
				robot.keyPress(KeyEvent.VK_Y);
				break;
			case "Z":
				robot.keyPress(KeyEvent.VK_Z);
				break;		
			case "1":
				robot.keyPress(KeyEvent.VK_1);
				break;
			case "2":
				robot.keyPress(KeyEvent.VK_2);
				break;
			case "3":
				robot.keyPress(KeyEvent.VK_3);
				break;
			case "4":
				robot.keyPress(KeyEvent.VK_4);
				break;
			case "5":
				robot.keyPress(KeyEvent.VK_5);
				break;
			case "6":
				robot.keyPress(KeyEvent.VK_6);
				break;
			case "7":
				robot.keyPress(KeyEvent.VK_7);
				break;
			case "8":
				robot.keyPress(KeyEvent.VK_8);
				break;
			case "9":
				robot.keyPress(KeyEvent.VK_9);
				break;
			case "0":
				robot.keyPress(KeyEvent.VK_0);
				break;
			case ":":
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_SEMICOLON);
				robot.keyRelease(KeyEvent.VK_SEMICOLON);
				robot.keyRelease(KeyEvent.VK_SHIFT);				
				break;
			case "\\":
				robot.keyPress(KeyEvent.VK_BACK_SLASH);
				break;
			case "/":
				robot.keyPress(KeyEvent.VK_SLASH);
				break;	
			case ".":
				robot.keyPress(KeyEvent.VK_PERIOD);
				break;			
	
			default:
				throw new IllegalArgumentException("pressKeyboardKeyWithRobot(): Key: '" + strChar + "' NOT supported");
			}
			
		
		} catch (Exception e) {
			FrameworkLogger.log(LogType.FAIL, "Keyboard key press action failed due to: " + e.getMessage());
		}
		}
		FrameworkLogger.log(LogType.INFO, "Keyboard even for string \"" + strValue + "\" is pressed");
		

	}
		
	/**
	 * Gets Column number matching column name 
	 * @param shtExcel   - Sheet object of excel
	 * @param strColName - Column name
	 * @return - Integer value of column index
	 */
	private static int getColumnHeaderIndex(XSSFSheet shtExcel, String strColName) {
		int iLastColumn = shtExcel.getRow(0).getLastCellNum();
		for (int iCol = 1; iCol < iLastColumn; iCol++) {
			String strShtColName = shtExcel.getRow(0).getCell(iCol).getStringCellValue();
			if (strColName.equalsIgnoreCase(strShtColName)) {
				return iCol;
			}
		}
		System.out.println("Column name \"" + strColName + "\" doest not match with the excel columns");
		FrameworkLogger.log(LogType.FAIL, "Column name \"" + strColName + "\" doest not match with the excel columns");
		return 0;
	}
	
	public static List<String> getSpecificColumnValues(String strFilePath, String strSheetName, String strColName) {
		XSSFWorkbook wbExcel = null;
		List<String> listOfLPNsAtExcel = new ArrayList<String>();
		try {
			File fileExcel = new File(strFilePath);
			FileInputStream fisExcel = new FileInputStream(fileExcel);
			wbExcel = new XSSFWorkbook(fisExcel);
			XSSFSheet shtExcel = wbExcel.getSheet(strSheetName);
			int iLPNColNumber = getColumnHeaderIndex(shtExcel, strColName);
			int iLastRow = shtExcel.getLastRowNum();
			for (int iRow = 1; iRow <= iLastRow; iRow++) {
				listOfLPNsAtExcel.add(shtExcel.getRow(iRow).getCell(iLPNColNumber).getStringCellValue().trim());			}
		} catch (Exception ex) {
			new ExceptionHandling(ex);
		}
		return listOfLPNsAtExcel;
	}

}