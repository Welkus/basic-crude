package com.crudelearning.cruddemo.service;
import java.util.List;

import com.crudelearning.cruddemo.ServiceUsers;
import com.crudelearning.cruddemo.UserFilter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @PersistenceContext
    private EntityManager em;
    public List<ServiceUsers> filterUser(UserFilter userFilter){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery <ServiceUsers> cq = cb.createQuery(ServiceUsers.class);
        Root<ServiceUsers> theseUsers = cq.from(ServiceUsers.class);

        List<Predicate> predicates = new ArrayList<>();
        if(userFilter.getFirstName() != null && !userFilter.getFirstName().isEmpty()){
            predicates.add(cb.equal(theseUsers.get("firstName"), userFilter.getFirstName()));
        }
        if(userFilter.getLastName() != null && !userFilter.getLastName().isEmpty()){
            predicates.add(cb.equal(theseUsers.get("lastName"),userFilter.getLastName()));
        }
        if(userFilter.getRole() != null && !userFilter.getRole().isEmpty()){
            predicates.add(cb.equal(theseUsers.get("role"),userFilter.getRole()));
        }

      cq.where(predicates.toArray(new Predicate[] {}));
        TypedQuery<ServiceUsers> query = em.createQuery(cq);
        return query.getResultList();

    }
}
