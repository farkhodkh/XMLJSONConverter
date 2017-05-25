package com.faha.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Администратор on 24.05.2017.
 */
public class XMLJSONConverter {

    public static String ConvertXMLtoJSON(String fileName) {
        String JSONData = "";
        String fileContent = "";
        try {
            FileReader reader = new FileReader(fileName);
            int c;
            while ((c = reader.read()) != -1) {
                fileContent = fileContent + (char) c;
            }
            JSONObject xmlJSONObj = XML.toJSONObject(fileContent);
            JSONData = xmlJSONObj.toString();
        } catch (JSONException je) {
            System.out.println(je.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JSONData;
    }

    public static void main(String[] args) {
        System.out.println(ConvertXMLtoJSON(args[0]));
    }
}
