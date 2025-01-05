package dev.nmarulo.despensa_app.app.pantry.product_categories;

import dev.nmarulo.despensa_app.app.pantry.products.Product;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "product_categories")
public class ProductCategory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    
    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "productCategories", fetch = FetchType.LAZY)
    private Set<Product> products;
    
    /**
     * Categoría padre. Nulo si es la categoría padre.
     */
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_categories_id")
    private ProductCategory productCategories;
    
    @OneToMany(mappedBy = "productCategories")
    private Set<ProductCategory> subcategories;
    
    public ProductCategory() {
        this.products = new HashSet<>();
        this.subcategories = new HashSet<>();
    }
    
}
