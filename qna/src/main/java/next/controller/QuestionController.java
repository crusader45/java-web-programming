package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.QuestionDao;
import next.model.Question;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.mvc.Controller;
import core.mvc.FrontController;

public class QuestionController implements Controller {

	private static final Logger log = LoggerFactory.getLogger(QuestionController.class);
	private QuestionDao questionDAO = new QuestionDao();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		log.debug("writer : {}, title : {}, contents : {}", writer, title, contents);
		Question question = new Question(writer, title, contents);
		questionDAO.insert(question);
		return "redirect:/list.next";
	}
	
	
}
