package co.edu.javeriana.bootnode.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.javeriana.bootnode.entitys.Node;

@Repository
public interface NodeRepository extends CrudRepository<Node, Long>{

}
