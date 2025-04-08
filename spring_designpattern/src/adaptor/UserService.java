package adaptor;

import adaptor.api.google.GoogleAdaptor;
import adaptor.api.kakao.KakaoAdaptor;

public class UserService {

    public UserProfile login(String provider, String token) {

        SocialLogin socialLogin = switch (provider.toUpperCase()) {
            case "KAKAO" -> new KakaoAdaptor();
            case "GOOGLE" -> new GoogleAdaptor();
            default -> throw new RuntimeException("지원하지 않습니다.");
        };

        UserProfile profile = socialLogin.login(token);
        System.out.println(profile);
        return profile;
    }
}