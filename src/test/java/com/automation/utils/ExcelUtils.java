package com.automation.utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelUtils {

    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public ExcelUtils(String fileName, String sheetName){
        try {
            workbook = new XSSFWorkbook("src/test/resources/excel/" + fileName);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getTotalNumOfRow(){
        return sheet.getLastRowNum();
    }

    public int getTotalNumOfCol(){
        return sheet.getRow(0).getLastCellNum();
    }

    public List<List<String>> getData(){
        List<List<String>> tableData = new ArrayList<>();

        for(int i = 1;i<getTotalNumOfRow();i++){
            XSSFRow row = sheet.getRow(i);
            List<String> rowData = new ArrayList<>();
            for(int j=0;j<getTotalNumOfCol();j++){
                rowData.add(row.getCell(j).getStringCellValue());
            }
            tableData.add(rowData);
        }

        return tableData;
    }

//    public static void main(String[] args) throws IOException {
//        XSSFWorkbook workbook = new XSSFWorkbook("src/test/resources/excel/credentials.xlsx");
//        XSSFSheet sheet = workbook.getSheet("ValidData");
//
//        for(int i = 0; i<sheet.getLastRowNum(); i++){
//            XSSFRow row = sheet.getRow(i);
//            for(int j = 0; j<row.getLastCellNum(); j++){
//                System.out.print(row.getCell(j).getStringCellValue()+" ");
//            }
//            System.out.println();
//        }
//        workbook.close();
//
//        List<List<String>> box = new ArrayList<>();
//
//        List<String> packet1 = Arrays.asList("bis1","bis2","bis3","bis4","bis5");
//        List<String> packet2 = Arrays.asList("bis1","bis2","bis3","bis4","bis5");
//        List<String> packet3 = Arrays.asList("bis1","bis2","bis3","bis4","bis5");
//        List<String> packet4 = Arrays.asList("bis1","bis2","bis3","bis4","bis5");
//        List<String> packet5 = Arrays.asList("bis1","bis2","bis3","bis4","bis5");
//
//        box.add(packet1);
//        box.add(packet2);
//        box.add(packet3);
//        box.add(packet4);
//        box.add(packet5);
//
//        for(List<String> packet : box){
//            for(String bis : packet){
//                System.out.print(bis + " ");
//            }
//            System.out.println();
//        }
//    }

}
