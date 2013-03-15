package org.evildethow.decorator;

import java.util.ArrayList;
import java.util.List;

public class NotNullArrayListBooleanTest extends AbstractNotNullListTest<Boolean> {

    public NotNullArrayListBooleanTest() {
        super(true, false, new TypeConstructor<List<Boolean>>() {
            @Override
            public List<Boolean> newInstance() {
                return new ArrayList<Boolean>();
            }
        });
    }
}
