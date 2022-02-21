package com.app.admin.controller;

import com.app.admin.dto.ExceptionFare;
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
@RequestMapping("exceptionfare")
public class ExceptionFareController {

    private ExceptionFareService exceptionFareService;

    public ExceptionFareController(ExceptionFareService exceptionFareService) {
        this.exceptionFareService = exceptionFareService;
    }

    @RequestMapping("/list")
    public String excpetionFareList(Model model, HttpServletRequest request) {
        ExceptionFare exceptionFare = new ExceptionFare();
        exceptionFare.setCurrentPage(1);
        List<ExceptionFare> exceptionFareList = exceptionFareService.getExceptionFareList(exceptionFare);
        List<HashMap<String, Object>> exceptionAreaList =  exceptionFareService.getExceptionAreaList();

        model.addAttribute("currentPage", 1);
        model.addAttribute("totalSize", exceptionFareService.exceptionFareTotalCnt(exceptionFare));
        model.addAttribute("exceptionFareList", exceptionFareList);
        model.addAttribute("perPage", exceptionFare.getPerPage());
        model.addAttribute("exceptionAreaList", exceptionAreaList);

        return "view/exceptionfare/list";
    }

    @RequestMapping(value="/search", method={RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody Map<String, Object> searchExceptionFareList(@RequestBody Map<String, Object> model) {
        ExceptionFare exceptionFare = new ExceptionFare();
        exceptionFare.setCurrentPage((Integer) model.get("currentPage"));
        exceptionFare.setName((String)model.get("searchName"));
        exceptionFare.setCode((String)model.get("searchCode"));

        List<ExceptionFare> list = exceptionFareService.getExceptionFareList(exceptionFare);
        model.put("exceptionFareList", list);
        model.put("totalSize",exceptionFareService.exceptionFareTotalCnt(exceptionFare));
        model.put("perPage", exceptionFare.getPerPage());

        return model;
    }

    @RequestMapping(value={"/detail"}, method= RequestMethod.POST)
    public ResponseEntity<ExceptionFare> detailAuthManager(@RequestParam(required = false) String id) {
        ExceptionFare exceptionFare = exceptionFareService.findExceptionFareByIdx(id);
        if(exceptionFare.getArea() == null || ("").equals(exceptionFare.getArea())){
            exceptionFare.setArea("0");
        }
        return ResponseEntity.ok().body(exceptionFare);

    }

    @RequestMapping(value={"/edit"}, method=RequestMethod.POST)
    public ResponseEntity<HashMap<String,Object>>  editExceptionList(HttpServletRequest request, @RequestBody ExceptionFare exceptionFare) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("message", "SUCCESS");

//        try{
//            List<AdminCode> adminCodeList = exceptionFareService.getExceptionFare(exceptionFare);
//            if (adminCode.getEditType().equals("add")) {
//                for(AdminCode code : adminCodeList){
//                    if(code.getAdmcode().equals(adminCode.getAdmcode())){
//                        map.put("message","이미 등록된 코드입니다.");
//                        return ResponseEntity.ok().body(map);
//                    }
//                    if(code.getDepth1().equals(adminCode.getDepth1())){
//                        if(code.getDepth2().equals(adminCode.getDepth2())){
//                            map.put("message","이미 등록된 지역입니다.");
//                            return ResponseEntity.ok().body(map);
//                        }
//                    }
//                }
//
//                //System.out.println("add");
//                adminCodeService.insertAdminCode(adminCode);
//
//            } else if (adminCode.getEditType().equals("update")) {
//
//                //adminCodeService.updateAdminCode(adminCode);
//                System.out.println("update");
//            }
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//            map.put("message", "등록에 실패하였습니다. 관리자에게 문의하세요");
//        }

        return ResponseEntity.ok().body(map);
    }
}
