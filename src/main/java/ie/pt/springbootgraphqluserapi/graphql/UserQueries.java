package ie.pt.springbootgraphqluserapi.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import ie.pt.springbootgraphqluserapi.model.User;
import ie.pt.springbootgraphqluserapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserQueries implements GraphQLQueryResolver {

    @Autowired
    UserRepository userRepository;

    public List<User> users() {
        return userRepository.findAll();
    }

    public List<User> activeUsers() {

        User u = new User();
        u.setId(82);
        u.setName("Alice");
        u.setActive(true);
        Example<User> example = Example.of(u);

        List<User> results = userRepository.findAll(example);
        
        return results;
    }
    public Optional<User> user(int id) {
        return userRepository.findById(id);
    }
}
