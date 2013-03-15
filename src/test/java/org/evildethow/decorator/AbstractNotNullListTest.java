package org.evildethow.decorator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

@Ignore
public abstract class AbstractNotNullListTest<T> {

    private final T test;
    private final T anotherTest;
    private final TypeConstructor<List<T>> type;
    private static final int EXPECTED_SIZE = 1;
    private List<T> testList;
    private List<T> nullList;
    private List<T> newList;
    private List<T> mixedNullAndElement;
    private List<T> mixedNonExistentAndElement;
    private List<T> mixedNonExistentAndNull;
    private List<T> emptyList;

    protected AbstractNotNullListTest(T test, T anotherTest, TypeConstructor<List<T>> type) {
        this.test = test;
        this.anotherTest = anotherTest;
        this.type = type;
    }

    @Before
    public void init() {
        testList = new NotNullList<T>(type.newInstance());
        testList.add(null);
        testList.add(test);
        nullList = type.newInstance();
        nullList.add(null);
        newList = type.newInstance();
        newList.add(anotherTest);
        mixedNullAndElement = type.newInstance();
        mixedNullAndElement.add(test);
        mixedNullAndElement.add(null);
        mixedNonExistentAndElement = type.newInstance();
        mixedNonExistentAndElement.add(anotherTest);
        mixedNonExistentAndElement.add(test);
        mixedNonExistentAndNull = type.newInstance();
        mixedNonExistentAndNull.add(anotherTest);
        mixedNonExistentAndNull.add(null);
        emptyList = type.newInstance();
    }

    @Test
    public void size() {
        Assert.assertEquals(EXPECTED_SIZE, testList.size());
    }

    @Test
    public void isEmpty() {
        Assert.assertFalse(testList.isEmpty());
    }

    @Test
    public void contains() {
        Assert.assertTrue(testList.contains(test));
    }

    @Test
    public void iterator() {
        Assert.assertNotNull(testList.iterator());
    }

    @Test
    public void toArray() {
        Assert.assertEquals(EXPECTED_SIZE, testList.toArray().length);
    }

    @Test
    public void add_Null() {
        testList.add(null);
        Assert.assertEquals(EXPECTED_SIZE, testList.size());
    }

    @Test
    public void add_Element() {
        testList.add(anotherTest);
        Assert.assertEquals(EXPECTED_SIZE + 1, testList.size());
    }

    @Test
    public void remove_Null() {
        testList.remove(null);
        Assert.assertEquals(EXPECTED_SIZE, testList.size());
    }

    @Test
    public void remove_NonExistentElement() {
        testList.remove(anotherTest);
        Assert.assertEquals(EXPECTED_SIZE, testList.size());
    }

    @Test
    public void remove_Element() {
        testList.remove(test);
        Assert.assertEquals(EXPECTED_SIZE - 1, testList.size());
    }

    @Test
    public void containsAll_Null() {
        Assert.assertFalse(testList.containsAll(nullList));
    }

    @Test
    public void containsAll_NewElement() {
        testList.add(anotherTest);
        Assert.assertTrue(testList.containsAll(testList));
    }

    @Test
    public void containsAll_NonExistentElement() {
        Assert.assertFalse(testList.containsAll(newList));
    }

    @Test
    public void containsAll_Element() {
        Assert.assertTrue(testList.containsAll(testList));
    }

    @Test
    public void containsAll_NonExistentElementAndElement() {
        Assert.assertFalse(testList.containsAll(mixedNonExistentAndElement));
    }

    @Test
    public void containsAll_NullAndElement() {
        Assert.assertFalse(testList.containsAll(mixedNullAndElement));
    }

    @Test
    public void containsAll_NonExistentElementAndNull() {
        Assert.assertFalse(testList.containsAll(mixedNonExistentAndNull));
    }

    @Test
    public void containsAll_EmptyElement() {
        Assert.assertFalse(testList.containsAll(emptyList));
    }

    @Test
    public void addAll_Null() {
        Assert.assertFalse(testList.addAll(nullList));
    }

    @Test
    public void addAll_NewElement() {
        Assert.assertTrue(testList.addAll(newList));
    }

    @Test
    public void addAll_Element() {
        Assert.assertTrue(testList.addAll(testList));
    }

    @Test
    public void addAll_EmptyElement() {
        Assert.assertFalse(testList.addAll(emptyList));
    }

    @Test
    public void removeAll_Null() {
        Assert.assertFalse(testList.removeAll(nullList));
    }

    @Test
    public void removeAll_NewElement() {
        Assert.assertFalse(testList.removeAll(newList));
    }

    @Test
    public void removeAll_Element() {
        Assert.assertTrue(testList.removeAll(testList));
    }

    @Test
    public void removeAll_NonExistentElementAndElement() {
        Assert.assertTrue(testList.removeAll(mixedNonExistentAndElement));
    }

    @Test
    public void removeAll_NullAndElement() {
        Assert.assertFalse(testList.removeAll(mixedNullAndElement));
    }

    @Test
    public void removeAll_NonExistentElementAndNull() {
        Assert.assertFalse(testList.removeAll(mixedNonExistentAndNull));
    }

    @Test
    public void removeAll_EmptyElement() {
        Assert.assertFalse(testList.removeAll(emptyList));
    }

    @Test
    public void retainAll_Unchanged() {
        Assert.assertFalse(testList.retainAll(testList));
    }

    @Test
    public void retainAll_Changed() {
        Assert.assertTrue(testList.retainAll(newList));
    }

    @Test
    public void retainAll_EmptyElement() {
        Assert.assertTrue(testList.retainAll(emptyList));
    }

    @Test
    public void set_Null() {
        Assert.assertEquals(null, testList.set(0, null));
    }

    @Test
    public void set_NewElement() {
        Assert.assertEquals(test, testList.set(0, anotherTest));
    }

    @Test
    public void set_Element() {
        Assert.assertEquals(test, testList.set(0, test));
    }

    @Test
    public void set_NullAndIndexOutOfBounds() {
        Assert.assertEquals(null, testList.set(1, null));
    }

    @Test
    public void set_NewElementAndIndexOutOfBounds() {
        Assert.assertEquals(anotherTest, testList.set(1, anotherTest));
    }

    @Test
    public void set_ElementAndIndexOutOfBounds() {
        Assert.assertEquals(test, testList.set(1, test));
    }
}
