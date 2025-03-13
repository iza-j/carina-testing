package com.solvd.carinatesting.helpers;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class FreeMarkerEngine {

    // https://freemarker.apache.org/docs/pgui_quickstart_createconfiguration.html
    private Configuration configuration = new Configuration(Configuration.VERSION_2_3_34);

    public FreeMarkerEngine() {
        configuration.setDefaultEncoding("UTF-8");
        try {
            configuration.setDirectoryForTemplateLoading(new File("src/test/resources"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // https://freemarker.apache.org/docs/pgui_quickstart_createdatamodel.html
    public String process(String templateName, Object dataModel) {
        try {
            Template template = configuration.getTemplate(templateName);
            StringWriter stringWriter = new StringWriter();
            template.process(dataModel, stringWriter);
            return stringWriter.toString();

        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
    }

    public void processAndSave (String templateName, Object dataModel, String outputFileName) {
        try {
            String processed = process(templateName, dataModel);
            FileWriter fw = new FileWriter(outputFileName);
            fw.write(processed);
            fw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}