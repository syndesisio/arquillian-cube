package org.arquillian.cube.kubernetes.impl;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by iocanel on 6/7/17.
 */
public class DefaultConfigurationTest {
    @Test
    public void filterEnvironmentVariables() throws Exception {

        Map<String, String> map = new HashMap<>();
        map.put("KEY1", "VALUE1");
        map.put("KEY_TWO", "VALUE2");
        map.put("env.KEY3", "VALUE3");
        map.put("env.key4", "VALUE4");
        map.put("env.KEY_5", "VALUE5");

        Map<String, String> result = DefaultConfiguration.filterEnvironmentVariables(map);
        Assert.assertEquals(3, result.size());
        Assert.assertTrue(result.containsKey("KEY3"));
        Assert.assertTrue(result.containsKey("key4"));
        Assert.assertTrue(result.containsKey("KEY_5"));
    }

}

