package com.warroom.poker.model;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserProfile {

    @Id
    @GeneratedValue(generator = "UUID") 
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID playerId;

    private String userName;
    private String password;
    private int chips; // Start with a default value, e.g., 1000 chips

    // Getter and Setter for username and password + playerId
    public UUID getPlayerId(){
        return playerId;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and Setter for chips
    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    // Setter for chips with winnings or losses (delta value)
    public void updateChips(int delta) {
        this.chips += delta;  // This will add winnings or subtract losses directly
    }

    // Optional: constructor for easy creation
    public UserProfile(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.chips = 1000;  // Start with 1000 chips by default
    }

    public UserProfile() {
        // Default constructor for JPA
    }
}
