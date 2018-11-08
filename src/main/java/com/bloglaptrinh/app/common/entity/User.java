package com.bloglaptrinh.app.common.entity;

import com.bloglaptrinh.app.common.utils.JsonConverter;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends JsonConverter<User> implements Serializable {
    private long id;
    private String loginId;
    private String loginPassword;
    private String reLoginPassword;
    private String firstName;
    private String lastName;
    private String nickname;
    private String email;
    private String role;
    private String description;
    private LocalDateTime createdAt = LocalDateTime.now();

    private String createdBy;

    private LocalDateTime updatedAt = LocalDateTime.now();

    private String updatedBy;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
