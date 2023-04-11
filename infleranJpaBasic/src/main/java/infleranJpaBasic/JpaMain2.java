package infleranJpaBasic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain2 {
	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			// Id가 20L인 데이터는 이미 데이터베이스가 존재한다.
			Member findMember1 = em.find(Member.class, 20L);
			Member findMember2 = em.find(Member.class, 20L);
			
			System.out.println(findMember1 == findMember2); // true
			
			findMember1.setName("회원");
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
}