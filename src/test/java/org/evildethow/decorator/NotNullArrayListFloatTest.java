package org.evildethow.decorator;

import java.util.ArrayList;
import java.util.List;

public class NotNullArrayListFloatTest extends AbstractNotNullListTest<Float> {

    public NotNullArrayListFloatTest() {
        super(0.0f, 1.0f, new TypeConstructor<List<Float>>() {
            @Override
            public List<Float> newInstance() {
                return new ArrayList<Float>();
            }
        });
    }
}
