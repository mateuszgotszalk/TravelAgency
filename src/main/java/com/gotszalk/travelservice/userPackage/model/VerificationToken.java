package com.gotszalk.travelservice.userPackage.model;


import javax.persistence.*;
import java.security.PrivateKey;
import java.time.Instant;

@Entity
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tokenId;
    private String token;
    @OneToOne(fetch = FetchType.LAZY)
    private User user;
    private Instant expiryDate;

    public VerificationToken() {
    }

    public VerificationToken(Long tokenId, String token, User user, Instant expiryDate) {
        this.tokenId = tokenId;
        this.token = token;
        this.user = user;
        this.expiryDate = expiryDate;
    }

    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instant getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Instant expiryDate) {
        this.expiryDate = expiryDate;
    }
}
