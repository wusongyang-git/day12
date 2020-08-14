package com.xiaoshu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.GoodsMapper;
import com.xiaoshu.dao.TypeMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.Goods;
import com.xiaoshu.entity.GoodsVo;
import com.xiaoshu.entity.Type;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;

@Service
public class GoodsService {


	


	@Autowired
	GoodsMapper goodsMapper;


	private static final List<GoodsVo> PageInfo = null;
	

	@Autowired
	TypeMapper typeMapper;



	public Object findType(Type type) {
		// TODO Auto-generated method stub
		return typeMapper.selectAll();
	}

	public PageInfo<GoodsVo> findPage(GoodsVo goodsVo, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<GoodsVo> list=goodsMapper.findList(goodsVo);
		
		return new PageInfo<GoodsVo>(list);
	}

	public Goods findByName(String name) {
		// TODO Auto-generated method stub
		Goods param=new Goods();
		param.setName(name);
		return goodsMapper.selectOne(param);
	}

	public void addGoods(Goods goods) {
		// TODO Auto-generated method stub
		goods.setCreatetime(new Date());
		goodsMapper.insert(goods);
		
	}

	public void updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsMapper.updateByPrimaryKeySelective(goods);
	}



	public void deleteGoods(int id) {
		// TODO Auto-generated method stub
		goodsMapper.deleteByPrimaryKey(id);

	}

	public List<GoodsVo> findList(GoodsVo goodsVo) {
		// TODO Auto-generated method stub
		return goodsMapper.findList(goodsVo);
	}

	public List<GoodsVo> countGoods(GoodsVo goodsVo) {
		// TODO Auto-generated method stub
		return goodsMapper.countGoods(goodsVo);
	}


}
