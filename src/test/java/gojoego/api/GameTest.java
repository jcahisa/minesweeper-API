package gojoego.api;


import org.junit.Test;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GameTest {

    @Test
    public void createNewGame() {
        final UUID userId = UUID.randomUUID();
        final Game newGame = new Game(userId);
        assertNotNull(newGame.getGameBoard());
        assertNotNull(newGame.getStartTime());
        assertNotNull(newGame.getId());
        assertNotNull(newGame.getUserId());
        assertEquals("Game Status", GameStatus.ACTIVE, newGame.getStatus());
    }
}