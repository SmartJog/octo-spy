package com.octo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.octo.model.dto.project.NewProjectDTO;
import com.octo.model.dto.project.ProjectDTO;
import com.octo.service.ProjectService;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml" })
public class ProjectControllerTest extends JerseyTest {

    @Mock
    ProjectService service;

    @InjectMocks
    ProjectController controller;

    @Override
    protected Application configure() {
        MockitoAnnotations.openMocks(this);
        final ResourceConfig rc = new ResourceConfig().register(ProjectController.class).register(new AbstractBinder() {
            @Override
            protected void configure() {
                this.bind(ProjectControllerTest.this.controller).to(ProjectController.class);
            }
        });
        ;

        rc.property("contextConfigLocation", "classpath:application-context.xml");

        return rc;
    }

    @Test
    public void testGetProject() {
        Mockito.when(this.service.load(1L)).thenReturn(new ProjectDTO());
        final Response response = this.controller.getProject(1L);

        assertNotNull(response);
        assertEquals(Status.OK.getStatusCode(), response.getStatus());
        assertNotNull(response.getEntity());
    }

    @Test
    public void testCreateProject() {
        Mockito.when(this.service.save(Mockito.any())).thenReturn(new ProjectDTO());
        final Response response = this.controller.createProject(new NewProjectDTO());

        assertNotNull(response);
        assertEquals(Status.CREATED.getStatusCode(), response.getStatus());
        assertNotNull(response.getEntity());
    }

    @Test
    public void testDeleteProject() {
        Mockito.doNothing().when(this.service).delete(1L);
        final Response response = this.controller.deleteProject(1L);

        assertNotNull(response);
        assertEquals(Status.NO_CONTENT.getStatusCode(), response.getStatus());
    }
}
