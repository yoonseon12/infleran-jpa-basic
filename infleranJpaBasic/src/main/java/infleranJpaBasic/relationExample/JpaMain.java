package infleranJpaBasic.relationExample;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin(); // 트랜잭션 시작
		try {
			MemberR member = new MemberR();
			member.setUsername("memberA");
			em.persist(member);
			
			Team team = new Team();
			team.setName("TeamA");
			team.addMember(member);
			em.persist(team);
			
			em.flush();
			em.clear();
			
//			MemberR findMember = em.find(MemberR.class, member.getId());
//			
//			List<MemberR> members = findMember.getTeam().getMembers();
//			for (MemberR m : members) {
//				System.out.println("member : "+m.getUsername()); // memberA 출력
//			}
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
	

}