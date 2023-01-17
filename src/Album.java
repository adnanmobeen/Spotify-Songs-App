import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    private String name;
    private String artist;
    private List<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
    public boolean findSong(String title){

        for(Song s:songs){
            if(s.getTitle().equals(title)) return true;
        }
        return false;
    }
    public void addSongToAlbum(String title,double duration){
        Song s = new Song(title,duration);
        if(findSong(s.getTitle())){
            System.out.println("Song already present in the album");
        }
        else{
            songs.add(s);
            System.out.println("new song added to the album");
        }
        return;
    }


    public void addToPlayListFromAlbum(String title, LinkedList<Song> playlist){
        if(findSong(title)) {
            for (Song song : songs) {
                if (song.getTitle().equals(title)) {
                    playlist.add(song);
                    System.out.println("Enjoy! Song has been added to your playlist");
                    break;
                }
            }
        }
           else{
            System.out.println("Sorry! your song is not present in the album");
        }
        }
    public void addToPlayListFromAlbum(int trackNo, LinkedList<Song> playlist){
        if(trackNo-1 >=0 && trackNo-1 < songs.size()){
            playlist.add(songs.get(trackNo-1));
            System.out.println("Happy! your song is added to your playlist");
        }
        else{
            System.out.println("sorry! invalid track");
        }
        return;
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", songs=" + songs +
                '}';
    }
}

