Class Grid:

public void create(String[]input) - creates the board by splitting the String characters into a the char array(grid)
private boolean isGreen(int x1,int y1) - changes the cell to red or green based on the return type of checkNeighbors and the cell color
private int checkNeighbors(int c,int r) - returns the ammount of green neighbors surrounding the cell
private int changeCell(int c,int r,int greenN) - changes the cell in the temporary grid by given rules
private int cloneGrid() - clone method to clone the ready temporary grid to the initial grid
public int calculateCellChange(int x1,int y1,int N) - Returns the number of times cell x1,x2 in N generations becomes green

Class Game:

public void start()-starts the game by using inputReader()to read the inputs and creates a grid with Grid.create()
private int inputReader()-simple input method to read and parse the input
