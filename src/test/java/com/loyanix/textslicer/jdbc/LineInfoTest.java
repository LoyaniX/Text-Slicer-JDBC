package com.loyanix.textslicer.jdbc;

import com.loyanix.textslicer.jdbc.Services.LineInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LineInfoTest {

    String string = "Hello, you are a human";

    @Test
    public void findLongestWordTest(){
        Assert.assertEquals("Hello,",new LineInfo(string).getLongestWord());
    }
    @Test
    public void findShortestWordTest(){
        Assert.assertEquals("a",new LineInfo(string).getShortestWord());
    }

}
