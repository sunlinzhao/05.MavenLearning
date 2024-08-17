package com.slz.app;

import org.junit.Test;
import org.junit.Assert;

/**
 * @author : SunLZ
 * @project : MavenLearning
 * @date : 2024/8/17
 */
public class TestAdd {
    @Test
    public void testAdd(){
        Add m = new Add();
        int result = m.add(10, 10);
        Assert.assertEquals(20, result);
    }
}
