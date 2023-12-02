package dev.nmarulo.depensaapp.app.productshoppinglist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products_has_shopping_list")
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
    
    @Column(name = "selected")
    private Boolean selected;
    
    public String toString() {return "ProductHasShoppingList(productHasShoppingListPK=" + this.getProductHasShoppingListPK() + ", unitsPerProduct=" + this.getUnitsPerProduct() + ", totalCalories=" + this.getTotalCalories() + ", totalPrice=" + this.getTotalPrice() + ", selected=" + this.getSelected() + ")";}
    
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
        final Object this$selected = this.getSelected();
        final Object other$selected = other.getSelected();
        return Objects.equals(this$selected, other$selected);
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
        final Object $selected = this.getSelected();
        result = result * PRIME + ($selected == null ? 43 : $selected.hashCode());
        return result;
    }
    
}
