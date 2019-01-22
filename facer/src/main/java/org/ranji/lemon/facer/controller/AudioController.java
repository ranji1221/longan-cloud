package org.ranji.lemon.facer.controller;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.speech.AipSpeech;

@Controller
public class AudioController {
	//设置APPID/AK/SK
    public static final String APP_ID = "15461819";
    public static final String API_KEY = "bmGAWNZ1Uw7KnX9aVPvtlSGV";
    public static final String SECRET_KEY = "8KLyywgKaUdvdNDqWbmy7HDr4jZcrKuk";
    
    // 初始化一个AipSpeech
    AipSpeech audioClient = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
    AipNlp underStandClient = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

    
    @RequestMapping(path="/index2")
    public ModelAndView index(){  
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("index2");
    	return mv;
    }
    
    
    
    @RequestMapping(path="/audio", method=RequestMethod.POST)
	@ResponseBody
	public String handleFileUpload(@RequestParam("audioData") MultipartFile audioFile, HttpServletResponse response) throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "*");
		
        // 可选：设置网络连接参数
		audioClient.setConnectionTimeoutInMillis(2000);
		audioClient.setSocketTimeoutInMillis(60000);
		underStandClient.setConnectionTimeoutInMillis(2000);
		underStandClient.setSocketTimeoutInMillis(60000);
		
  
        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
       // System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");
        
        // 调用接口
        JSONObject res = audioClient.asr(audioFile.getBytes(), "pcm", 16000, null);
        System.out.println(res);
        System.out.println(res.getJSONArray("result"));
        
        JSONObject underStand = underStandClient.lexer(res.getJSONArray("result").getString(0), null);
        System.out.println(underStand.toString(2));
		return res.toString(2);
    }
}
