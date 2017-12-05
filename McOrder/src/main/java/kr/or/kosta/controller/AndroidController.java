package kr.or.kosta.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;


import kr.or.kosta.dto.Cart;
import kr.or.kosta.dto.Event;
import kr.or.kosta.service.FrontService;

@Controller
public class AndroidController {
	
	@Autowired
	private View jsonview;
	
	@Autowired
	private FrontService frontService;
	
	// 앱에서 받아서 이벤트 정보 보내주기
	@RequestMapping(value="/android.htm", method={RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody View json(ModelMap model){
        // json-simple 라이브러리 추가 필요(JSON 객체 생성)
		List<Event> eventList = frontService.getEventList();
        // {변수명:값, 변수명:값}
        // {sendData:[{변수명:값},{변수명:값},...]}
        Event event = new Event();
        Collections.shuffle(eventList);
		event.setEventImage2(eventList.get(0).getEventImage2());
		event.setEventContent(eventList.get(0).getEventContent());
		event.setEventTitle(eventList.get(0).getEventTitle());
        
        model.addAttribute(event);
        return jsonview;
    }

}

