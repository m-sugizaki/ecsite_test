package jp.co.bow.ec.handler;

import java.util.concurrent.TimeoutException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class GlobalExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView model = new ModelAndView("error");
		if(ex.getClass() == TimeoutException.class) {
			model.addObject("error", "セッションの有効期限が切れました。");
			} else {
				model.addObject("error", "予期せぬエラーが発生しました。<br /> " + "詳細：" + ex);
			}
		model.addObject("link", "top");
		return model;
	}
}
