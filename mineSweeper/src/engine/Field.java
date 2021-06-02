package engine;

public class Field {
    private int rows = 0;
    private int columns = 0;
    private Cell[][] cell = null;
    private int mineCount = 0;
    private boolean over = false;

    public Field(int rows, int columns) {
        this.columns = columns;
        this.rows = rows;

        cell = new Cell[rows][columns];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                cell[r][c] = new Cell();
            }
        }

        mineCount = rows * columns * 20 / 100;
        for (int i = 0; i < mineCount; i++) {
            int r = (int) (Math.random() * rows);
            int c = (int) (Math.random() * columns);
            cell[r][c].hasMine = true;
        }

        for(int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if(cell[r][c].hasMine)
                    continue;

                cell[r][c].minesAround = nextMines(r, c);
            }
        }
    }

    public void open(int row, int column) {
        cell[row][column].state = State.OPEN;
        if(cell[row][column].hasMine) {
            over = true;
            }
    }

    public void flag(int row, int column) {
        cell[row][column].state = State.FLAGGED;
    }

    public void show(boolean open) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (open) {
                    var st = cell[r][c].state;
                    cell[r][c].state = State.OPEN;
                    System.out.print(cell[r][c].toString() + " ");
                    cell[r][c].state = st;
                }
                else {
                    System.out.print(cell[r][c].toString() + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isOver() {
        return over;
    }

    public int nextMines(int row, int col) {
        final int[][] ni = {
                {-1, -1}, {0, -1}, {1, -1},
                {-1, 0}, {1, 0},
                {-1, 1}, {0, 1}, {1, 1}
        };
        int count = 0;
        for (var rc : ni) {
            int nr = row + rc[0];
            int nc = col + rc[1];
            if (nr < 0 || nr >= rows)
                continue;
            if (nc < 0 || nc >= columns)
                continue;
            if (cell[nr][nc].hasMine)
                count++;
        }
        return count;
    }

}
