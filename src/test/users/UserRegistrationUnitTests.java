package users;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import user.User;
import user.UserBuilder;
import user.UserService;

import java.net.URI;

public class UserRegistrationUnitTests {
    private UserService userService = new UserService();

    @Before
    public void cleanUp() {
        userService.clear();
    }

    @Test
    public void createAndRegisterUser() throws Exception {
        String testName = "halli galli";
        URI testAvatarURI = new URI("http://whatsoever.com");

        User newUser = new UserBuilder()
                .setName(testName)
                .setAvatar(testAvatarURI)
                .createUser();
        assertEquals(testName, newUser.getName());
        assertEquals(testAvatarURI, newUser.getAvatar());

        userService.registerUser(newUser);
    }

    @Test
    public void createRegisterAndGetUser() throws Exception {
        // region create
        String testName = "halli galli";
        URI testAvatarURI = new URI("http://whatsoever.com");
        int testId = 4711;

        User newUser = new UserBuilder()
                .setName(testName)
                .setAvatar(testAvatarURI)
                .createUser();
        newUser.setId(testId);
        assertEquals(testName, newUser.getName());
        assertEquals(testAvatarURI, newUser.getAvatar());
        assertEquals(testId, newUser.getId());

        userService.registerUser(newUser);
        // endregion

        // region get
        User retrievedUser = userService.getUserByID(testId);
        assertEquals(newUser, retrievedUser);
        // endregion
    }

    @Test(expected = Exception.class)
    public void createRegisterSameUserTwice() throws Exception {
        // region create
        String testName = "halli galli";
        URI testAvatarURI = new URI("http://whatsoever.com");

        User newUser = new UserBuilder()
                .setName(testName)
                .setAvatar(testAvatarURI)
                .createUser();
        assertEquals(testName, newUser.getName());
        assertEquals(testAvatarURI, newUser.getAvatar());

        userService.registerUser(newUser);
        // endregion

        // create second time (should throw an exception)
        userService.registerUser(newUser);
    }

    @Test(expected = Exception.class)
    public void getUnregisteredUser() throws Exception {
        userService.getUserByID(0);
    }
}