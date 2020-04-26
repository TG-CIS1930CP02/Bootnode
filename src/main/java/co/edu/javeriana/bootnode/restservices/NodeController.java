package co.edu.javeriana.bootnode.restservices;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.bootnode.entitys.Node;
import co.edu.javeriana.bootnode.repositories.NodeRepository;

@RestController
@RequestMapping("/node")
public class NodeController {
	
	private static final Logger log = LoggerFactory.getLogger(NodeController.class);
	
	@Autowired
	private NodeRepository nodeRepository;
	
	@PostMapping
	public void registerNode(HttpServletRequest request, @RequestBody String publicKey) {
		Node node = new Node();
		node.setPublicKey(publicKey);
		log.info("Registration Request from: " + request.getRemoteAddr()+":"+request.getRemotePort());
		node.setIp(request.getRemoteAddr()+":"+request.getRemotePort());
		nodeRepository.save(node);
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Node>> getNodes(){
		return ResponseEntity.ok(nodeRepository.findAll());
	}
}
