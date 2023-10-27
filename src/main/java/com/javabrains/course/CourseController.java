package com.javabrains.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javabrains.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService topicService;
	
	@GetMapping("/topics/{id}/courses")
	public List<Course> getAllCourse(@PathVariable String id) {
		return topicService.getAllcourse(id);
	}
	
	@GetMapping("/topics/{topicId}/courses/{id}")
	public Optional<Course> getCourse(@PathVariable String id) {
		return topicService.getCourse(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/cources")
	public void addCourse(@RequestBody Course t1, @PathVariable String topicId ){
		t1.setTopic(new Topic(topicId,"",""));
		topicService.addCourse(t1);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/cources/{id}")
	public void updateCourse(@RequestBody Course t1, @PathVariable String id, @PathVariable String topicId){
		t1.setTopic(new Topic(topicId,"",""));
		topicService.updateCourse(t1);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}//cources/{id}")
	public void deleteCourse(@PathVariable String id){
		topicService.deleteCourse(id);
	}

}
