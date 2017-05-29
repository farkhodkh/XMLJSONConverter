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

    private static void writeUsingBufferedWriter(String data, int noOfLines, String fileName) {
        File file = new File(fileName);
        FileWriter fr = null;
        BufferedWriter br = null;
        int bufferSize = 1;
        //String dataWithNewLine = data + System.getProperty("line.separator");
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr, bufferSize);
            br.write(data);
//             for(int i = noOfLines; i>0; i--){

//                br.write(dataWithNewLine);

//            }
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
        String JSONData = ConvertXMLtoJSON(args[0]);
        JSONData.length();
        writeUsingBufferedWriter(JSONData, 1, args[1]);
    }
}
