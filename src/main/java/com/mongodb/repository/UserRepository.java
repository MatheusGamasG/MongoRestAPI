package com.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mongodb.model.User;

// MongoRepository seria equivalente ao JpaRepository, mas focado em persistência ao Mongo. É possível também fazer queries personalizadas, assim como no caso do uso com JPA e SQL.
public interface UserRepository extends MongoRepository<User, String> {

	// Podemos fazer o @Query também, assim como JPA, a semântica diverge bastante, mas é em formato de JSON. gte = greater than equals, lte = lesser than equals 
	@Query("{ $and : [ { 'idade' : { $gte: ?0 } }, { 'idade' : { $lte: ?1 } } ] }")
	public List<User> obterUsuariosPorRangeDeIdade(Integer de, Integer ate);
	
	// Assim como com JPA Repository, podemos usar o build-in "find by X" para procurar por algum campo da coleção.
	public List<User> findByNome(String nome);
}
