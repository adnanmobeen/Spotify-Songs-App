import java.util.*;

public class Main {
    public static List<Album>albumlist =new ArrayList<Album>();
    public static void main(String[] args) {
      Album a1 = new Album("sadsong","Arijit Singh");
      a1.addSongToAlbum("kesariya",4.8);
      a1.addSongToAlbum("Gerua",4.5);
      a1.addSongToAlbum("Naina",5.8);
      Album a2 = new Album("pop","Siddhu Moosewala");
      a2.addSongToAlbum("295",4.1);
      a2.addSongToAlbum("LastRide",4.7);
      a2.addSongToAlbum("so high",5.2);

      albumlist.add(a1);
      albumlist.add(a2);
        System.out.println(a1.findSong("Gerua"));
        LinkedList<Song>myplaylist = new LinkedList<>();
        a1.addToPlayListFromAlbum("kesariya",myplaylist);
        a2.addToPlayListFromAlbum("295",myplaylist);
        a1.addToPlayListFromAlbum(2,myplaylist);
        a2.addToPlayListFromAlbum(2,myplaylist);
      System.out.println(a1.getSongs());
      System.out.println(albumlist.get(1));
      System.out.println(albumlist.get(0));

      play(myplaylist);

    }
    public static void play(LinkedList<Song>playlist){
      ListIterator<Song>itr = playlist.listIterator();
      Scanner sc = new Scanner(System.in);
      boolean isForward = false;
      if(playlist.size() > 0){
        System.out.println("Currently playing: "+itr.next());
        isForward = true;

      }
      else{
        System.out.println("sorry! your playlist is empty.");
        return;
      }
      System.out.println("Enter your choice: ");
      printmenu();
      boolean quit = false;
      while(!quit){

        int choice = sc.nextInt();
        switch(choice) {
          case 1:
            if (isForward == false) {
              itr.next();
              isForward = true;
            }
            if (itr.hasNext()) {
              System.out.println(itr.next());
            } else {
              System.out.println("you are at the end of playlist");
              isForward = false;
            }
            break;
          case 2:
            if (isForward == true) {
              itr.previous();
              isForward = false;
            }
            if (itr.hasPrevious()) {
              System.out.println(itr.previous());
            } else {
              System.out.println("you are at the start of playlist");
              isForward = true;
            }
            break;
          case 3:
            if (isForward == true) {
              if (itr.hasPrevious()) {
                System.out.println(itr.previous());
                isForward = false;
              }
            } else {
              if (itr.hasNext()) {
                System.out.println(itr.next());
                isForward = true;
              }
            }
            break;
          case 4:
            printmenu();
            break;
          case 5:
            int size = playlist.size();
            if (size > 0){
              if (itr.hasNext()) {
                itr.remove();
                itr.next();
                size--;
              } else {
                itr.remove();
               // itr.previous();
               // itr.next();
                size--;
              }
            System.out.println("Current Song Successfully Deleted");
        }
        else {
              System.out.println("No song to delete");
            }

            break;
          case 6:
            printSongs(playlist);
            break;
          case 7:
            quit = true;
            break;
        }
      }

    }
    public static void printSongs(LinkedList<Song>playlist){
      for(Song song:playlist){
        System.out.println(song);
      }
      return;
    }
    public static void printmenu(){
      System.out.println("1 - Play next song");
      System.out.println("2 - Play previous song");
      System.out.println("3 - Repeat the current song");
      System.out.println("4 - Show menu again");
      System.out.println("5 - Delete the current song");
      System.out.println("6 - Print all the song in playlist");
      System.out.println("7 - Exit");
      return;
    }
}