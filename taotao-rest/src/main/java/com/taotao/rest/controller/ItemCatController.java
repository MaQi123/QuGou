package com.taotao.rest.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
/**
 * 商品分类列表
 * @author mi
 *
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.utils.JsonUtils;
import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatService;
@Controller
public class ItemCatController {
	@Autowired
	private ItemCatService ItemCatService;
	/*
	 * @RequestMapping(value="/itemcat/list",produces=MediaType.
	 * APPLICATION_JSON_VALUE+";charset=utf-8")
	 * 
	 * @ResponseBody public String getItemCatList(String callback) { CatResult
	 * catResult=ItemCatService.getItemCatList(); //把pojo转换成字符串 String
	 * json=JsonUtils.objectToJson(catResult); //拼装返回值 String
	 * result=callback+"("+json+");"; return result; }
	 */
	@RequestMapping(value="/itemcat/list")
	@ResponseBody
	public Object getItemCatList(String callback) {
		 CatResult catResult=ItemCatService.getItemCatList();
		 MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(catResult);
		 mappingJacksonValue.setJsonpFunction(callback);
		 return mappingJacksonValue;
	}
	
}
