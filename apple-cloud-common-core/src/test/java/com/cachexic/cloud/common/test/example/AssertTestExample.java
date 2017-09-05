package com.cachexic.cloud.common.test.example;

import com.cachexic.cloud.common.exceptions.BizException;
import com.cachexic.cloud.common.exceptions.BizPreconditions;
import com.cachexic.cloud.common.test.TestParent;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author tangmin
 * @version V1.0
 * @Title: AssertTestExample.java
 * @Package com.cachexic.sjdbc.common.junit.example
 * @Description: 
 * @date 2017-09-02 13:54:04
 */
public class AssertTestExample extends TestParent {

    @Test(expected = BizException.class)
    public void staticImportAssertAndMockito(){
        assertFalse(false);
        assertFalse("error reson...",false);

        assertTrue(true);
        assertTrue("error reson...",true);

        assertThat(1, is(1));
        assertThat("error ..reason",1, is(1));

        assertEquals("ABC","ABC");
        assertNotEquals("abc","ABC");

        assertNull(null);
        assertNotNull(new Object());

        Object o = new Object();
        Object o1 = o;
        assertSame(o,o1);
        assertNotSame(new Object(),new Object());

        BizPreconditions.checkState(false);
        BizPreconditions.checkState(false,"密码错误");
    }
}
