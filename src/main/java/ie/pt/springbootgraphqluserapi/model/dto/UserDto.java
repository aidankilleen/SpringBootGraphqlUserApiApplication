package ie.pt.springbootgraphqluserapi.model.dto;

import lombok.Data;

@Data
public class UserDto {
    String name;
    String email;
    boolean active;
}
