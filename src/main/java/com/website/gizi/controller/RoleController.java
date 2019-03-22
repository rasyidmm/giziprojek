//package com.website.gizi.controller;
//
//import com.website.gizi.model.Role;
//import com.website.gizi.request.TambahRoleRequest;
//import com.website.gizi.response.ApiResponse;
//import com.website.gizi.services.RoleServices;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.net.URI;
//
//@RestController
//public class RoleController {
//    @Autowired
//    RoleServices roleServices;
//    @RequestMethodestMapping(value = "/tambahrole",method = RequestMethod.POST)
////    public ResponseEntity<?> tambahRole(@RequestBody TambahRoleRequest tambahRoleRequest){
////        Role role = new Role();
////        role.setNamaRole(tambahRoleRequest.getNamaRole());
////        Role result = roleServices.SaveOrUpdateRole(role);
////        URI location = ServletUriComponentsBuilder
////                .fromCurrentContextPath().path("/role/{username}")
////                .buildAndExpand(result.getNamaRole()).toUri();
////        return ResponseEntity.created(location).body(new ApiResponse(true,"asdasdadasd"));
//   }
//
//}
