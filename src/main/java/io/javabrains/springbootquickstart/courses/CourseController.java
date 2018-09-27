package io.javabrains.springbootquickstart.courses;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootquickstart.topics.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	
	@GetMapping("/topics/{topicId}/courses/{courseId}")
	public Optional<Course> getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@PostMapping("/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}
	
	@PutMapping("/topics/{topicId}/course/{id}")
	public void updateCourse(@PathVariable String id, @RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
}
	
