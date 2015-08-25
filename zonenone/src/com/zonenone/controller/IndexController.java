package com.zonenone.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.zonenone.form.BaseFormBean;
import com.zonenone.form.IndexFormBean;
import com.zonenone.form.LoginFormBean;
import com.zonenone.form.PlanFormBean;
import com.zoneone.bo.impl.LoginBOImpl;
import com.zoneone.bo.impl.PlanBOImpl;

@Controller
public class IndexController {

	@Autowired
	private ServletContext servContext;

	@Autowired
	private WebApplicationContext appContext;

	/**
	 * First Method to load Default Page
	 * 
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/loadlogin.do", method = RequestMethod.GET)
	public ModelAndView loadLogin(HttpServletRequest request,
			HttpServletResponse response) {
		LoginFormBean loginFormBean = null;
		try {
			ModelAndView mv = new ModelAndView("login");
			loginFormBean = (LoginFormBean) appContext.getBean("loginFormBean");
			mv.addObject("loginFormBean", loginFormBean);
			mv.addObject("currentUrl", "login");
			return mv;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	/**
	 * Method to validate login
	 * 
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView home(
			@ModelAttribute("loginFormBean") LoginFormBean loginFormBean,
			HttpServletRequest request, HttpServletResponse response) {
		LoginBOImpl loginBOImpl = (LoginBOImpl) appContext.getBean("loginBOImpl");
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("loginFormBean", loginFormBean);
		BaseFormBean baseFormBean = loginFormBean;
		try {
			loginBOImpl.validate(baseFormBean);
			mv.addObject("currentUrl", "login");
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl("loadplan.do");
			mv.setView(redirectView);
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("errorMsg", e.getMessage());
			mv.setViewName("login");
			return mv;
		}
	}

	/**
	 * Method to load plan
	 * 
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/loadplan.do", method = RequestMethod.GET)
	public ModelAndView loadPlan(HttpServletRequest request,
			HttpServletResponse response) {
		BaseFormBean baseFormBean = null;
		PlanBOImpl boImpl = (PlanBOImpl) appContext.getBean("planBOImpl");
		try {
			ModelAndView mv = new ModelAndView("plan");
			baseFormBean = (PlanFormBean) appContext.getBean("planFormBean");
			boImpl.load(baseFormBean);
			System.out.println(baseFormBean);
			mv.addObject("planBean", baseFormBean);
			mv.addObject("planFormBean", baseFormBean);
			mv.addObject("currentUrl", "plan");
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("error");
		}
	}

	/**
	 * Method to load plan
	 * 
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/loadplan1.do", method = RequestMethod.GET)
	public ModelAndView loadPlan1(HttpServletRequest request,
			HttpServletResponse response) {
		BaseFormBean baseFormBean = null;
		PlanBOImpl boImpl = (PlanBOImpl) appContext.getBean("planBOImpl");
		try {
			ModelAndView mv = new ModelAndView("plan1");
			baseFormBean = (PlanFormBean) appContext.getBean("planFormBean");
			boImpl.load(baseFormBean);
			System.out.println(baseFormBean);
			mv.addObject("planBean", baseFormBean);
			mv.addObject("planFormBean", baseFormBean);
			mv.addObject("currentUrl", "plan1");
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("error");
		}
	}

	/**
	 * Method to save plan
	 * 
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/saveplan.do", method = RequestMethod.POST)
	public ModelAndView savePlan(
			@ModelAttribute("planFormBean") PlanFormBean planFormBean,
			HttpServletRequest request, HttpServletResponse response) {
		PlanBOImpl boImpl = (PlanBOImpl) appContext.getBean("planBOImpl");
		ModelAndView mv = new ModelAndView("plan");
		BaseFormBean baseFormBean = planFormBean;
		mv.addObject("currentUrl", "plan");
		try {
			boImpl.validate(baseFormBean);
			boImpl.save(baseFormBean);
			mv.addObject("planBean", baseFormBean);
			mv.addObject("planFormBean", baseFormBean);
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl("loadplan.do");
			mv.setView(redirectView);
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("planBean", baseFormBean);
			mv.addObject("planFormBean", baseFormBean);
			mv.addObject("errorMsg", e.getMessage());
			return mv;
		}
	}

	/**
	 * Method to map
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/map.do", method = RequestMethod.GET)
	public ModelAndView loadMap(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			ModelAndView mv = new ModelAndView("map");
			mv.addObject("currentUrl", "map");
			return mv;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	/**
	 * Method to map
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/chart.do", method = RequestMethod.GET)
	public ModelAndView loadChart(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			ModelAndView mv = new ModelAndView("chart");
			mv.addObject("currentUrl", "chart");
			return mv;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	/**
	 * Method to map
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/morrisbarchart.do", method = RequestMethod.GET)
	public ModelAndView morrisBarChart(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			ModelAndView mv = new ModelAndView("morris-bar-chart");
			return mv;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	/**
	 * Method to map
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/bubblechart.do", method = RequestMethod.GET)
	public ModelAndView loadBubbleChart(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			ModelAndView mv = new ModelAndView("bubble-chart");
			return mv;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	/**
	 * Method to map
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/liquidfillgauagechart.do", method = RequestMethod.GET)
	public ModelAndView loadLiquidFillGauageChart(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			ModelAndView mv = new ModelAndView("liquid-fill-gauage-chart");
			return mv;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	/**
	 * Method to map
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/chloropethbarchart.do", method = RequestMethod.GET)
	public ModelAndView loadChloroBarChart(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			ModelAndView mv = new ModelAndView("chloropeth-bar-chart");
			return mv;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

}
