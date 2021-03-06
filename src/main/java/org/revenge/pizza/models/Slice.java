package org.revenge.pizza.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Thomas on 28/01/2017.
 */
public class Slice
{
    public ArrayList<Cell> cells = new ArrayList<Cell>();

    public Slice(){};

    public int getNumbOfType(Cell.Type type)
    {
        int num = 0;

        for(Cell cell : cells)
        {
            if(cell.type == type)
            {
                num++;
            }
        }

        return num;
    }

    public int getNumCells(){
        return cells.size();
    }

    public int[][] getBounds(){
        Collections.sort(cells, new Comparator<Cell>() {
            @Override
            public int compare(Cell p0, Cell p1) {return p0.compareTo(p1);}
        });

        int bounds[][] = new int[2][2];
        bounds[0][0] = cells.get(0).row;
        bounds[0][1] = cells.get(0).col;
        bounds[1][0] = cells.get(cells.size()-1).row;
        bounds[1][1] = cells.get(cells.size()-1).col;

        return bounds;
    }

    @Override
    public String toString(){

        Collections.sort(cells, new Comparator<Cell>() {
            @Override
            public int compare(Cell p0, Cell p1) {
                return p0.compareTo(p1);
            }
        });

        StringBuilder s = new StringBuilder();
        s.append(cells.get(0).row);
        s.append(" ");
        s.append(cells.get(0).col);
        s.append(" ");
        s.append(cells.get(cells.size()-1).row);
        s.append(" ");
        s.append(cells.get(cells.size()-1).col);

        return s.toString();
    }
}
