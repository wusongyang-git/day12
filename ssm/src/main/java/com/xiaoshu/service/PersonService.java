package com.xiaoshu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.CompanyMapper;
import com.xiaoshu.dao.PersonMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.Company;
import com.xiaoshu.entity.Person;
import com.xiaoshu.entity.PersonVo;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;

@Service
public class PersonService {

	@Autowired
	UserMapper userMapper;
	@Autowired
	PersonMapper personMapper;
	@Autowired
	CompanyMapper companyMapper;



	


	public PageInfo<PersonVo> findPage(PersonVo personVo, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub\
		PageHelper.startPage(pageNum,pageSize);
		List<PersonVo> list=personMapper.findList(personVo);
		return new PageInfo<PersonVo>(list);
	}



	public Object findCompany(Company company) {
		// TODO Auto-generated method stub
		return companyMapper.selectAll();
	}



	public Person findByName(String expressName) {
		// TODO Auto-generated method stub
		Person param=new Person();
		param.setExpressName(expressName);

		return personMapper.selectOne(param);
	}



	public void updatePerson(Person person) {
		// TODO Auto-generated method stub
		personMapper.updateByPrimaryKeySelective(person);
	}



	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		person.setCreateTime(new Date());
		personMapper.insert(person);
	}



	public void deletePerson(int id) {
		// TODO Auto-generated method stub
		personMapper.deleteByPrimaryKey(id);
	}



	public List<PersonVo> findList(PersonVo personVo) {
		// TODO Auto-generated method stub
		return personMapper.findList(personVo);
	}



	public List<PersonVo> countPerson() {
		// TODO Auto-generated method stub
		return personMapper.countPerson();
	}





}
