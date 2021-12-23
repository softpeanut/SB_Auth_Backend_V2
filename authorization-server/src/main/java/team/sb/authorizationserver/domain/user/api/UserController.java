package team.sb.authorizationserver.domain.user.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import team.sb.authorizationserver.domain.user.api.dto.request.EmailRequest;
import team.sb.authorizationserver.domain.user.api.dto.request.LoginRequest;
import team.sb.authorizationserver.domain.user.api.dto.request.SignupRequest;
import team.sb.authorizationserver.domain.user.service.UserService;
import team.sb.authorizationserver.global.security.jwt.dto.TokenResponse;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void signup(@RequestPart(required = false) MultipartFile profile,
                       @RequestPart @Valid SignupRequest signUpRequest) {
        userService.signup(profile, signUpRequest);
    }

    @PostMapping("/email")
    public void sendEmail(@RequestBody @Valid EmailRequest emailRequest) {
        userService.sendEmail(emailRequest);
    }

    @PostMapping("/auth")
    public String login(@RequestParam String clientId,
                        @RequestParam String redirectUri,
                        @RequestBody @Valid LoginRequest loginRequest) {
        return userService.login(loginRequest, clientId, redirectUri);
    }

    @PutMapping("/auth")
    public TokenResponse reissue(@RequestHeader("X-Refresh-Token") String refreshToken) {
        return userService.reissue(refreshToken);
    }

}