package com.luxsoft.datastructure.reflection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReflectionUtilsTest {

    @Test
    public void testClearPrivateFieldsDataWithFromNull() throws IllegalAccessException {
        Assertions.assertThrows(NullPointerException.class, () ->
                ReflectionUtils.changeFieldsToDefault(null));

        try {
            ReflectionUtils.changeFieldsToDefault(null);
        } catch (NullPointerException exception) {
            assertEquals("Null is not supported", exception.getMessage());
        }
    }
}
