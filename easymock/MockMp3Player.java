import java.util.ArrayList;
import java.util.Date;

public class MockMp3Player implements Mp3Player{

	private boolean isPlaying;
	private String nowPlaying = null;
	private double nowPosition = 0.0;
	private ArrayList plist = new ArrayList();
	private int nowPlaying_index = -1;

	@Override
	public void loadSongs(ArrayList names){
		plist = names;
	}

	@Override
	public boolean isPlaying(){
		return isPlaying;
	}

	@Override
	public void play(){
		if(!plist.isEmpty()){
			isPlaying = true;
			nowPlaying = (String)plist.get(0);
			nowPlaying_index = 0;
			nowPosition = 0.2;
		}
	}

	@Override
	public double currentPosition(){
		return nowPosition;
	}

	@Override
	public String currentSong(){
		return nowPlaying;
	}

	@Override
	public void pause(){
		if(isPlaying){
			isPlaying = false;
			nowPosition = 0.2;
		}
	}

	@Override
	public void stop(){
		if(isPlaying){
			isPlaying = false;
			nowPosition = 0.0;
		}
		if(!plist.isEmpty()){
			nowPlaying = (String)plist.get(0);
		}
		nowPosition = 0.0;
	}

	@Override
	public void next() {
		int next_pos = nowPlaying_index + 1;
		if (next_pos < plist.size())
			{
				nowPlaying = (String)plist.get(next_pos);
				nowPlaying_index = next_pos;
			}
		
	}

	@Override
	public void prev() {
		int prev_pos = nowPlaying_index - 1;
		if (prev_pos > -1){
			nowPlaying = (String)plist.get(prev_pos);
			nowPlaying_index = prev_pos;
		}
	}



}
