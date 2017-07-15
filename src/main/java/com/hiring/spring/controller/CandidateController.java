package com.hiring.spring.controller;

import java.util.List;
import javax.validation.Valid;

import com.hiring.spring.bean.Candidate;
import com.hiring.spring.bean.FeedBack;
import com.hiring.spring.bean.Interview;
import com.hiring.spring.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Theodore on 7/8/2017.
 */
@Controller
@RequestMapping("hiring")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<Candidate> candidateList = candidateService.findAll();
        model.addAttribute("candidates", candidateList);
        return "candidates/list";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("/candidates/new_candidate", "candidate-model", new Candidate());
    }


    @RequestMapping(value = "/addCandidate", method = RequestMethod.POST)
    public String addCandidate(@Valid @ModelAttribute("candidate-model") Candidate candidate, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }

        List<Candidate> candidateList = candidateService.add(candidate);
        model.addAttribute("candidates", candidateList);

        return "redirect:/hiring";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteCandidate(Model model, @RequestParam(value = "selectedItem", required = false) String id) {
        List<Candidate> candidateList = candidateService.delete(id);
        model.addAttribute("candidates", candidateList);
        return "redirect:/hiring";
    }

    @RequestMapping(value = "feedback", method = RequestMethod.GET)
    public ModelAndView showFeedBackForm(Model model, @RequestParam(value = "selectedItem", required = false) String id) {
        Candidate candidate = candidateService.findCandidate(id);
        ModelAndView modelAndView = new ModelAndView("/candidates/feedback", "candidate-feedback-model", new FeedBack());
        modelAndView.addObject(candidate);
        return modelAndView;
    }

    @RequestMapping(value = "/addFeedback", method = RequestMethod.POST)
    public String addFeedback(@Valid @ModelAttribute("candidate-feedback-model") FeedBack feedBack, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }

        Candidate candidate = candidateService.addFeedBack(feedBack);
        model.addAttribute("candidate", candidate);

        return "redirect:/hiring/feedback?selectedItem=" + feedBack.getKey();
    }

    @RequestMapping(value = "interview", method = RequestMethod.GET)
    public ModelAndView showInterviewForm(Model model, @RequestParam(value = "selectedItem", required = false) String id) {
        Candidate candidate = candidateService.findCandidate(id);
        ModelAndView modelAndView = new ModelAndView("/candidates/interview", "candidate-interview-model", new Interview());
        modelAndView.addObject(candidate);
        return modelAndView;
    }

    @RequestMapping(value = "/addInterview", method = RequestMethod.POST)
    public String addInterview(@Valid @ModelAttribute("candidate-interview-model") Interview interview, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }

        Candidate candidate = candidateService.addInterview(interview);
        model.addAttribute("candidate", candidate);

        return "redirect:/hiring/interview?selectedItem=" + interview.getKey();
    }
}
