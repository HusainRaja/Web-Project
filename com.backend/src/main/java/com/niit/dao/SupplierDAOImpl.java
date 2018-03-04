package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Supplier;

public class SupplierDAOImpl implements SupplierDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		}
		catch(Exception e) {
			System.out.println("exception arised:"+e);
			return false;
		}
	}

	@Transactional
	public boolean updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception e) {
			System.out.println("Exception arised:"+e);
			return false;
		}
	}

	@Transactional
	public boolean deleteSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e) {
			System.out.println("Exception arised:"+e);
			return false;
		}
	}

	public Supplier getSupplier(int supplierId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Supplier supplier=session.get(Supplier.class,supplierId);
		return supplier;
	}

	public List<Supplier> listSuppliers() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier> list=(List<Supplier>)query.list();
		return list;
	}

}
