import processing.core.PApplet;
import java.util.ArrayList;

public class Game2048 extends PApplet {

    int[][] board;
    int gridSize = 4;
    int tileSize = 100;
    int padding = 10;
    boolean hasMoved;
    boolean gameOver;

    @Override
    public void setup() {
        size(500, 500);
        board = new int[gridSize][gridSize];
        addRandomTile();
        addRandomTile();
    }

    @Override
    public void draw() {
        background(187, 173, 160);
        drawBoard();
        if (gameOver) {
            fill(255, 0, 0);
            textSize(32);
            textAlign(CENTER, CENTER);
            text("Game Over", width / 2, height / 2);
            noLoop();
        }
    }

    @Override
    public void keyPressed() {
        if (gameOver) return;
        hasMoved = false;

        if (keyCode == UP) {
            hasMoved = moveUp();
        } else if (keyCode == DOWN) {
            hasMoved = moveDown();
        } else if (keyCode == LEFT) {
            hasMoved = moveLeft();
        } else if (keyCode == RIGHT) {
            hasMoved = moveRight();
        }

        if (hasMoved) {
            addRandomTile();
            if (isGameOver()) gameOver = true;
        }
    }

    public void drawBoard() {
        for (int y = 0; y < gridSize; y++) {
            for (int x = 0; x < gridSize; x++) {
                int value = board[y][x];
                fill(getTileColor(value));
                rect(x * (tileSize + padding) + padding, y * (tileSize + padding) + padding, tileSize, tileSize);

                if (value > 0) {
                    fill(0);
                    textSize(32);
                    textAlign(CENTER, CENTER);
                    text(value, x * (tileSize + padding) + padding + tileSize / 2, y * (tileSize + padding) + padding + tileSize / 2);
                }
            }
        }
    }

    int getTileColor(int value) {
        switch (value) {
            case 2: return color(238, 228, 218);
            case 4: return color(237, 224, 200);
            case 8: return color(242, 177, 121);
            case 16: return color(245, 149, 99);
            case 32: return color(246, 124, 95);
            case 64: return color(246, 94, 59);
            case 128: return color(237, 207, 114);
            case 256: return color(237, 204, 97);
            case 512: return color(237, 200, 80);
            case 1024: return color(237, 197, 63);
            case 2048: return color(237, 194, 46);
            default: return color(205, 193, 180);
        }
    }

    public void addRandomTile() {
        ArrayList<int[]> emptyCells = new ArrayList<>();
        for (int y = 0; y < gridSize; y++) {
            for (int x = 0; x < gridSize; x++) {
                if (board[y][x] == 0) emptyCells.add(new int[] { y, x });
            }
        }

        if (emptyCells.size() > 0) {
            int[] cell = emptyCells.get((int) random(emptyCells.size()));
            board[cell[0]][cell[1]] = random(1) > 0.1 ? 2 : 4;
        }
    }

    public boolean moveUp() {
        boolean moved = false;

        for (int x = 0; x < gridSize; x++) {
            for (int y = 0; y < gridSize - 1; y++) {
                if (board[y][x] != 0 && board[y][x] == board[y + 1][x]) {
                    board[y][x] *= 2;
                    board[y + 1][x] = 0;
                    moved = true;
                } else if (board[y][x] == 0 && board[y + 1][x] != 0) {
                    board[y][x] = board[y + 1][x];
                    board[y + 1][x] = 0;
                    moved = true;
                }
            }
        }
        return moved;
    }

    public boolean moveDown() {
        boolean moved = false;

        for (int x = 0; x < gridSize; x++) {
            for (int y = gridSize - 1; y > 0; y--) {
                if (board[y][x] != 0 && board[y][x] == board[y - 1][x]) {
                    board[y][x] *= 2;
                    board[y - 1][x] = 0;
                    moved = true;
                } else if (board[y][x] == 0 && board[y - 1][x] != 0) {
                    board[y][x] = board[y - 1][x];
                    board[y - 1][x] = 0;
                    moved = true;
                }
            }
        }
        return moved;
    }

    public boolean moveLeft() {
        boolean moved = false;

        for (int y = 0; y < gridSize; y++) {
            for (int x = 0; x < gridSize - 1; x++) {
                if (board[y][x] != 0 && board[y][x] == board[y][x + 1]) {
                    board[y][x] *= 2;
                    board[y][x + 1] = 0;
                    moved = true;
                } else if (board[y][x] == 0 && board[y][x + 1] != 0) {
                    board[y][x] = board[y][x + 1];
                    board[y][x + 1] = 0;
                    moved = true;
                }
            }
        }
        return moved;
    }

    public boolean moveRight() {
        boolean moved = false;

        for (int y = 0; y < gridSize; y++) {
            for (int x = gridSize - 1; x > 0; x--) {
                if (board[y][x] != 0 && board[y][x] == board[y][x - 1]) {
                    board[y][x] *= 2;
                    board[y][x - 1] = 0;
                    moved = true;
                } else if (board[y][x] == 0 && board[y][x - 1] != 0) {
                    board[y][x] = board[y][x - 1];
                    board[y][x - 1] = 0;
                    moved = true;
                }
            }
        }
        return moved;
    }

    boolean isGameOver() {
        for (int y = 0; y < gridSize; y++) {
            for (int x = 0; x < gridSize; x++) {
                if (board[y][x] == 0) return false;
                if (x < gridSize - 1 && board[y][x] == board[y][x + 1]) return false;
                if (y < gridSize - 1 && board[y][x] == board[y + 1][x]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PApplet.main("Game2048");
    }
}
