package com.food.ordering.zinger.controller;

import com.food.ordering.zinger.column.UserColumn;
import com.food.ordering.zinger.model.CollegeModel;
import com.food.ordering.zinger.model.ConfigurationModel;
import com.food.ordering.zinger.model.ShopConfigurationModel;
import com.food.ordering.zinger.model.ShopModel;
import com.food.ordering.zinger.service.ShopService;
import com.food.ordering.zinger.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/shop")
public class ShopController {

    @Autowired
    ShopService shopService;

    @PostMapping(value = "")
    public Response<String> insertShop(@RequestBody ShopModel shopModel,@RequestHeader(value = UserColumn.oauthId) String oauthId, @RequestHeader(value = UserColumn.mobile) String mobile, @RequestHeader(value = UserColumn.role) String role) {
        return shopService.insertShop(shopModel,oauthId,mobile,role);
    }


    @GetMapping(value = "/college")
    public Response<List<ShopConfigurationModel>> getShopsByCollegeId(@RequestBody CollegeModel collegeModel, @RequestHeader(value = UserColumn.oauthId) String oauthId, @RequestHeader(value = UserColumn.mobile) String mobile, @RequestHeader(value = UserColumn.role) String role) {
        return shopService.getShopByCollegeId(collegeModel, oauthId, mobile, role);
    }

    @PatchMapping(value = "/config")
    Response<String> updateShopConfiguration(@RequestBody ConfigurationModel configurationModel, @RequestHeader(value = UserColumn.oauthId) String oauthId, @RequestHeader(value = UserColumn.mobile) String mobile, @RequestHeader(value = UserColumn.role) String role){
        return shopService.updateShopConfiguration(configurationModel,oauthId,mobile,role);
    }
}
