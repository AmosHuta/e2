package e2;
//Authors : AMOS HUTA & SILBIANA DEMA
public class Slopes {

    private static void isSquare(char[][] mat) {
        int columnLength;
        int rowLength = mat.length;
        /* Check every if every single column has the same length as the rows (Before we were checking just mat[0].length, so we were only checking the length of the first column) */
        for (char[] chars : mat) {
            columnLength = chars.length;
            if (rowLength != columnLength)
                throw new IllegalArgumentException("Matrix is not square");
        }
        }

    private static void charCheck(char[][] mat) {
        // Iterate in the matrix and check if all chars are '.' and '#', if they're not, we throw an Exceoption
        for (char[] chars : mat) {
        for (int j = 0; j < mat[0].length; j++) {
        if (chars[j] != '.' && chars[j] != '#')
        throw new IllegalArgumentException("Matrix has wrong chars!");
            }
        }
        }

    private static void rightdowncheck(char[][] mat, int right, int down) {
        // Iterate in the matrix and check if the movement in the matrix are right as we have been told in the assignement, if they're not, we we throw an Exceoption
        int columnLength = mat[0].length;
        int rowLength = mat.length;
        if (right >= columnLength || right < 1)
        throw new IllegalArgumentException("Right movement is wrong");
        if (down >= rowLength || down < 1)
        throw new IllegalArgumentException("Down movement is wrong");


    }

    public static int downTheSlope(char[][] slopeMap, int right, int down) {
        int trees = 0;
        boolean finished = false;
        int rightLimit = slopeMap[0].length;
        int lastRow = slopeMap.length - 1;
        int movRight, movDown;
        int i = 0;
        int j = 0;

        isSquare(slopeMap);
        charCheck(slopeMap);
        rightdowncheck(slopeMap, right, down);

        while(!finished){
        movRight = right;
        movDown = down;

        /* Moving right */
        while(movRight > 0){
        if(slopeMap[i][j] == '#') {
        trees++;

        }
        /* if j is greater than the rightmost limit it'll get resested */
        j++;
        j= j%rightLimit;
        movRight--;
        }

        if(i == lastRow)
        finished = true;

        /* Moving down */
        while(movDown > 0 && !finished){
        if(slopeMap[i][j] == '#') {
        trees++;
        }
        if(i != lastRow)
        i++;
        else
        finished = true;
        movDown--;
        }
        }
        return trees;
        }



    public static int jumpTheSlope(char[][] slopeMap, int right, int down) {
        int trees = 0;
        boolean finished = false;
        int rightLimit = slopeMap[0].length;
        int lastRow = slopeMap.length - 1;
        int movDown;
        int i = 0;
        int j = 0;

        isSquare(slopeMap);
        charCheck(slopeMap);
        rightdowncheck(slopeMap, right, down);

        while (!finished) {
        movDown = down;
        j = j + right;
        j = j % rightLimit;
        while (movDown > 0 && !finished) {
        if (i < lastRow)
        i++;
        /* if it reaches the final row, and there are still movements down, we set finished as true to get out of the while loop */
        else
        finished = true;
        movDown--;
        }
        /* Now, if the process is finished, we don't count the last position as the skier would be "Out of the matrix" */
        if(!finished) {
        if (slopeMap[i][j] == '#')
        trees++;
        }
        }
        return trees;
        }
        }






