package jp.shoheisawachika.presentation;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class UserInterceptor implements HandlerInterceptor {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // ModelAndViewがnullでないかつViewがレンダリングされる場合のみ処理を行う
        if (modelAndView != null && !isRedirectView(modelAndView)) {
            // ここでログインユーザー情報を取得するロジックを実装
            // 例えば、SecurityContextHolderからユーザー詳細を取得
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            String username = (principal instanceof UserDetails) ? ((UserDetails) principal).getUsername() : principal.toString();
            String username = (principal instanceof UserDetails) ? ((UserDetails) principal).getUsername() : null;

            // モデルにユーザー情報を追加
            modelAndView.addObject("username", username);
            
            Set<String> roles = (principal instanceof UserDetails) ? ((UserDetails) principal).getAuthorities().stream()
            		.map(simpleGrantedAuthority -> simpleGrantedAuthority.toString())
            		.collect(Collectors.toSet()) : null;
            modelAndView.addObject("roles", roles);
        }
    }

    private boolean isRedirectView(ModelAndView modelAndView) {
        String viewName = modelAndView.getViewName();
        return viewName != null && viewName.startsWith("redirect:");
    }
}