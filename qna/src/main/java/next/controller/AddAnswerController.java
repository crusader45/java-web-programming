package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Answer;
import core.mvc.Controller;

public class AddAnswerController implements Controller {

	private AnswerDao answerDAO = new AnswerDao();
	private QuestionDao questionDAO = new QuestionDao();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String writer = request.getParameter("writer");
		String contents = request.getParameter("contents");
		long questionId = Long.parseLong(request.getParameter("questionId"));
		
		Answer answer = new Answer(writer, contents, questionId);
		answerDAO.insert(answer);
		questionDAO.update(questionId);
		return "api";
	}
}
