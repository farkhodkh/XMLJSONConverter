package com.faha.converter;

import org.json.JSONObject;
import org.json.XML;

import java.io.*;

//import java.io.FileReader;

/**
 * Created by Администратор on 24.05.2017.
 */
public class XMLJSONConverter {

    public static String ConvertXMLtoJSON(String fileName) {
        String JSONData = "";
        try{
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            String xmlString = "";
            while((line = br.readLine()) != null){
                xmlString = xmlString + line;
            }
            JSONObject xmlJSONObj = XML.toJSONObject(xmlString);
            JSONData = xmlJSONObj.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return JSONData;
    }

    private static String ConvertJSONtoXML(String fileName){
        String XMLData = "";
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String jsonString = "";
            while((line = bufferedReader.readLine()) != null){
                jsonString = jsonString + line;
            }
            org.json.JSONObject jsonFileObject = new org.json.JSONObject(jsonString);
            XMLData = org.json.XML.toString(jsonFileObject);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return XMLData;
    }

    private static void writeUsingBufferedWriter(String data, String fileName) {
        File file = new File(fileName);
        FileWriter fr = null;
        BufferedWriter br = null;
        int bufferSize = 1024;
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr, bufferSize);
            br.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String val = args[0];
        if(val.equals("0")){
            String JSONData = ConvertXMLtoJSON(args[1]);
            writeUsingBufferedWriter(JSONData, args[2]);
        }else if (val.equals("1")){
            String XMLData = ConvertJSONtoXML(args[1]);
            writeUsingBufferedWriter(XMLData, args[2]);
        }else {
            System.out.println("Wrong argument 1");
        }
    }
}
