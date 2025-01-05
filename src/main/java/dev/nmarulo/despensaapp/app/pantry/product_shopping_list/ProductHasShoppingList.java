package dev.nmarulo.despensaapp.app.pantry.product_shopping_list;

import dev.nmarulo.despensaapp.app.pantry.products.Product;
import dev.nmarulo.despensaapp.app.pantry.unitytypes.UnitType;
import dev.nmarulo.despensaapp.app.pantry.shoppinglist.ShoppingList;
import dev.nmarulo.despensaapp.commons.gson.GsonExclude;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "products_has_shopping_list")
@ToString
public class ProductHasShoppingList {
    
    @EmbeddedId
    private ProductHasShoppingListPK productHasShoppingListPK;
    
    @Basic
    @Column(name = "units_per_product", nullable = false)
    private Integer unitsPerProduct;
    
    @Basic
    @Column(name = "total_calories", nullable = false, precision = 2)
    private BigDecimal totalCalories;
    
    @Basic
    @Column(name = "total_price", nullable = false, precision = 2)
    private BigDecimal totalPrice;
    
    @Column(name = "selected", nullable = false)
    private boolean selected;
    
    @Basic
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @Basic
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    @ToString.Exclude
    @GsonExclude
    private Product product;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shopping_list_id", insertable = false, updatable = false)
    @ToString.Exclude
    @GsonExclude
    private ShoppingList shoppingList;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_type_id", insertable = false, updatable = false)
    @ToString.Exclude
    @GsonExclude
    private UnitType unitType;
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ProductHasShoppingList other)) {
            return false;
        }
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$productHasShoppingListPK = this.getProductHasShoppingListPK();
        final Object other$productHasShoppingListPK = other.getProductHasShoppingListPK();
        if (!Objects.equals(this$productHasShoppingListPK, other$productHasShoppingListPK)) {
            return false;
        }
        final Object this$unitsPerProduct = this.getUnitsPerProduct();
        final Object other$unitsPerProduct = other.getUnitsPerProduct();
        if (!Objects.equals(this$unitsPerProduct, other$unitsPerProduct)) {
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
        return this.isSelected() == other.isSelected();
    }
    
    protected boolean canEqual(final Object other) {return other instanceof ProductHasShoppingList;}
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $productHasShoppingListPK = this.getProductHasShoppingListPK();
        result = result * PRIME + ($productHasShoppingListPK == null ? 43 : $productHasShoppingListPK.hashCode());
        final Object $unitsPerProduct = this.getUnitsPerProduct();
        result = result * PRIME + ($unitsPerProduct == null ? 43 : $unitsPerProduct.hashCode());
        final Object $totalCalories = this.getTotalCalories();
        result = result * PRIME + ($totalCalories == null ? 43 : $totalCalories.hashCode());
        final Object $totalPrice = this.getTotalPrice();
        result = result * PRIME + ($totalPrice == null ? 43 : $totalPrice.hashCode());
        result = result * PRIME + (this.isSelected() ? 79 : 97);
        return result;
    }
    
}
