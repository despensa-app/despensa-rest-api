package dev.nmarulo.depensaapp.app.productshoppinglist;

import dev.nmarulo.depensaapp.app.products.Product;
import dev.nmarulo.depensaapp.app.shoppinglist.ShoppingList;
import dev.nmarulo.depensaapp.app.unitytypes.UnitType;
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
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shopping_list_id", insertable = false, updatable = false)
    private ShoppingList shoppingList;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_type_id", insertable = false, updatable = false)
    private UnitType unitType;
    
    public String toString() {return "ProductHasShoppingList(productHasShoppingListPK=" + this.getProductHasShoppingListPK() + ", unitsPerProduct=" + this.getUnitsPerProduct() + ", totalCalories=" + this.getTotalCalories() + ", totalPrice=" + this.getTotalPrice() + ", selected=" + this.getSelected() + ", product=" + this.getProduct() + ", shoppingList=" + this.getShoppingList() + ", unitType=" + this.getUnitType() + ")";}
    
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
        if (!Objects.equals(this$selected, other$selected)) {
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
        final Object $product = this.getProduct();
        result = result * PRIME + ($product == null ? 43 : $product.hashCode());
        final Object $shoppingList = this.getShoppingList();
        result = result * PRIME + ($shoppingList == null ? 43 : $shoppingList.hashCode());
        final Object $unitType = this.getUnitType();
        result = result * PRIME + ($unitType == null ? 43 : $unitType.hashCode());
        return result;
    }
    
}
