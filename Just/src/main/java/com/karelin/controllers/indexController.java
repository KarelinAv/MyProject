package com.karelin.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.karelin.dao.DaoComments;
import com.karelin.dao.DaoProjects;
import com.karelin.dao.DaoTasks;
import com.karelin.dao.DaoTasksStatuses;
import com.karelin.dao.DaoUsers;
import com.karelin.dao.DaoUsersProjects;
import com.karelin.dao.DaoUsersTasks;
import com.karelin.entity.Comments;
import com.karelin.entity.Projects;
import com.karelin.entity.Roles;
import com.karelin.entity.Tasks;
import com.karelin.entity.TasksStatuses;
import com.karelin.entity.Users;
import com.karelin.entity.UsersProjects;
import com.karelin.entity.UsersTasks;
import com.karelin.other.Mail;
import com.karelin.other.activeLisseners;
import com.karelin.validation.RegValidation;

@Controller
public class indexController {

	@RequestMapping(value = { "/", "/index" })
	public String indexPage(HttpServletResponse response, HttpSession session) {
		if (session.getAttribute("id") != null) {
			Integer userId = Integer.valueOf(String.valueOf(session.getAttribute("id")));
			DaoUsers du = new DaoUsers();
			Users user = du.get(userId);
			if (user.isRole("manager")) {
				return "redirect:manager";
			} else {
				return "redirect:developer";
			}
		} else {
			return "index";
		}
	}

	@RequestMapping(value = "/registration")
	public String registration(@RequestParam String login, @RequestParam String password,
			@RequestParam String repeat_password, @RequestParam String email, Model model, HttpSession session,
			@RequestParam int roles) {
		if (RegValidation.testLogin(login) && RegValidation.testPassword(password, repeat_password)
				&& RegValidation.testEmail(email)) {
			DaoUsers du = new DaoUsers();
			List<Users> list = du.getAll("FROM Users WHERE login = '" + login + "' OR email ='" + email + "'");
			if (list.isEmpty()) {

				long number = (long) (Math.random() * 42232) + 523232;
				session.setAttribute("number", number);
				session.setAttribute("login", login);
				session.setAttribute("password", password);
				session.setAttribute("email", email);
				session.setAttribute("roles", roles);
				Mail.sendMail(email, number);
				model.addAttribute("result", "success");
				model.addAttribute("notification",
						"На ваш почтовый ящик было отправлено письмо с подтверждением регистрации");
			} else {
				model.addAttribute("result", "fail");
				model.addAttribute("notification", "Пользователь уже существует!");
			}
		} else {
			model.addAttribute("result", "fail");
			model.addAttribute("notification", "Введены неверные данные!");
		}
		// return "redirect:index";
		return "index";
	}

	@RequestMapping(value = "/confirmRegistration")
	public String confirmRegistration(Model model, @RequestParam Long number, HttpSession session) {
		if (session.getAttribute("number") != null) {
			long sessionNumber = Long.valueOf(String.valueOf(session.getAttribute("number")));
			String login = String.valueOf(session.getAttribute("login"));
			String password = String.valueOf(session.getAttribute("password"));
			String email = String.valueOf(session.getAttribute("email"));
			int roles = Integer.valueOf(String.valueOf(session.getAttribute("roles")));
			if (sessionNumber == number) {
				DaoUsers du = new DaoUsers();
				du.insert(new Users(login, password, email, new Roles(roles)));
				model.addAttribute("result", "success");
				model.addAttribute("notification", "Регистрация прошла успешно!");

			} else {
				model.addAttribute("result", "fail");
				model.addAttribute("notification", "Неверный проверочный код!");

			}
		} else {
			model.addAttribute("result", "fail");
			model.addAttribute("notification", "Неверный проверочный код!ошибка хз");

		}
		return "index";
	}

	@RequestMapping(value = "/autorization")
	public String authorization(@RequestParam String login, @RequestParam String password, Model model,
			HttpServletResponse response, HttpSession session) {
		DaoUsers du = new DaoUsers();
		List<Users> list = du.getAll("FROM Users WHERE login = '" + login + "' AND password = '" + password + "'");
		if (list.isEmpty()) {
			model.addAttribute("result", "fail");
			model.addAttribute("notification", "Нет такого пользователя");
			return "index";
		} else {
			Users user = list.get(0);
			session.setAttribute("id", list.get(0).getId());
			session.setAttribute("role", list.get(0).getRoles().getType());
			Cookie cok = new Cookie("authorization", "ok");
			Cookie cok2 = new Cookie("id", String.valueOf(list.get(0).getId()));
			response.addCookie(cok);
			response.addCookie(cok2);

			if (user.isRole("manager")) {
				return "redirect:manager";
			} else if (user.isRole("developer")) {
				return "redirect:developer";
			} else {

				return "index";
			}
		}
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpServletResponse response, HttpSession session) {
		session.invalidate();
		return "redirect:index";
	}

	@RequestMapping(value = "/manager")
	public String manager(Model model, HttpSession session) {
		if (session.getAttribute("id") != null) {
			Integer userId = Integer.valueOf(String.valueOf(session.getAttribute("id")));
			DaoUsers du = new DaoUsers();
			Users user = du.get(userId);
			if (user.isRole("manager")) {
				DaoProjects zp = new DaoProjects();
				List<Projects> listProjects = zp.getAll("FROM Projects");
				model.addAttribute("listProjects", listProjects);
				return "manager";
			} else {
				return "redirect:developer";
			}
		} else {
			return "redirect:index";
		}
	}

	@RequestMapping(value = "/developer")
	public String developer(Model model, HttpSession session) {
		if (session.getAttribute("id") != null) {
			Integer userId = Integer.valueOf(String.valueOf(session.getAttribute("id")));
			DaoUsers du = new DaoUsers();
			Users user = du.get(userId);
			if (user.isRole("developer")) {
				DaoProjects dev = new DaoProjects();
				List<Projects> listProjects = dev.getAll("FROM Projects");
				model.addAttribute("listProjects", listProjects);
				return "developer";
			} else {
				return "redirect:manager";
			}
		} else {
			return "redirect:index";
		}
	}

	@RequestMapping(value = "/my_projects")
	public String projectsPage(Model model, HttpSession session) {
		if (session.getAttribute("id") != null) {
			Integer userId = Integer.valueOf(String.valueOf(session.getAttribute("id")));
			DaoProjects zp = new DaoProjects();
			List<Projects> listProjects = zp.getAll("FROM Projects WHERE id_users=" + userId);
			model.addAttribute("listProjects", listProjects);
			return "my_projects";
		} else {
			return "redirect:index";
		}
	}

	@RequestMapping(value = "/my_tasks")
	public String tasksPage(Model model, HttpSession session) {
		if (session.getAttribute("id") != null) {
			DaoTasks zp = new DaoTasks();
			DaoTasksStatuses statuses = new DaoTasksStatuses();
			List<Tasks> tasks = zp.getAll("FROM UsersTasks WHERE id_users=" + session.getAttribute("id"));
			List<TasksStatuses> statusesList = statuses.getAll("FROM TasksStatuses");
			model.addAttribute("tasks", tasks);
			model.addAttribute("statusesList", statusesList);
			return "my_tasks";
		} else {
			return "redirect:index";
		}
	}

	@RequestMapping(value = "/statistics")
	public String statisticsPage1(Model model) {
		int count = activeLisseners.count;
		model.addAttribute("online", count);
		return "statistics";
	}

	@RequestMapping(value = "/about")
	public String aboutPage(HttpSession session) {
		if (session.getAttribute("id") != null) {
			return "about";
		} else {
			return "redirect:index";
		}
	}

	@RequestMapping(value = "/projectTasks")
	public String projectTasks(@RequestParam int id, HttpSession session, Model model) {
		if (session.getAttribute("id") != null) {
			DaoTasks zг = new DaoTasks();
			DaoUsers us = new DaoUsers();
			DaoTasksStatuses statuses = new DaoTasksStatuses();
			session.setAttribute("id_project", id);
			List<Tasks> listTasks = zг.getAll("FROM Tasks where id_projects=" + id);
			List<TasksStatuses> statusesList = statuses.getAll("FROM TasksStatuses");
			List<Users> users = us.getAll("FROM Users");
			model.addAttribute("listTasks", listTasks);
			model.addAttribute("id_projects", id);
			model.addAttribute("statusesList", statusesList);
			model.addAttribute("users", users);
			return "projectsTasks";
		} else {
			return "redirect:index";
		}
	}

	@RequestMapping(value = "/addProject")
	public String addProject(@RequestParam String nameProject, HttpSession session) {
		if (session.getAttribute("id") != null) {
			int id = Integer.valueOf(String.valueOf(session.getAttribute("id")));
			DaoProjects dp = new DaoProjects();
			dp.insert(new Projects(nameProject, new Users(id), new Date()));
			return "redirect:my_projects";
		} else {
			return "redirect:index";
		}
	}

	@RequestMapping(value = "/dropProject")
	public String dropProject(@RequestParam int id, HttpSession session, Model model,
			RedirectAttributes redirectAttributes) {
		if (session.getAttribute("id") != null) {

			DaoProjects dl = new DaoProjects();
			Projects projects = dl.get(id);
			dl.delete(projects);
			redirectAttributes.addAttribute("id", Integer.valueOf(String.valueOf(session.getAttribute("id"))));
			return "redirect:manager";
		} else {
			return "redirect:index";
		}
	}

	@RequestMapping(value = "/addTask")
	public String addTask(@RequestParam String description, @RequestParam int userId, @RequestParam int id_projects,
			HttpSession session) {
		if (session.getAttribute("id") != null) {
			DaoTasks dt = new DaoTasks();
			DaoUsers us = new DaoUsers();
			DaoUsersTasks ut = new DaoUsersTasks();
			Tasks task = new Tasks(description, new TasksStatuses(1), new Projects(id_projects), new Date());
			dt.insert(task);
			Users user = us.get(userId);
			ut.insert(new UsersTasks(task, user));
			return "redirect:projectTasks?id=" + id_projects;
		} else {
			return "redirect:index";
		}
	}

	@RequestMapping(value = "/addComment")
	public String addComment(@RequestParam String message, HttpSession session) {
		if (session.getAttribute("id") != null) {
			DaoComments dc = new DaoComments();
			int id_task = Integer.valueOf(String.valueOf(session.getAttribute("id_task")));
			dc.insert(new Comments(new Tasks(id_task),
					new Users(Integer.valueOf(String.valueOf(session.getAttribute("id")))), message, new Date()));
			return "redirect:comments?id=" + id_task;
		} else {
			return "redirect:index";
		}
	}

	@RequestMapping(value = "/deleteComment")
	public String deleteComment(@RequestParam int id, HttpSession session) {
		if (session.getAttribute("id") != null) {
			int id_task = Integer.valueOf(String.valueOf(session.getAttribute("id_task")));
			DaoComments dc = new DaoComments();
			dc.delete(new Comments(id));
			return "redirect:comments?id=" + id_task;
		} else {
			return "redirect:index";
		}
	}

	@RequestMapping(value = "/comments")
	public String comments(@RequestParam int id, HttpSession session, Model model) {
		if (session.getAttribute("id") != null) {
			DaoComments dc = new DaoComments();
			List<Comments> listComments = dc.getAll("FROM Comments where id_tasks=" + id);
			model.addAttribute("listComments", listComments);
			session.setAttribute("id_task", id);
			return "comments";
		} else {
			return "redirect:index";
		}
	}

	@RequestMapping(value = "/addUser")
	public String addUser(@RequestParam int id, HttpSession session, Model model) {
		if (session.getAttribute("id") != null) {
			session.setAttribute("id_project", id);
			DaoUsersProjects du = new DaoUsersProjects();
			DaoUsers du2 = new DaoUsers();
			List<UsersProjects> list1 = du.getAll("FROM UsersProjects WHERE id_projects = "
					+ Integer.valueOf(String.valueOf(session.getAttribute("id_project"))));
			List<Users> list2;
			if (list1.isEmpty()) {
				list2 = du2.getAll("FROM Users");
			} else {
				String ids = "(";
				for (UsersProjects item : list1) {
					if (item != list1.get(list1.size() - 1)) {
						ids += item.getUsers().getId() + ",";
					} else {
						ids += item.getUsers().getId();
					}
				}
				ids += ")";
				list2 = du2.getAll("FROM Users WHERE id not in " + ids);
			}
			model.addAttribute("listUser", list1);
			model.addAttribute("listUser2", list2);
			return "adduser";
		} else {
			return "redirect:index";
		}
	}

	@RequestMapping(value = "/dropUser")
	public String dropUser(@RequestParam int id, HttpSession session, Model model) {
		if (session.getAttribute("id") != null) {
			session.setAttribute("id_project", id);
			System.out.println(id);
			DaoUsersProjects du = new DaoUsersProjects();
			List<UsersProjects> list1 = du.getAll("FROM UsersProjects WHERE id_projects = " + id);

			model.addAttribute("listUser", list1);
			return "drop_user";
		} else {
			return "redirect:index";
		}
	}

	@RequestMapping(value = "/dropFromProject")
	public String dropFromProject(@RequestParam int id, HttpSession session, Model model,
			RedirectAttributes redirectAttributes) {
		if (session.getAttribute("id") != null) {
			DaoUsersProjects du = new DaoUsersProjects();
			UsersProjects usersProject = du.get(id);
			du.delete(usersProject);
			redirectAttributes.addAttribute("id", Integer.valueOf(String.valueOf(session.getAttribute("id_project"))));
			return "redirect:dropUser";
		} else {
			return "redirect:index";
		}
	}

	@RequestMapping(value = "/addToProject")
	public String addToProject(@RequestParam int id, HttpSession session, Model model) {
		if (session.getAttribute("id") != null) {
			DaoUsersProjects du = new DaoUsersProjects();
			Integer projectId = Integer.valueOf(String.valueOf(session.getAttribute("id_project")));
			List<UsersProjects> list = du
					.getAll("FROM UsersProjects where id_projects = " + projectId + " and id_users = " + id);
			if (list.isEmpty()) {
				du.insert(new UsersProjects(new Projects(projectId), new Users(id)));
			}
			return "redirect:addUser?id=" + projectId;
		} else {
			return "redirect:index";
		}
	}

	@RequestMapping(value = "/changeStatus")
	public void changeStatus(@RequestParam String taskId, @RequestParam String selectedStatus,
			HttpServletResponse response, HttpSession session, Model model) throws ServletException, IOException {
		String jsonObject;
		if (session.getAttribute("id") != null) {
			DaoTasks du = new DaoTasks();
			Tasks task = du.get(Integer.valueOf(String.valueOf(taskId)));
			DaoTasksStatuses da = new DaoTasksStatuses();
			TasksStatuses status = da.get(Integer.valueOf(String.valueOf(selectedStatus)));
			task.setStatus(status);
			du.update(task);
			jsonObject = "{result: 'success'}";
		} else {
			jsonObject = "{result: 'fail'}";
		}
		response.setContentType("application/json");
		response.getWriter().write(jsonObject);
	}

	@RequestMapping(value = "/task")
	public String taskPages( HttpSession session, Model model) {
		if (session.getAttribute("id") != null) {
			DaoTasks zг = new DaoTasks();
			DaoTasksStatuses statuses = new DaoTasksStatuses();
			List<Tasks> listTasks = zг.getAll("FROM Tasks");
			List<TasksStatuses> statusesList = statuses.getAll("FROM TasksStatuses");
			model.addAttribute("listTasks", listTasks);
			model.addAttribute("statusesList", statusesList);
			return "task";
		} else {
			return "redirect:index";
		}
	}

	@RequestMapping(value = "/i18n")
	public String i18n(@RequestParam String language, HttpSession session) {
		String contry = "";// Страна
		String lang = "";// Язык(диалект)
		switch (language) {
		case "rus":
			contry = "RU";
			lang = "rus";
			break;

		case "eng":
			contry = "EN";
			lang = "eng";
			break;
		case "deu":
			contry = "GM";
			lang = "deu";
			break;
		}
		session.setAttribute("coutry", contry);
		session.setAttribute("lang", lang);
		return "redirect:index";
	}
	@RequestMapping(value = "/sendError")
	public String sendError(HttpServletResponse response, HttpSession session) {
		session.invalidate();
		return "sendError";
	}
}
