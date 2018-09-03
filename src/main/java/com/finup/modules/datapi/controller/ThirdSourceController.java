package com.finup.modules.datapi.controller;

import com.finup.common.annotation.SysLog;
import com.finup.common.utils.PageUtils;
import com.finup.common.utils.Query;
import com.finup.common.utils.R;
import com.finup.common.validator.ValidatorUtils;
import com.finup.modules.datapi.entity.ThirdSourceEntity;
import com.finup.modules.datapi.enums.ThirdSourceEnum;
import com.finup.modules.datapi.service.ThirdSourceService;
import com.finup.modules.sys.entity.SysConfigEntity;
import com.finup.modules.sys.entity.SysUserEntity;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 定时任务
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月28日 下午2:16:40
 */
@RestController
@RequestMapping("/datapi/thirdsource")
public class ThirdSourceController extends BaseController{
	@Autowired
	private ThirdSourceService thirdSourceService;
	
	/**
	 * 定时任务列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<ThirdSourceEntity> list = thirdSourceService.queryList(query);
		int total = thirdSourceService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(list, total, query.getLimit(), query.getPage());
		return R.ok().put("page", pageUtil);
	}

	/**
	 * 配置信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		ThirdSourceEntity thirdSource = thirdSourceService.queryObject(id);
		return R.ok().put("thirdSource", thirdSource);
	}

	/**
	 * 修改配置
	 */
	@SysLog("修改数据源配置")
	@RequestMapping("/update")
	public R update(@RequestBody ThirdSourceEntity thirdSource){
		ValidatorUtils.validateEntity(thirdSource);
		SysUserEntity sysUser = getUser();
		thirdSource.setUpdateUser(sysUser.getUsername());
		thirdSourceService.update(thirdSource);

		return R.ok();
	}


	/**
	 * 获取数据源列表
	 * @return
	 */
	@RequestMapping("/thirdsource/list")
	public R thridSourceList(){
		return R.ok().put("thirdSourceList", ThirdSourceEnum.convertToList());
	}


	/**
	 * 获取数据源列表
	 * @return
	 */
	@RequestMapping("/source/{creditType}")
	public R thridSourceList(@PathVariable("creditType") String creditType){
		//根据渠道好获取三方数据源
		if(StringUtils.isEmpty(creditType)){
			return R.error(-1,"参数错误");
		}
		//查询数据来源
		return R.ok().put("thirdSource", thirdSourceService.queryThirdSource(creditType));
	}


}

