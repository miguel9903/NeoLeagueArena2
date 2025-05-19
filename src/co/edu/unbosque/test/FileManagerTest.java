package co.edu.unbosque.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.Player;
import co.edu.unbosque.model.UserRole;
import co.edu.unbosque.persistence.FileManager;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la clase FileManager.
 *
 * Estas pruebas validan el correcto funcionamiento de los métodos de lectura
 * y escritura de archivos utilizando objetos de tipo Player. También se verifica
 * que el archivo se cree correctamente y se manejen situaciones como archivos vacíos.
 */
public class FileManagerTest {

    private FileManager<Player> fileManager;
    private String testFilePath = "test-data/players_test.dat";
    private Player player1;
    private Player player2;
    private ArrayList<Player> players;

    /**
     * Inicializa los datos de prueba antes de cada ejecución.
     * Se crean dos jugadores des ejemplo y se inicializa FileManager.
     */
    @Before
    public void setUp() {
        fileManager = new FileManager<>(testFilePath);

        player1 = new Player(1, "John", "Doe", "john@neo.com", "pass123", "USA", "NYC", LocalDate.of(1995, 5, 12), UserRole.PLAYER);
        player1.setNickName("JDozer");
        player1.setExperienceLevel(5);

        player2 = new Player(2, "Alice", "Smith", "alice@neo.com", "alicepass", "Canada", "Toronto", LocalDate.of(1998, 10, 23), UserRole.PLAYER);
        player2.setNickName("Alicorn");
        player2.setExperienceLevel(3);

        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
    }

    /**
     * Verifica que los objetos se escriban correctamente al archivo y se
     * puedan leer posteriormente con los mismos datos.
     */
    @Test
    public void testWriteAndReadPlayers() {
        fileManager.writeToFile(players, Player.class);
        ArrayList<Player> loadedPlayers = fileManager.readFromFile(Player.class);

        assertNotNull("La lista leída no debe ser null", loadedPlayers);
        assertEquals("Debe haber 2 jugadores leídos", 2, loadedPlayers.size());

        Player loaded1 = loadedPlayers.get(0);
        assertEquals("Primer jugador: nombre incorrecto", "John", loaded1.getFirstName());
        assertEquals("Primer jugador: nickname incorrecto", "JDozer", loaded1.getNickName());

        Player loaded2 = loadedPlayers.get(1);
        assertEquals("Segundo jugador: ciudad incorrecta", "Toronto", loaded2.getCity());
    }

    /**
     * Verifica que el archivo haya sido creado correctamente al instanciar FileManager.
     */
    @Test
    public void testFileIsCreated() {
        File file = new File(testFilePath);
        assertTrue("El archivo debe existir después de crear FileManager", file.exists());
    }

    /**
     * Verifica que la lectura de un archivo vacío retorne null.
     */
    @Test
    public void testReadEmptyFileShouldReturnNull() {
        String emptyFilePath = "test-data/empty_test.dat";
        FileManager<Player> emptyManager = new FileManager<>(emptyFilePath);

        ArrayList<Player> result = emptyManager.readFromFile(Player.class);
        assertNull("Leer un archivo vacío debe retornar null", result);
    }

    /**
     * Elimina los archivos temporales generados durante las pruebas.
     */
    @After
    public void cleanUp() {
        File file = new File(testFilePath);
        if (file.exists()) {
            file.delete();
        }

        File emptyFile = new File("test-data/empty_test.dat");
        if (emptyFile.exists()) {
            emptyFile.delete();
        }
    }
}
