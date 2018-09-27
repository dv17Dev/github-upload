package io.javabrains.springbootquickstart.topics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

//	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("t1", "Spring", "Spring Boot Applications."),
//			new Topic("t2", "Deep Learning", "Applications of Deep Learning and Neural Networks."),
//			new Topic("t3", "Quantum Computing", "Quantum Computing Expertise."),
//			new Topic("t4", "Competitive Programming", "Developing problem solving skills."),
//			new Topic("t5", "Computer Networks", "Computer Network basics."),
//			new Topic("t6", "Operating Systems", "Introduction to Operating Systems."),
//			new Topic("t7", "Distributed Databases", "Introduction to Distributed Databases."),
//			new Topic("t8", "Cloud Computing and Container", "Introduction to CC and Kubernetes/Docker.")));

	public List<Topic> getAllTopics() {
		// return topics; older method w/o DB.
		List<Topic> topicList = new ArrayList<Topic>();
		topicRepository.findAll().forEach(topicList::add);
		return topicList;
	}

	public Optional<Topic> getTopic(String id) {
		// return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
			return topicRepository.findById(id);
		
	}

	public void addTopic(Topic topic) {
		// topics.add(topic); older method w/o DB.
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
//		for (int i = 0, k = topics.size(); i < k; i++) {
//			if (topics.get(i).getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//	}
		topicRepository.save(topic);
	}
}
