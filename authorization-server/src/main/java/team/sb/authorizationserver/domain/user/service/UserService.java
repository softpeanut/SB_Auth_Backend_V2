package team.sb.authorizationserver.domain.user.service;

import org.springframework.web.multipart.MultipartFile;
import team.sb.authorizationserver.domain.user.api.dto.request.EmailRequest;
import team.sb.authorizationserver.domain.user.api.dto.request.LoginRequest;
import team.sb.authorizationserver.domain.user.api.dto.request.SignupRequest;

public interface UserService {
    void signup(MultipartFile profile, SignupRequest signUpRequest);
    void sendEmail(EmailRequest emailRequest);
    String login(LoginRequest loginRequest, String clientId, String redirectUri, String authorizedType);
}
