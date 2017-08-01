package net.mingsoft.basic.action.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import net.mingsoft.basic.bean.CityBean;
import net.mingsoft.basic.biz.ICityBiz;
import net.mingsoft.basic.entity.CityEntity;
import com.mingsoft.util.PageUtil;
import com.mingsoft.util.StringUtil;
import net.mingsoft.basic.util.BasicUtil;
	
/**
 * 省市县镇村数据管理控制层
 * @author 伍晶晶
 * @version 
 * 版本号：100<br/>
 * 创建日期：2017-7-27 14:47:29<br/>
 * 历史修订：<br/>
 */
@Controller("webCityAction")
@RequestMapping("/basic/city")
public class CityAction extends com.mingsoft.basic.action.BaseAction{
	
	/**
	 * 注入省市县镇村数据业务层
	 */	
	@Autowired
	private ICityBiz cityBiz;
	
	
	/**
	 * 查询省市县镇村数据列表
	 * @param city 省市县镇村数据实体
	 * <i>city参数包含字段信息参考：</i><br/>
	 * id 主键编号<br/>
	 * provinceId 省／直辖市／自治区级id<br/>
	 * provinceName 省／直辖市／自治区级名称<br/>
	 * cityId 市级id <br/>
	 * cityName 市级名称<br/>
	 * countyId 县／区级id<br/>
	 * countyName 县／区级名称<br/>
	 * townId 街道／镇级id<br/>
	 * townName 街道／镇级名称<br/>
	 * villageId 村委会id<br/>
	 * villageName 村委会名称<br/>
	 * <dt><span class="strong">返回</span></dt><br/>
	 * <dd>[<br/>
	 * { <br/>
	 * id: 主键编号<br/>
	 * provinceId: 省／直辖市／自治区级id<br/>
	 * provinceName: 省／直辖市／自治区级名称<br/>
	 * cityId: 市级id <br/>
	 * cityName: 市级名称<br/>
	 * countyId: 县／区级id<br/>
	 * countyName: 县／区级名称<br/>
	 * townId: 街道／镇级id<br/>
	 * townName: 街道／镇级名称<br/>
	 * villageId: 村委会id<br/>
	 * villageName: 村委会名称<br/>
	 * }<br/>
	 * ]</dd><br/>	 
	 */
	@RequestMapping("/list")
	@ResponseBody
	public void list(@ModelAttribute CityEntity city,HttpServletResponse response, HttpServletRequest request,ModelMap model) {
		BasicUtil.startPage();
		List cityList = cityBiz.query(city);
		BasicUtil.endPage(cityList);
		this.outJson(response, JSONArray.toJSONStringWithDateFormat(cityList, "yyyy-MM-dd"));
	}
	
	
	/**
	 * 获取省市县镇村数据
	 * @param city 省市县镇村数据实体
	 * <i>city参数包含字段信息参考：</i><br/>
	 * id 主键编号<br/>
	 * provinceId 省／直辖市／自治区级id<br/>
	 * provinceName 省／直辖市／自治区级名称<br/>
	 * cityId 市级id <br/>
	 * cityName 市级名称<br/>
	 * countyId 县／区级id<br/>
	 * countyName 县／区级名称<br/>
	 * townId 街道／镇级id<br/>
	 * townName 街道／镇级名称<br/>
	 * villageId 村委会id<br/>
	 * villageName 村委会名称<br/>
	 * <dt><span class="strong">返回</span></dt><br/>
	 * <dd>{ <br/>
	 * id: 主键编号<br/>
	 * provinceId: 省／直辖市／自治区级id<br/>
	 * provinceName: 省／直辖市／自治区级名称<br/>
	 * cityId: 市级id <br/>
	 * cityName: 市级名称<br/>
	 * countyId: 县／区级id<br/>
	 * countyName: 县／区级名称<br/>
	 * townId: 街道／镇级id<br/>
	 * townName: 街道／镇级名称<br/>
	 * villageId: 村委会id<br/>
	 * villageName: 村委会名称<br/>
	 * }</dd><br/>
	 */
	@RequestMapping("/get")
	@ResponseBody
	public void get(@ModelAttribute CityEntity city,HttpServletResponse response, HttpServletRequest request,ModelMap model){
		if(StringUtil.isBlank(city.getId())) {
			this.outJson(response, null, false, getResString("err.error", this.getResString("id")));
			return;
		}
		CityEntity _city = (CityEntity)cityBiz.getEntity(Integer.parseInt(city.getId()));
		this.outJson(response, _city);
	}
	
	/**
	 * 保存省市县镇村数据实体
	 * @param city 省市县镇村数据实体
	 * <i>city参数包含字段信息参考：</i><br/>
	 * id 主键编号<br/>
	 * provinceId 省／直辖市／自治区级id<br/>
	 * provinceName 省／直辖市／自治区级名称<br/>
	 * cityId 市级id <br/>
	 * cityName 市级名称<br/>
	 * countyId 县／区级id<br/>
	 * countyName 县／区级名称<br/>
	 * townId 街道／镇级id<br/>
	 * townName 街道／镇级名称<br/>
	 * villageId 村委会id<br/>
	 * villageName 村委会名称<br/>
	 * <dt><span class="strong">返回</span></dt><br/>
	 * <dd>{ <br/>
	 * id: 主键编号<br/>
	 * provinceId: 省／直辖市／自治区级id<br/>
	 * provinceName: 省／直辖市／自治区级名称<br/>
	 * cityId: 市级id <br/>
	 * cityName: 市级名称<br/>
	 * countyId: 县／区级id<br/>
	 * countyName: 县／区级名称<br/>
	 * townId: 街道／镇级id<br/>
	 * townName: 街道／镇级名称<br/>
	 * villageId: 村委会id<br/>
	 * villageName: 村委会名称<br/>
	 * }</dd><br/>
	 */
	@PostMapping("/save")
	@ResponseBody
	public void save(@ModelAttribute CityEntity city, HttpServletResponse response, HttpServletRequest request) {
		cityBiz.saveEntity(city);
		this.outJson(response, city);
	}

	/**
	 * @param city 省市县镇村数据实体
	 * <i>city参数包含字段信息参考：</i><br/>
	 * id:多个id直接用逗号隔开,例如id=1,2,3,4
	 * 批量删除省市县镇村数据
	 *            <dt><span class="strong">返回</span></dt><br/>
	 *            <dd>{code:"错误编码",<br/>
	 *            result:"true｜false",<br/>
	 *            resultMsg:"错误信息"<br/>
	 *            }</dd>
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public void delete(@ModelAttribute CityEntity city,HttpServletResponse response, HttpServletRequest request) {
		int[] ids = BasicUtil.getInts("id");
		if(ids==null){
			this.outJson(response,null, false);
			return;
		}
		cityBiz.delete(ids);		
		this.outJson(response, true);
	}
	
	/** 
	 * 更新省市县镇村数据信息省市县镇村数据
	 * @param city 省市县镇村数据实体
	 * <i>city参数包含字段信息参考：</i><br/>
	 * id 主键编号<br/>
	 * provinceId 省／直辖市／自治区级id<br/>
	 * provinceName 省／直辖市／自治区级名称<br/>
	 * cityId 市级id <br/>
	 * cityName 市级名称<br/>
	 * countyId 县／区级id<br/>
	 * countyName 县／区级名称<br/>
	 * townId 街道／镇级id<br/>
	 * townName 街道／镇级名称<br/>
	 * villageId 村委会id<br/>
	 * villageName 村委会名称<br/>
	 * <dt><span class="strong">返回</span></dt><br/>
	 * <dd>{ <br/>
	 * id: 主键编号<br/>
	 * provinceId: 省／直辖市／自治区级id<br/>
	 * provinceName: 省／直辖市／自治区级名称<br/>
	 * cityId: 市级id <br/>
	 * cityName: 市级名称<br/>
	 * countyId: 县／区级id<br/>
	 * countyName: 县／区级名称<br/>
	 * townId: 街道／镇级id<br/>
	 * townName: 街道／镇级名称<br/>
	 * villageId: 村委会id<br/>
	 * villageName: 村委会名称<br/>
	 * }</dd><br/>
	 */
	@PostMapping("/update")
	@ResponseBody	 
	public void update(@ModelAttribute CityEntity city, HttpServletResponse response,
			HttpServletRequest request) {
		cityBiz.updateEntity(city);
		this.outJson(response, city);
	}
	
	
	
		
}