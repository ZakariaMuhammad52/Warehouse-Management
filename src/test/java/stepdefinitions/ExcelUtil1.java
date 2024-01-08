package stepdefinitions;

import com.dhl.constants.FrameworkConstants;
import com.dhl.constants.RunManagerConstants;
import com.dhl.driver.DriverManager;
import com.dhl.enums.KeyboardKeys;
import com.dhl.exception.ExceptionHandling;
import com.dhl.reports.FrameworkLogger;
import com.dhl.reports.LogType;
import com.dhl.utils.ConfigurationUtils;
import com.dhl.utils.CurrentThreadInstance;
import com.dhl.utils.GeneralUtils;
import com.dhl.utils.RandomUtils;
import com.dhl.utils.Variables;
import com.dhl.web.utils.KeyboardActions;
import com.dhl.web.utils.SeleniumActions;
import com.jayway.jsonpath.internal.function.text.Concatenate;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringJoiner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import static com.dhl.enums.ConfigKeys.RUNMODE;

@SuppressWarnings("unused")
public class ExcelUtil1 {

	public FileInputStream fis;
	public static XSSFWorkbook wbExcelFile;
	private static XSSFSheet shExcelFile;
	private static XSSFRow row;
	private static XSSFCell cell;
	private static String downloadDirPath = GeneralUtils.getDownloadPathAsPerOS()+"\\";		
	private static final By bySaveBtn = By.xpath("//ion-button[contains(text(),'SAVE')]");
	private static final By byupload = By.xpath("//*[@id='documentInputId']");
	//String strRunMode = ConfigurationUtils.getFrameworkConfig(RUNMODE);
	private static String ImportFilePath = FrameworkConstants.getTestDataDirPath() + "ImportFiles/";	// for open shift execution
//	private static String ImportFilePath =FrameworkConstants.getProjectPath() + "\\TestData\\ImportFiles\\"; // For local execution
	private static final By byChooseFileBtn = By.xpath("//label[contains(text(),'Choose File')]");  //For local execution
	
   public static String convert_variable_to_timestamp(String strInput) {
        String strDateFormat = strInput.substring(strInput.indexOf("<")+1, strInput.indexOf(">"));
        String strPrefix = strInput.substring(0, strInput.indexOf("<"));
        return RandomUtils.generateString_WithTimeStamp(strPrefix, strDateFormat);
    }

	public static void deleteExistingFile(String strFilename) { 
		try {		
				String filePath = downloadDirPath + strFilename ;
				System.out.println("Download path : "+ filePath);
				File fileManger = new File(filePath);
				if (fileManger.exists() && !fileManger.isDirectory()) {
					fileManger.delete();//.deleteOnExit();
					FrameworkLogger.log(LogType.INFO, strFilename + " is deleted now at location "+ downloadDirPath);
					System.out.println("File present : "+ filePath);
				}			
				System.out.println("File not present : "+ filePath);
			} 
		catch (Exception e) {
			new ExceptionHandling(e);
		}
	}

	public static void verifyFilePresent(String strFilename) {
		try {
			String filePath = ImportFilePath + strFilename;
			File fileManger = new File(filePath);
			int iWaittime = 0;
			System.out.println("Verify File present : " + filePath);
			while (!fileManger.exists() && iWaittime < 180) {
				GeneralUtils.wait(2 * 1000);
				iWaittime = +2;
			}
			System.out.println("File present : " + filePath);
			if (fileManger.exists() && !fileManger.isDirectory()) {
				FrameworkLogger.log(LogType.PASS, strFilename + " is available at location " + ImportFilePath);
			} else {
				FrameworkLogger.log(LogType.FAIL, strFilename + " is not available at location " + ImportFilePath);
			}
		} catch (Exception e) {
			new ExceptionHandling(e);
		}
	}

	public static void verifyFilePresentfromuserdir(String strFilename) {
		try {
			String filePath = ImportFilePath + strFilename;
			//String demo = FrameworkConstants.getProjectPath() + "\\TestData\\ImportFiles\\";
			//String filePath = demo + strFilename;
			File fileManger = new File(filePath);
			int iWaittime = 0;
			System.out.println("Verify File present : " + filePath);
			while (!fileManger.exists() && iWaittime < 180) {
				GeneralUtils.wait(2 * 1000);
				iWaittime = +2;
			}
			System.out.println("File present : " + filePath);
			if (fileManger.exists() && !fileManger.isDirectory()) {
				FrameworkLogger.log(LogType.PASS, strFilename + " is available at location ");
			} else {
				FrameworkLogger.log(LogType.FAIL, strFilename + " is not available at location " + ImportFilePath);
			}
		} catch (Exception e) {
			new ExceptionHandling(e);
		}
	}

	public static void readCellValueForColumn(String strFilename, String strSheet, String strColumn) {
		try {
			String filePath = ImportFilePath + strFilename;
			File fileManger = new File(filePath);
			if (fileManger.exists() && !fileManger.isDirectory()) {
				FileInputStream fisFile = new FileInputStream(fileManger);
				wbExcelFile = new XSSFWorkbook(fisFile);
				shExcelFile = wbExcelFile.getSheet(strSheet);
				int iLastRow = shExcelFile.getLastRowNum();
				for (int iRow = 2; iRow <= iLastRow; iRow++) {
					Cell updateCell = shExcelFile.getRow(iRow).getCell(getColumnHeaderIndex(shExcelFile, strColumn));
					FrameworkLogger.log(LogType.INFO, updateCell.getStringCellValue());
				}
			}
		} catch (Exception e) {
			new ExceptionHandling(e);
		}
	}

	public static String readCellValueForColumnfromdir( String strFilename, String strSheet, String strColumn, int iRow)
	{
		try
		{
			String filePath = ImportFilePath + strFilename;
			File fileManger = new File(filePath);
			if (fileManger.exists() && !fileManger.isDirectory())
			{
				FileInputStream fisFile = new FileInputStream(fileManger);
				wbExcelFile = new XSSFWorkbook(fisFile);
				shExcelFile = wbExcelFile.getSheet(strSheet);
				int iLastRow = shExcelFile.getLastRowNum();
				//for (int iRow = 2; iRow <= iLastRow; iRow++) {
				//FrameworkLogger.log(LogType.INFO, updateCell.getStringCellValue());
				//}
			}
		} catch (Exception e)
		{
			new ExceptionHandling(e);
		}
		Cell updateCell = shExcelFile.getRow(iRow).getCell(getColumnHeaderIndex(shExcelFile, strColumn));
		return updateCell.getStringCellValue();
		//FrameworkLogger.log(LogType.INFO, updateCell.getStringCellValue());
	}

	public static void writeCellValueForColumn(String strFilename,String strSheet, String strColumn,String strOrderValue) { 
		try {	String filePath = ImportFilePath + strFilename ;					
				File fileManger = new File(filePath);
				if (fileManger.exists() && !fileManger.isDirectory()) {
					FileInputStream fisFile = new FileInputStream(fileManger);			
					wbExcelFile = new XSSFWorkbook(fisFile);	
					shExcelFile = wbExcelFile.getSheet(strSheet);	
					int iLastRow = shExcelFile.getLastRowNum();				
					for (int iRow = 1; iRow <= iLastRow; iRow++) {	
						String strAppend =Integer.toString(iRow);
						int ilength = Integer.toString(iRow).length();
						for (int iCount = 1; iCount <= ilength; iCount++) {	strAppend = "0" + strAppend	;}
						String strFinalOrderValue = String.join("", strOrderValue,strAppend);
						Cell updateCell = shExcelFile.getRow(iRow).createCell(getColumnHeaderIndex(shExcelFile,strColumn));
						updateCell.setCellValue(strFinalOrderValue);
						if (strColumn.equalsIgnoreCase("OriginalOrderId")) { Variables.set(CurrentThreadInstance.getCurrentScenarioId()+"OriginalOrder", strFinalOrderValue);}
						else if (strColumn.equalsIgnoreCase("ASNId")) { Variables.set(CurrentThreadInstance.getCurrentScenarioId()+"ASN", strFinalOrderValue);}
						else if (strColumn.equalsIgnoreCase("BatchNumberId")) { Variables.set(CurrentThreadInstance.getCurrentScenarioId()+"BatchNumber", strFinalOrderValue);}
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

	public static void writeCellValueForColumn1(String strFilename,String strSheet, String strColumn,String strValue) {
		try {	String filePath = ImportFilePath  + strFilename ; //downloadDirPath
				System.out.println(filePath);
				FrameworkLogger.log(LogType.INFO,""+filePath);
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
				public static void writeCellValueForColumnfromdir(String strFilename,String strSheet, String strColumn,String strOrderValue) {
					try {	String filePath = ImportFilePath + strFilename ;
						File fileManger = new File(filePath);
						if (fileManger.exists() && !fileManger.isDirectory()) {
							FileInputStream fisFile = new FileInputStream(fileManger);
							wbExcelFile = new XSSFWorkbook(fisFile);
							shExcelFile = wbExcelFile.getSheet(strSheet);
							int iLastRow = shExcelFile.getLastRowNum();
							for (int iRow = 1; iRow <= iLastRow; iRow++) {
								String strAppend =Integer.toString(iRow);
								int ilength = Integer.toString(iRow).length();
								for (int iCount = 1; iCount <= ilength; iCount++) {	strAppend = "0" + strAppend	;}
								String strFinalOrderValue = String.join("", strOrderValue,strAppend);
								Cell updateCell = shExcelFile.getRow(iRow).createCell(getColumnHeaderIndex(shExcelFile,strColumn));
								updateCell.setCellValue(strFinalOrderValue);
								if (strColumn.equalsIgnoreCase("OriginalOrderId")) { Variables.set(CurrentThreadInstance.getCurrentScenarioId()+"OriginalOrder", strFinalOrderValue);}
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

	/**
	 * Function to write data into cells without changing/appendig actual data
	 */
	public static void writeCellValueForColumnwoAppend1(String strFilename,String strSheet, String strColumn,String strOrderValue) {
		try {	String filePath = ImportFilePath + strFilename ;
			File fileManger = new File(filePath);
			if (fileManger.exists() && !fileManger.isDirectory()) {
				FileInputStream fisFile = new FileInputStream(fileManger);
				wbExcelFile = new XSSFWorkbook(fisFile);
				shExcelFile = wbExcelFile.getSheet(strSheet);
				int iLastRow = shExcelFile.getLastRowNum();
				for (int iRow = 1; iRow <= iLastRow; iRow++) {
					//String strAppend =Integer.toString(iRow);
					String strAppend =Integer.toString(iRow);

					int ilength = Integer.toString(iRow).length();
					for (int iCount = 1; iCount <= ilength; iCount++) {	strAppend = "0" + strAppend	;}
					String strFinalOrderValue = String.join("", strOrderValue,strAppend);
					Cell updateCell = shExcelFile.getRow(iRow).createCell(getColumnHeaderIndex(shExcelFile,strColumn));
					updateCell.setCellValue(strFinalOrderValue);
					if (strColumn.equalsIgnoreCase("OriginalOrderId")) { Variables.set(CurrentThreadInstance.getCurrentScenarioId()+"OriginalOrder", strFinalOrderValue);}
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
	
	/**
	 * Function to write data into cells without changing/appendig actual data
	 */
	public static void writeCellValueForColumnwoAppend(String strFilename,String strSheet, String strColumn,String strOrderValue) {
		try {	String filePath = ImportFilePath + strFilename ;
			File fileManger = new File(filePath);
			if (fileManger.exists() && !fileManger.isDirectory()) {
				FileInputStream fisFile = new FileInputStream(fileManger);
				wbExcelFile = new XSSFWorkbook(fisFile);
				shExcelFile = wbExcelFile.getSheet(strSheet);
				int iLastRow = shExcelFile.getLastRowNum();
				for (int iRow = 1; iRow <= iLastRow; iRow++) {
					//String strAppend =Integer.toString(iRow);
					int ilength = Integer.toString(iRow).length();
					//for (int iCount = 1; iCount <= ilength; iCount++) {	strAppend = "0" + strAppend	;}
					//String strFinalOrderValue = String.join("", strOrderValue,strAppend);
					String strFinalOrderValue = String.join("", strOrderValue);

					Cell updateCell = shExcelFile.getRow(iRow).createCell(getColumnHeaderIndex(shExcelFile,strColumn));
					updateCell.setCellValue(strFinalOrderValue);
					if (strColumn.equalsIgnoreCase("OriginalOrderId")) { Variables.set(CurrentThreadInstance.getCurrentScenarioId()+"OriginalOrder", strFinalOrderValue);}
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
	
	public static void writeCellValueForColumntoparticularrow(String strFilename,String strSheet, String strColumn,String strOrderValue, int iRow) {
		try {	String filePath = ImportFilePath + strFilename ;
			File fileManger = new File(filePath);
			if (fileManger.exists() && !fileManger.isDirectory()) {
				FileInputStream fisFile = new FileInputStream(fileManger);
				wbExcelFile = new XSSFWorkbook(fisFile);
				shExcelFile = wbExcelFile.getSheet(strSheet);
				int iLastRow = shExcelFile.getLastRowNum();
				//for (int iRow = 1; iRow <= iLastRow; iRow++) {
					//String strAppend =Integer.toString(iRow);
					int ilength = Integer.toString(iRow).length();
					//for (int iCount = 1; iCount <= ilength; iCount++) {	strAppend = "0" + strAppend	;}
					//String strFinalOrderValue = String.join("", strOrderValue,strAppend);
				String strFinalOrderValue = String.join("", strOrderValue);

				Cell updateCell = shExcelFile.getRow(iRow).createCell(getColumnHeaderIndex(shExcelFile,strColumn));
				updateCell.setCellValue(strFinalOrderValue);
				if (strColumn.equalsIgnoreCase("OriginalOrderId")) { Variables.set(CurrentThreadInstance.getCurrentScenarioId()+"OriginalOrder", strFinalOrderValue);}
					FrameworkLogger.log(LogType.INFO,"Row : " + iRow + " updated for column "+strColumn+ ":"+ updateCell.getStringCellValue() + " under file at "+filePath+ " with sheet :"+ strSheet);
				//}
				FileOutputStream outputStream = new FileOutputStream(filePath);
				wbExcelFile.write(outputStream);
				wbExcelFile.close();
			}
		}
		catch (Exception e) {
			new ExceptionHandling(e);
		}
	}


	public static void writeCellValueForColumnboolean(String strFilename,String strSheet, String strColumn,String strOrderValue) {
		try {	String filePath = ImportFilePath + strFilename ;
			File fileManger = new File(filePath);
			if (fileManger.exists() && !fileManger.isDirectory()) {
				FileInputStream fisFile = new FileInputStream(fileManger);
				wbExcelFile = new XSSFWorkbook(fisFile);
				shExcelFile = wbExcelFile.getSheet(strSheet);
				int iLastRow = shExcelFile.getLastRowNum();
				for (int iRow = 1; iRow <= iLastRow; iRow++) {
					//String strAppend =Integer.toString(iRow);
					int ilength = Integer.toString(iRow).length();
					//for (int iCount = 1; iCount <= ilength; iCount++) {	strAppend = "0" + strAppend	;}
					//String strFinalOrderValue = String.join("", strOrderValue,strAppend);
					String strFinalOrderValue = String.join("", strOrderValue);
					 Boolean bool = Boolean.valueOf(strFinalOrderValue);
					Cell updateCell = shExcelFile.getRow(iRow).createCell(getColumnHeaderIndex(shExcelFile,strColumn));
					updateCell.setCellValue(bool);
				/*	if (strColumn.equalsIgnoreCase("OriginalOrderId")) { Variables.set(CurrentThreadInstance.getCurrentScenarioId()+"OriginalOrder", strFinalOrderValue);}
					FrameworkLogger.log(LogType.INFO,"Row : " + iRow + " updated for column "+strColumn+ ":"+ updateCell.getStringCellValue() + " under file at "+filePath+ " with sheet :"+ strSheet);
				*/}
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
		try {	String filePath = ImportFilePath + strFilename ;					
				File fileManger = new File(filePath);
				if (fileManger.exists() && !fileManger.isDirectory()) {
					FileInputStream fisFile = new FileInputStream(fileManger);			
					wbExcelFile = new XSSFWorkbook(fisFile);	
					shExcelFile = wbExcelFile.getSheet(strSheet);	
					int iLastRow = shExcelFile.getLastRowNum();				
					for (int iRow = 1; iRow <= iLastRow; iRow++) {	
						String strAppend =Integer.toString(iRow);
						int ilength = Integer.toString(iRow).length();
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
	/**
	 * Function to Delete existing record from sheet.
	 */
	public static void deleteRowsfromSheet(String strFilename,String strSheet) {
		try {	String filePath = ImportFilePath + strFilename ;
			File fileManger = new File(filePath);
			if (fileManger.exists() && !fileManger.isDirectory()) {
				FileInputStream fisFile = new FileInputStream(fileManger);
				wbExcelFile = new XSSFWorkbook(fisFile);
				shExcelFile = wbExcelFile.getSheet(strSheet);
				int iLastRow = shExcelFile.getLastRowNum();
				for (int iRow = 1; iRow <= iLastRow; iRow++) {
					shExcelFile.removeRow( shExcelFile.getRow(iRow));

					FrameworkLogger.log(LogType.INFO,"Row : " + iRow +"deleted all existingz "+ " under file at "+filePath+ " with sheet :"+ strSheet);
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
			case "_":
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_MINUS);
				robot.keyRelease(KeyEvent.VK_MINUS);
				robot.keyRelease(KeyEvent.VK_SHIFT);
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
	 * 
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
			File fileExcel = new File(ImportFilePath + strFilePath);
			FileInputStream fisExcel = new FileInputStream(new File(ImportFilePath + strFilePath));
			wbExcel = new XSSFWorkbook(fisExcel);
			XSSFSheet shtExcel = wbExcel.getSheet(strSheetName);
			int iLPNColNumber = getColumnHeaderIndex(shtExcel, strColName);
			int iLastRow = shtExcel.getLastRowNum();
			for (int iRow = 1; iRow <= iLastRow; iRow++) {
				listOfLPNsAtExcel.add(shtExcel.getRow(iRow).getCell(iLPNColNumber).getStringCellValue().trim());		}
			wbExcel.close();
			fisExcel.close();
		} catch (Exception ex) {
			new ExceptionHandling(ex);
		}
		return listOfLPNsAtExcel;
	}

	/**
	 * Function to write data into cells without changing/appendig actual data
	 */
	/*public static void writeCellValueForColumnwoAppend(String strfilePath,String strFilename,String strSheet, String strColumn,String strOrderValue) {
		try {	String filePath = strfilePath + strFilename ;
			File fileManger = new File(filePath);
			if (fileManger.exists() && !fileManger.isDirectory()) {
				FileInputStream fisFile = new FileInputStream(fileManger);
				wbExcelFile = new XSSFWorkbook(fisFile);
				shExcelFile = wbExcelFile.getSheet(strSheet);
				int iLastRow = shExcelFile.getLastRowNum();
				for (int iRow = 1; iRow <= iLastRow; iRow++) {
					//String strAppend =Integer.toString(iRow);
					int ilength = Integer.toString(iRow).length();
					//for (int iCount = 1; iCount <= ilength; iCount++) {	strAppend = "0" + strAppend	;}
					//String strFinalOrderValue = String.join("", strOrderValue,strAppend);
					String strFinalOrderValue = String.join("", strOrderValue);

					Cell updateCell = shExcelFile.getRow(iRow).createCell(getColumnHeaderIndex(shExcelFile,strColumn));
					updateCell.setCellValue(strFinalOrderValue);
					if (strColumn.equalsIgnoreCase("OriginalOrderId")) { Variables.set(CurrentThreadInstance.getCurrentScenarioId()+"OriginalOrder", strFinalOrderValue);}
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
	}*/
	
/*	public static void verifyFilePresentfromuserdir(String strFilename) {
		try {
			String demo = System.getProperty("user.dir") + "\\TestData\\Web_excelfiles\\";
			String filePath = demo + strFilename;
			File fileManger = new File(filePath);
			int iWaittime = 0;
			System.out.println("Verify File present : " + filePath);
			while (!fileManger.exists() && iWaittime < 180) {
				GeneralUtils.wait(2 * 1000);
				iWaittime = +2;
			}
			System.out.println("File present : " + filePath);
			if (fileManger.exists() && !fileManger.isDirectory()) {
				FrameworkLogger.log(LogType.PASS, strFilename + " is available at location ");
			} else {
				FrameworkLogger.log(LogType.FAIL, strFilename + " is not available at location " + downloadDirPath);
			}
		} catch (Exception e) {
			new ExceptionHandling(e);
		}
	}*/
	
	/**
	 * Function to Delete existing recorde from sheet.
	 */
/*	public static void deleteRowsfromSheet(String strfilePath,String strFilename,String strSheet) {
		try {	String filePath = strfilePath + strFilename ;
			File fileManger = new File(filePath);
			if (fileManger.exists() && !fileManger.isDirectory()) {
				FileInputStream fisFile = new FileInputStream(fileManger);
				wbExcelFile = new XSSFWorkbook(fisFile);
				shExcelFile = wbExcelFile.getSheet(strSheet);
				int iLastRow = shExcelFile.getLastRowNum();
				for (int iRow = 1; iRow <= iLastRow; iRow++) {
					shExcelFile.removeRow( shExcelFile.getRow(iRow));

					FrameworkLogger.log(LogType.INFO,"Row : " + iRow +"deleted all existingz "+ " under file at "+filePath+ " with sheet :"+ strSheet);
				}
				FileOutputStream outputStream = new FileOutputStream(filePath);
				wbExcelFile.write(outputStream);
				wbExcelFile.close();
			}
		}
		catch (Exception e) {
			new ExceptionHandling(e);
		}
	}*/
	
	  /**
		 * Function to select file to import 
		 * 
		 */
	    public static void selectFiletoImport(String importFileName) {
	        String FilePath = ImportFilePath+importFileName;
			WebElement upload = DriverManager.getDriver().findElement(byupload);
			((RemoteWebElement)upload).setFileDetector(new LocalFileDetector());
			upload.sendKeys(FilePath);
			SeleniumActions.click(bySaveBtn, "click Save button");	
		  }
	    
		/**
		 * Function to select file to import
		 * 
		 */

		public static void selectFiletoImport1(String importFileName) {				
			 String FilePath = ImportFilePath+importFileName;
			 GeneralUtils.wait(5 * 1000);    	  
	         WebElement upload = DriverManager.getDriver().findElement(byupload);
	         upload.sendKeys(FilePath);
	         SeleniumActions.click(bySaveBtn, "click Save button");
		}
	/**
	 * Function to select file to import from Import files path w/o robot button
	 *
	 */

	public static void selectFiletoImportfromtestdatadir(String fileName) {

		GeneralUtils.wait(5 * 1000);

		WebElement upload = DriverManager.getDriver().findElement(By.id("documentInputId"));
		upload.sendKeys(ImportFilePath+fileName);

		SeleniumActions.click(bySaveBtn, "click Save button");

	}


	public static void setCellData(String filePath, String sheetName, int rowNumber, int columnNumber, String value) throws IOException {
		try {
			File f = new File(ImportFilePath + filePath);
			if (f.exists()) {
				try {
					FileInputStream fisFile = new FileInputStream(new File(ImportFilePath + filePath));
					wbExcelFile = new XSSFWorkbook(fisFile);
					int index = wbExcelFile.getSheetIndex(sheetName);
					if(index<=0){
						FrameworkLogger.log(LogType.FAIL, sheetName+" Sheet Not exists in File : " + filePath);
					}
					shExcelFile = wbExcelFile.getSheet(sheetName);
					row = shExcelFile.getRow(rowNumber - 1);
					cell = row.createCell(columnNumber - 1);
					cell.setCellValue(value);
					FrameworkLogger.log(LogType.INFO, "Set cell data. FilePath : " + filePath + ", sheet : " + sheetName + ", Row : " + rowNumber + ", Column : " + columnNumber + ", value : " + value);
					FileOutputStream outputStream = new FileOutputStream(ImportFilePath + filePath);
					wbExcelFile.write(outputStream);
					wbExcelFile.close();
					outputStream.flush();
					outputStream.close();
				} catch (Exception e) {
					wbExcelFile.close();
					FrameworkLogger.log(LogType.FAIL, "Got error while setting setting cell data. FilePath : " + filePath + ", sheet : " + sheetName + ", Row : " + rowNumber + ", Column : " + columnNumber + ", value : " + value);
					new ExceptionHandling(e);
				}
			}else{
				FrameworkLogger.log(LogType.FAIL, "File Not exists. FilePath : " + filePath);
			}
		} catch (Exception e) {
			new ExceptionHandling(e);
		}
	}

	public static void setMultipleCellData(String filePath, ArrayList<String> data) throws Exception {
		try {
			String sheetName=null ;
			String rowNumber=null ;
			String columnNumber=null;
			String value=null ;
			File f = new File(ImportFilePath + filePath);
			if (f.exists()) {
				try {
					FileInputStream fisFile = new FileInputStream(new File(ImportFilePath + filePath));
					wbExcelFile = new XSSFWorkbook(fisFile);
					for (String record: data ) {
						sheetName = record.split("::")[0];
						rowNumber = record.split("::")[1];
						columnNumber = record.split("::")[2];
						value = record.split("::")[3];
						int index = wbExcelFile.getSheetIndex(sheetName);
						if (index <= 0) {
							FrameworkLogger.log(LogType.FAIL, sheetName + " Sheet Not exists in File : " + filePath);
						}
						shExcelFile = wbExcelFile.getSheet(sheetName);
						row = shExcelFile.getRow(Integer.parseInt(rowNumber) - 1);
						cell = row.createCell(Integer.parseInt(columnNumber) - 1);
						cell.setCellValue(value);
						FrameworkLogger.log(LogType.INFO, "Set cell data. FilePath : " + filePath + ", sheet : " + sheetName + ", Row : " + rowNumber + ", Column : " + columnNumber + ", value : " + value);
					}
					FileOutputStream outputStream = new FileOutputStream(ImportFilePath + filePath);
					wbExcelFile.write(outputStream);
					wbExcelFile.close();
					outputStream.flush();
					outputStream.close();
				} catch (Exception e) {
					wbExcelFile.close();
					FrameworkLogger.log(LogType.FAIL, "Got error while setting setting cell data. FilePath : " + filePath + ", sheet : " + sheetName + ", Row : " + rowNumber + ", Column : " + columnNumber + ", value : " + value);
					new ExceptionHandling(e);
				}
			}else{
				FrameworkLogger.log(LogType.FAIL, "File Not exists. FilePath : " + filePath);
			}
		} catch (Exception e) {
			new ExceptionHandling(e);
		}
	}
}