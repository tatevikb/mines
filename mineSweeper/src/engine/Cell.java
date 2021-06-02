package engine;

public class Cell {

    public State state = State.CLOSED;
    public boolean hasMine = false;
    public int minesAround = 0;

    @Override
    public String toString() {

        if(state == State.CLOSED) {
            return "?";
        }

        if(state == State.FLAGGED) {
            return "P";
        }

        if(state == State.OPEN) {
            if(hasMine) {
                return "*";
            }
            else {
                return minesAround == 0 ? "." : String.valueOf(minesAround);
            }
        }
        return "";
    }
}
