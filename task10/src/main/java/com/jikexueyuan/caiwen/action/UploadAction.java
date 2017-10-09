package com.jikexueyuan.caiwen.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by caiwen on 2016/8/28.
 */
public class UploadAction extends ActionSupport {
    private File file;
    private String contentType;
    private String filename;
    private Map<String,Object> data = new HashMap<>();

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setGoodsPic(File file) {
        this.file = file;
    }

    public void setGoodsPicContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setGoodsPicFileName(String filename) {
        this.filename = filename;
    }

    public String upload() throws Exception {
        String[] splitedFileName = filename.split("\\.");
        String suffix = splitedFileName[splitedFileName.length - 1];
        File saveFile;
        if (file != null) {
            ServletContext servletContext = ServletActionContext.getServletContext();
            String saveFilePath = servletContext.getRealPath("img/goods/") + UUID.randomUUID() + "." + suffix;
            saveFile = new File(saveFilePath);
            FileUtils.copyFile(file, saveFile);
            url = "img/goods/" + saveFile.getName();
        }
        data.put("url", url);
        return SUCCESS;
    }

}
