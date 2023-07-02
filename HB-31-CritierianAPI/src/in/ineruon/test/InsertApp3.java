package in.ineruon.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class InsertApp3 {
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public static void main(String[] args) {
		Session session = null;

		try {
			session = HibernateUtil.getSession();
			Criteria criteria=session.createCriteria(Product.class);
			
			ProjectionList list=Projections.projectionList();
			list.add(Projections.property("pname"));
			list.add(Projections.property("qty"));
			
			criteria.setProjection(list);
			
			Criterion cond1=Restrictions.ge("price", 10000);
			Criterion cond2=Restrictions.le("price", 60000);
			
			criteria.add(cond1);
			criteria.add(cond2);
			
			Order order=Order.asc("pname");
			
			criteria.addOrder(order);
			
			List<Object[]> products=criteria.list();
			System.out.println("Pname\tqty");
			products.forEach(row->{
				for(Object obj:row) {
					System.out.print(obj+"\t");
				}
				System.out.println();
			});
			
            
			

		} catch (HibernateException he) {
			he.printStackTrace();
			
		} finally {
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
