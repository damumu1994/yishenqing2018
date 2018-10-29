package com.cmct.ysq.controller.common;

import com.cmct.common.web.WebResponse;
import com.cmct.ysq.model.bo.AuthRequestBo;
import com.cmct.ysq.model.po.SysUserPo;
import com.cmct.ysq.model.vo.AuthResponseVo;
import com.cmct.ysq.model.vo.UserTokenVo;
import com.cmct.ysq.service.ISysUserService;
import com.cmct.ysq.util.JwtTokenUtil;
import com.cmct.ysq.util.MyConstants;
import com.cmct.ysq.util.QiniuUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.io.IOException;

import static com.cmct.ysq.model.vo.SysUserVo.transfer;

/**
 * @author 1
 */
@RestController
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @ApiOperation(value = "获取用户token", tags = "公共")
    @PostMapping(value = "token")
    public WebResponse<UserTokenVo> getUserToken(@Valid @RequestBody AuthRequestBo authRequest) {

        SysUserPo user = sysUserService.getUserInfo(authRequest.getUserName());

        if (user == null || user.getDeleteStatus() == null || user.getDeleteStatus() != 0) {
            return new WebResponse(-1, "账号不存在", null);
        }
        if (!user.getPassword().equals(authRequest.getPassword())) {
            return new WebResponse(-1, "密码错误", null);
        }

        final String randomKey = jwtTokenUtil.getRandomKey();
        final String token = jwtTokenUtil.generateToken(authRequest.getUserName(), randomKey);
        return WebResponse.success(UserTokenVo.builder()
                .authResponse(AuthResponseVo.builder()
                        .randomKey(randomKey)
                        .token(token)
                        .build())
                .sysUser(transfer(user))
                .build());

    }

    @RequestMapping(value = "/uniMobile", method = RequestMethod.GET)
    @ApiOperation(value = "验证手机号", tags = "公共")
    public WebResponse uniMobile(@RequestParam(required = false) String userId, @RequestParam String mobile) {
        boolean result = sysUserService.uniMobile(userId, mobile);
        return new WebResponse(0, "操作成功", result);
    }

    /**
     * 上传头像
     * @param request
     * @param file
     * @return
     */
   @ApiOperation(value = "图片上传", tags = "公共")
    @PostMapping(value = "/upload")
    public   boolean uploadHeadImg(HttpServletRequest request, MultipartFile file, String userId){
        boolean flag=false;
        if ( null!=file){
            String name=  MyConstants.idWorkerUtil.nextId()+".png";
            System.out.println(name);
            if(MyConstants.ifDebug)
            {
                name="test_"+name;
            }
            try {
                flag=  QiniuUtil.uploadFile(name,file.getBytes());
                if (flag){
                    //  userInter.uploadImg(name,userId);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  flag;
    }
}
