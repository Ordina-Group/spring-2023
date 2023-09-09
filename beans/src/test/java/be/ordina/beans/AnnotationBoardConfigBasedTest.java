package be.ordina.beans;

import be.ordina.beans.config.BoardConfig;
import be.ordina.beans.config.GameConfig;
import be.ordina.beans.repo.ChessGameRepository;
import be.ordina.beans.service.ChessGameService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AnnotationBoardConfigBasedTest {

    @Test
    void testApplicationContext() {
        var context = new AnnotationConfigApplicationContext(GameConfig.class);

        assertAll(
                () -> assertNotNull(context.getBean(ChessGameRepository.class)),
                () -> assertNotNull(context.getBean(ChessGameService.class)),
                () -> assertNotNull(context.getBean("chessBoard")),
                () -> assertNotNull(context.getBean("game")),
                () -> assertNotNull(context.getBean("config")),
                () -> assertNotNull(context.getBean("gameConfig"))
        );
    }
}