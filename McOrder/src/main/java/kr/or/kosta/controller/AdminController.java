
package kr.or.kosta.controller;
/*
* @FileName : AdminController
* @Project : McOrder
* @Date : 2017.12.27 
* @Author : 최한나, 염주호, 김수진
*/ 
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.View;

import kr.or.kosta.dto.Admin;
import kr.or.kosta.dto.Event;
import kr.or.kosta.dto.Member;
import kr.or.kosta.dto.Menu;
import kr.or.kosta.dto.Order;
import kr.or.kosta.dto.Sales;
import kr.or.kosta.service.AdminService;
import kr.or.kosta.service.CartService;
import kr.or.kosta.service.EventService;
import kr.or.kosta.service.MenuService;
import kr.or.kosta.service.OrderService;
import kr.or.kosta.service.SalesService;

@Controller
@RequestMapping("/Admin/")
public class AdminController {

	@Autowired
	private CartService cartService;

	@Autowired
	private EventService eventService;

	@Autowired
	private MenuService menuService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private SalesService salesService;

	private AdminService adminService;
	
	@Autowired
	private View jsonview;
	
	///////////////////////////// 이벤트 관련 메소드 ///////////////////////
	/*
	* @method Name : showEventListAdmin
	* @date  : 2017.11.29
	* @author :2017.11.29. : 염주호
	* @description : 이벤트 리스트보기 (관리자페이지) 하위 최상위 관리자 모두 볼 수 있음
	* @param spec : Model model
	* @return : String 
	*/ 
		@RequestMapping("manageEvent.htm")
		public String showEventListAdmin(Model model) throws ClassNotFoundException, SQLException {
			System.out.println("컨트롤러 탔냐");
			List<Event> list = eventService.getEventList();
			
			model.addAttribute("list", list);
			System.out.println("컨트롤러 탔음");
			System.out.println(list.toString());
			
			return "manageEvent.admin";
		}

		/*
		* @method Name : showEventDetailAdmin
		* @date  : 2017.11.29
		* @author :2017.11.29 : 염주호
		* @description : 이벤트 상세보기 (관리자페이지)
		* @param spec : int eventNum, Model model
		* @return : String 
		*/
		@RequestMapping("showEventDetailAdmin.htm")
		public String showEventDetailAdmin(int eventNum, Model model) {
			Event event = eventService.getEvent(eventNum);
			
			model.addAttribute("event", event);
			
			return "detailEvent.admin";
		}
		
		/*
		* @method Name : addEvent
		* @date  : 2017.11.29
		* @author :2017.11.29. : 염주호
		* @description : 최상위 관리자가 이벤트 등록하기 위한 페이지로 리턴
		* @param spec : 
		* @return : String 
		*/
		// 나중에 writer 관리자로 디폴트값줘서 insert때 안해도 되게 테이블 바꾸자
		@RequestMapping(value = "regEvent.htm", method = RequestMethod.GET)
		public String addEvent() {
			return "registEvent.admin";
		}
		
		
		/*
		* @method Name : addEvent
		* @date  : 2017.11.29
		* @author :2017.11.29. : 염주호
		* @description : 최상위 관리자 이벤트 등록 처리
		* @param spec : Event event, HttpServletRequest request, Principal principal
		* @return : String 
		*/
		/*
		 * @method Name : addEvent
		 * @date  : 2017.12.03
		 * @author :2017.12.03. : 김수진
		 * @description : 파일첨부시 바로 아래에 첨부된 이미지 추가
		 * @param spec : Event event, HttpServletRequest request, Principal principal
		 * @return : String 
		 */
		@RequestMapping(value = "regEvent.htm", method = RequestMethod.POST)
		public String addEvent(Event event, HttpServletRequest request, Principal principal)
				throws IOException, ClassNotFoundException, SQLException {
			System.out.println("이벤트 등록 컨트롤러 들어왔어!!");
			System.out.println("뷰에서 event 값 가지고 왔니" + event);
			System.out.println(event);

			List<CommonsMultipartFile> files = event.getFiles();
			String fpath2 = null;
			List<String> filenames = new ArrayList<String>(); // 파일명만 추출
			if (files != null && files.size() > 0) {
				// 업로드한 파일이 하나라도 있다면
				for (CommonsMultipartFile mutifile : files) {
					String filename = mutifile.getOriginalFilename();
					String path = request.getServletContext().getRealPath("/resources/upload");
					String fpath = path + "\\" + filename;
					fpath2 = "resources/upload" + "/" + filename; //
					System.out.println(filename + " , " + fpath);
					if (!filename.equals("")) {
						// 서버에 파일 업로드 (write)
						FileOutputStream fs = new FileOutputStream(fpath);
						fs.write(mutifile.getBytes());
						fs.close();
					}
					filenames.add(fpath2);
				}		
			}

			event.setEventImage1(filenames.get(0));
			event.setEventImage2(filenames.get(1));
			eventService.addEvent(event);

			return "redirect:/Admin/manageEvent.htm";
		}


		/*
		 * @method Name : showEditEventForm
		 * @date  : 2017.12.03
		 * @author :2017.12.03. : 김수진
		 * @description : 최상위 관리자가 이벤트수정하려고 가는 페이지로 전환, dao 에서 event 객체 받아서 수정페이지에 내용 주자
		 * @param spec : int eventNum, Model model
		 * @return : String 
		 */
		@RequestMapping(value = "editDetailEvent.htm", method = RequestMethod.GET)
		public String showEditEventForm(int eventNum, Model model) {
			System.out.println("수정화면 시작");
			Event event = eventService.getEvent(eventNum);
			model.addAttribute("event", event);
			System.out.println("수정화면 끄읏");
			return "editDetailEvent.admin";
		}
		
		/*
		 * @method Name : editCompleteEvent
		 * @date  : 2017.12.03
		 * @author :2017.12.03. : 김수진
		 * @description : 최상위 관리자가 이벤트 수정완료후 다시 이벤트리스트로 전환
		 * @param spec : Event event, HttpServletRequest request
		 * @return : String 
		 */
		@RequestMapping(value = "editDetailEvent.htm", method = RequestMethod.POST)
		public String editCompleteEvent(Event event, HttpServletRequest request)
				throws IOException, ClassNotFoundException, SQLException {
			System.out.println("수정처리화면 시작");
			System.out.println(event);

	
			System.out.println("123");
			List<CommonsMultipartFile> files = event.getFiles();
			List<String> filenames = new ArrayList<String>();// 파일명만 추출
			String fpath2 = null;

			if (files != null && files.size() > 0) {
				System.out.println("if문탔니");
				// 업로드한 파일이 하나라도 있다면
				for (CommonsMultipartFile multifile : files) {
					System.out.println("for문은?");
					String filename = multifile.getOriginalFilename();
					String path = request.getServletContext().getRealPath("/resources/upload");
					String fpath = path + "\\" + filename;
					fpath2 = "resources/upload" + "/" + filename; // 수진
					System.out.println(filename + "/" + fpath);
					if (!filename.equals("")) {
						// 서버에 파일 쓰기 작업
						FileOutputStream fs = new FileOutputStream(fpath);
						fs.write(multifile.getBytes());
						fs.close();
					}
					filenames.add(fpath2);
					;// 실제 DB insert 할 파일명
				}
			}
			// DB작업
			event.setEventImage1(filenames.get(0));
			event.setEventImage2(filenames.get(1));

			eventService.editCompleteEvent(event);

			return "redirect:/Admin/manageEvent.htm";
		}


		/*
		 * @method Name : deleteEvent
		 * @date  : 2017.12.03
		 * @author :2017.12.03. : 김수진
		 * @description : 최상위 관리자가 이벤트삭제 후 다시 이벤트리스트로 전환
		 * @param spec : int eventNum, Model model
		 * @return : String 
		 */
		@RequestMapping(value = "deleteEvent.htm")
		public String deleteEvent(int eventNum, Model model) {
			eventService.deleteEvent(eventNum);
			return "redirect:/Admin/manageEvent.htm";
		}
	/////////////////// 메뉴 관련 메소드 ////////////////////////////

		/*
		 * @method Name : showMenuListAdmin
		 * @date  : 2017.12.01
		 * @author :2017.12.01. : 염주호
		 * @description : 하위관리자가 관리자 페이지에서 매장에 판매되는 메뉴리스트 보는 것
		 * @param spec : Model model
		 * @return : String 
		 */
		@RequestMapping(value= "manageMenu_rowadmin_admin.htm", method = RequestMethod.GET)
		public String showMenuListAdmin(Model model) {
			List<Menu> list = menuService.getMenuList();
			model.addAttribute("menuList", list);
			return "manageMenu_rowadmin_admin.admin";
		}
		
		/*
		 * @method Name : showMenuListAdmin
		 * @date  : 2017.12.01
		 * @author :2017.12.01. : 염주호
		 * @description : 하위관리자가 관리자 페이지에서 매장에 판매되는 메뉴리스트에서 선택 등록
		 * @param spec : Principal principal,HttpServletRequest request
		 * @return : String 
		 */
		@RequestMapping(value="manageMenu_rowadmin_admin.htm", method = RequestMethod.POST)
			public String showMenuListAdmin(Principal principal,HttpServletRequest request){
				
				String[] arr= request.getParameterValues("checkbox");	//체크박스 이름들 가져옴
				int branchCode = Integer.parseInt(principal.getName());	//지점 코드 가져옴
				System.out.println("컨트롤러 브랜치코드 : " + branchCode);
				
				Map<String, Object> paramMap = new HashMap<>();
				paramMap.put("branchCode", branchCode);		//아이디값은 일정
				
				Map<String, Object> menuMap;
				
				List<Map<String, Object>> menuList = new ArrayList<>(); 
				
				for(int i=0;i<arr.length;i++) {
					menuMap = new HashMap<>();
					
					menuMap.put("menuName", arr[i]);
					//menuMap.put("branchCode", branchCode);
					
					menuList.add(menuMap);
				}  
				
				paramMap.put("menuList", menuList);
				
				menuService.addMenuListRowAdmin(branchCode, paramMap);
				
			return "redirect:/Admin/manageMenu_rowadmin.htm";
		}
		
		/*
		 * @method Name : showMenuListRowAdmin
		 * @date  : 2017.12.01
		 * @author :2017.12.01. : 염주호
		 * @description : 하위관리자에 최상위 관리자에서 선택한 메뉴 리스트 출력
		 * @param spec : Principal principal, Model model
		 * @return : String 
		 */
		@RequestMapping(value="manageMenu_rowadmin.htm", method = RequestMethod.GET)
		public String showMenuListRowAdmin(Principal principal, Model model) {
			int branchCode = Integer.parseInt(principal.getName());	//지점 코드 가져옴
			
			List<String> list = menuService.getMenuRowAdmin(branchCode);
			System.out.println("showMenuListRowAdmin컨트롤러 list 출력 : "+list.toString() );
			
			model.addAttribute("menuList", list);
			
			return "manageMenu_rowadmin.admin";
		}
	/*
	 * @method Name : showMenuListTopAdmin
	 * @date  : 2017.11.30
	 * @author :2017.11.30. : 최한나
	 * @description : 최상위 관리자가 관리자 페이지에서 메뉴 리스트 보는 것
	 * @param spec : Model model
	 * @return : String 
	 */
	@RequestMapping("manageMenu.htm") 
	public String showMenuListTopAdmin(Model model) {
		List<Menu> list = menuService.getMenuList();
		model.addAttribute("menuList", list);
		return "manageMenu.admin";
	}
	
	/*
	 * @method Name : showMenuDetail
	 * @date  : 2017.11.30
	 * @author :2017.11.30. : 최한나
	 * @description : 하위관리자, 상위관리자가 메뉴 상세보기
	 * @param spec : String menuName, Model model
	 * @return : String 
	 */
	@RequestMapping("detailMenu.htm") 
	public String showMenuDetail(String menuName, Model model) {
		Menu menu = menuService.getMenuDetail(menuName);
		model.addAttribute("menu", menu);
		return "detailMenu.admin";
	}

	// 최상위 관리자가 메뉴수정하려고 가는 페이지 뷰단만 보여주는것
	public String showEditMenu(String menuName) {
		return null;
	}

	// 최상위 관리자가 메뉴수정완료후 다시 메뉴리스트로 돌아 가는 것
	public String editCompletedMenu(Menu menu, Model model) {
		return null;
	}

	// 하위관리자가 메뉴 추가하러 가는 페이지
	public String showaddMenu(int branchCode) {
		return null;
	}

	// 하위관리자가 메뉴 추가후 리스트로 돌아가는것 이때 서비스 두개부르자 먼저 전체삭제하고
	// 페이지에서 체크한거 통째로 추가
	public String addMenu(int branchCode, List<Menu> list) {
		return null;
	}

	/*
	 * @method Name : addMenu
	 * @date  : 2017.12.01
	 * @author :2017.12.01. : 염주호
	 * @description : 최상위관리자가 메뉴 추가하러 가는 페이지
	 * @param spec : 
	 * @return : String 
	 */
		@RequestMapping(value = "registMenu.htm", method = RequestMethod.GET)
		public String addMenu() {
			System.out.println("여기가 get");
			return "registMenu.admin";
		}

		/*
		 * @method Name : addMenu
		 * @date  : 2017.12.01
		 * @author :2017.12.01. : 염주호
		 * @description : 최상위관리자의 메뉴 등록
		 * @param spec : Menu menu, HttpServletRequest request
		 * @return : String 
		 */
		@RequestMapping(value="registMenu.htm", method = RequestMethod.POST)
		public String addMenu(Menu menu, HttpServletRequest request) throws IOException {
			
			System.out.println("여기가 POST");
			System.out.println("컨트롤러진입");
			
			
			CommonsMultipartFile file = menu.getFile();
			
			String filename = "";
			if(file != null) {
				 //업로드한 파일이 있다면
				
					 filename = file.getOriginalFilename();
					 String path = request.getServletContext().getRealPath("/resources/upload");
					 String fpath = path + "\\" + filename;
					 
					 System.out.println(filename + " , " + fpath);
					 
					 if(!filename.equals("")) {
						 //서버에 파일 업로드 (write)
						 System.out.println("여기 들어왔나?");
						 FileOutputStream fs = new FileOutputStream(fpath);
						 fs.write(file.getBytes());
						 fs.close();
				 }
			 }
			
			//실 DB Insert
			 menu.setMenuImage(filename);
			 
			 
			 menuService.addMenu(menu);
			 System.out.println(menu.toString());
			 
			return "redirect:manageMenu.htm";
		}
//////////////////// 주문관리 관련 메소드 //////////////////////////////////////

	/*
	 * @method Name : getOrderList
	 * @date  : 2017.11.30
	 * @author :2017.11.30. : 최한나
	 * @description : 매장별 주문 내역 리스트 뿌리기
	 * @param spec : Model model, Principal principal
	 * @return : String 
	 */
	@RequestMapping("manageOrder.htm")
	public String getOrderList(Model model, Principal principal) {

		int branchCode = Integer.parseInt(principal.getName());
		List<Order> orderList = orderService.getOrderList(branchCode);

		model.addAttribute("orderList", orderList);

		return "manageOrder.admin";
	}
	/*
	 * @method Name : completeOrder
	 * @date  : 2017.11.30
	 * @author :2017.11.30. : 최한나
	 * @description : 주문내역리스트에서 주문완료버튼 누르면 주문완료시각 생성되고 비동기로 주문내역 리스트 다시 보내주기
	 * @param spec : Principal principal, @RequestBody Order order, ModelMap map
	 * @return : View 
	 */
	@RequestMapping("completeOrderList.htm")
	public View completeOrder(Principal principal, @RequestBody Order order, ModelMap map) throws Exception {

		int orderNum = order.getOrderNum();

		System.out.println("주문완료버튼 컨트롤러왔나" + orderNum);
		int branchCode = Integer.parseInt(principal.getName());
		orderService.completeOrder(branchCode, orderNum);
		List<Order> list = orderService.getOrderList(branchCode);

		map.addAttribute("orderList", list);
		return jsonview;
	}

	// 웹소켓 인디 나중에 생각좀...
	public View getOrder(int branchCode, ModelMap map) {
		return jsonview;
	}

	//////////////////// 매출 관련 메소드 /////////////////////////////
		/*
		 * @method Name : showSalesList
		 * @date  : 2017.11.29
		 * @author :2017.11.29. : 김수진
		 * @description : 매장별 매출 리스트 보여주기
		 * @param spec : Principal principal, Model model
		 * @return : String 
		 */
		@RequestMapping("manageSales.htm")
		public String showSalesList(Principal principal, Model model) {
			int branchCode = Integer.parseInt(principal.getName());		
			List<Sales> list = salesService.showSalesList(branchCode);
			model.addAttribute("list", list);	
			
			return "manageSales.admin";
		}
		
		
		/*
		 * @method Name : salesDetail
		 * @date  : 2017.11.29
		 * @author :2017.11.29. : 김수진
		 * @description : 매출 리스트에서 매출일자 클릭하면 그 일자에 판매 리스트 모두 보여주기
		 * @param spec : Principal principal, Model model
		 * @return : String 
		 */
		/*
		 * @method Name : salesDetail
		 * @date  : 2017.12.04
		 * @author :2017.12.04. : 최한나
		 * @description : 매출 리스트에서 매출 일자를 일 월 주단위로 나누어 그 해당하는 단위의 매출 내역 리스트로 보내주기
		 * @param spec : Principal principal, Date salesDate, int selectDay, Model model
		 * @return : String 
		 */
		@RequestMapping("manageSalesDetail.htm")
		public String salesDetail(Principal principal, Date salesDate, int selectDay, Model model) {
			System.out.println("컨트롤러탔다");
			System.out.println("selectDay 가져왔나? : " + selectDay);
			System.out.println("salesDate 가져왔니?" +  salesDate);
			int branchCode = Integer.parseInt(principal.getName());
			System.out.println("branchcode 는?" + branchCode);
			List<Order> list = null;
			list = salesService.salesDetail(branchCode, salesDate, selectDay);
			System.out.println("컨트롤러2");
			System.out.println("list" + list);
			model.addAttribute("list", list);
			return "manageSalesDetail.admin";
		}
		
		/*
		 * @method Name : salesOfSelectType
		 * @date  : 2017.12.04
		 * @author :2017.12.04. : 최한나
		 * @description : 매출 리스트에서 select으로 일 월 주 로 값 바뀔 때마다 비동기로 단위에 맞는 매출 리스트 보내주기
		 * @param spec : @RequestBody Sales sales, Principal principal, ModelMap map
		 * @return : View 
		 */
		@RequestMapping("salesOfSelectType.htm")
		public View salesOfSelectType(@RequestBody Sales sales, Principal principal, ModelMap map ) {
			
			System.out.println("매출 비동기 컨트롤러 왔다!!!");
			int branchCode = Integer.parseInt(principal.getName());
			List<Sales> list = null;
			int selectDay = sales.getSelectDay();
			System.out.println("brachCode 값 잘 왔나요 : " + branchCode);
			System.out.println("select값 잘왔나요 : " + selectDay);
			if(selectDay ==1) {
				list = salesService.showSalesList(branchCode);
			}else if(selectDay ==2) {
				list = salesService.getWeeklyTotalSales(branchCode);
			}else {
				list = salesService.getMonthlyTotalSales(branchCode);
			}
			map.addAttribute("salesList", list);
			System.out.println("컨트롤러에서 리스트 받아오는 거");
			
			return jsonview;
		}
		/////////////////// 관리자 관리 ///////////////////////
		
		/*
		 * @method Name : viewAdminList
		 * @date  : 2017.12.06
		 * @author :2017.12.06. : 최한나
		 * @description : 하위 관리자 리스트 보여주기
		 * @param spec : Model model
		 * @return : String 
		 */
		@RequestMapping("manageAdmin.htm")
		public String viewAdminList(Model model) {
			System.out.println("관리자 관리 왔나요");
			List<Admin> list = adminService.getAdminList();
			System.out.println("관리자 리스트  : " + list.toString());
			model.addAttribute("adminList", list);
			return "manageAdmin.admin";
		}
		
		/*
		 * @method Name : deleteAdmin
		 * @date  : 2017.12.06
		 * @author :2017.12.06. : 최한나
		 * @description : 하위 관리자 삭제
		 * @param spec : @RequestBody Admin admin, Model model
		 * @return : View 
		 */
		@RequestMapping("deleteAdmin.htm")
		public View deleteAdmin(@RequestBody Admin admin, Model model) {
			
			String branchCode = admin.getBranchCode();
			
			List<Admin> list = adminService.deleteAdmin(branchCode);
			
			model.addAttribute("adminList", list);
			return jsonview;
		}
		
		/*
		 * @method Name : addAdmin
		 * @date  : 2017.12.06
		 * @author :2017.12.06. : 최한나
		 * @description : 하위 관리자  등록 페이지 가기
		 * @param spec : 
		 * @return : String 
		 */
		@RequestMapping(value="addAdmin.htm", method=RequestMethod.GET)
		public String addAdmin() {
			return "addAdminForm.admin";
		}
		
		/*
		 * @method Name : addAdmin
		 * @date  : 2017.12.06
		 * @author :2017.12.06. : 최한나
		 * @description : 하위 관리자 등록처리 
		 * @param spec : Member member
		 * @return : String 
		 */
		@RequestMapping(value="addAdmin.htm", method=RequestMethod.POST)
		public String addAdmin(Member member) {
			
			adminService.addAdmin(member);
			
			return "redirect:manageAdmin.htm";
		}
		
		
		
}
