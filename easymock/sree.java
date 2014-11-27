import static org.easymock.EasyMock.*;

public class MockMp3Player implements Mp3Player{

	private Mp3Player mockMp3Player;
	private Mp3Player mockMp3Player_control;
	private boolean isPlaying;
	private String nowPlaying;
	private double nowPosition;
	private ArrayList plist;

	public MockMp3Player(){
		plist = new ArrayList;
		isPlaying = false;
		nowPosition = 0.0;
		mockMp3Player_control = createMock(Mp3Player.class);

		mockMp3Player = mockMp3Player_control;
	}

	public void loadSongs(ArrayList names){
		plist = names;
		mockMp3Player.loadSongs(names);
	}

	public void isPlaying(){
		return isPlaying;
	}

	public void play(){
		if(!plist.isEmpty()){
			isPlaying = true;
			nowPlaying = plist.get(0);
			nowPosition = 0.1;
		}
	}

	public double currentPosition(){
		rn nowPosition;
	}

	public String currentSong(){
		return nowPlaying;
	}

	public void pause(){
		if(isPlaying)
			isPlaying = false;
	}

	public void stop(){
		if(isPlaying)
			nowPosition = 0.0;
	}

}
