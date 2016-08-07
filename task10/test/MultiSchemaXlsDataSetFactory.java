import org.unitils.core.UnitilsException;
import org.unitils.dbunit.datasetfactory.DataSetFactory;
import org.unitils.dbunit.util.MultiSchemaDataSet;

import java.io.File;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created by caiwen on 2016/8/6.
 */
public class MultiSchemaXlsDataSetFactory implements DataSetFactory {
    protected String defaultSchemaName;

    //① 初始化数据集工厂
    public void init(Properties configuration, String defaultSchemaName) {
        this.defaultSchemaName = defaultSchemaName;
    }

//    //② 从Excel文件创建数据集
    public MultiSchemaDataSet createDataSet(File... dataSetFiles) {
        try {
            MultiSchemaXlsDataSetReader xlsDataSetReader =
                    new MultiSchemaXlsDataSetReader(defaultSchemaName);
            return xlsDataSetReader.readDataSetXls(dataSetFiles);
        } catch (Exception e) {
            throw new UnitilsException("创建数据集失败: "
                    + Arrays.toString(dataSetFiles), e);
        }
    }

    //③  获取数据集文件的扩展名
    public String getDataSetFileExtension() {
        return "xls";
    }
}
