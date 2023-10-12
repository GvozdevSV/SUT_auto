package api;

public class SuccessLogin {
    private String accessToken;
    private String refreshToken;
    private String abilityToken;

    public SuccessLogin(String accessToken, String refreshToken, String abilityToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.abilityToken = abilityToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getAbilityToken() {
        return abilityToken;
    }
}
