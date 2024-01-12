package com.tunehub.demo.services;

import java.util.List;

import com.tunehub.demo.entities.Playlist;

public interface PlaylistService {

	public void addPlaylist(Playlist playlist);

	public List<Playlist> fetchAllPlaylists();

}
