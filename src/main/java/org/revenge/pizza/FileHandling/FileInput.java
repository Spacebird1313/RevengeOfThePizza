package org.revenge.pizza.FileHandling;

/**
 * Created by arthu on 28/01/2017.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInput {
    private BufferedReader reader;
    private String sCurrentLine;
    private int line;

    private int nRows;
    private int nCols;
    private int minIngredientsPerSlice;
    private int maxIngredientsPerSlice;

    //Pizza
    private ArrayList<ArrayList<Character>> pizza = new ArrayList<ArrayList<Character>>();

    public void parseFile(String fileName)
    {
        line = 1;

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            reader = new BufferedReader(new FileReader(classLoader.getResource(fileName).getFile()));
            sCurrentLine = reader.readLine();
            line++;
            //Read First Line
            String sCurrLineSplit[] = sCurrentLine.split(" ");

            nRows = Integer.parseInt(sCurrLineSplit[0]);
            nCols = Integer.parseInt(sCurrLineSplit[1]);
            minIngredientsPerSlice = Integer.parseInt(sCurrLineSplit[2]);
            maxIngredientsPerSlice = Integer.parseInt(sCurrLineSplit[3]);

            //add rows arraylists to pizza
            for(int i = 0; i<nRows; i++){
                pizza.add(new ArrayList<>());
            }

            parsePizza(nCols, nRows);

            System.out.println("End Parse");
        /*
        while ((sCurrentLine != null && !sCurrentLine.contains("]"))) {
            switch(sCurrentLine){
                case "OBJECTS[":{
                    System.out.println("\"OBJECTS\" detected, parsing...");
                    break;
                }
            }
            sCurrentLine = reader.readLine();
            line++;
        }
        */

        }catch(StringIndexOutOfBoundsException e){
            System.err.println("Error occured at line " + line);
        }
        catch (IOException e) {
            System.err.println("Error occured at line " + line);
        } catch (NumberFormatException e) {
            System.err.println("Number parsing error occured at line " + line);
        } finally {
            try {
                if (reader != null)reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void parsePizza(int nCols, int nRows){
        int row = 0;

        for(row = 0; row < nRows; row++){
            try {
                sCurrentLine = reader.readLine();
                line++;
                parseLine(row, nCols, sCurrentLine);
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }

    private void parseLine(int row, int length, String line){
        for(int i = 0; i < length; i++){
            pizza.get(row).add(line.charAt(i));
        }
    }
}
