package com.skilldistillery.runlog.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.runlog.entities.RunLog;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RunLogDAOImpl implements RunLogDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public RunLog findByID(int id) {
		RunLog runlog = em.find(RunLog.class, id);

		return runlog;
	}

	@Override
	public RunLog addLog(RunLog log) {

		em.persist(log);

		return log;
	}

	@Override
	public List<RunLog> getLogs() {

		String jpql = "SELECT log FROM RunLog log";

		return em.createQuery(jpql, RunLog.class).getResultList();

	}

	@Override
	public boolean editLog(RunLog log) {

		RunLog editlog = findByID(log.getId());

		editlog.setDescription(log.getDescription());
		editlog.setType(log.getType());
		editlog.setTimeInMinutes(log.getTimeInMinutes());
		editlog.setDistanceInMiles(log.getDistanceInMiles());
		editlog.setDate(log.getDate());

		return true;

	}

	@Override
	public void deleteLog(int id) {

		RunLog foundEntry = em.find(RunLog.class, id);

		em.remove(foundEntry);

	}
}
