package com.octo.model.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class DeploymentViewTest {

    @Test
    public void testGetterAndSetter() {
        DeploymentView dto = new DeploymentView();

        assertNull(dto.getClient());
        assertNull(dto.getEnvironment());
        assertNull(dto.getId());
        assertNull(dto.getProject());
        assertNull(dto.getVersion());

        dto.setClient("client");
        dto.setEnvironment("environment");
        dto.setId(1L);
        dto.setProject("project");
        dto.setVersion("version");

        assertEquals("client", dto.getClient());
        assertEquals("environment", dto.getEnvironment());
        assertEquals(Long.valueOf(1L), dto.getId());
        assertEquals("project", dto.getProject());
        assertEquals("version", dto.getVersion());
    }
}