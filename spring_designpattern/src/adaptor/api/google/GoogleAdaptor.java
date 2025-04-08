package adaptor.api.google;

import adaptor.SocialLogin;
import adaptor.UserProfile;

public class GoogleAdaptor implements SocialLogin {

    private final GoogleApi api = new GoogleApi();

    @Override
    public UserProfile login(String token) {
        GoogleProfile profile = api.getProfile(token);
        return new UserProfile(profile.username(), profile.email());
    }
}