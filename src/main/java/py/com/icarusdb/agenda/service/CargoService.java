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
package py.com.icarusdb.agenda.service;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import py.com.icarusdb.agenda.data.CargoRepository;
import py.com.icarusdb.agenda.model.Cargo;

@RequestScoped
public class CargoService
{

    @Inject
    private Logger log;

     @Inject
     private CargoRepository repository;

    @Inject
    private Event<Cargo> cargoEventSrc;

    public void register(Cargo cargo) throws Exception
    {
        log.info("Registering " + cargo.getDescripcion());
        repository.insert(cargo);
        cargoEventSrc.fire(cargo);
    }
    
    
}
