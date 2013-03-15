package org.evildethow.decorator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class NotNullArrayListStringTest {

    private static final String TEST = "test";
    private static final String ANOTHER_TEST = "another";
    private static final int EXPECTED_SIZE = 1;
    private List<String> testList;
    private List<String> nullList;
    private List<String> newList;
    private List<String> mixedNullAndElement;
    private List<String> mixedNonExistentAndElement;
    private List<String> mixedNonExistentAndNull;

    @Before
    public void init() {
        testList = new NotNullList<String>(new ArrayList<String>());
        testList.add(null);
        testList.add(TEST);
        nullList = new ArrayList<String>();
        nullList.add(null);
        newList = new ArrayList<String>();
        newList.add(ANOTHER_TEST);
        mixedNullAndElement = new ArrayList<String>();
        mixedNullAndElement.add(TEST);
        mixedNullAndElement.add(null);
        mixedNonExistentAndElement = new ArrayList<String>();
        mixedNonExistentAndElement.add(ANOTHER_TEST);
        mixedNonExistentAndElement.add(TEST);
        mixedNonExistentAndNull = new ArrayList<String>();
        mixedNonExistentAndNull.add(ANOTHER_TEST);
        mixedNonExistentAndNull.add(null);
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
        Assert.assertTrue(testList.contains(TEST));
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
        testList.add(ANOTHER_TEST);
        Assert.assertEquals(EXPECTED_SIZE + 1, testList.size());
    }

    @Test
    public void remove_Null() {
        testList.remove(null);
        Assert.assertEquals(EXPECTED_SIZE, testList.size());
    }

    @Test
    public void remove_NonExistentElement() {
        testList.remove(ANOTHER_TEST);
        Assert.assertEquals(EXPECTED_SIZE, testList.size());
    }

    @Test
    public void remove_Element() {
        testList.remove(TEST);
        Assert.assertEquals(EXPECTED_SIZE - 1, testList.size());
    }

    @Test
    public void containsAll_Null() {
        Assert.assertFalse(testList.containsAll(nullList));
    }

    @Test
    public void containsAll_NewElement() {
        testList.add(ANOTHER_TEST);
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
    public void retainAll_Unchanged() {
        Assert.assertFalse(testList.retainAll(testList));
    }

    @Test
    public void retainAll_Changed() {
        Assert.assertTrue(testList.retainAll(newList));
    }

    @Test
    public void set_Null() {
        Assert.assertEquals(null, testList.set(0, null));
    }

    @Test
    public void set_NewElement() {
        Assert.assertEquals(TEST, testList.set(0, ANOTHER_TEST));
    }

    @Test
    public void set_Element() {
        Assert.assertEquals(TEST, testList.set(0, TEST));
    }

    @Test
    public void set_NullAndIndexOutOfBounds() {
        Assert.assertEquals(null, testList.set(1, null));
    }

    @Test
    public void set_NewElementAndIndexOutOfBounds() {
        Assert.assertEquals(ANOTHER_TEST, testList.set(1, ANOTHER_TEST));
    }

    @Test
    public void set_ElementAndIndexOutOfBounds() {
        Assert.assertEquals(TEST, testList.set(1, TEST));
    }
}
