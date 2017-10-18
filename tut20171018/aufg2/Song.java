package tut20171018.aufg2;

public class Song {

	private String name;
	private int duration;
	
	public Song(String name, int duration) {
		this.name= name;
		this.duration = duration;
	}
	
	public int getDuration() {
		return duration;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name + " " + duration;
	}
}
