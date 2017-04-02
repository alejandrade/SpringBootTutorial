package com.gigamog.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gigamog.Exceptions.ErrorJson;

@RestController
public class ExceptionHandlerController implements ErrorController {
	private static final String PATH = "/error";
    @Autowired
    private ErrorAttributes errorAttributes;

    @Value("${debug}")
    private boolean debug;
    
	@RequestMapping(value = PATH)
	public ErrorJson error(HttpServletRequest request, HttpServletResponse response) {
		 return new ErrorJson(response.getStatus(), getErrorAttributes(request, debug));
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH;
	}
	
    private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }

}
