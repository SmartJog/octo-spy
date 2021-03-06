package com.octo.model.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Timestamp;
import java.time.Instant;

import org.junit.Test;

public class DeploymentProgressTest {

    @Test
    public void testGetterAndSetter() {
        DeploymentProgress entity = new DeploymentProgress();

        assertNull(entity.getId());
        assertNull(entity.getDeployment());
        assertNull(entity.getInsertDate());
        assertNull(entity.getUpdateDate());

        entity.setId(Long.valueOf(0L));
        entity.setDeployment(new Deployment());
        entity.setInsertDate(Timestamp.from(Instant.ofEpochMilli(1L)));
        entity.setUpdateDate(Timestamp.from(Instant.ofEpochMilli(2L)));

        assertEquals(Long.valueOf(0L), entity.getId());
        assertNotNull(entity.getDeployment());
        assertEquals(Timestamp.from(Instant.ofEpochMilli(1L)), entity.getInsertDate());
        assertEquals(Timestamp.from(Instant.ofEpochMilli(2L)), entity.getUpdateDate());

        entity.setInsertDate(null);
        entity.setUpdateDate(null);
        assertNull(entity.getInsertDate());
        assertNull(entity.getUpdateDate());

        entity.prePersist();
        assertNotNull(entity.getInsertDate());
    }

}
