package com.cachexic.cloud.security.core.validate.code.image;

import com.cachexic.cloud.security.core.validate.code.entity.ImageCode;
import com.cachexic.cloud.security.core.validate.code.impl.AbstractValidateCodeProcessor;
import javax.imageio.ImageIO;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Description: 图片验证码处理器
 * @author tangmin
 * @date 2017-10-02 11:58:58
 */
@Component("imageValidateCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {

	/**
	 * 发送图形验证码，将其写到响应中
	 */
	@Override
	protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
		ImageIO.write(imageCode.getImage(), "JPEG", request.getResponse().getOutputStream());
	}

}
