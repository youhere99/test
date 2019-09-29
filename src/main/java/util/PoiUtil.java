package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.dom4j.Document;

public class PoiUtil {

    /**
     * 
     * @param title
     * @param data
     * @param fileName
     * @param response
     * @throws FileNotFoundException
     *             2018年6月5日 zhaomingxing
     */
    public static void downloadExcel(List<String> title, List<List<String>> data, String fileName,
        HttpServletResponse response) {
        XSSFWorkbook wb = createExcel(title, data);
        fileName = fileName + ".xlsx";
        response.reset();
        response.setContentType("application/octet-stream;charset=utf-8");
        try {
            response.setHeader("Content-Disposition",
                "attachment;filename=" + new String(fileName.getBytes(), "iso-8859-1"));
            wb.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void downloadXML(String fileName, Document document, HttpServletResponse response) {
        fileName = fileName + ".xml";
        response.reset();
        response.setContentType("application/octet-stream;charset=utf-8");
        try {
            response.setHeader("Content-Disposition",
                "attachment;filename=" + new String(fileName.getBytes(), "iso-8859-1"));
            document.write(response.getWriter());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @Description: TODO(读取excel信息 只能读取2007版本及之后的版本)
     */
    public static List<List<String>> readXlsx(InputStream inputStream) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);// 获取excel文件对象
        List<List<String>> lists = new ArrayList<List<String>>();
        for (int num = 0; num < workbook.getNumberOfSheets(); num++) {
            XSSFSheet hssfSheet = workbook.getSheetAt(num);// 循环excel文件对象获取excel每页对象
            if (hssfSheet == null) {
                continue;
            }
            for (int roeNum = 1; roeNum <= hssfSheet.getLastRowNum(); roeNum++) {
                XSSFRow row = hssfSheet.getRow(roeNum);// 由每页对象获取每行对象
                int minRow = row.getFirstCellNum();
                int maxRow = row.getLastCellNum();
                List<String> list = new ArrayList<String>();
                for (int cellx = minRow; cellx < maxRow; cellx++) {
                    XSSFCell cell = row.getCell(cellx);// 获取每行的单元格对象
                    if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                        continue;
                    }
                    list.add(getCellValue(cell));
                }
                if (list != null && list.size() > 0) {
                    lists.add(list);
                }
            }
        }
        return lists;
    }

    /**
     * 功能：判断excel 空行
     * <P>
     * 
     * @param row
     * @return 2017年11月20日上午10:58:53 zhaomingxing
     */
    private static boolean isBlankRow(XSSFRow row) {
        if (row == null) {
            return true;
        }
        for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
            XSSFCell hcell = row.getCell(i);
            if (!isBlankCell(hcell)) {
                return false;
            }
        }
        return true;
    }

    /**
     * / 功能：判断excel 空单元格
     * <P>
     * 
     * @param hcell
     * @return 2017年11月20日上午10:57:57 zhaomingxing
     */
    private static boolean isBlankCell(XSSFCell hcell) {
        if (hcell == null) {
            return true;
        }
        hcell.setCellType(hcell.CELL_TYPE_STRING);
        String content = hcell.getStringCellValue().trim();
        if (StringUtils.isBlank(content)) {
            return true;
        }
        return false;
    }

    /**
     * @Description: TODO(重写的XSSFUtil 方法) @param @param cell @param @return 设定文件 @return String 返回类型 @throws
     */
    private static String getCellValue(XSSFCell cell) {
        String cellValue = "";
        DecimalFormat df = new DecimalFormat("yyy-MM-dd");
        switch (cell.getCellType()) {
            case XSSFCell.CELL_TYPE_STRING:
                cellValue = cell.getRichStringCellValue().getString().trim();
                break;
            case XSSFCell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    cellValue = formatter.format(cell.getDateCellValue());
                } else {
                    cellValue = NumberToTextConverter.toText(cell.getNumericCellValue());
                }

                break;
            case XSSFCell.CELL_TYPE_BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue()).trim();
                break;
            case XSSFCell.CELL_TYPE_FORMULA:
                cellValue = cell.getCellFormula();
                break;
            default:
                cellValue = "";
        }
        return cellValue;
    }

    /**
     * @Description: TODO(重写的HSSFUtil 方法) @param @param cell @param @return 设定文件 @return String 返回类型 @throws
     */
    private static String getCellValue2(HSSFCell cell) {
        String cellValue = "";
        DecimalFormat df = new DecimalFormat("yyy-MM-dd");
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING:
                cellValue = cell.getRichStringCellValue().getString().trim();
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    cellValue = formatter.format(cell.getDateCellValue());
                } else {
                    cellValue = NumberToTextConverter.toText(cell.getNumericCellValue());
                }

                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue()).trim();
                break;
            case HSSFCell.CELL_TYPE_FORMULA:
                cellValue = cell.getCellFormula();
                break;
            default:
                cellValue = "";
        }
        return cellValue;
    }

    /**
     * 创建Excel，并写入内容
     */
    private static XSSFWorkbook createExcel(List<String> title, List<List<String>> data) {
        // 1.创建Excel工作薄对象
        XSSFWorkbook wb = new XSSFWorkbook();
        // 2.创建Excel工作表对象
        XSSFSheet sheet = wb.createSheet();
        // 3.创建Excel工作表的行
        XSSFRow row = sheet.createRow(0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        XSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        XSSFCell cell = row.createCell(0);
        for (int i = 0; i < title.size(); i++) {
            cell = row.createCell(i);
            cell.setCellValue(title.get(i));
            cell.setCellStyle(style);
        }
        if (data != null && data.size() > 0) {
            for (int j = 1; j <= data.size(); j++) {
                row = sheet.createRow(j);
                List<String> temp = data.get(j - 1);
                for (int i = 0; i < temp.size(); i++) {
                    row.createCell(i).setCellValue(temp.get(i));
                }

            }
        }
        return wb;
    }

    /**
     * @Description: TODO(读取excel信息 只能读取2007版本及之后的版本,xlsx) 包括读取表头 从0开始
     */
    public static List<List<String>> readXlsx1(InputStream inputStream) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);// 获取excel文件对象
        List<List<String>> lists = new ArrayList<List<String>>();
        for (int num = 0; num < workbook.getNumberOfSheets(); num++) {
            XSSFSheet hssfSheet = workbook.getSheetAt(num);// 循环excel文件对象获取excel每页对象
            if (hssfSheet == null) {
                continue;
            }
            for (int roeNum = 0; roeNum <= hssfSheet.getLastRowNum(); roeNum++) {
                XSSFRow row = hssfSheet.getRow(roeNum);// 由每页对象获取每行对象
                int minRow = row.getFirstCellNum();
                int maxRow = row.getLastCellNum();
                List<String> list = new ArrayList<String>();
                for (int cellx = minRow; cellx < maxRow; cellx++) {
                    XSSFCell cell = row.getCell(cellx);// 获取每行的单元格对象
                    if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                        continue;
                    }
                    list.add(getCellValue(cell));
                }
                if (list != null && list.size() > 0) {
                    lists.add(list);
                }
            }
            return lists;
        }
        return null;
    }

    /**
     * @Description: TODO(读取excel信息 只能读取2007版本及之钱的版本,xlsx) 包括读取表头 从0开始
     */
    public static List<List<String>> readXlsx2(InputStream inputStream) throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);// 获取excel文件对象
        List<List<String>> lists111 = new ArrayList<List<String>>();
        for (int num = 0; num < workbook.getNumberOfSheets(); num++) {
            HSSFSheet sheetAt = workbook.getSheetAt(num);// 循环excel文件对象获取excel每页对象
            if (sheetAt == null) {
                continue;
            }
            for (int roeNum = 0; roeNum <= sheetAt.getLastRowNum(); roeNum++) {
                HSSFRow row = sheetAt.getRow(roeNum);// 由每页对象获取每行对象
                int minRow = row.getFirstCellNum();
                int maxRow = row.getLastCellNum();
                List<String> list = new ArrayList<String>();
                for (int cellx = minRow; cellx < maxRow; cellx++) {
                    HSSFCell cell = row.getCell(cellx);// 获取每行的单元格对象
                    if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                        continue;
                    }
                    list.add(getCellValue2(cell));
                }
                if (list != null && list.size() > 0) {
                    lists111.add(list);
                }
            }
            return lists111;
        }
        return null;
    }

}
