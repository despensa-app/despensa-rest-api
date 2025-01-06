package dev.nmarulo.despensa_app.app.pantry.products;

import dev.nmarulo.despensa_app.app.pantry.product_categories.ProductCategory;
import dev.nmarulo.despensa_app.app.pantry.product_images.ProductImage;
import dev.nmarulo.despensa_app.app.pantry.product_shopping_list.ProductHasShoppingList;
import dev.nmarulo.despensa_app.app.pantry.supermarkets.Supermarket;
import dev.nmarulo.despensa_app.commons.gson.GsonExclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
@ToString
public class Product {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Basic
    @Column(name = "name", nullable = false)
    private String name;
    
    @Basic
    @Column(name = "price", nullable = false, precision = 2)
    private BigDecimal price;
    
    @Basic
    @Column(name = "calories", nullable = false, precision = 2)
    private BigDecimal calories;
    
    @Basic
    @Column(name = "description")
    private String description;
    
    @Basic
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Basic
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @ToString.Exclude
    @GsonExclude
    private Set<ProductHasShoppingList> productHasShoppingList;
    
    @ToString.Exclude
    @OneToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private Set<ProductImage> productImages;
    
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "supermarkets_id", nullable = false)
    private Supermarket supermarkets;
    
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_categories_id", nullable = false)
    private ProductCategory productCategories;
    
    public Product() {
        this.productHasShoppingList = new HashSet<>();
        this.productImages = new HashSet<>();
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Product other)) {
            return false;
        }
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (!Objects.equals(this$id, other$id)) {
            return false;
        }
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (!Objects.equals(this$name, other$name)) {
            return false;
        }
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (!Objects.equals(this$price, other$price)) {
            return false;
        }
        final Object this$calories = this.getCalories();
        final Object other$calories = other.getCalories();
        if (!Objects.equals(this$calories, other$calories)) {
            return false;
        }
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (!Objects.equals(this$description, other$description)) {
            return false;
        }
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (!Objects.equals(this$createdAt, other$createdAt)) {
            return false;
        }
        final Object this$updatedAt = this.getUpdatedAt();
        final Object other$updatedAt = other.getUpdatedAt();
        return Objects.equals(this$updatedAt, other$updatedAt);
    }
    
    protected boolean canEqual(final Object other) {return other instanceof Product;}
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final Object $calories = this.getCalories();
        result = result * PRIME + ($calories == null ? 43 : $calories.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final Object $updatedAt = this.getUpdatedAt();
        result = result * PRIME + ($updatedAt == null ? 43 : $updatedAt.hashCode());
        return result;
    }
    
}
