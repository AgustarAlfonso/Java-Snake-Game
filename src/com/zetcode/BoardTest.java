package com.zetcode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.event.ActionEvent;

public class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void testMove() {
        // Simulasi gerakan ke kanan
        int initialX = board.x[0];
        int initialY = board.y[0];

        board.move();

        assertEquals(initialX + 10, board.x[0], "Kepala ular seharusnya bergerak ke kanan");
        assertEquals(initialY, board.y[0], "Y tidak boleh berubah karena hanya bergerak ke kanan");
    }

    @Test
    void testCheckCollision() {
        // Simulasi tabrakan ke diri sendiri
        board.dots = 5;
        board.x[0] = 50;
        board.y[0] = 50;
        for (int i = 1; i < board.dots; i++) {
            board.x[i] = 50;
            board.y[i] = 50;
        }
        board.checkCollision();
        assertFalse(board.inGame, "Ular seharusnya mati saat menabrak dirinya sendiri");

        // Simulasi tabrakan ke dinding
        board.inGame = true;
        board.x[0] = 300;
        board.checkCollision();
        assertFalse(board.inGame, "Ular seharusnya mati saat keluar dari batas papan");
    }
}

