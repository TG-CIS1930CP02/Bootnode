package co.edu.javeriana.bootnode.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.javeriana.bootnode.entitys.Node;
import co.edu.javeriana.bootnode.repositories.NodeRepository;
import co.edu.javeriana.bootnode.restservices.NodeController;

@Service
public class NodeService {
	
	private static final Logger log = LoggerFactory.getLogger(NodeController.class);
	
	@Autowired
	private NodeRepository nodeRepository;
	
	public void createNode(String ip, String publicKey) {
		Node node = new Node();
		node.setPublicKey(publicKey);
		log.info("Registration Request from: "+ ip);
		node.setIp(ip);
		nodeRepository.save(node);
	}
	
	public Iterable<Node> getNodes(){
		return nodeRepository.findAll();
	}

}
