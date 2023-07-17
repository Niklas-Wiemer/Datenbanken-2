package datenbanken.database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.Attribute;
import jakarta.persistence.metamodel.EntityType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

    private final EntityManager manager;

    public Database() {

        EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("my-persistence-unit");
        this.manager = entityManager.createEntityManager();

        manager.getTransaction().begin();
    }

    public <T> List<T> getAllFromTable(Class<T> clazz) {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        Root<T> rootEntry = cq.from(clazz);

        CriteriaQuery<T> all = cq.select(rootEntry);

        TypedQuery<T> allQuery = manager.createQuery(all);
        return allQuery.getResultList();
    }

    public <T> T getFromTable(Class<T> clazz, String get, String result) {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        Root<T> rootEntry = cq.from(clazz);

        CriteriaQuery<T> all = cq.select(rootEntry);
        all.where(cb.equal(rootEntry.get(get), result));

        TypedQuery<T> allQuery = manager.createQuery(all);
        return allQuery.getSingleResult();
    }

    public <T> void insert(T entity) {
        if (!manager.getTransaction().isActive()) {
            manager.getTransaction().begin();
        }
        manager.persist(entity);
        manager.flush();
        manager.getTransaction().commit();
    }

    public <T> void delete(T entity) {
        if (!manager.getTransaction().isActive()) {
            manager.getTransaction().begin();
        }
        manager.remove(entity);
        manager.getTransaction().commit();
    }

    public Map<String, Class<?>> getTableNames(Class<?> table) {
        Map<String, Class<?>> map = new HashMap<>();
        EntityType<?> type = manager.getEntityManagerFactory().getMetamodel().entity(table);

        for (Attribute<?, ?> attribute : type.getAttributes()) {
            map.put(attribute.getName(), attribute.getJavaType());
        }
        return map;
    }

}
