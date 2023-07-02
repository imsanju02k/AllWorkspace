package in.ineuron.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Product;
import in.ineuron.util.mysqlsanjuHibernateUtil;
import in.ineuron.util.mysqlstudentHibernateUtil;

public class TransferDaoImpl implements ITransferDao {

	@SuppressWarnings("finally")
	@Override
	public String tranferProuductById(Integer id) {
		
		Session mysqlsanjuSession=mysqlsanjuHibernateUtil.getSession();
		Session mysqlstudentSession=mysqlstudentHibernateUtil.getSession();
		
		Integer idvalue=0;
		Boolean flag=false;
		
		Transaction transactionSanju=null;
		
		Product product=mysqlstudentSession.get(Product.class, 1);
		System.out.println(product);
		if(product == null)
		{
			return "record not available for copyping...";
		}else {
			try {
				transactionSanju=mysqlsanjuSession.beginTransaction();
				idvalue=(Integer) mysqlsanjuSession.save(product);
				flag=true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if(flag) {
					transactionSanju.commit();
					return "data copied from student table to sanjay table with the id :: " +idvalue;
				}
				else {
					transactionSanju.rollback();
					return "data not copied from student table to sanjay table with the id :: " +idvalue;
					
				}
			}
		}
		

	}
}
