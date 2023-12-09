package dev.nmarulo.depensaapp.app.shoppinglist;

import dev.nmarulo.depensaapp.app.productshoppinglist.ProductHasShoppingList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "shopping_list")
public class ShoppingList {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Basic
    @Column(name = "name", nullable = false, length = 250)
    private String name;
    
    @Column(name = "total_products", nullable = false)
    private Integer totalProducts;
    
    @Basic
    @Column(name = "total_calories", nullable = false, precision = 2)
    private BigDecimal totalCalories;
    
    @Basic
    @Column(name = "total_price", nullable = false, precision = 2)
    private BigDecimal totalPrice;
    
    @Basic
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Basic
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "shopping_list_id")
    private Set<ProductHasShoppingList> productHasShoppingList;
    
    public ShoppingList() {
        this.productHasShoppingList = new HashSet<>();
    }
    
    public String toString() {return "ShoppingList(id=" + this.getId() + ", name=" + this.getName() + ", totalProducts=" + this.getTotalProducts() + ", totalCalories=" + this.getTotalCalories() + ", totalPrice=" + this.getTotalPrice() + ", createdAt=" + this.getCreatedAt() + ", updatedAt=" + this.getUpdatedAt() + ", productHasShoppingList=" + this.getProductHasShoppingList() + ")";}
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ShoppingList other)) {
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
        final Object this$totalProducts = this.getTotalProducts();
        final Object other$totalProducts = other.getTotalProducts();
        if (!Objects.equals(this$totalProducts, other$totalProducts)) {
            return false;
        }
        final Object this$totalCalories = this.getTotalCalories();
        final Object other$totalCalories = other.getTotalCalories();
        if (!Objects.equals(this$totalCalories, other$totalCalories)) {
            return false;
        }
        final Object this$totalPrice = this.getTotalPrice();
        final Object other$totalPrice = other.getTotalPrice();
        if (!Objects.equals(this$totalPrice, other$totalPrice)) {
            return false;
        }
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (!Objects.equals(this$createdAt, other$createdAt)) {
            return false;
        }
        final Object this$updatedAt = this.getUpdatedAt();
        final Object other$updatedAt = other.getUpdatedAt();
        if (!Objects.equals(this$updatedAt, other$updatedAt)) {
            return false;
        }
        final Object this$productHasShoppingList = this.getProductHasShoppingList();
        final Object other$productHasShoppingList = other.getProductHasShoppingList();
        return Objects.equals(this$productHasShoppingList, other$productHasShoppingList);
    }
    
    protected boolean canEqual(final Object other) {return other instanceof ShoppingList;}
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $totalProducts = this.getTotalProducts();
        result = result * PRIME + ($totalProducts == null ? 43 : $totalProducts.hashCode());
        final Object $totalCalories = this.getTotalCalories();
        result = result * PRIME + ($totalCalories == null ? 43 : $totalCalories.hashCode());
        final Object $totalPrice = this.getTotalPrice();
        result = result * PRIME + ($totalPrice == null ? 43 : $totalPrice.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final Object $updatedAt = this.getUpdatedAt();
        result = result * PRIME + ($updatedAt == null ? 43 : $updatedAt.hashCode());
        final Object $productHasShoppingList = this.getProductHasShoppingList();
        result = result * PRIME + ($productHasShoppingList == null ? 43 : $productHasShoppingList.hashCode());
        return result;
    }
    
}
