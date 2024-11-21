package dev.nmarulo.depensaapp.commons.util;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

public final class BigDecimalUtil {
    
    private BigDecimalUtil() {
    }
    
    public static BigDecimal multiply(BigDecimal bigDecimal, Integer integer) {
        return bigDecimal.multiply(valueOf(integer));
    }
    
    public static BigDecimal valueOf(Integer integer) {
        if (integer == null) {
            return BigDecimal.ZERO;
        }
        
        return new BigDecimal(integer);
    }
    
    public static BigDecimal nullToZero(BigDecimal bigDecimal) {
        return bigDecimal == null ? BigDecimal.ZERO : bigDecimal;
    }
    
    public static AtomicReference<BigDecimal> newAtomicReference(BigDecimal bigDecimal) {
        return new AtomicReference<>(nullToZero(bigDecimal));
    }
    
}
