package com.itu.aswe.videorecorder.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.itu.aswe.videorecorder.data.UserMedia;

@RepositoryRestResource
public interface UserMediaRepository extends PagingAndSortingRepository<UserMedia, Integer> {
	List<UserMedia> findByUserName(@Param("userName") String userName);
}