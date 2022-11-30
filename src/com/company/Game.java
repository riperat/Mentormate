package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    private int x;
    private int y;
    private String[] gridArray;
    private int x1;
    private int y1;
    private int N;

    public Game() {
        this.x = 0;
        this.y = 0;
        this.gridArray = new String[0];
        this.x1 = 0;
        this.y1 = 0;
        N = 0;
    }


    public void start() throws IOException {
        this.inputReader();

        Grid grid = new Grid(this.x, this.y);
        grid.create(this.gridArray);

        System.out.println(grid.calculateCellChange(this.x1, this.y1, this.N));

    }


    private int inputReader() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //splitting by Whitespace and comma
        String[] sizeOfGrid = reader.readLine().split("[\\s,]+");
        this.x = Integer.parseInt(sizeOfGrid[0]);
        this.y = Integer.parseInt(sizeOfGrid[1]);

        this.gridArray = new String[x];
        for (int i = 0; i < x; i++) {
            gridArray[i] = reader.readLine();
        }

        String[] lastArg = reader.readLine().split("[\\s,]+");
        this.x1 = Integer.parseInt(lastArg[0]);
        this.y1 = Integer.parseInt(lastArg[1]);
        this.N = Integer.parseInt(lastArg[2]);

        return 1;
    }


}
