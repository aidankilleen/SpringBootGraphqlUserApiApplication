package ie.pt.springbootgraphqluserapi.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import ie.pt.springbootgraphqluserapi.model.User;
import ie.pt.springbootgraphqluserapi.model.dto.UserDto;
import ie.pt.springbootgraphqluserapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMutations implements GraphQLMutationResolver {

    @Autowired
    UserRepository userRepository;

    public User addUser(UserDto userToAdd) {

        User newUser = new User();
        newUser.setName(userToAdd.getName());
        newUser.setEmail(userToAdd.getEmail());
        newUser.setActive(userToAdd.isActive());

        return userRepository.save(newUser);
    }

    public int delete(int id) {
        try {
            userRepository.deleteById(id);
        } catch(Exception ex) {
            return 0;
        }
        return id;
    }

    public User update (User userToUpdate) {
        return userRepository.save(userToUpdate);
    }
}
