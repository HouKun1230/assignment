package com.uxpsystems.assignment.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 8831737280677588472L;



    @Id
    @NotNull(message = "Please enter id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Name is mandatory")
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotEmpty(message = "Password is mandatory")
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull(message = "Only possible values accepted")
    @Column(name = "status", nullable = false)
    private Status status;

    public User(long id, @NotEmpty(message = "Name is mandatory") String username, @NotEmpty(message = "Password is mandatory") String password, @NotNull(message = "Only possible values accepted") Status status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }

}

