package team.sb.resourceserver.domain.user.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import team.sb.resourceserver.domain.user.entity.User;
import team.sb.resourceserver.global.exception.AuthenticationNotFoundException;
import team.sb.resourceserver.global.security.auth.AuthDetails;

@RequiredArgsConstructor
@Component
public class UserFacade {

    public User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(!(principal instanceof AuthDetails)) {
            throw AuthenticationNotFoundException.EXCEPTION;
        }

        return ((AuthDetails) principal).getUser();

    }

}
