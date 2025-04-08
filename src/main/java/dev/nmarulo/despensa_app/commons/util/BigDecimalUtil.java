package dev.nmarulo.despensa_app.commons.util;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

public final class BigDecimalUtil {
    
    private BigDecimalUtil() {
    }
    
    public static BigDecimal multiply(final BigDecimal bigDecimal, final Integer integer) {
        return bigDecimal.multiply(valueOf(integer));
    }
    
    public static BigDecimal valueOf(final Integer integer) {
        if (integer == null) {
            return BigDecimal.ZERO;
        }
        
        return new BigDecimal(integer);
    }
    
    public static BigDecimal nullToZero(final BigDecimal bigDecimal) {
        return bigDecimal == null ? BigDecimal.ZERO : bigDecimal;
    }
    
    public static AtomicReference<BigDecimal> newAtomicReference(final BigDecimal bigDecimal) {
        return new AtomicReference<>(nullToZero(bigDecimal));
    }
    
}
