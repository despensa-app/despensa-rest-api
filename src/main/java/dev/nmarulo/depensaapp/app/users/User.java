package dev.nmarulo.depensaapp.app.users;

import dev.nmarulo.depensaapp.app.shoppinglist.ShoppingList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
@ToString
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "username", nullable = false, length = 45)
    private String username;
    
    @Column(name = "password", nullable = false, length = 60)
    private String password;
    
    @Column(name = "email", length = 100)
    private String email;
    
    @Basic
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Basic
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private Set<ShoppingList> shoppingLists;
    
    public User() {
        this.shoppingLists = new LinkedHashSet<>();
    }
    
}
