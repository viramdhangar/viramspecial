package com.waio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.waio.dto.CourseDTO;
import com.waio.dto.SyllabusDTO;
import com.waio.service.ICourseService;
import com.waio.utility.GenUtils;

@Controller
public class CoursesController {

	@Autowired
	ICourseService courseService;
	
	/*@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public @ResponseBody String getStudent() throws Exception {
		
		System.out.println("in");
		List<CourseDTO> courseList = new ArrayList<CourseDTO>();
		courseList = courseService.getCourseList();
		
		for (CourseDTO b : courseList) {
			System.out.println(b.getCourse()+" , "+b.getDescription());
		}
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode returnArray = mapper.createObjectNode();
		
		try{
			returnArray.put("courseList", mapper.readTree(GenUtils.getJsonFromJava(courseList)));
			returnArray.put("count", mapper.readTree(GenUtils.getJsonFromJava(count)));
		}catch(IOException e){
			e.printStackTrace();
		}
		
		String courseJson = GenUtils.getJsonFromJava(courseList);
		System.out.println("courseJson "+ courseJson);
		return courseJson;
		
	}*/
	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getCourseList() throws Exception {
		
		ModelAndView model = new ModelAndView("courses");
		System.out.println("in");
		List<CourseDTO> courseList = new ArrayList<CourseDTO>();
		courseList = courseService.getCourseList();
		model.addObject("courseList",courseList);
		return model;
		
	}
	@RequestMapping(value = "/course", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getCourse(@RequestParam(value="courseId") String courseId ) throws Exception {
		
		ModelAndView model = new ModelAndView("course-single");
		System.out.println("in");
		CourseDTO courseDTO = new CourseDTO();
		courseDTO = courseService.getCourse(courseId).get(0);
		model.addObject("course",courseDTO);
		return model;
		
	}
	@RequestMapping(value = "/syllabus", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getSyllabus() throws Exception {
		
		ModelAndView model = new ModelAndView("features-pricetables");
		List<SyllabusDTO> syllabusList = courseService.getSyllabus();
		for(SyllabusDTO syllabus : syllabusList){
			String content = syllabus.getContent();
			String[] words = content.split(",");  
			syllabus.setContentList(words);
		}
		model.addObject("syllabusList",syllabusList);
		return model;
	}
	@RequestMapping(value = "/searchCourse", method = RequestMethod.POST)
	public @ResponseBody String searchCourse(@RequestBody String body) throws Exception {
		
		ModelAndView model = new ModelAndView("course-single");
		CourseDTO courseDTO = (CourseDTO)GenUtils.getJavaFromJson(body.toString(), CourseDTO.class);
		System.out.println("text :: "+courseDTO.getCourse());
		
		List<CourseDTO> courseDTOList = courseService.searchCourses(courseDTO.getCourse());
		model.addObject("courseList",courseDTOList);
		//String jsn = GenUtils.getJsonFromJava(courseDTOList);
		int id = courseDTOList.get(0).getId();
		String course = courseDTOList.get(0).getCourse();
		return id+","+course;
		
	}
}
