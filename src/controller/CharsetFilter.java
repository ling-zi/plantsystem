package controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 设置所有字符编码
 */
public class CharsetFilter implements Filter {
	String charset = "utf-8"; // 为了以防下面没获取到，给它一个值

	public CharsetFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(this.charset);
		response.setCharacterEncoding(charset);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// 从配置中获取参数charset的值
		String ch = fConfig.getInitParameter("charset");
		// 获取到，赋值给
		if (ch != null) {
			this.charset = ch;
		}
	}

}
