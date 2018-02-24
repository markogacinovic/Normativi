/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import JPA.exceptions.NonexistentEntityException;
import JPA.exceptions.PreexistingEntityException;
import entitiKlase.Normativi;
import entitiKlase.Normativizaartikal;
import entitiKlase.NormativizaartikalPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Marko
 */
public class NormativizaartikalJpaController implements Serializable {

    public NormativizaartikalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Normativizaartikal normativizaartikal) throws PreexistingEntityException, Exception {
        if (normativizaartikal.getNormativizaartikalPK() == null) {
            normativizaartikal.setNormativizaartikalPK(new NormativizaartikalPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(normativizaartikal);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNormativizaartikal(normativizaartikal.getNormativizaartikalPK()) != null) {
                throw new PreexistingEntityException("Normativizaartikal " + normativizaartikal + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Normativizaartikal normativizaartikal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            normativizaartikal = em.merge(normativizaartikal);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                NormativizaartikalPK id = normativizaartikal.getNormativizaartikalPK();
                if (findNormativizaartikal(id) == null) {
                    throw new NonexistentEntityException("The normativizaartikal with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(NormativizaartikalPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Normativizaartikal normativizaartikal;
            try {
                normativizaartikal = em.getReference(Normativizaartikal.class, id);
                normativizaartikal.getNormativizaartikalPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The normativizaartikal with id " + id + " no longer exists.", enfe);
            }
            em.remove(normativizaartikal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Normativizaartikal> findNormativizaartikalEntities() {
        return findNormativizaartikalEntities(true, -1, -1);
    }

    public List<Normativizaartikal> findNormativizaartikalEntities(int maxResults, int firstResult) {
        return findNormativizaartikalEntities(false, maxResults, firstResult);
    }

    private List<Normativizaartikal> findNormativizaartikalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Normativizaartikal.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }    

    public Normativizaartikal findNormativizaartikal(NormativizaartikalPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Normativizaartikal.class, id);
        } finally {
            em.close();
        }
    }
    
    public List<Normativizaartikal> findNormativiPoIDArtikla(int idArtikla) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery q = em.createNamedQuery("Normativizaartikal.findByIdartikla", Normativizaartikal.class);
            q.setParameter("idartikla", idArtikla);
            List<Normativizaartikal> ln = q.getResultList();
            if (ln.size() > 0)
            {
                return ln;
            }
            else
            {
                return null;
            } 
        } finally {
            em.close();
        }
    }

    public int getNormativizaartikalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Normativizaartikal> rt = cq.from(Normativizaartikal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
