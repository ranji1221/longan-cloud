package org.ranji.lemon.facer.controller;

import org.springframework.stereotype.Controller;
import com.baidu.aip.speech.AipSpeech;

@Controller
public class AudioController {
	//设置APPID/AK/SK
    public static final String APP_ID = "14249113";
    public static final String API_KEY = "9kRewoweX5dAQRRVsyBrncKG";
    public static final String SECRET_KEY = "Id0Gc2OeXgkGN7BZ1i64XPUa43dONsmo";
    
    // 初始化一个AipSpeech
    AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
}
