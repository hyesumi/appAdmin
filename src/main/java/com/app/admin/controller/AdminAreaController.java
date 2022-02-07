package com.app.admin.controller;

import com.app.admin.dto.AdminArea;
import com.app.admin.dto.CommonArea;
import com.app.admin.dto.PagingInfo;
import com.app.admin.service.AdminAreaService;
import com.app.admin.service.CommonAreaService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("adminArea")
public class AdminAreaController {

    private AdminAreaService adminAreaService;

    public AdminAreaController(AdminAreaService adminAreaService) {
        this.adminAreaService = adminAreaService;
    }

    @RequestMapping("/list")
    public String adminAreaList(Model model, HttpServletRequest request) {
        PagingInfo pagingInfo = new PagingInfo();
        pagingInfo.setCurrentPage(1);

        List<AdminArea> AdminAreaList = adminAreaService.getAdminAreaList(pagingInfo);

        model.addAttribute("currentPage", 1);
        model.addAttribute("totalSize", AdminAreaList.size());
        model.addAttribute("commonAreaList", AdminAreaList);
        model.addAttribute("perPage", pagingInfo.getPerPage());

        return "view/adminArea/list";
    }

//    @RequestMapping(value="/search", method={RequestMethod.POST, RequestMethod.GET})
//    public @ResponseBody Map<String, Object> searchListAdmin(@RequestBody Map<String, Object> model) {
//
//        PagingInfo pagingInfo = new PagingInfo();
//        pagingInfo.setCurrentPage((Integer) model.get("currentPage"));
//        List<CommonArea> list = commonAreaService.getMemberList(pagingInfo);
//
//        model.put("memberList",list);
//        model.put("totalSize",list.size());
//        model.put("perPage", pagingInfo.getPerPage());
//
//        return model;
//    }
//
//    @RequestMapping(value={"/detail"}, method= RequestMethod.POST)
//    public ResponseEntity<Member>detailAuthManager(@RequestParam(required = false) String email) {
//
//        Member member = memberService.findUserByEmail(email);
//        return ResponseEntity.ok().body(member);
//
//    }
//
//    @RequestMapping(value={"/edit"}, method=RequestMethod.POST)
//    public ResponseEntity<HashMap<String,Object>>  editAuthAdminList(HttpServletRequest request, @RequestBody EditMember member) {
//        HashMap<String,Object> map = new HashMap<>();
//        map.put("message", "SUCCESS");
//        try{
//            if (member.getEditType().equals("add")) {
//                member.setPassword(BCrypt.hashpw("asdf1234@@!!",BCrypt.gensalt(10)));
//                memberService.insertAuthAdminList(member);
//            } else if (member.getEditType().equals("update")) {
//                memberService.updateAuthAdminList(member);
//            }  else if (member.getEditType().equals("edit")) {
//                Member checkMember = memberService.checkPassword(member.getLoginId());
//                if(BCrypt.checkpw(member.getPassword(),checkMember.getPassword())){
//                    if(member.getNewpassword().equals(member.getPassword())){
//                        map.put("message","동일한 패스워드로는 변경불가능합니다.");
//                        return ResponseEntity.ok().body(map);
//                    } else if(member.getNewpassword().equals(member.getLoginId())){
//                        map.put("message","아이디와 동일한 패스워드로는 변경불가능합니다.");
//                        return ResponseEntity.ok().body(map);
//                    }
//                    member.setPassword(BCrypt.hashpw(member.getNewpassword(),BCrypt.gensalt(10)));
//                    memberService.updateUserPassword(member);
//                } else {
//                     map.put("message","패스워드가 잘못입력되었습니다.");
//                }
//            }
//
//        }catch(Exception e){
//            map.put("message", "등록에 실패하였습니다. 관리자에게 문의하세요");
//        }
//
//        return ResponseEntity.ok().body(map);
//    }
//
//    @RequestMapping(value="/delete", method=RequestMethod.POST)
//    public ResponseEntity<HashMap<String,Object>> deleteAuthAdminList(HttpServletRequest request, @RequestBody Map<String,Object> idxArray) {
//        HashMap<String,Object> map = new HashMap<>();
//        try {
//            memberService.deleteAuthUser(idxArray);
//            map.put("message", "SUCCESS");
//
//        } catch (DataAccessException e) {
//            map.put("message", "FAIL");
//            return  ResponseEntity.ok().body(map);
//        }
//
//        return  ResponseEntity.ok().body(map);
//    }
}
