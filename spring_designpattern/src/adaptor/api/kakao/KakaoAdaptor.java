package adaptor.api.kakao;

import adaptor.SocialLogin;
import adaptor.UserProfile;

public class KakaoAdaptor implements SocialLogin {

    private final KakaoApi api = new KakaoApi();

    @Override
    public UserProfile login(String token) {
        KakaoProfile profile = api.getProfile(token);
        return new UserProfile(profile.name(), profile.mail());
    }
}