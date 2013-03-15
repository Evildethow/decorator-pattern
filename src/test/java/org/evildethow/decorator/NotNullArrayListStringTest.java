package org.evildethow.decorator;

import java.util.ArrayList;
import java.util.List;


public class NotNullArrayListStringTest extends AbstractNotNullListTest<String> {

    public NotNullArrayListStringTest() {
        super("test", "another", new TypeConstructor<List<String>>() {
            @Override
            public List<String> newInstance() {
                return new ArrayList<String>();
            }
        });
    }
}
