package io.javabrains.springbootquickstart.courses;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourses(String topicId) {
		// return topics; older method w/o DB.
		List<Course> courseList = new ArrayList<Course>();
		courseRepository.findByTopicId(topicId).forEach(courseList::add);
		return courseList;
	}

	public Optional<Course> getCourse(String id) {
		// return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
			return courseRepository.findById(id);
		
	}

	public void addCourse(Course course) {
		// topics.add(topic); older method w/o DB.
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);
	}
}
