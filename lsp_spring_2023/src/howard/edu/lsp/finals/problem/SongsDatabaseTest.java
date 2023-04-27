package howard.edu.lsp.finals.problem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

public class SongsDatabaseTest {

	@Test
    public void testAddSong() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Rap", "Savage");
        db.addSong("Rap", "Gin and Juice");
        db.addSong("Jazz", "Always There");
        Set<String> rapSongs = db.getSongs("Rap");
        Set<String> jazzSongs = db.getSongs("Jazz");
        assertEquals(2, rapSongs.size());
        assertEquals(1, jazzSongs.size());
        assertTrue(rapSongs.contains("Savage"));
        assertTrue(rapSongs.contains("Gin and Juice"));
        assertTrue(jazzSongs.contains("Always There"));

        // Adding the same song to the same genre should not change anything
        db.addSong("Rap", "Savage");
        db.addSong("Jazz", "Always There");
        assertEquals(2, rapSongs.size());
        assertEquals(1, jazzSongs.size());
        assertTrue(rapSongs.contains("Savage"));
        assertTrue(rapSongs.contains("Gin and Juice"));
        assertTrue(jazzSongs.contains("Always There"));

        // Adding a song to a new genre should create a new set of songs
        db.addSong("Rock", "Stairway to Heaven");
        Set<String> rockSongs = db.getSongs("Rock");
        assertEquals(1, rockSongs.size());
        assertTrue(rockSongs.contains("Stairway to Heaven"));
    }

    @Test
    public void testGetSongs() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Rap", "Savage");
        db.addSong("Rap", "Gin and Juice");
        db.addSong("Jazz", "Always There");
        Set<String> rapSongs = db.getSongs("Rap");
        Set<String> jazzSongs = db.getSongs("Jazz");
        Set<String> emptySongs = db.getSongs("Rock");
        assertEquals(2, rapSongs.size());
        assertEquals(1, jazzSongs.size());
        assertEquals(0, emptySongs.size());
        assertTrue(rapSongs.contains("Savage"));
        assertTrue(rapSongs.contains("Gin and Juice"));
    }

    @Test
    public void testGetGenreOfSong() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Rap", "Savage");
        db.addSong("Rap", "Gin and Juice");
        db.addSong("Jazz", "Always There");
        String rapGenre = db.getGenreOfSong("Savage");
        String jazzGenre = db.getGenreOfSong("Always There");
        String missingGenre = db.getGenreOfSong("Stairway to Heaven");
        assertEquals("Rap", rapGenre);
        assertEquals("Jazz", jazzGenre);
        assertNull(missingGenre);

        // Adding a song to a new genre and then checking its genre
        db.addSong("Rock", "Stairway to Heaven");
        String rockGenre = db.getGenreOfSong("Stairway to Heaven");
        assertEquals("Rock", rockGenre);
    }
    @Test
    public void testEmptyDatabase() {
        SongsDatabase db = new SongsDatabase();
        Set<String> emptySet = db.getSongs("Rock");
        assertNull(db.getGenreOfSong("Stairway to Heaven"));
        assertEquals(0, emptySet.size());
    }
    @Test
    public void testGetGenreOfNonExistentSong() {
        SongsDatabase db = new SongsDatabase();
        assertNull(db.getGenreOfSong("Hello"));
    }
    @Test
    public void testGetSongsOfNonExistentGenre() {
        SongsDatabase db = new SongsDatabase();
        Set<String> songs = db.getSongs("Country");
        assertNotNull(songs);
        assertTrue(songs.isEmpty());
    }
    
    @Test
    public void testAddMultipleSongsToDifferentGenresWithSameTitle() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Pop", "Don't Start Now");
        db.addSong("Rock", "Don't Start Now");
        Set<String> popSongs = db.getSongs("Pop");
        assertEquals(1, popSongs.size());
        assertTrue(popSongs.contains("Don't Start Now"));
        Set<String> rockSongs = db.getSongs("Rock");
        assertEquals(1, rockSongs.size());
        assertTrue(rockSongs.contains("Don't Start Now"));
    }
    @Test
    public void testAddSongToNonExistentGenre() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Pop", "Shallow");
        Set<String> songs = db.getSongs("Pop");
        assertEquals(1, songs.size());
        assertTrue(songs.contains("Shallow"));
    }





}
