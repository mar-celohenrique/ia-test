package br.marcelo.userapi.repository;

import br.marcelo.userapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
