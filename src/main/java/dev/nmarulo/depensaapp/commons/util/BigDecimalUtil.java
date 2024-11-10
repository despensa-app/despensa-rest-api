package dev.nmarulo.depensaapp.commons.util;

import java.math.BigDecimal;

public final class BigDecimalUtil {
    
    private BigDecimalUtil() {
    }
    
    public static BigDecimal multiply(BigDecimal bigDecimal, Integer integer) {
        return bigDecimal.multiply(new BigDecimal(integer));
    }
    
}
