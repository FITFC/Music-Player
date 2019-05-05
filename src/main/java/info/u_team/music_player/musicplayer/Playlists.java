package info.u_team.music_player.musicplayer;

import java.util.*;

import com.google.common.collect.Iterators;

public class Playlists implements Iterable<Playlist> {
	
	private final List<Playlist> playlists;
	
	private transient Playlist playing;
	
	public Playlists() {
		playlists = new ArrayList<>();
	}
	
	public int size() {
		return playlists.size();
	}
	
	public Playlist get(int index) {
		return playlists.get(index);
	}
	
	public void add(Playlist playlist) {
		playlists.add(playlist);
		save();
	}
	
	public void remove(Playlist playlist) {
		playlists.remove(playlist);
		save();
	}
	
	public void setPlaying(Playlist playing) {
		this.playing = playing;
	}
	
	public Playlist getPlaying() {
		return playing;
	}
	
	@Override
	public Iterator<Playlist> iterator() {
		return Iterators.unmodifiableIterator(playlists.iterator());
	}
	
	private void save() {
		MusicPlayerManager.getPlaylistManager().writeToFile();
	}
	
}
