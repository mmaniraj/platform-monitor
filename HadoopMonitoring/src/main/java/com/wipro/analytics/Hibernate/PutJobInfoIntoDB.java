package com.wipro.analytics.Hibernate;

import org.hibernate.classic.Session;

/**
 * Created by cloudera on 6/26/18.
 */
public class PutJobInfoIntoDB {

    public static void main(String[] args)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

       /* //Add new Employee object
        EmployeeEntity emp = new EmployeeEntity();
        emp.setEmail("lokesh@mail.com");
        emp.setFirstName("lokesh");
        emp.setLastName("gupta");

        //Save the employee in database
        session.save(emp);*/

        //Commit the transaction
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
