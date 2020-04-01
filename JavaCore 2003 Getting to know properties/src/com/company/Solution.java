package com.company;

/*

2003 Getting to know properties
In the fillInPropertiesMap method, read the file name from the console and fill in the properties map with the data from the file.
Read about .properties here - http://en.wikipedia.org/wiki/.properties
Implement the logic of writing to a file and reading from a file for the properties map.

Requirements:
1. The fillInPropertiesMap method should read data from the console.
2. The fillInPropertiesMap method should create a FileInputStream, passing the read string as a parameter.
3. The fillInPropertiesMap method should call the load method passing the newly created FileInputStream as a parameter.
4. The save method must save the properties map into an OutputStream-type object received as a parameter.
5. The load method must restore the status of the properties map from an object of type InputStream received as a parameter.


*/


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;



public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties prop = new Properties();
    public static String filName;

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));
        filName = conReader.readLine();
        conReader.close();

        FileInputStream fileInputStream = new FileInputStream (Solution.filName);
        load(fileInputStream);
        fileInputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        prop.clear();
        for (Map.Entry<String, String> pair : properties.entrySet()) {
            prop.put (pair.getKey(), pair.getValue());
        }

        prop.store(outputStream,"");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        prop.load(inputStream);
        for (Map.Entry<Object, Object> pair: prop.entrySet()) {
            properties.put((String) pair.getKey(), (String) pair.getValue());
        }
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.fillInPropertiesMap ();

        FileOutputStream fileOutputStream = new FileOutputStream(Solution.filName);
        solution.save(fileOutputStream);
        fileOutputStream.close();
    }
}
