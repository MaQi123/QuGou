package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
/**
 * 商品列表
 * @author mi
 *
 */
public interface ItemService {
	/**
	 * 这个方法做测试用的没有按id查询
	 */
	TbItem getItemById(long itemId);
	/**
	 * 分页查询全部
	 * @param page
	 * @param rows
	 * @return
	 */
	EUDataGridResult getItemList(int page,int rows);
	TaotaoResult createItem(TbItem item,String desc,String itemParam)throws Exception;
	
	
}
