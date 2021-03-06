package com.octo.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml" })
public class ConfigurationTest {

    @Autowired
    Configuration configuration;

    @Test
    public void test() {
        assertNotNull(this.configuration);
        assertEquals("octo-spy-test", this.configuration.getProject());
        assertEquals("test", this.configuration.getVersion());
        assertEquals("test-env", this.configuration.getEnvironment());
        assertEquals("InternalTest", this.configuration.getClient());
        assertEquals(10, this.configuration.getDefaultApiLimit());
        assertEquals(100, this.configuration.getMaximumApiLimit());
    }
}
