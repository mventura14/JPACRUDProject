package com.skilldistillery.runlog.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.runlog.data.RunLogDAO;
import com.skilldistillery.runlog.entities.RunLog;

@Controller
public class RunLogController {

	private RunLogDAO runLogDAO;

	public RunLogController(RunLogDAO dao) {
		this.runLogDAO = dao;
	}

	@GetMapping({ "/", "home.do" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();

		List<RunLog> logs = runLogDAO.getLogs();

		mv.addObject("runner", logs);
		System.out.println(logs.get(0).toString());
		mv.setViewName("home");

		return mv;
	}

	@GetMapping({ "getService.do" })
	public String getRunLogById(@RequestParam("id") int id, Model model) {
		List<RunLog> logs = new ArrayList<>();
		logs.add(runLogDAO.findByID(id));

		model.addAttribute("runner", logs);
		return "home";
	}

	@PostMapping({ "addLogEntry.do" })
	public ModelAndView addFilm(RunLog log) {
		ModelAndView mv = new ModelAndView();

		RunLog logEntry = runLogDAO.addLog(log);

		mv.setViewName("redirect:home.do");
		return mv;
	}

	@PostMapping({ "updateEntry" })
	public ModelAndView updateFilm(RunLog log, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();

		boolean edited = runLogDAO.editLog(log);

		redir.addFlashAttribute("edited", edited);
		mv.setViewName("redirect:home.do");

		return mv;
	}

	@PostMapping({ "deleteEntry" })
	public ModelAndView deleteFilm(@RequestParam("id") int id, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();

		runLogDAO.deleteLog(id);

//		mv.addObject("edited", edited);
//		mv.setViewName("re:home");

		mv.setViewName("redirect:home.do");

		return mv;
	}
}
