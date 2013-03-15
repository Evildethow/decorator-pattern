package org.evildethow.decorator;

import java.util.ArrayList;
import java.util.List;

public class NotNullArrayListLongTest extends AbstractNotNullListTest<Long> {

    public NotNullArrayListLongTest() {
        super(0L, 1L, new TypeConstructor<List<Long>>() {
            @Override
            public List<Long> newInstance() {
                return new ArrayList<Long>();
            }
        });
    }

}