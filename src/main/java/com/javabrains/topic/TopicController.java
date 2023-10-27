package com.javabrains.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@GetMapping("/topics/")
	public List<Topic> getAllToipics() {
		return topicService.getAlltopics();
	}
	
	@GetMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable String id) {
		return topicService.getToipic(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/topics/")
	public void addTopic(@RequestBody Topic t1){
		topicService.addTopic(t1);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic t1, @PathVariable String id){
		topicService.updateTopic(id, t1);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id){
		topicService.deleteTopic(id);
	}

}
