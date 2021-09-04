package com.despegar.test.controller;

import com.despegar.test.helpers.Dictionary;
import org.junit.Assert;

public class AssertController {

    private AssertController(){}

    public static void compare(String field, String expected, String found){
        Assert.assertTrue(
            String.format(Dictionary.Messages.COMPARE, field, expected, found),
            expected.equalsIgnoreCase(found)
        );
    }

}
