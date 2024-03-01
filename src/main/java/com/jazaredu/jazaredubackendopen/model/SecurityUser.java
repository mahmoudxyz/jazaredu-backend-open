package com.jazaredu.jazaredubackendopen.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SecurityUser implements UserDetails {

    private static final String ROLE_PREFIX = "ROLE_";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @OneToOne
    @JoinColumn(name = "user_profile_id")
    private UserProfile user;

    public SecurityUser(UserProfile user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println();
        return user.getRoles().stream()
                .map((Role role) -> new SimpleGrantedAuthority(ROLE_PREFIX + role.name()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Assuming account locking functionality is not implemented yet
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Assuming credentials expiration functionality is not implemented yet
    }

    @Override
    public boolean isEnabled() {
        return true; // Assuming account enabling functionality is not implemented yet
    }
}
