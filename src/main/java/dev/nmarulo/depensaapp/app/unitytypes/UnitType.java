package dev.nmarulo.depensaapp.app.unitytypes;

import dev.nmarulo.depensaapp.app.productshoppinglist.ProductHasShoppingList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "unit_types")
public class UnitType {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Basic
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    
    @Basic
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Basic
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_type_id")
    private Set<ProductHasShoppingList> productHasShoppingList;
    
    public UnitType() {
        this.productHasShoppingList = new HashSet<>();
    }
    
    public String toString() {return "UnitType(id=" + this.getId() + ", name=" + this.getName() + ", createdAt=" + this.getCreatedAt() + ", updatedAt=" + this.getUpdatedAt() + ", productHasShoppingList=" + this.getProductHasShoppingList() + ")";}
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof UnitType other)) {
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
    
    protected boolean canEqual(final Object other) {return other instanceof UnitType;}
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final Object $updatedAt = this.getUpdatedAt();
        result = result * PRIME + ($updatedAt == null ? 43 : $updatedAt.hashCode());
        final Object $productHasShoppingList = this.getProductHasShoppingList();
        result = result * PRIME + ($productHasShoppingList == null ? 43 : $productHasShoppingList.hashCode());
        return result;
    }
    
}
