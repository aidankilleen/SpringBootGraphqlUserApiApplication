package ie.pt.springbootgraphqluserapi.repository;

import ie.pt.springbootgraphqluserapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, QueryByExampleExecutor<User> {
}
