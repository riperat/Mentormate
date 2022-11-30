package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Grid {

    private int x, y;
    private char[][] grid;
    private char[][] temp;

    public Grid(int x, int y) {
        this.x = x;
        this.y = y;
        this.grid = new char[x][y];
        //temporary grid to store all changes
        this.temp = new char[this.x][this.y];
    }


    public void create(String[] input) {

        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                this.grid[i][j] = input[i].charAt(j);
            }
        }
    }

    private boolean isGreen(int x1, int y1) {
        if (grid[x1][y1] == '1') {
            return true;
        }
        return false;
    }

    private int checkNeighbors(int c, int r) {

        int count = 0;
        //All top neighbors starting from top left to top right
        if (c > 0 && r > 0 && this.grid[c - 1][r - 1] == '1')
            count++;
        if (c > 0 && this.grid[c - 1][r] == '1')
            count++;
        if (c > 0 && r < this.y - 1 && this.grid[c - 1][r + 1] == '1')
            count++;

        //All bottom neighbors starting from bottom left to bottom right
        if (c < this.x - 1 && r > 0 && this.grid[c + 1][r - 1] == '1')
            count++;
        if (c < this.x - 1 && this.grid[c + 1][r] == '1')
            count++;
        if (c < this.x - 1 && r < this.y - 1 && this.grid[c + 1][r + 1] == '1')
            count++;

        //left and right neighbors
        if (r > 0 && this.grid[c][r - 1] == '1')
            count++;
        if (r < this.y - 1 && this.grid[c][r + 1] == '1')
            count++;

        return count;
    }

    private int changeCell(int c, int r, int greenN) {

        //checks green cell
        if (grid[c][r] == '1') {
            if (greenN != 0 && greenN % 3 == 0 || greenN == 2) {
                temp[c][r] = '1';
            } else {
                temp[c][r] = '0';
            }
        //checks red cell
        } else {
            if (greenN != 0 && greenN % 3 == 0) {
                temp[c][r] = '1';
            } else {
                temp[c][r] = '0';
            }
        }

        return 1;
    }

    private int cloneGrid() {

        for (int i = 0; i < this.x; i++) {
            System.arraycopy(this.temp[i], 0, this.grid[i], 0, this.temp[i].length);
        }

        return 1;
    }


    public int calculateCellChange(int x1, int y1, int N) {
        int count = 0;
        int cnt = 0;

        while (N >= 0) {
            N--;

           //counts how many times the cell turns green
            if (this.isGreen(y1, x1)) {
                count++;
            }

            // Loops through all cells and changes cell type
            for (int i = 0; i < this.x; i++) {
                for (int j = 0; j < this.y; j++) {

                    int greenCount = checkNeighbors(i, j);

                    //adds the change to the temporary grid
                    this.changeCell(i, j, greenCount);

                }
            }
            //Merges the grid with the temporary grid
            cloneGrid();

        }

        return count;
    }
}
