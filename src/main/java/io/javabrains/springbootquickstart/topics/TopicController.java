package io.javabrains.springbootquickstart.topics;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@GetMapping("/topics")
	public List<Topic> getTopics() {
		return topicService.getAllTopics();
	}
	
	@GetMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@PostMapping("/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@PutMapping("/topics/{id}")
	public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
		topicService.updateTopic(id, topic);
	}
}
	
