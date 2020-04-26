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
import co.edu.javeriana.bootnode.services.NodeService;

@RestController
@RequestMapping("/node")
public class NodeController {
	
	@Autowired
	private NodeService nodeService;
	
	@PostMapping
	public void registerNode(HttpServletRequest request, @RequestBody String publicKey) {
		nodeService.createNode(request.getRemoteAddr()+":"+request.getRemotePort(), publicKey);
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Node>> getNodes(){
		return ResponseEntity.ok(nodeService.getNodes());
	}
}
