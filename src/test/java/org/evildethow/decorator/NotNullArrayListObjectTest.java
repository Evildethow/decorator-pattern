package org.evildethow.decorator;

import java.util.ArrayList;
import java.util.List;

public class NotNullArrayListObjectTest extends AbstractNotNullListTest<Object> {

    public NotNullArrayListObjectTest() {
        super("string", 1, new TypeConstructor<List<Object>>() {
            @Override
            public List<Object> newInstance() {
                return new ArrayList<Object>();
            }
        });
    }
}
