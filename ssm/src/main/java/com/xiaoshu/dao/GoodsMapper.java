package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.Goods;
import com.xiaoshu.entity.GoodsExample;
import com.xiaoshu.entity.GoodsVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper extends BaseMapper<Goods> {

	List<GoodsVo> findList(GoodsVo goodsVo);

	List<GoodsVo> countGoods(GoodsVo goodsVo);
    }