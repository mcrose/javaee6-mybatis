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
package py.com.icarusdb.agenda.data;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import py.com.icarusdb.agenda.model.Cargo;
import py.com.icarusdb.agenda.model.client.CargoMapper;

@RequestScoped
public class CargoRepository
{
    private SqlSession session = null;
    private CargoMapper mapper = null;
    

    @Inject
    private SqlSessionFactory sqlMapper;

    /**
     * 
     * @param id
     * @return {@link Cargo}
     */
    public Cargo findById(Long id)
    {
        session = sqlMapper.openSession();
        try
        {
            mapper = session.getMapper(CargoMapper.class);
            
            return mapper.selectByPrimaryKey(id);
        }
        finally
        {
            session.close();
        }
        
    }

    public List<Cargo> findAllActives()
    {
        session = sqlMapper.openSession();
        try
        {
            mapper = session.getMapper(CargoMapper.class);
            
            return mapper.selectAllActive();
        }
        finally
        {
            session.close();
        }
        
    }

    public List<Cargo> findAllOrderedByName()
    {
        session = sqlMapper.openSession();
        try
        {
            mapper = session.getMapper(CargoMapper.class);
            
            return mapper.selectAllOrderedByName();
        }
        finally
        {
            session.close();
        }
        
    }

    public void insert(Cargo cargo)
    {
        session = sqlMapper.openSession();
        try
        {
            mapper = session.getMapper(CargoMapper.class);
            
            mapper.insert(cargo);
        }
        finally
        {
            session.close();
        }
        
        
    }
}
