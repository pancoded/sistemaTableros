package ar.edu.ottokrause.sistemaTableros.persistencia;

import ar.edu.ottokrause.sistemaTableros.logica.Prestamo;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import ar.edu.ottokrause.sistemaTableros.logica.Tablero;
import ar.edu.ottokrause.sistemaTableros.persistencia.exceptions.NonexistentEntityException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class PrestamoJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public PrestamoJpaController() {
        emf = Persistence.createEntityManagerFactory("sistemaTablerosPU");
    }

    public PrestamoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Prestamo prestamo) {
        if (prestamo.getTableros() == null) {
            prestamo.setTableros(new ArrayList<Tablero>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Tablero> attachedTableros = new ArrayList<Tablero>();
            for (Tablero tablerosTableroToAttach : prestamo.getTableros()) {
                tablerosTableroToAttach = em.getReference(tablerosTableroToAttach.getClass(), tablerosTableroToAttach.getId());
                attachedTableros.add(tablerosTableroToAttach);
            }
            prestamo.setTableros(attachedTableros);
            em.persist(prestamo);
            for (Tablero tablerosTablero : prestamo.getTableros()) {
                Prestamo oldPrestamoOfTablerosTablero = tablerosTablero.getPrestamo();
                tablerosTablero.setPrestamo(prestamo);
                tablerosTablero = em.merge(tablerosTablero);
                if (oldPrestamoOfTablerosTablero != null) {
                    oldPrestamoOfTablerosTablero.getTableros().remove(tablerosTablero);
                    oldPrestamoOfTablerosTablero = em.merge(oldPrestamoOfTablerosTablero);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Prestamo prestamo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Prestamo persistentPrestamo = em.find(Prestamo.class, prestamo.getId());
            List<Tablero> tablerosOld = persistentPrestamo.getTableros();
            List<Tablero> tablerosNew = prestamo.getTableros();
            List<Tablero> attachedTablerosNew = new ArrayList<Tablero>();
            for (Tablero tablerosNewTableroToAttach : tablerosNew) {
                tablerosNewTableroToAttach = em.getReference(tablerosNewTableroToAttach.getClass(), tablerosNewTableroToAttach.getId());
                attachedTablerosNew.add(tablerosNewTableroToAttach);
            }
            tablerosNew = attachedTablerosNew;
            prestamo.setTableros(tablerosNew);
            prestamo = em.merge(prestamo);
            for (Tablero tablerosOldTablero : tablerosOld) {
                if (!tablerosNew.contains(tablerosOldTablero)) {
                    tablerosOldTablero.setPrestamo(null);
                    tablerosOldTablero = em.merge(tablerosOldTablero);
                }
            }
            for (Tablero tablerosNewTablero : tablerosNew) {
                if (!tablerosOld.contains(tablerosNewTablero)) {
                    Prestamo oldPrestamoOfTablerosNewTablero = tablerosNewTablero.getPrestamo();
                    tablerosNewTablero.setPrestamo(prestamo);
                    tablerosNewTablero = em.merge(tablerosNewTablero);
                    if (oldPrestamoOfTablerosNewTablero != null && !oldPrestamoOfTablerosNewTablero.equals(prestamo)) {
                        oldPrestamoOfTablerosNewTablero.getTableros().remove(tablerosNewTablero);
                        oldPrestamoOfTablerosNewTablero = em.merge(oldPrestamoOfTablerosNewTablero);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = prestamo.getId();
                if (findPrestamo(id) == null) {
                    throw new NonexistentEntityException("The prestamo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Prestamo prestamo;
            try {
                prestamo = em.getReference(Prestamo.class, id);
                prestamo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The prestamo with id " + id + " no longer exists.", enfe);
            }
            List<Tablero> tableros = prestamo.getTableros();
            for (Tablero tablerosTablero : tableros) {
                tablerosTablero.setPrestamo(null);
                tablerosTablero = em.merge(tablerosTablero);
            }
            em.remove(prestamo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Prestamo> findPrestamoEntities() {
        return findPrestamoEntities(true, -1, -1);
    }

    public List<Prestamo> findPrestamoEntities(int maxResults, int firstResult) {
        return findPrestamoEntities(false, maxResults, firstResult);
    }

    private List<Prestamo> findPrestamoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Prestamo.class));
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

    public Prestamo findPrestamo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Prestamo.class, id);
        } finally {
            em.close();
        }
    }

    public int getPrestamoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Prestamo> rt = cq.from(Prestamo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
