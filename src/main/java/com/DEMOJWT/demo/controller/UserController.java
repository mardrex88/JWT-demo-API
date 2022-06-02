package com.DEMOJWT.demo.controller;

import com.DEMOJWT.demo.Model.UserModel;
import com.DEMOJWT.demo.Repository.UserRepository;
import com.DEMOJWT.demo.dto.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("login")
    public User login(@RequestBody User user) {

        UserModel userModel = userRepository.findByUsername(user.getUser());

        if (!(user.getPwd().equals(userModel.getPassword()))){
            throw new RuntimeException("Usuario o contraseña incorrecta");
        }

        String token = getJWTToken(user.getUser());
        User userOk = new User();
        userOk.setUser(user.getUser());
        userOk.setToken(token);

        return userOk;


    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("sofkaJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Valido " + token;
    }
}
