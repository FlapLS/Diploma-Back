package ru.authservice.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.authservice.application.auth.model.CustomerDto;
import ru.authservice.utils.JwtUtils;
import static org.springframework.util.StringUtils.hasText;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;
    private final ObjectMapper objectMapper;

    @Override
    public void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
                                 @NonNull FilterChain filterChain)
            throws IOException, ServletException {
        String token = getTokenFromRequest(request);
        if (token != null && jwtUtils.validateToken(token)) {
            CustomerDto customerDto = objectMapper.readValue(jwtUtils.getWordForToken(token), CustomerDto.class);

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(customerDto, null,
                            AuthorityUtils.commaSeparatedStringToAuthorityList(
                                    "ROLE_".concat(customerDto.getRole().name())
                            )
                    );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String AUTHORIZATION = "Authorization";
        String bearer = request.getHeader(AUTHORIZATION);
        if (hasText(bearer) && bearer.startsWith("Bearer ")) {
            return bearer.substring(7);
        }
        return null;
    }

}
