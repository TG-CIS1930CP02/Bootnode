package co.edu.javeriana.bootnode.restservices;

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
public class NodeService {
	
	@Autowired
	private NodeRepository nodeRepository;
	
	@PostMapping
	public void registerNode(@RequestBody String publicKey) {
		System.out.println("test");
		Node node = new Node();
		node.setPublicKey(publicKey);
		nodeRepository.save(node);
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Node>> getNodes(){
		return ResponseEntity.ok(nodeRepository.findAll());
	}
}
