package kz.alken1t.alex.ecarsprojectforspring.security;

import kz.alken1t.alex.ecarsprojectforspring.entity.Users;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class UserDetailsImp implements UserDetails {

    private final Users users;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role = users.getRole().toLowerCase();
        GrantedAuthorityImpl grantedAuthority = new GrantedAuthorityImpl(role,true);
        return List.of(grantedAuthority);
    }

    @Override
    public String getUsername() {
        return users.getEmail();
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
