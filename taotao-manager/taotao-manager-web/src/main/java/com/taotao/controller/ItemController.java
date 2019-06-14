package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
/**
 * 商品
 * @author mi
 *
 */
@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	/**
	 * 这个方法做测试用的没有按id查询
	 */
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemByid(@PathVariable Long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page,Integer rows) {
		EUDataGridResult itemList=itemService.getItemList(page, rows);
		return itemList;
	}
	
	@RequestMapping(value="/item/save",method=RequestMethod.POST)
	@ResponseBody
	private TaotaoResult createItem(TbItem item,String desc,String itemParams) throws Exception {
		TaotaoResult result = itemService.createItem(item,desc,itemParams);
		return result;
	}
}
