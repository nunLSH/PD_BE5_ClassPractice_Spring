package adaptor.api.google;

public class GoogleApi {
    public GoogleProfile getProfile(String token){
        // token 으로 사용자 정보 불러온다.
        // ...
        return new GoogleProfile("google user", "google@google.com");
    }
}