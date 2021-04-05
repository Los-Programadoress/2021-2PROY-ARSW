package edu.eci.arsw.lacman.logic;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "games")
public class Game implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "passcode")
    private String passcode;

    public Game() {
    }

    public Game(Long id, String name, String passcode) {
        this.id = id;
        this.name = name;
        this.passcode = passcode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Game game = (Game) o;
        return passcode == game.passcode && Objects.equals(id, game.id) && Objects.equals(name, game.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, passcode);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Games{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", passCode=").append(passcode);
        sb.append('}');
        return sb.toString();
    }
}