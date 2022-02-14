package com.app.admin.controller;

import com.app.admin.dto.AdminCode;
import com.app.admin.dto.ExceptionFare;
import com.app.admin.dto.PagingInfo;
import com.app.admin.service.AdminCodeService;
import com.app.admin.service.ExceptionFareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("adminCode")
public class AdminCodeController {

    private AdminCodeService adminCodeService;

    public AdminCodeController(AdminCodeService adminCodeService) {
        this.adminCodeService = adminCodeService;
    }

    @RequestMapping("/list")
    public String excpetionFareList(Model model, HttpServletRequest request) {
        AdminCode adminCode = new AdminCode();
        adminCode.setCurrentPage(1);

        List<AdminCode> adminCodeList = adminCodeService.getAdminCodeList(adminCode);

        model.addAttribute("currentPage", 1);
        model.addAttribute("totalSize", adminCodeService.adminCodeTotalCnt(adminCode));
        model.addAttribute("adminCodeList", adminCodeList);
        model.addAttribute("perPage", adminCode.getPerPage());

        return "view/admincode/list";
    }

    @RequestMapping(value="/search", method={RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody Map<String, Object> searchListAdmin(@RequestBody Map<String, Object> model) {
        AdminCode adminCode = new AdminCode();
        adminCode.setCurrentPage((Integer) model.get("currentPage"));
        adminCode.setDepth1((String)model.get("searchName"));
        adminCode.setAdmcode((String)model.get("searchCode"));

        List<AdminCode> list = adminCodeService.getAdminCodeList(adminCode);
        model.put("adminCodeList", list);
        model.put("totalSize",adminCodeService.adminCodeTotalCnt(adminCode));
        model.put("perPage", adminCode.getPerPage());

        return model;
    }

    @RequestMapping(value={"/detail"}, method= RequestMethod.POST)
    public ResponseEntity<AdminCode> detailAuthManager(@RequestParam(required = false) String id) {
        AdminCode adminCode = adminCodeService.findAdminCodeByIdx(id);
        return ResponseEntity.ok().body(adminCode);

    }

    @RequestMapping(value={"/detailCode"}, method= RequestMethod.POST)
    public ResponseEntity<String> detailCodeManager(@RequestParam(required = false) String sidoContent, @RequestParam(required = false) String gugunContent) {
        String areaName = sidoContent;
        System.out.println(areaName);
        String code = adminCodeService.findDetailCode(areaName);
        System.out.println(code);
        return ResponseEntity.ok().body(code);

    }


    @RequestMapping(value={"/edit"}, method=RequestMethod.POST)
    public ResponseEntity<HashMap<String,Object>>  editAuthAdminList(HttpServletRequest request, @RequestBody AdminCode adminCode) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("message", "SUCCESS");
        try{
            if (adminCode.getEditType().equals("add")) {
                System.out.println("add");
            } else if (adminCode.getEditType().equals("update")) {
                System.out.println("update");
            }
        }catch(Exception e){
            map.put("message", "등록에 실패하였습니다. 관리자에게 문의하세요");
        }

        return ResponseEntity.ok().body(map);
    }
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
