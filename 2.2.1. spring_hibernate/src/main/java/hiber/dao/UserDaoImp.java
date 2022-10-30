package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUser(String model, long series) {
      User mainUser = null;
      for(User user: getListUser()){
         if(user.getCar().getModel().equals(model) && user.getId() == series){
            String hql = "from User where id = :paramName";
            Query query = sessionFactory.getCurrentSession().createQuery(hql);
            query.setParameter("paramName",series);
            mainUser = (User) query.getSingleResult();
         }
      }
      return mainUser;
   }
   public List<User> getListUser(){
      return sessionFactory.getCurrentSession().createQuery("from User").getResultList();
   }
}
