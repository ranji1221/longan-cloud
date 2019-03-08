package org.ranji.lemon.game;

import com.jme3.app.SimpleApplication;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.system.AppSettings;

/**
 * 第一个Java 3D游戏
 * @author RanJi
 * 
 */
public class HelloModel extends SimpleApplication{
	
	
	public static void main(String[] args) {
		//-- 配置参数
		AppSettings settings = new AppSettings(true);
		settings.setTitle("一个方块");	//-- 标题
		settings.setResolution(1366, 768);	//-- 分辨率
		
		//-- 启动JME3程序
		HelloModel app = new HelloModel();
		app.setSettings(settings);	//-- 应用参数
		app.setShowSettings(false);		//-- 阻止配置参数的窗口出现
		app.start();
	}
	/**
	 * 初始化3D场景，显示一个方块。
	 */
	@Override
	public void simpleInitApp() {
		cam.setLocation(new Vector3f(0.41600543f, 3.2057908f, 6.6927643f));
		cam.setRotation(new Quaternion(-0.00414816f, 0.9817784f, -0.18875499f, -0.021575727f));
		
		flyCam.setMoveSpeed(10);
		viewPort.setBackgroundColor(ColorRGBA.LightGray);
		
		// #1 导入模型
		Spatial model = assetManager.loadModel("assets/Models/Ashe/DRAGON.obj");
		model.scale(0.03f);// 按比例缩小
		model.center();// 将模型的中心移到原点
		
		// #2 创造光源
		
		// 定向光
		DirectionalLight sun = new DirectionalLight();
		sun.setDirection(new Vector3f(-1, -2, -3));
		
		// 环境光
		AmbientLight ambient = new AmbientLight();
		
		// 调整光照亮度
		ColorRGBA lightColor = new ColorRGBA();
		sun.setColor(lightColor.mult(0.6f));
		ambient.setColor(lightColor.mult(0.4f));
		
		// #3 将模型和光源添加到场景图中
		rootNode.attachChild(model);
		rootNode.addLight(sun);
		rootNode.addLight(ambient);
		
	}
	
	
}
