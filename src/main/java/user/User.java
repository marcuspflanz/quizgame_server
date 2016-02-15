package user;

import java.net.URI;

/**
 * User class holds als definitions of a real world user.
 *
 * Created by marcuspflanz on 06/01/16.
 */
public class User {
    // region members
    /**
     * Unique identifier.
     * Never changes.
     */
    int id;

    /**
     * Display name.
     * Might be changed by user.
     */
    String name;

    /**
     * Avatar image displayed.
     * Might be changed by user.
     */
    URI avatar;
    // endregion

    // region getters / setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public URI getAvatar() {
        return avatar;
    }

    public void setAvatar(URI avatar) {
        this.avatar = avatar;
    }
    // endregion

    // region methods
    /**
     * Checks whether or not two users equal by ID.
     * @param other - Other user instance to check for ID.
     * @return True if {other} is not null, and a User with equal ID.
     */
    public boolean equals(Object other) {
        return other != null &&
               other instanceof User &&
               ((User) other).getId() == this.getId();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
    // endregion
}
