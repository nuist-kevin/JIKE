import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import org.dbunit.database.AmbiguousTableNameException;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.DefaultDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.util.fileloader.XlsDataFileLoader;
import org.unitils.core.UnitilsException;
import org.unitils.dbunit.util.MultiSchemaDataSet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * Created by caiwen on 2016/8/6.
 */
public class MultiSchemaXlsDataSetReader {
    private String defaultSchemaName;

    public MultiSchemaXlsDataSetReader(String defaultSchemaName) {
        this.defaultSchemaName = defaultSchemaName;
    }
    // Excel数据集读取器
    public MultiSchemaDataSet readDataSetXls(File... dataSetFiles) {
        try {
            Map<String, List<ITable>> tableMap = getTables(dataSetFiles);
            MultiSchemaDataSet dataSets = new MultiSchemaDataSet();
            for (Map.Entry<String, List<ITable>> entry : tableMap.entrySet()) {
                List<ITable> tables = entry.getValue();
                try {
                    DefaultDataSet ds = new DefaultDataSet(tables
                            .toArray(new ITable[] {}));
                    dataSets.setDataSetForSchema(entry.getKey(), ds);
                } catch (AmbiguousTableNameException e) {
                    throw new UnitilsException("构造DataSet失败!",  e);
                }
            }
            return dataSets;
        } catch (Exception e) {
            throw new UnitilsException("解析EXCEL文件出错：", e);
        }
    }

    public Map<String, List<ITable>> getTables(File... dataSetFiles) throws IOException, DataSetException {
        Map<String, List<ITable>> tableMap = new HashMap<>();
        //每个excel文件形成一个XlsDataSet
        for (int i = 0; i < dataSetFiles.length; i++) {
            FileInputStream fileInputStream = new FileInputStream(dataSetFiles[0]);
            HSSFWorkbook workBook = new HSSFWorkbook(fileInputStream);
            XlsDataSet xlsDataSet = new XlsDataSet(fileInputStream);
            List<ITable> tables = new ArrayList<>();
            for (int j = 0; j < workBook.getNumberOfSheets(); j++) {
                ITable xlsTable = xlsDataSet.getTable(workBook.getSheetName(j));
                tables.add(xlsTable);
            }
            tableMap.put(defaultSchemaName, tables);
        }
        return tableMap;
    }

}
