package com.example.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name="User_Data")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @Column(name = "email", nullable = false)
        private String email;

        @Column(name = "password")
        private String passwrod;

        @Column(name = "first_name")
        private String firstName;

        @Column(name = "last_name")
        private String lastName;



        @Column(name = "enabled")
        private boolean enabled;

        @Column(name = "username")
        private String userName;

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
        private Collection<Role> roles;

        public User(){}

        public User(String email, String passwrod, String firstName, String lastName,boolean enabled,String userName ){
            this.setEmail(email);
            this.setPasswrod(passwrod);
            this.setFirstName(firstName);
            this.setLastName(lastName);
            this.setEnabled(enabled);
            this.setUserName(userName);
        }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.passwrod = passwordEncoder.encode(passwrod);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}


