package org.evildethow.decorator;

import java.util.ArrayList;
import java.util.List;

public class NotNullArrayListEnumTest extends AbstractNotNullListTest<Enum> {

    public NotNullArrayListEnumTest() {
        super(Status.NORMAL, Status.ERROR, new TypeConstructor<List<Enum>>() {
            @Override
            public List<Enum> newInstance() {
                return new ArrayList<Enum>();
            }
        });
    }

    public enum Status {
        ERROR,
        NORMAL
    }
}
