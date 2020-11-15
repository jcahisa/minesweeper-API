package gojoego.db;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gojoego.api.GameBoard;

import javax.persistence.AttributeConverter;
import java.io.IOException;

public class GameBoardConverter implements AttributeConverter<GameBoard, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(GameBoard gameBoard) {

        String customerInfoJson = null;
        try {
            customerInfoJson = objectMapper.writeValueAsString(gameBoard);
        } catch (final JsonProcessingException e) {
            System.out.println(String.format("JSON writing error - %s", e));
        }

        return customerInfoJson;
    }

    @Override
    public GameBoard convertToEntityAttribute(String gameBoardJson) {

        GameBoard gameBoard = null;
        try {
            gameBoard = objectMapper.readValue(gameBoardJson, GameBoard.class);
        } catch (final IOException e) {
            System.out.println(String.format("JSON reading error - %s", e));
        }

        return gameBoard;
    }
}
