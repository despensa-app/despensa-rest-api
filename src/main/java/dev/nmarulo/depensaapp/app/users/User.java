package dev.nmarulo.depensaapp.app.users;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
@ToString
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Column(name = "username", nullable = false, length = 45)
    private String username;
    
    @Column(name = "password", nullable = false, length = 60)
    private String password;
    
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    
    @Basic
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Basic
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
}
