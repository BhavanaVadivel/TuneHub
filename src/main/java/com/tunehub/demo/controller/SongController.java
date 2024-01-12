package com.tunehub.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.demo.entities.Song;
import com.tunehub.demo.services.SongService;


@Controller
public class SongController {
	@Autowired
	SongService service;

	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Song song) {
		boolean songStatus = service.nameExists(song.getName());
		if(songStatus == false) {
			service.addSong(song);
			System.out.println("Song Added Successfully");
		}
		else {
			System.out.println("Song Already exixts");
		}
		return "adminHome";
	}
	
	@GetMapping("/viewSongs")
	public String viewSongs(Model model) {
		List<Song> songsList = service.fetchAllSongs();
		//System.out.println(songsList);
		model.addAttribute("songs",songsList);
		return "displaySongs";
	}
	
	@GetMapping("/playSongs")
	public String playSongs(Model model) {
		boolean premiumUser = true;
		if(premiumUser == true) {
			List<Song> songsList = service.fetchAllSongs();
			model.addAttribute("songs",songsList);
			return "displaySongs";
		}
		else {
			return "makePayment";
		}
		
	}
}
