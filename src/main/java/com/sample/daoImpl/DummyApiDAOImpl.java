package com.sample.daoImpl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sample.dao.DummyApiDAO;

@Repository
@Transactional
public class DummyApiDAOImpl implements DummyApiDAO{

}
