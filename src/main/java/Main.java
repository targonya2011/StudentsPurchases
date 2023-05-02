import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry)
                .getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<Courses> queryCourses = session.createQuery("from Courses ", Courses.class);
        List<Courses> coursesList = queryCourses.list();

        Query<Students> queryStudents = session.createQuery("from Students ", Students.class);
        List<Students> studentsList = queryStudents.list();

        Query<PurchaseList> queryPurchase = session.createQuery("from PurchaseList ", PurchaseList.class);
        List<PurchaseList> purchaseList = queryPurchase.list();


        for (Courses courses : coursesList) {
            for (PurchaseList purchase : purchaseList) {
                for (Students student : studentsList) {
                    if (courses.getName().equals(purchase.getId().getCourseName())
                            && student.getName().equals(purchase.getId().getStudentName()))
                    {
                        LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList(new PK(courses.getId(), student.getId()));
                        session.merge(linkedPurchaseList);
                    }
                }
            }
        }



        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
