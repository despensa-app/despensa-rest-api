package dev.nmarulo.depensaapp.app.productshoppinglist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class ProductHasShoppingListPK implements Serializable {
    
    @Column(name = "product_id", nullable = false)
    private Long productId;
    
    @Column(name = "shopping_list_id", nullable = false)
    private Long shoppingListId;
    
    @Column(name = "unit_type_id", nullable = false)
    private Long unitTypeId;
    
    public String toString() {return "ProductHasShoppingListPK(productId=" + this.getProductId() + ", shoppingListId=" + this.getShoppingListId() + ", unitTypeId=" + this.getUnitTypeId() + ")";}
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ProductHasShoppingListPK other)) {
            return false;
        }
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$product = this.getProductId();
        final Object other$product = other.getProductId();
        if (!Objects.equals(this$product, other$product)) {
            return false;
        }
        final Object this$shoppingList = this.getShoppingListId();
        final Object other$shoppingList = other.getShoppingListId();
        if (!Objects.equals(this$shoppingList, other$shoppingList)) {
            return false;
        }
        final Object this$unitType = this.getUnitTypeId();
        final Object other$unitType = other.getUnitTypeId();
        return Objects.equals(this$unitType, other$unitType);
    }
    
    protected boolean canEqual(final Object other) {return other instanceof ProductHasShoppingListPK;}
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $product = this.getProductId();
        result = result * PRIME + ($product == null ? 43 : $product.hashCode());
        final Object $shoppingList = this.getShoppingListId();
        result = result * PRIME + ($shoppingList == null ? 43 : $shoppingList.hashCode());
        final Object $unitType = this.getUnitTypeId();
        result = result * PRIME + ($unitType == null ? 43 : $unitType.hashCode());
        return result;
    }
    
}
