/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package py.org.pti.agenda.test;

import static org.junit.Assert.assertNotNull;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;

import py.com.icarusdb.agenda.model.Cargo;
import py.com.icarusdb.agenda.service.CargoService;
import py.com.icarusdb.agenda.util.Resources;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class CargoRegistrationTest
{
    @Deployment
    public static Archive<?> createTestArchive()
    {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                            .addClasses(Cargo.class, CargoService.class, Resources.class)
                            //.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml"); // Deploy our test datasource
                            //.addAsWebInfResource("test-ds.xml");
    }

    @Inject
    CargoService cargoService;

    @Inject
    Logger log;
    
    private final static int times = 1;

    @Test
    public void testRegister() throws Exception
    {
        for(int index=0; index < times; index++)
        {
            Cargo newCargo = new Cargo();
            newCargo.setDescripcion("arquillian tester");
            newCargo.setActivo(true);
            
            cargoService.register(newCargo);
            
            assertNotNull(newCargo.getId());
            
            log.info(newCargo.getDescripcion() + " was persisted with id " + newCargo.getId());
        }
    }

}
