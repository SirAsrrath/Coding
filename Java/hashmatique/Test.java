import java.util.Set;
import java.util.HashMap;

public class Test {
    
    public static void main(String[] args){
        HashMap<String, String> songs = new HashMap<String,String>();
        songs.put("Song 1","Lyric 1");
        songs.put("Song 2","Lyric 2");
        songs.put("Song 3","Lyric 3");
        songs.put("Song 4","Lyric 4");

        Set<String> keys = songs.keySet();
        for(String key:keys){
            System.out.println(key + " : " + songs.get(key));
        }
    }
}
