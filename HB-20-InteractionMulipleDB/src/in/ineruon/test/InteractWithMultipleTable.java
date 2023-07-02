package in.ineruon.test;

import in.ineuron.dao.ITransferDao;
import in.ineuron.dao.TransferDaoImpl;
import in.ineuron.util.mysqlsanjuHibernateUtil;
import in.ineuron.util.mysqlstudentHibernateUtil;

public class InteractWithMultipleTable {

	public static void main(String[] args) throws Exception {

		ITransferDao dao= new TransferDaoImpl();
		System.out.println(dao.tranferProuductById(1));
		
		mysqlsanjuHibernateUtil.closeSessionFactory();
		mysqlstudentHibernateUtil.closeSessionFactory();
	}
}
