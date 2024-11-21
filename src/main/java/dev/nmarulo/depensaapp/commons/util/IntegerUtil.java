package dev.nmarulo.depensaapp.commons.util;

import java.util.concurrent.atomic.AtomicReference;

public final class IntegerUtil {
    
    private IntegerUtil() {
    }
    
    public static Integer nullToZero(Integer integer) {
        return integer == null ? 0 : integer;
    }
    
    public static AtomicReference<Integer> newAtomicReference(Integer integer) {
        return new AtomicReference<>(nullToZero(integer));
    }
    
}
