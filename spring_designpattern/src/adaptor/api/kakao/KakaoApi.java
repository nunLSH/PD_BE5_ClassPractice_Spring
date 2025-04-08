package adaptor.api.kakao;

public class KakaoApi {
    public KakaoProfile getProfile(String token){
        // token 으로 사용자 정보를 불러온다.
        return new KakaoProfile("kakao user", "kakao@kakao.com");
    }
}