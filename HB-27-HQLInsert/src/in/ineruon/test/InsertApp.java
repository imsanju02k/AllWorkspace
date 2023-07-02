package in.ineruon.test;

import in.ineruon.dao.InsurancePolicyDao;
import in.ineruon.dao.InsurancePolicyDaoImpl;

public class InsertApp {

	public static void main(String[] args) {

		InsurancePolicyDao daoImpl = new InsurancePolicyDaoImpl();
		String result = daoImpl.transferPolicies(6);
		System.out.println(result);
	}
}
