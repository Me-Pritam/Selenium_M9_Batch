package dataproviderpackage;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;

public class DataStorage
{
    @DataProvider(name = "DummyData")
    public Object[][] getData()
    {
        Object[][] arr = new Object[3][2];

        arr[0][0] = "Java";
        arr[0][1] = "Selenium";

        arr[1][0] = "Python";
        arr[1][1] = "MCP";

        arr[2][0] = "TypeScript";
        arr[2][1] = "PlayWright";

        return arr;
    }

    @DataProvider(name = "ExcelDataProvider")
    public Object[][] getExcelData()
    {
        Object[][] arr;

        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestData_folder/SwagLabsProductDetails.xlsx");

            Workbook workbook = WorkbookFactory.create(fis);

            Sheet sheet  = workbook.getSheet("ProductPrices");

            int firstRow = sheet.getFirstRowNum();
            int lastRow = sheet.getLastRowNum();

            int firstCell = sheet.getRow(firstRow).getFirstCellNum();
            int lastCell = sheet.getRow(firstRow).getLastCellNum();


            arr = new Object[lastRow-firstRow][lastCell-firstCell];

            int rowNum =0;

            for(int r=firstRow+1;r<=lastRow;r++)
            {
                int cellNum =0;
                Row newRow = sheet.getRow(r);

                for(int c=firstCell;c<lastCell;c++)
                {
                    arr[rowNum][cellNum] = newRow.getCell(c).toString();

                    cellNum++;
                }
                rowNum++;
            }

            return arr;


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;

    }
}
