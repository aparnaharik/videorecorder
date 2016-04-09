package com.itu.aswe.videorecorder;

import java.io.IOException;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.itu.aswe.videorecorder.dao.VideoRepository;
import com.itu.aswe.videorecorder.data.Video;

@RestController
@RequestMapping(value = "/video")
@MultipartConfig(fileSizeThreshold = 20971520)
public class VideoController {

	@Autowired
	VideoRepository videoRepository;

	@RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Integer> save(@RequestParam("uploadedFile") MultipartFile file) {
		Video video = new Video();
		try {
			video.setVideo(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		video = videoRepository.save(video);
		System.out.println(video.getId());
		return new ResponseEntity<Integer>(video.getId(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{videoId}", method = RequestMethod.GET)
    public HttpEntity<byte[]> getById(@PathVariable int videoId) {
		Video video = videoRepository.findOne(videoId);
        // send it back to the client
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "video/webm");
        return new ResponseEntity<byte[]>(video.getVideo(), httpHeaders, HttpStatus.OK);
	}

}
