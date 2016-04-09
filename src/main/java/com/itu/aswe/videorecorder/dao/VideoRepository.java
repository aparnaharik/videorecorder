package com.itu.aswe.videorecorder.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.itu.aswe.videorecorder.data.Video;

@Repository
public interface VideoRepository  extends CrudRepository<Video, Integer> {
	
}
