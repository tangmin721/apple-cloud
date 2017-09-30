package com.cachexic.cloud.security.core.validate.code.image;

import com.cachexic.cloud.security.core.validate.code.entity.ImageCode;
import com.cachexic.cloud.security.core.validate.code.impl.AbstractValidateCodeProcessor;
import javax.imageio.ImageIO;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 图片验证码处理器
 * 
 * @author zhailiang
 *
 */
@Component("imageValidateCodeProcessor")
public class ImageValidateCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {

	/**
	 * 发送图形验证码，将其写到响应中
	 */
	@Override
	protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
		ImageIO.write(imageCode.getImage(), "JPEG", request.getResponse().getOutputStream());
	}

}
