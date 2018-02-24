/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import JPA.exceptions.NonexistentEntityException;
import JPA.exceptions.PreexistingEntityException;
import entitiKlase.Artikliradnognaloga;
import entitiKlase.ArtikliradnognalogaPK;
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
public class ArtikliradnognalogaJpaController implements Serializable {

    public ArtikliradnognalogaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void create(Artikliradnognaloga artikliradnognaloga, EntityManager em) {
        em.persist(artikliradnognaloga);
    }

    public void create(Artikliradnognaloga artikliradnognaloga) throws PreexistingEntityException, Exception {
        if (artikliradnognaloga.getArtikliradnognalogaPK() == null) {
            artikliradnognaloga.setArtikliradnognalogaPK(new ArtikliradnognalogaPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(artikliradnognaloga);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findArtikliradnognaloga(artikliradnognaloga.getArtikliradnognalogaPK()) != null) {
                throw new PreexistingEntityException("Artikliradnognaloga " + artikliradnognaloga + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Artikliradnognaloga artikliradnognaloga) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            artikliradnognaloga = em.merge(artikliradnognaloga);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ArtikliradnognalogaPK id = artikliradnognaloga.getArtikliradnognalogaPK();
                if (findArtikliradnognaloga(id) == null) {
                    throw new NonexistentEntityException("The artikliradnognaloga with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void destroy(StringBuilder greska, ArtikliradnognalogaPK id, EntityManager em) {      
        Artikliradnognaloga artikliradnognaloga;
        try {
            artikliradnognaloga = em.getReference(Artikliradnognaloga.class, id);
            artikliradnognaloga.getArtikliradnognalogaPK();
        } catch (EntityNotFoundException enfe) {
            greska.append("1");
            return;
        }
        em.remove(artikliradnognaloga);
    }

    public void destroy(ArtikliradnognalogaPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Artikliradnognaloga artikliradnognaloga;
            try {
                artikliradnognaloga = em.getReference(Artikliradnognaloga.class, id);
                artikliradnognaloga.getArtikliradnognalogaPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The artikliradnognaloga with id " + id + " no longer exists.", enfe);
            }
            em.remove(artikliradnognaloga);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Artikliradnognaloga> findArtikliradnognalogaEntities() {
        return findArtikliradnognalogaEntities(true, -1, -1);
    }

    public List<Artikliradnognaloga> findArtikliradnognalogaEntities(int maxResults, int firstResult) {
        return findArtikliradnognalogaEntities(false, maxResults, firstResult);
    }

    private List<Artikliradnognaloga> findArtikliradnognalogaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Artikliradnognaloga.class));
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

    public Artikliradnognaloga findArtikliradnognaloga(ArtikliradnognalogaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Artikliradnognaloga.class, id);
        } finally {
            em.close();
        }
    }
    
    public List<Artikliradnognaloga> findArtikleNaloga(int idRN) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery q = em.createNamedQuery("Artikliradnognaloga.findByIdradnognaloga", Artikliradnognaloga.class);
            q.setParameter("idradnognaloga", idRN);
            List<Artikliradnognaloga> ln = q.getResultList();
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

    public int getArtikliradnognalogaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Artikliradnognaloga> rt = cq.from(Artikliradnognaloga.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
