package com.itu.aswe.videorecorder.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Video implements Serializable {
    
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name = "id")
   private int id;
   
   @Lob
   @Column(name = "video", length=1000000)
   private byte[] video;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public byte[] getVideo() {
		return video;
	}
	
	public void setVideo(byte[] video) {
		this.video = video;
	}

}
