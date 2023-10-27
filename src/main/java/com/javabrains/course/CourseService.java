package com.javabrains.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;

	public List<Course> getAllcourse(String topicid) {
		List <Course> course = new ArrayList<>();
		courseRepository.findByTopicId(topicid).forEach(course::add);
		return course;
	}
	
	public Optional<Course> getCourse(String id) {
		return courseRepository.findById(id);
	}

	public void addCourse(Course t1){
		courseRepository.save(t1);
	}

	public void updateCourse(Course t2){
		courseRepository.save(t2);
	}

	public void deleteCourse(String t1){
		courseRepository.deleteById(t1);
		return;
	}
}
