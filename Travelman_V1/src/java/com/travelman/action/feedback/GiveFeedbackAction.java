package com.travelman.action.feedback;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.travelman.business.service.feedback.FeedbackBusinesService;
import com.travelman.domain.Feedback;
import com.travelman.domain.User;

public class GiveFeedbackAction  extends ActionSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String subject;
     
    private String body;

    private String currentUserName;

	public String getCurrentUserName() {
		return currentUserName;
	}

	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}
	// Business Service
	private FeedbackBusinesService feedbackBusinesService;
	
	




	@Override
	public String execute() throws Exception {
		String actionResult ="";
		feedbackBusinesService = new FeedbackBusinesService();
		Feedback feedback = new Feedback();
		feedback.setBody(body);
		feedback.setSubject(subject);
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("USER");
		setCurrentUserName(user.getFname()+" "+user.getLname());
		if (user.getUprofile() == 1) {
			actionResult = "individual";
			setCurrentUserName(getCurrentUserName()+" [I]");
		} else {
			if (user.getUprofile() == 2) {
				actionResult = "group";
				setCurrentUserName(getCurrentUserName()+" [G]");
			} else {
				if (user.getUprofile() == 3) {
					actionResult = "admin";
					setCurrentUserName(getCurrentUserName()+" [A]");
				}
			}
		}
		
		feedbackBusinesService.sendFeedback(feedback);
		
		return actionResult;
	}




	public String getSubject() {
		return subject;
	}




	public void setSubject(String subject) {
		this.subject = subject;
	}




	public String getBody() {
		return body;
	}




	public void setBody(String body) {
		this.body = body;
	}

	
}
