package com.sangam.demo.facade.wf;

import com.sangam.demo.vo.BaseRequestVO;
import com.sangam.demo.vo.BaseResponseVO;
import com.sangam.demo.vo.UserVO;

public interface UserWfFacade {
	
	public BaseResponseVO<Long> save(BaseRequestVO<UserVO> userVORequest);
	
}
