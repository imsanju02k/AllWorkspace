package in.ineruon.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class InsertApp2 {
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public static void main(String[] args) {
		Session session = null;

		try {
			session = HibernateUtil.getSession();
			Criteria criteria=session.createCriteria(Product.class);
			
			Criterion cond1=Restrictions.ge("price", 10000);
			Criterion cond2=Restrictions.le("price", 60000);
			
			criteria.add(cond1);
			criteria.add(cond2);
			
			List<Product> products=criteria.list();
			
			products.forEach(System.out::println);
            
			

		} catch (HibernateException he) {
			he.printStackTrace();
			
		} finally {
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
