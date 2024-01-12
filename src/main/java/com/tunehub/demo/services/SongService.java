package com.tunehub.demo.services;

import java.util.List;

import com.tunehub.demo.entities.Song;

public interface SongService {

	public void addSong(Song song);

	public List<Song> fetchAllSongs();

	public boolean nameExists(String name);
	
	public void updateSong(Song song);

}
