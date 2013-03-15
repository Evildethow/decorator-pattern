package org.evildethow.decorator;

import java.util.ArrayList;
import java.util.List;

public class NotNullArrayListIntegerTest extends AbstractNotNullListTest<Integer> {

    public NotNullArrayListIntegerTest() {
        super(0, 1, new TypeConstructor<List<Integer>>() {
            @Override
            public List<Integer> newInstance() {
                return new ArrayList<Integer>();
            }
        });
    }
}
