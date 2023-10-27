package com.javabrains.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	TopicRepository topicRepository;

	public List<Topic> getAlltopics() {
		List <Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);;
		return topics;
	}
	
	public Optional<Topic> getToipic(String id) {
		return topicRepository.findById(id);
	}

	public void addTopic(Topic t1){
		topicRepository.save(t1);
	}

	public void updateTopic(String t1, Topic t2){
		topicRepository.save(t2);
	}

	public void deleteTopic(String t1){
		topicRepository.deleteById(t1);
		return;
	}
}
