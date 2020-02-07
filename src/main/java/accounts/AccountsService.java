package accounts;

import java.util.HashMap;
import java.util.Map;

public class AccountsService  {
    private final Map<String, UserProfile> loginToProfile;

    public AccountsService() {
        loginToProfile = new HashMap<>();
    }

    public void addNewUser(UserProfile userProfile) {
        loginToProfile.put(userProfile.getLogin(), userProfile);
    }

    public UserProfile getUserByLogin(String login) {
        return loginToProfile.get(login);
    }

}
