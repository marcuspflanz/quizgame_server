package user;

import java.net.URI;

/**
 * Created by marcuspflanz on 15/02/16.
 */
public class UserBuilder {
    private User user = new User();

    public UserBuilder setName(String name) {
        user.setName(name);
        return this;
    }

    public UserBuilder setAvatar(URI avatarURI) {
        user.setAvatar(avatarURI);
        return this;
    }

    public User createUser() {
        return user;
    }
}
