class Position {
    final int col; // 0–7  (a–h)
    final int row; // 0–7  (1–8)

    public Position(int col, int row) {
    if (col < 0 || col > 7 || row < 0 || row > 7) {
        System.out.println("Invalid position: col=" + col + " row=" + row);
        col = 0;
        row = 0;
    }
    this.col = col;
    this.row = row;
}

    public int colDiff(Position b) { return Math.abs(b.col - col); }
    public int rowDiff(Position b) { return Math.abs(b.row - row); }

    @Override
    public String toString() {
        return "" + (char)('a' + col) + (row + 1);
    }
}

abstract class Piece {
    protected Position position;
    protected boolean isWhite;

    public Piece(Position position, boolean isWhite) {
        this.position = position;
        this.isWhite = isWhite;
    }

    public Position getPosition()           { return position; }
    public void setPosition(Position p)     { position = p; }
    public boolean isWhite()                { return isWhite; }

    public abstract boolean isLegalMove(Position b);

    public boolean tryMove(Position b) {
        if (isLegalMove(b)) {
            System.out.println(getClass().getSimpleName() + " moves " + position + " -> " + b);
            position = b;
            return true;
        }
        System.out.println(getClass().getSimpleName() + " CANNOT move " + position + " -> " + b);
        return false;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" + (isWhite ? "W" : "B") + ", " + position + "]";
    }
}

class Rook extends Piece { /*moves in straight lines only in 4 direction*/
    public Rook(Position position, boolean isWhite) { super(position, isWhite); }

    @Override
    public boolean isLegalMove(Position b) {
        if (position.col == b.col && position.row == b.row) return false;
        return position.col == b.col || position.row == b.row;
    }
}

class Bishop extends Piece { /*moves diagonally only in 4 directions*/
    public Bishop(Position position, boolean isWhite) { super(position, isWhite); }

    @Override
    public boolean isLegalMove(Position b) {
        if (position.col == b.col && position.row == b.row) return false;
        return position.colDiff(b) == position.rowDiff(b);
    }
}

class Queen extends Piece { /*combine rook and bishop */
    public Queen(Position position, boolean isWhite) { super(position, isWhite); }

    @Override
    public boolean isLegalMove(Position b) {
        if (position.col == b.col && position.row == b.row) return false;
        return position.col == b.col
            || position.row == b.row
            || position.colDiff(b) == position.rowDiff(b);
    }
}

class King extends Piece { /*like queen, but can do only one step */
    public King(Position position, boolean isWhite) { super(position, isWhite); }

    @Override
    public boolean isLegalMove(Position b) {
        if (position.col == b.col && position.row == b.row) return false;
        return position.colDiff(b) <= 1 && position.rowDiff(b) <= 1;
    }
}

class Knight extends Piece { /*move l shape  2+1*/
    public Knight(Position position, boolean isWhite) { super(position, isWhite); }

    @Override
    public boolean isLegalMove(Position b) {
        int dc = position.colDiff(b), dr = position.rowDiff(b);
        return (dc == 1 && dr == 2) || (dc == 2 && dr == 1);
    }
}

class Pawn extends Piece { /*only one step, white moves up while back moves down */
    private boolean hasMoved;

    public Pawn(Position position, boolean isWhite) {
        super(position, isWhite);
        this.hasMoved = false;
    }

    @Override
    public boolean isLegalMove(Position b) {
        int direction = isWhite ? 1 : -1;
        int rowStep   = b.row - position.row;
        int colDiff   = position.colDiff(b);

        if (colDiff == 0) {
            if (rowStep == direction) return true;
            if (!hasMoved && rowStep == 2 * direction) return true;
        }
        return false;
    }

    @Override
    public boolean tryMove(Position b) {
        boolean moved = super.tryMove(b);
        if (moved) hasMoved = true;
        return moved;
    }

    public boolean isCapture(Position b) {
        int direction = isWhite ? 1 : -1;
        return position.colDiff(b) == 1 && (b.row - position.row) == direction;
    }
}

public class MainChess {
    public static void main(String[] args) {
        System.out.println("Rook");
        Rook rook = new Rook(new Position(0, 0), true);
        rook.tryMove(new Position(0, 7));  // valid  — same column
        rook.tryMove(new Position(3, 3));  // invalid — diagonal
        rook.tryMove(new Position(7, 7));  // valid  — same row (now at a8)

        System.out.println("\nBishop");
        Bishop bishop = new Bishop(new Position(2, 0), true);
        bishop.tryMove(new Position(5, 3));  // valid  — diagonal
        bishop.tryMove(new Position(5, 4));  // invalid — not diagonal
        bishop.tryMove(new Position(2, 6));  // invalid — straight

        System.out.println("\nQueen");
        Queen queen = new Queen(new Position(3, 0), true);
        queen.tryMove(new Position(3, 7));  // valid  — vertical
        queen.tryMove(new Position(7, 7));  // valid  — horizontal
        queen.tryMove(new Position(4, 5));  // invalid — arbitrary
        queen.tryMove(new Position(3, 4));  // valid  — diagonal from h8

        System.out.println("\nKing");
        King king = new King(new Position(4, 0), true);
        king.tryMove(new Position(4, 1));  // valid  — one step forward
        king.tryMove(new Position(4, 3));  // invalid — two steps
        king.tryMove(new Position(5, 2));  // valid  — diagonal

        System.out.println("\nKnight");
        Knight knight = new Knight(new Position(1, 0), true);
        knight.tryMove(new Position(2, 2));  // valid  — L-shape
        knight.tryMove(new Position(4, 1));  // invalid
        knight.tryMove(new Position(1, 4));  // invalid
        knight.tryMove(new Position(3, 3));  // valid  — L-shape

        System.out.println("\nPawn");
        Pawn pawn = new Pawn(new Position(4, 1), true);
        pawn.tryMove(new Position(4, 3));  // valid  — two steps on first move
        pawn.tryMove(new Position(4, 5));  // invalid — two steps after first move
        pawn.tryMove(new Position(4, 4));  // valid  — one step
        pawn.tryMove(new Position(4, 3));  // invalid — backward
        System.out.println("  Capture e5->f6? " + pawn.isCapture(new Position(5, 5)));  // true
        System.out.println("  Capture e5->d4? " + pawn.isCapture(new Position(3, 3)));  // false (backward)

        System.out.println("\nBlack Pawn");
        Pawn blackPawn = new Pawn(new Position(3, 6), false);
        blackPawn.tryMove(new Position(3, 4));  // valid  — two steps
        blackPawn.tryMove(new Position(3, 3));  // valid  — one step
        blackPawn.tryMove(new Position(3, 4));  // invalid — backward (up for black)
    }
}