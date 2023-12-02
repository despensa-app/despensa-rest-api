package dev.nmarulo.depensaapp.app.productshoppinglist;

import dev.nmarulo.depensaapp.app.products.Product;
import dev.nmarulo.depensaapp.app.shoppinglist.ShoppingList;
import dev.nmarulo.depensaapp.app.unitytypes.UnitType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class ProductHasShoppingListPK implements Serializable {
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private ShoppingList shoppingList;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private UnitType unitType;
    
    public String toString() {return "ProductHasShoppingListPK(product=" + this.getProduct() + ", shoppingList=" + this.getShoppingList() + ", unitType=" + this.getUnitType() + ")";}
    
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
        final Object this$product = this.getProduct();
        final Object other$product = other.getProduct();
        if (!Objects.equals(this$product, other$product)) {
            return false;
        }
        final Object this$shoppingList = this.getShoppingList();
        final Object other$shoppingList = other.getShoppingList();
        if (!Objects.equals(this$shoppingList, other$shoppingList)) {
            return false;
        }
        final Object this$unitType = this.getUnitType();
        final Object other$unitType = other.getUnitType();
        return Objects.equals(this$unitType, other$unitType);
    }
    
    protected boolean canEqual(final Object other) {return other instanceof ProductHasShoppingListPK;}
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $product = this.getProduct();
        result = result * PRIME + ($product == null ? 43 : $product.hashCode());
        final Object $shoppingList = this.getShoppingList();
        result = result * PRIME + ($shoppingList == null ? 43 : $shoppingList.hashCode());
        final Object $unitType = this.getUnitType();
        result = result * PRIME + ($unitType == null ? 43 : $unitType.hashCode());
        return result;
    }
    
}
