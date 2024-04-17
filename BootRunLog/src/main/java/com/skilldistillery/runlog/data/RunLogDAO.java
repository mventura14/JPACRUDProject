package com.skilldistillery.runlog.data;

import java.util.List;

import com.skilldistillery.runlog.entities.RunLog;

public interface RunLogDAO {

	RunLog findByID(int id);

	RunLog addLog(RunLog log);

	List<RunLog> getLogs();

	boolean editLog(RunLog log);

	void deleteLog(int id);

}
